package com.hexaware.ftp41.persistence;

import com.hexaware.ftp41.model.LeaveDetails;
import com.hexaware.ftp41.model.LeaveStatus;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * The DAO class for leave details.
 */
public interface LeaveDetailsDAO  {
/**
 * To retrive the data from leave details.
 * @return the Leave details object.
 */
  @SqlQuery("SELECT * FROM LEAVEDETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the leave details of the selected employee.
   * @param leaveId the id of the leave.
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE Leave_Id = :leaveId")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails levId(@Bind("leaveId") int leaveId);

 /**to update leavedetails.
  * @param leaveId leaveid.
  * @param leaveMgrComment manager comments.
  * @param stat1 status.
  */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_MANAGER_COMMENTS = :leaveMgrComment,"
      + " LEAVE_STATUS = :stat1 WHERE LEAVE_ID = :leaveId")
  void approve(@Bind("leaveId") int leaveId,
      @Bind("leaveMgrComment") String leaveMgrComment,
      @Bind("stat1") LeaveStatus stat1);

  /**
   * to update the employee.
   * @param empId emp id.
   * @param days for number of days.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_AVAILABLE_LEAVE_BALANCE=EMP_AVAILABLE_LEAVE_BALANCE+:days WHERE EMP_ID=:empId")
  void deny(@Bind("empId") int empId, @Bind("days") int days);

  /**
   * return details of all the employees who applied for leave.
   * @param empId the id of th e leave details.
   * @return the leave details object.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> finder(@Bind("empId") int empId);
  /**
   * return all the pending leave details of the selected leave.
   * @param empID the id of the employee
   * @return the leavedetails object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS INNER JOIN EMPLOYEE ON EMPLOYEE.EMP_ID=LEAVE_DETAILS.EMP_ID"
      + " WHERE  EMPLOYEE.EMP_MGR_ID =:empID AND LEAVE_DETAILS.LEAVE_STATUS = 'PENDING'"
      + "ORDER BY EMPLOYEE.EMP_NAME")
   @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> pendingRec(@Bind("empID") int empID);
  /**
  * close with no args is used to close the connection.
  */
  void close();
}
