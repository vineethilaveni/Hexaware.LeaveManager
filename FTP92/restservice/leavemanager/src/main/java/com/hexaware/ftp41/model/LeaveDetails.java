package com.hexaware.ftp41.model;

import com.hexaware.ftp41.persistence.DbConnection;
import com.hexaware.ftp41.persistence.LeaveDetailsDAO;

import java.util.Objects;
import java.util.Date;
import java.util.List;


/**
 * Leave class to store Leave details.
 * @author hexware
 */
public class LeaveDetails {

  private int leaveId;
  /**
   *leaveId to store leave id.
   */
  private int empId;
  /**
   *empId to store employee id.
   */
  private int leaveNoDays;
  /**
  leaveNoDays to store no of days.
   */
  private Date leaveStartDate;
  /**
  leaveStartDate to store leave start date.
   */
  private Date leaveEndDate;
  /**
  leaveEndDate to store leave end date.
   */
  private LeaveType leaveType;
  /**
  leaveType to store leave type.
   */
  private Date leaveAppliedOn;
  /**
  leaveAppliedOn to store leave appiled date.
   */
  private LeaveStatus leaveStatus;
  /**
  leaveStatus to store status.
   */
  private String leaveReason;
  /**
  leaveReason to store reason.
   */
  private String leaveMgrComment;
  /**
  leaveMgrComment to store managers comment.
   */

