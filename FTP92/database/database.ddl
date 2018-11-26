-- change this to your team id
use FTP41;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the table

create table EMPLOYEE (EMP_ID int primary key);  

-- Altering EMPLOYEE Table

  alter table EMPLOYEE add EMP_NAME varchar(50) ;
    alter table EMPLOYEE ADD EMP_EMAIL_ADDRESS varchar(50) UNIQUE;
      alter table EMPLOYEE ADD EMP_MOBILE_NUMBER INT(50) UNIQUE;
       alter table EMPLOYEE add  EMP_DEPARTMENT VARCHAR(50);
         alter table EMPLOYEE ADD EMP_DATE_JOINED DATE ;
           alter table EMPLOYEE add EMP_AVAILABLE_LEAVE_BALANCE varchar(50);
            alter table EMPLOYEE add EMP_MGR_ID INT(10);

-- Making EMP_ MGR_ID as a foreign key

             alter table EMPLOYEE add foreign key(EMP_MGR_ID) references EMPLOYEE(EMP_ID);

-- create the table

      create table LEAVE_DETAILS( EMP_ID int(50)  , LEAVE_ID INT(50) primary key , LEAVE_NUMBER_OF_DAYS INT(50) , 
         LEAVE_START_DATE Date , LEAVE_END_DATE date , LEAVE_TYPE varchar(50) ,
           LEAVE_APPLIED_ON date not null, LEAVE_STATUS varchar(50), LEAVE_REASON varchar(50), 
              LEAVE_MANAGER_COMMENTS varchar(50));

-- Making EMPLOYEE_ID as a foreign key 

        alter table LEAVE_DETAILS add foreign key(EMP_ID) references EMPLOYEE(EMP_ID);
 