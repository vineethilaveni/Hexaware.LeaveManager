package com.hexaware.ftp41.persistence;

import com.hexaware.ftp41.model.Employee;
/**import com.hexaware.ftp41.model.LeaveDetails;*/
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.Date;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * return all the details of the selected employee.
   * @param employeeId the id of the employee.
   * @param startDate leave start date.
   * @param endDate leave end date.
   * @param numDays leave number of days.
   * @param appliedOn leave applied date.
   * @param lvType leave type.
   * @param levRes to store leave reson.
   */

  @SqlUpdate("INSERT INTO LEAVE_DETAILS(EMP_ID, LEAVE_START_DATE, LEAVE_END_DATE,"
             + "LEAVE_NUMBER_OF_DAYS, LEAVE_APPLIED_ON, LEAVE_TYPE, LEAVE_REASON)"
              + "VALUES(:empId, :sdate, :edate, :nod, :aod, :leaveType, :leaveReason)")
  void insert(@Bind("empId") int employeeId, @Bind("sdate") Date startDate, @Bind("edate") Date endDate,
                  @Bind("nod") int numDays, @Bind("aod") Date appliedOn, @Bind("leaveType") String lvType,
                  @Bind("leaveReason") String levRes);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee.
   * @param nod leave number of days.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_AVAILABLE_LEAVE_BALANCE = EMP_AVAILABLE_LEAVE_BALANCE-:NOD WHERE EMP_ID =:empId")
  void decrement(@Bind("empId") int empId, @Bind("NOD") int nod);
  /**
   * return all the details of the selected employee.
   * @param empId to get the id of the employee.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS='APPROVED' WHERE LEAVE_STATUS='PENDING' and  EMP_ID=:empId")
  void autoApprove(@Bind("empId") int empId);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