  @Override
  public final boolean equals(final Object obj) {

    if (obj == null) {

      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails leave = (LeaveDetails) obj;
    if (Objects.equals(empId, leave.empId)
        && Objects.equals(leaveId, leave.leaveId)
        && Objects.equals(leaveNoDays, leave.leaveNoDays)
        && Objects.equals(leaveStartDate, leave.leaveStartDate)
        && Objects.equals(leaveEndDate, leave.leaveEndDate)
        && Objects.equals(leaveType, leave.leaveType)
        && Objects.equals(leaveAppliedOn, leave.leaveAppliedOn)
        && Objects.equals(leaveStatus, leave.leaveStatus)
        && Objects.equals(leaveReason, leave.leaveReason)
        && Objects.equals(leaveMgrComment, leave.leaveMgrComment)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, leaveId, leaveNoDays, leaveStartDate,
    leaveEndDate, leaveType, leaveAppliedOn, leaveStatus, leaveReason, leaveMgrComment);
  }

  @Override
  public final String toString() {
    return "empid :" + empId + "\t"
      + "leaveId :" + leaveId + "\t"
      + "leaveNoDays :" + leaveNoDays + "\t"
      + "leaveStartDate :" + leaveStartDate + "\t"
      + "leaveEndDate :" + leaveEndDate + "\t"
      + "leaveType :" + leaveType + "\t"
      + "leaveAppliedOn :" + leaveAppliedOn + "\t"
      + "leaveStatus :" + leaveStatus + "\t"
      + "leaveReason :" + leaveReason + "\t"
      + "leaveMgrComment :" + leaveMgrComment;
  }
/**
   *@param argEmpId to initialize empId.
   *@param argLeaveId to initialize LeaveId.
   *@param argLeaveNoDays to initialize number of leave days.
   *@param argLeaveStartDate to initialize leave start date.
   *@param argLeaveEndDate to initialize leave end date.
   *@param argLeaveType to initialize leave type.
   *@param argLeaveAppliedOn to initialize leave application.
   *@param argLeaveStatus to initialize leave status.
   *@param argLeaveReason to initialize leave reason.
   *@param argLeaveMgrComment to initialize manager comment.
   */

  public LeaveDetails(final int argEmpId, final int argLeaveId,
                 final int argLeaveNoDays, final Date argLeaveStartDate,
                 final Date argLeaveEndDate, final LeaveType argLeaveType,
                 final Date argLeaveAppliedOn, final LeaveStatus argLeaveStatus,
                 final String argLeaveReason, final String argLeaveMgrComment) {
    this.empId = argEmpId;
    this.leaveId = argLeaveId;
    this.leaveNoDays = argLeaveNoDays;
    this.leaveStartDate = argLeaveStartDate;
    this.leaveEndDate = argLeaveEndDate;
    this.leaveType = argLeaveType;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.leaveStatus = argLeaveStatus;
    this.leaveReason = argLeaveReason;
    this.leaveMgrComment = argLeaveMgrComment;
  }

  /**
   * Gets the EmpId.
   * @return this Emloyee Id.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * Gets the LeaveId.
   * @return this Leave ID.
   */
  public final int getLeaveId() {
    return leaveId;
  }
  /**
   * Gets the LeaveNoDays.
   * @return this Number of Days.
   */
  public final int getLeaveNoDays() {
    return leaveNoDays;
  }
  /**
   * Gets the LeaveStartDate.
   * @return this Start Date.
   */
  public final Date getLeaveStartDate() {
    return leaveStartDate;
  }
  /**
   * Gets the LeaveEndDate.
   * @return this End Date.
   */
  public final Date getLeaveEndDate() {
    return leaveEndDate;
  }
  /**
   * Gets the LeaveType.
   * @return this Leave Type.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }
  /**
   * Gets the LeaveAppliedOn.
   * @return this Leave Applied On.
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }
   /**
   * Gets the LeaveStatus.
   * @return this Leave Status.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }
   /**
   * Gets the LeaveReason.
   * @return this Leave Reason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }
   /**
   * Gets the LeaveMgrComment.
   * @return this Leave Manager Comment.
   */
  public final String getLeaveMgrComment() {
    return leaveMgrComment;
  }

  /**
   * @param argEmpId to set Leave ID.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argLeaveId to set Leave ID.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   * @param argLeaveNoDays to set LeaveNoDays.
   */
  public final void setLeaveNoDays(final int argLeaveNoDays) {
    this.leaveNoDays = argLeaveNoDays;
  }
  /**
   * @param argLeaveStartDate to set LeaveStartDate
   */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    this.leaveStartDate = argLeaveStartDate;
  }
  /**
   * @param argLeaveEndDate to set LeaveEndDate.
   */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    this.leaveEndDate = argLeaveEndDate;
  }
  /**
   * @param argLeaveType to set LeaveType.
   */
  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }
  /**
   * @param argLeaveAppliedOn to set LeaveAppliedOn.
   */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }
  /**
   * @param argLeaveStatus to set Leave Status.
   */
  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }
  /**
   * @param argLeaveReason set Leave Reason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }
   /**
   * @param argLeaveMgrComment to set Manager Comment.
   */
  public final void setLeaveMgrComment(final String argLeaveMgrComment) {
    this.leaveMgrComment = argLeaveMgrComment;
  }

  /**
   *The dao for employee.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * list leave details by id.
   * @param empId id to get employee leave details.
   * @return Employee
   */
  public static LeaveDetails[] listById(final int empId) {
    List<LeaveDetails> es = dao().finder(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * list leave details by id.
   * @param leaveId id to get employee leave details.
   * @return Employee
   */
  public static LeaveDetails listByLid(final int leaveId) {
    return dao().levId(leaveId);
  }
  /**
   * list leave details by id.
   * @param empId id to get employee leave details.
   * @return Employee
   */
  public static LeaveDetails[] listByEid(final int empId) {
    List<LeaveDetails> es = dao().pendingRec(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * @param empId to indicate employee Id.
   * @param leaveId to indicate leave Id.
   * @param leaveMgrComment to indicate manager comment.
   * @param leaveStatus to indicate leave Status.
   * @return res.
   */
  public static String approveDeny(final int leaveId, final int empId,
      final String leaveMgrComment, final String leaveStatus) {
    String res = "";
    if (leaveStatus.equals("APPROVED")) {
      dao().approve(leaveId, leaveMgrComment, LeaveStatus.valueOf(leaveStatus));
      res = "Successfully Approved";
    } else if (leaveStatus.equals("DENIED")) {
      dao().approve(leaveId, leaveMgrComment, LeaveStatus.valueOf(leaveStatus));
      LeaveDetails l1 = listByLid(leaveId);
      int days = l1.getLeaveNoDays();
      dao().deny(empId, days);
      res = "Successfully Denied";
    } else {
      res = "";
    }
    return res;
  }
}

