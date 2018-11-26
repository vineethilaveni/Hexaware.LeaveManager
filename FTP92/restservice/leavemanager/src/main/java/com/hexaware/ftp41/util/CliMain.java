package com.hexaware.ftp41.util;
import java.util.Scanner;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.hexaware.ftp41.model.Employee;
import com.hexaware.ftp41.model.LeaveDetails;




/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply for Leave");
    System.out.println("4. Leave History");
    System.out.println("5. Pending Leave Request");
    System.out.println("6. Leave Status");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistory();
        break;
      case 5:
        pendingRequest();
        break;
      case 6:
        approveDeny();
        break;
      case 7:
        System.exit(0);
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println("Choose an option: ");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    System.out.println(" EmpId " + "  " + " EmpName "
          + "   " + " EmpMailAddress " + "             " + " EmpMobileNumber "
          + "    " + " EmpDepartment " + "      " + " EmpDateJoined "
          + "     " + " EmpLeaveBalance " + "     " + " EmpMgrId ");
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println(employee.getEmpId() + "  " + employee.getEmpName()
          + "  " + employee.getEmpMailAddress() + "  " + employee.getEmpMobileNumber()
          + "  " + employee.getEmpDepartment() + "  " + employee.getEmpDateJoined()

          + "  " + employee.getEmpLeaveBalance() + "  " + employee.getEmpMgrId());


    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    System.out.println(" EmpId " + "  " + " EmpName "
          + "  " + " EmpMailAddress " + "             " + " EmpMobileNumber "
          + "  " + " EmpDepartment " + "      " + " EmpDateJoined "
          + "     " + " EmpLeaveBalance " + "     " + " EmpMgrId ");
    for (Employee e : employee) {

      System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  " + e.getEmpMailAddress()
          + "  " + e.getEmpMobileNumber() + "  " + e.getEmpDepartment() + "  " + e.getEmpDateJoined()
          + "  " + e.getEmpLeaveBalance() + "  " + e.getEmpMgrId());


    }
  }


  private void leaveHistory() {
    int empId = 0;
    System.out.println("Enter an Employee Id");
    try {
      empId = option.nextInt();
    } catch (Exception e) {
      System.out.println("enter valid input");
      Runtime.getRuntime().halt(0);
    }
    Employee e = Employee.listById(empId);
    if (e == null) {
      System.out.println("Sorry,No such employee");
    } else {
      System.out.println("EMP_ID" + "    " + "LEAVE_ID" + "     " + "LEAVE_START_DATE" + "      "
          + "LEAVE_END_DATE" + "     " + "LEAVE_TYPE" + "    " + "LEAVE_STATUS" + "      "
          + "LEAVE_REASON" + "      " + "LEAVE_APPLIED_ON " + "     " + "MANAGER_COMMENTS"
          + "     " + "NUMBER_OF_DAYS" + "        ");
      LeaveDetails[] ld = LeaveDetails.listById(empId);
      int arrayLength = ld.length;
      if (arrayLength > 0) {
        for (LeaveDetails le : ld) {
          System.out.println(le.getEmpId() + "        " + le.getLeaveId() + "           "
               + le.getLeaveStartDate() + "           " + le.getLeaveEndDate() + "          "
               + le.getLeaveType() + "            " + le.getLeaveStatus() + "             "
               + le.getLeaveReason() + "            " + le.getLeaveAppliedOn() + "          "
               + le.getLeaveMgrComment() + "                    " + le.getLeaveNoDays());
        }
      } else {
        System.out.println("No Records found");

      }
    }
  }
  private void applyLeave() {
    int nod = 0;
    Date sdate = null, edate = null, aod = null;
    String leaveType = null, levRes = null;
    System.out.println("enter Employee Id");
    int empId = option.nextInt();
    System.out.println("****************************************");
    Employee empl = Employee.listById(empId);
    if (empl == null) {
      System.out.println("No such emp id is existing");
    } else {
      System.out.println("welcome!!! " + empl.getEmpName());
      System.out.println("****************************************");
      int temp1 = empl.getEmpLeaveBalance();
      System.out.println("your Available leave balance : " + temp1);
      System.out.println("****************************************");
      if (temp1 <= 0) {
        System.out.println("SORRY  " + empl.getEmpName() + " you dont have sufficient leave balance");
        System.out.println("****************************************");
      } else {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        System.out.println("enter leave Start date  (DD-mm-YYYY)");
        String sd = option.next();
        try {
          sdate = sdf.parse(sd);
        } catch (ParseException e) {
          System.out.println("enter valid start date");
          Runtime.getRuntime().halt(0);
        }
        System.out.println("*****************************************");
        System.out.println("enter leave end date (DD-mm-YYYY)");
        String ed = option.next();
        try {
          edate = sdf.parse(ed);
        } catch (ParseException e) {
          System.out.println("enter valid end date");
          Runtime.getRuntime().halt(0);
        }
        System.out.println("*****************************************");
        System.out.println("enter number of days");
        nod = option.nextInt();
        System.out.println("*****************************************");
        System.out.println("enter the  leave type");
        leaveType = option.next();
        System.out.println("*****************************************");
        System.out.println("enter the leave reason");
        levRes = option.next();
        System.out.println("*****************************************");
        aod = java.util.Calendar.getInstance().getTime();
        System.out.println("Leave applied on :" + aod);
        System.out.println("*****************************************");
        System.out.println(Employee.apply(empId, sdate, edate, nod, aod, leaveType, levRes));
      }
    }
  }
  private void approveDeny() {
    try {
      int status = 0;
      System.out.println("Enter Manager Employee ID");
      int mgrId = option.nextInt();
      Employee[] eid = Employee.listAll();
      for (Employee em : eid) {
        if (mgrId == em.getEmpMgrId()) {
          status = 1;
        } else {
          System.out.println("");
        }
      }
      if (status != 1) {
        System.out.println("Enter valid ID");
      } else {
        System.out.println("Enter Leave ID ");
        int leaveId = option.nextInt();
        LeaveDetails leave = LeaveDetails.listByLid(leaveId);
        if (leaveId == 0) {
          System.out.println("sorry, no such id exist");
          System.out.println("");
        } else {
          int empID = leave.getEmpId();
          System.out.println("");
          System.out.println("Empolyee id :" + empID);
          option.nextLine();
          System.out.println("Enter manager comments ");
          String mgrcomments = option.nextLine();
          System.out.println("");
          System.out.println("Enter status of the leave APPROVED OR DENIED)");
          String stat = option.next();
          String status1 = stat.toUpperCase();
          if (status1.equals("APPROVED") || status1.equals("DENIED")) {
            LeaveDetails.approveDeny(leaveId, empID, mgrcomments, status1);
          } else {
            System.out.println("You can't change");
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Enter correct id");
    }
  }

  private void pendingRequest() {
    System.out.println("Enter the Employee ID\n");
    try {
      int empId = option.nextInt();
      Employee e = Employee.listById(empId);
      if (e == null) {
        System.out.println("Sorry, No such Employee found");
      } else {
        LeaveDetails[] lpen = LeaveDetails.listByEid(empId);
        int arrayLength = lpen.length;
        if (arrayLength > 0) {
          System.out.println("Emp Id" + " " + "Leave ID" + " "
              + "No of Days" + " " + "Start Date" + " " + "End Date"
              + " " + "Leave Reason" + " " + "Applied On"  + " " + "Comments" + " " + "Status");
          for (LeaveDetails l: lpen) {
            System.out.println(l.getEmpId() + " " + l.getLeaveId()
                + " " + l.getLeaveNoDays()  + " " + l.getLeaveStartDate()
                + " " + l.getLeaveEndDate() + " " + l.getLeaveType()
                + " " + l.getLeaveReason() + " " + l.getLeaveAppliedOn()
                + " " + l.getLeaveMgrComment() + " " + l.getLeaveStatus());
          }
        } else {
          System.out.println("Employee has no pending leave");
        }
      }
    } catch (Exception exp) {
      System.out.println(" Invalid input ");
    }
  }

  /**
   * The main entry point.
   * @param ar the list of arguments.
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
