#!/bin/bash -ex
#deploy
curl --fail -T ftp41.war "http://manager:manager@$INTEGRATION_HOST:8080/manager/text/deploy?path=/ftp41&update=true"
#scp -i ~/.ssh/ftp_jenkins.pem ftp41.war centos@$INTEGRATION_HOST:/home/centos/apache-tomcat-8.5.23/webapps
#database
mysql --host ftp-integration.c1jpaaszplju.us-east-1.rds.amazonaws.com -u FTP41 -pFTP41 FTP41 < database.ddl
mysql --host ftp-integration.c1jpaaszplju.us-east-1.rds.amazonaws.com -u FTP41 -pFTP41 FTP41 < database.dml
#rest tests
rm -rf restservice
mkdir -p restservice/integration-test/src/test/java
cd restservice/integration-test/src/test/java
jar -xvf ../../../../../ftp41-integration-tests-1.0-test-sources.jar
cd ../../../
cp ./src/test/java/META-INF/maven/com.hexa/ftp41-integration-tests/pom.xml .
#before running tests, make sure that the war file has been deployed completely
n=0
while true
do
  response=$(curl --write-out %{http_code} --silent --output /dev/null http://$INTEGRATION_HOST:8080/ftp41/favicon.ico)
  [ $response -eq 200 ] && break
  n=$[$n+1]
  if [ $n -ge 5 ]
  then
    echo "Web app never came up; aborting..."
    exit -1
  else
    echo "Web app still not up; sleeping and retrying..."
  fi
  sleep 30
done
/var/lib/jenkins/apache-maven-3.5.2/bin/mvn test -Dservice.host=$INTEGRATION_HOST -Dservice.webapp=ftp41
#protractor tests
cd ../..
tar -xvzf lm-app.zip
cd lm-app
./node_modules/protractor/bin/protractor --baseUrl "http://$INTEGRATION_HOST:8080/"
