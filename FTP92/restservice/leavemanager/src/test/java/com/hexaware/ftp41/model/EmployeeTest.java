package com.hexaware.ftp41.model;

import com.hexaware.ftp41.persistence.EmployeeDAO;
import com.hexaware.ftp41.persistence.LeaveDetailsDAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {
  /**
   * changing the date format.
   * @param sdate to store start date.
   * @param edate to store end date.
   * @param aod to store applied date.
   */
  private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
  private String sdate = "10-05-2018";
  private String edate = "11-05-2018";
  private String aod = "09-05-2018";
  /**private LeaveType leavetype = LeaveType.EL;
  private LeaveStatus leavestatus = LeaveStatus.PENDING;*/
  /**
   * setup method.
   */
  @Before
public void initInput() {

  }
  /**
   * Tests the constructor, getters, setters methods of the employee class.
   * @throws ParseException for exception in date
   */
  @Test
  public final void testEmployee() throws ParseException {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    //Date d = new Date(2018 - 03 - 15);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
    Employee e = new Employee(2001, "Neha S", "NehaS3@hexaware.com", 9456894466L,  "FTP", sdf.parse("2018-03-15"),
            63, 2000);
    assertEquals("Neha S", e.getEmpName());
    assertEquals("NehaS3@hexaware.com", e.getEmpMailAddress());
    assertEquals(9456894466L, e.getEmpMobileNumber());
    assertEquals("FTP", e.getEmpDepartment());
    assertEquals(sdf.parse("2018-03-15"), e.getEmpDateJoined());
    assertEquals(63, e.getEmpLeaveBalance());
    assertEquals(2000, e.getEmpMgrId());
    e.setEmpId(2001);
    assertEquals(2001, e.getEmpId());
    e.setEmpName("Neha S");
    assertEquals("Neha S", e.getEmpName());
    e.setEmpMailAddress("NehaS3@hexaware.com");
    assertEquals("NehaS3@hexaware.com", e.getEmpMailAddress());
    e.setEmpMobileNumber(9456894466L);
    assertEquals(9456894466L, e.getEmpMobileNumber());
    e.setEmpDepartment("FTP");
    assertEquals("FTP", e.getEmpDepartment());
    e.setEmpDateJoined(sdf.parse("2018-03-15"));
    assertEquals(sdf.parse("2018-03-15"), e.getEmpDateJoined());
    e.setEmpLeaveBalance(63);
    assertEquals(63, e.getEmpLeaveBalance());
    e.setEmpMgrId(2000);
    assertEquals(2000, e.getEmpMgrId());
  }
/**
 * test case for hash code of employee.
 */
  @Test
  public final void testHashCodeEmp() {
    Date d1 = new Date(2018 - 03 - 15);
    Employee emp1 = new Employee(1000, "Shashank",
        "ShashankM3@hexaware.com", 8884030037L, "FTP", d1, 8, 0);
    assertEquals(new Employee(1000, "Shashank",
        "ShashankM3@hexaware.com", 8884030037L, "FTP", d1, 8, 0).hashCode(), emp1.hashCode());
  }
  /**
   *Tests the toString method for employee class.
   */
  @Test
  public final void testToString() {
    Date d1 = new Date(2018 - 03 - 15);
    String str1 = "Empid :" + 1000 + "Empname :" + "Shashank" + "Empmailaddress :"
        + "ShashankM3@hexaware.com" + "\t" + "Empmobilenum :" + 8884030037L + "\t" + "Empdpmnt :" + "FTP"
        + "\t" + "Empdatejoin :" + d1 + "\t" + "Empleavebalance :" + 3 + "\t" + "Emplmanager :" + 0;
    Employee emp1 = new Employee(1000, "Shashank", "ShashankM3@hexaware.com", 8884030037L, "FTP", d1, 3, 0);
    assertEquals(str1, emp1.toString());
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }
  /**
   * Test for Apply Leave.
   * @param dao for mocking the EmployeeDAO class
   * @param dao1 for mocking the LeaveDetailsDAO class
   * @throws ParseException exception
   */
  @Test
  public final void testapplyLeave(@Mocked final EmployeeDAO dao,
                     @Mocked final LeaveDetailsDAO dao1) throws ParseException {
    Employee em = new Employee(2001, "Neha S", "NehaS3@hexaware.com", 9456894466L,  "FTP", sdf.parse("2018-03-15"),
                          13, 2000);
    String st = Employee.apply(3000, sdf.parse("2018-05-16"), sdf.parse("2018-05-14"), 4, sdf.parse("2018-05-10"),
            "EL", "SICK");
    String st1 = "ALERT: End date shoud be greter than Start date";
    System.out.println("st1" + st1);
    assertEquals(st1, st);
    String st2 = Employee.apply(3000, sdf.parse("2018-05-11"), sdf.parse("2018-05-13"), -3, sdf.parse("2018-05-14"),
            "EL", "SICK");
    String st3 = "ALERT: invalid number of days";
    System.out.println("st3" + st3);
    assertEquals(st3, st2);
    String st4 = Employee.apply(3001, sdf.parse("2018-05-10"), sdf.parse("2018-05-14"), 0, sdf.parse("2018-05-14"),
            "EL", "SICK");
    String st5 = "ALERT: invalid number of days";
    System.out.println("st5" + st5);
    assertEquals(st5, st4);
    String st6 = Employee.apply(3001, sdf.parse("2018-05-11"), sdf.parse("2018-05-12"), 3, sdf.parse("2018-05-10"),
            "EL", "SICK");
    String st7 = "ALERT: invalid number of days";
    System.out.println("st7" + st7);
    assertEquals(st7, st6);
    String st8 = Employee.apply(3001, sdf.parse("2018-04-11"), sdf.parse("2018-05-12"), 2, sdf.parse("2018-05-10"),
            "EL", "SICK");
    String st9 = "Start date cannot be lesser than today's date";
    System.out.println("st8" + st9);
    assertNotEquals(st9, st8);

  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
}
