package com.hexaware.ftp41.model;

import com.hexaware.ftp41.persistence.DbConnection;
import com.hexaware.ftp41.persistence.EmployeeDAO;
/**import com.hexaware.ftp41.model.LeaveType;
import com.hexaware.ftp41.model.LeaveDetails;*/

import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  private  int empId;
  /**
   *empId to store employee id.
   */
  private String empName;
  /**
  empName to store employee name.
   */
  private String empMailAddress;
  /**
  empName to store employee Mail Address.
   */
  private long empMobileNumber;
  /**
  empName to store employee mobile number.
   */
  private String empDepartment;
  /**
  empName to store employee Department.
   */
  private Date empDateJoined;
  /**
  empName to store employee Date of Join.
   */
  private int empLeaveBalance;
  /**
  empName to store employee Laeve balance.
   */
  private int empMgrId;
  /**
  empName to store employee Manager's Id.
   */

  @Override
  public final boolean equals(final Object obj) {

    if (obj == null) {

      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
        && Objects.equals(empMailAddress, emp.empMailAddress) && Objects.equals(empMobileNumber, emp.empMobileNumber)
        && Objects.equals(empDepartment, emp.empDepartment) && Objects.equals(empDateJoined, emp.empDateJoined)
        && Objects.equals(empLeaveBalance, emp.empLeaveBalance) && Objects.equals(empMgrId, emp.empMgrId)) {
      return true;
    }
    return false;
  }


  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empMailAddress,
    empMobileNumber, empDepartment, empDateJoined, empLeaveBalance, empMgrId);
  }

  @Override
  public final String toString() {
    return "Empid :" + empId
      + "Empname :" + empName
      + "Empmailaddress :" + empMailAddress + "\t"
      + "Empmobilenum :" + empMobileNumber + "\t"
      + "Empdpmnt :" + empDepartment + "\t"
      + "Empdatejoin :" + empDateJoined + "\t"
      + "Empleavebalance :" + empLeaveBalance + "\t"
      + "Emplmanager :" + empMgrId;
  }
  /**
   *@param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;

  }

  /**
   *@param argEmpId to initialize employee id.
   *@param argEmpName to initialize employee name.
   *@param argEmpMailAddress to initialize employee mail address.
   *@param argEmpMobileNumber to initialize employee mobile number.
   *@param argEmpDepartment to initialize employee department.
   *@param argEmpDateJoined to initialize employee join date.
   *@param argEmpLeaveBalance to initialize employee leave balance.
   *@param argEmpMgrId to initialize employee manager id.
   */
  public Employee(final int argEmpId, final String argEmpName,
                 final String argEmpMailAddress, final long argEmpMobileNumber,
                 final String argEmpDepartment, final Date argEmpDateJoined,
                 final int argEmpLeaveBalance, final int argEmpMgrId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empMailAddress = argEmpMailAddress;
    this.empMobileNumber = argEmpMobileNumber;
    this.empDepartment = argEmpDepartment;
    this.empDateJoined = argEmpDateJoined;
    this.empLeaveBalance = argEmpLeaveBalance;
    this.empMgrId = argEmpMgrId;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's Id.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }
   /**
   * Gets the EmployeeMailAddress.
   * @return this Employee's MailAddress.
   */
  public final String getEmpMailAddress() {
    return empMailAddress;
  }
  /**
   * Gets the EmployeeMobileNumber.
   * @return this Employee's Mobile Number.
   */
  public final long getEmpMobileNumber() {
    return empMobileNumber;
  }
  /**
   * Gets the Employee Department.
   * @return this Employee's Department.
   */
  public final String getEmpDepartment() {
    return empDepartment;
  }
  /**
   * Gets the EmployeeDateJoined.
   * @return this Employee's DateJoined.
   */
  public final Date getEmpDateJoined() {
    return empDateJoined;
  }
  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's LeaveBalance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }
  /**
   * Gets the EmployeeMgr.
   * @return this Employee's Mgr.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }
  /**
   * @param argEmpId to set employee EmpId.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   *
   * @param argEmpName to set employee EmpName.
   */

  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   *
   * @param  argEmpMailAddress to set employee mailaddress.
   */
  public final void setEmpMailAddress(final String argEmpMailAddress) {
    this.empMailAddress = argEmpMailAddress;
  }

  /**
   *
   * @param argEmpMobileNumber to set employee MobileNumber.
   */
  public final void setEmpMobileNumber(final long argEmpMobileNumber) {
    this.empMobileNumber = argEmpMobileNumber;
  }

  /**
   *
   * @param argEmpDepartment  to set employee Department .
   */
  public final void setEmpDepartment(final String argEmpDepartment) {
    this.empDepartment = argEmpDepartment;
  }

  /**
   *
   * @param argEmpDateJoined to set employee DateJoined .
   */

  public final void setEmpDateJoined(final Date argEmpDateJoined) {
    this.empDateJoined = argEmpDateJoined;
  }

  /**
   *
   * @param argEmpLeaveBalance to set employee  LeaveBalance .
   */

  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }
  /**
   *
   * @param argEmpMgrId to set employee  Manager Id .
   */

  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

  /**
   *The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }
  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }
  /**
   * @param sdate id to get leave start date.
   * @param edate id to get leave end date.
   * @return comapare details.
   */
  public static boolean compare(final Date sdate, final Date edate) {
    return edate.after(sdate);
  }
  /**
   * @param sdate id to get leave start date.
   * @param aod id to get current date.
   * @return compare start date and current date.
   */
  public static boolean current(final Date sdate, final Date aod) {
    return sdate.after(aod);
  }
  /**
   * list employee details by id.
   * @param empId to get employee id.
   * @param sdate id to get leave start date.
   * @param edate id to get leave end date.
   * @param nod id to get number of days.
   * @param aod id to get leave applied date.
   * @param leaveType id to get applied leave type.
   * @param levRes to store leave reason.
   * @return employee leave details.
   */
  public static String apply(final int empId, final Date sdate,
      final Date edate, final int nod,
      final Date aod, final String leaveType, final String levRes) {
    String value = null;
    Employee empl = Employee.listById(empId);
    int mgrId = empl.getEmpMgrId();
    int temp1 = empl.getEmpLeaveBalance();
    LeaveDetails[] l = null;
    Date sd1 = null, ed1 = null;
    try {
      l = LeaveDetails.listById(empId);
    } catch (Exception e) {
      System.out.println(" ABC ");
    }
    if (compare(sdate, edate)) {
      System.out.println("");
      if (current(sdate, aod)) {
        System.out.println("");
      } else {
        System.out.println("*****************************************");
        value = "Start date cannot be lesser than today's date";
      }
      long diff = edate.getTime() - sdate.getTime();
      long nod1 = diff / (1000 * 60 * 60 * 24) + 1;
      if (nod == nod1 && nod > 0)  {
        System.out.println("");
      } else {
        System.out.println("*****************************************");
        value = "ALERT: invalid number of days";
        System.out.println("*****************************************");
      }
      if (nod <= temp1) {
        System.out.println("");
      } else {
        System.out.println("*****************************************");
        value = "SORRY!!! you dont have sufficient leave balance to apply for leave";
      }
    } else {
      System.out.println("*****************************************");
      value = "ALERT: End date shoud be greter than Start date";
    }
    if (mgrId == 0) {
      dao().autoApprove(empId);
    }
    try {
      for (LeaveDetails lev : l) {
        sd1 = lev.getLeaveStartDate();
        ed1 = lev.getLeaveEndDate();
        if (sdate.compareTo(sd1) >= 0 && sdate.compareTo(ed1) <= 0
            || edate.compareTo(sd1) >= 0 && edate.compareTo(ed1) <= 0) {
          System.out.println("You have already applied for a Leave..!!");
          System.out.println("please try again with different dates");
        } else {
          dao().insert(empId, sdate, edate, nod, aod, leaveType, levRes);
          dao().decrement(empId, nod);
          value = "Leave applied successfully";
        }
      }
    } catch (Exception e) {
      System.out.println(" ");
    }
    dao().insert(empId, sdate, edate, nod, aod, leaveType, levRes);
    dao().decrement(empId, nod);
    return value;
  }
}


