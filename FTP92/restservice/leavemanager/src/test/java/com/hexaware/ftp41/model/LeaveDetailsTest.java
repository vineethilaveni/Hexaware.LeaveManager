package com.hexaware.ftp41.model;

import com.hexaware.ftp41.persistence.LeaveDetailsDAO;
//package com.hexaware.ftp41.test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
/**
* Test class for leave details.
*/
public class LeaveDetailsTest {
 /**
  * @param sdf creating date format obj.
  * @param leavetype  variable of Leave Type.
  * @param leavestatus variable of Leave Status.
  * @param sdate to store start date.
  * @param edate to store end date.
  * @param aod to store applied date.
  */
  private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
  private LeaveType leavetype = LeaveType.EL;
  private LeaveStatus leavestatus = LeaveStatus.PENDING;
  private String sdate = "10-05-2018";
  private String edate = "11-05-2018";
  private String aod = "09-05-2018";
/**
 * getters and setters of Leave details.
 * @throws ParseException while testing.
 */
  @Test
    public final void testGetSet()throws ParseException {
    LeaveDetails lea = new LeaveDetails(3000, 1, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
         sdf.parse(aod), leavestatus, "SICK", "OK");
    assertEquals(3000, lea.getEmpId());
    assertEquals(1, lea.getLeaveId());
    assertEquals(2, lea.getLeaveNoDays());
    assertEquals(sdf.parse(sdate), lea.getLeaveStartDate());
    assertEquals(sdf.parse(edate), lea.getLeaveEndDate());
    assertEquals(leavetype, lea.getLeaveType());
    assertEquals(sdf.parse(aod), lea.getLeaveAppliedOn());
    assertEquals(leavestatus, lea.getLeaveStatus());
    assertEquals("SICK", lea.getLeaveReason());
    assertEquals("OK", lea.getLeaveMgrComment());
    String sd = "15-05-2018";
    String ed = "16-05-2018";
    LeaveDetails lea1 = new LeaveDetails(3001, 2, 2, sdf.parse(sd),  sdf.parse(ed), leavetype,
         sdf.parse(aod), leavestatus, "HEADACHE", "OK");
    assertEquals(3001, lea1.getEmpId());
    lea1.setEmpId(3001);
    assertEquals(2, lea1.getLeaveId());
    lea1.setLeaveId(2);
    assertEquals(2, lea1.getLeaveNoDays());
    lea1.setLeaveNoDays(2);
    assertEquals(sdf.parse(sd), lea1.getLeaveStartDate());
    lea1.setLeaveStartDate(sdf.parse(sd));
    assertEquals(sdf.parse(ed), lea1.getLeaveEndDate());
    lea1.setLeaveEndDate(sdf.parse(ed));
    assertEquals(leavetype, lea1.getLeaveType());
    lea1.setLeaveType(leavetype);
    assertEquals(sdf.parse(aod), lea1.getLeaveAppliedOn());
    lea1.setLeaveAppliedOn(sdf.parse(aod));
    assertEquals(leavestatus, lea.getLeaveStatus());
    lea1.setLeaveStatus(leavestatus);
    assertEquals("HEADACHE", lea1.getLeaveReason());
    lea1.setLeaveReason("HEADACHE");
    assertEquals("OK", lea1.getLeaveMgrComment());
    lea1.setLeaveMgrComment("OK");
  }
    /**
     * Testing that a list for leave history.
     * @param dao mocking the dao class.
     * @throws ParseException throw exception.
     */
  public final void testLeaveHistory(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    new Expectations() {
      {
        ArrayList<LeaveDetails> ld = new ArrayList<LeaveDetails>();
        ld.add(new LeaveDetails(3000, 34, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "reason", "ok"));
        dao.finder(3000);

        result = ld;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es = LeaveDetails.listById(3000);
    assertEquals(new LeaveDetails(3000, 34, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "reason", "ok"), es[0]);

    new Expectations() {
      {
        ArrayList<LeaveDetails> ld1 = new ArrayList<LeaveDetails>();
        ld1.add(new LeaveDetails(1000, 14, 3, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "no reason", "ok"));
        dao.finder(1000);

        result = ld1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es1 = LeaveDetails.listById(1000);
    //assertEquals(1, es.length);
    assertEquals(new LeaveDetails(1000, 14, 3, sdf.parse(sdate), sdf.parse(edate), leavetype,
              sdf.parse(aod), leavestatus, "no reason", "ok"), es1[0]);
    new Expectations() {
      {
        ArrayList<LeaveDetails> ld = new ArrayList<LeaveDetails>();
        ld.add(new LeaveDetails(3001, 34, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "SICK", "ok"));
        dao.finder(3001);

        result = ld;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es3 = LeaveDetails.listById(3001);
    assertEquals(new LeaveDetails(3001, 34, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "SICK", "ok"), es3[0]);
  }
/**
 * test case for pending leave of Leave details.
 * @param dao is the refrence variable.
 * @throws ParseException while testing.
 */
  public final void testPendingLeave(@Mocked final LeaveDetailsDAO dao)throws ParseException {
    new Expectations() {
        {
          ArrayList<LeaveDetails> al = new ArrayList<LeaveDetails>();
          al.add(new LeaveDetails(1000, 1, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod),  leavestatus, "sick", "OK"));
          dao.pendingRec(1000);
          result = al;
        }
      };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] es2 = LeaveDetails.listByEid(1000);
    assertEquals(new LeaveDetails(1000, 1, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "sick", "ok"), es2[0]);

    new Expectations() {
        {
          ArrayList<LeaveDetails> al = new ArrayList<LeaveDetails>();
          al.add(new LeaveDetails(2000, 1, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod),  leavestatus, "no reason", "OK"));
          dao.pendingRec(2000);
          result = al;
        }
      };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] a2 = LeaveDetails.listByEid(2000);
    assertEquals(new LeaveDetails(2000, 1, 2, sdf.parse(sdate), sdf.parse(edate), leavetype,
                sdf.parse(aod), leavestatus, "no reason", "ok"), a2[0]);
  }
   /**
     * Tests the hashcode methods of the leave details class.
     * @throws ParseException throws the exception.
     */
  @Test
    public final void testHashcodeLeave() throws ParseException {
    final LeaveStatus ls = LeaveStatus.PENDING;
    final LeaveType lt = LeaveType.EL;
    LeaveDetails ld = new LeaveDetails(2000, 1, 2, sdf.parse("2018-02-21"), sdf.parse("2018-02-22"), lt,
                            sdf.parse("2018-02-10"), ls, "FUNCTION", " ");
    assertEquals(new LeaveDetails(2000, 1, 2, sdf.parse("2018-02-21"), sdf.parse("2018-02-22"),
                            lt, sdf.parse("2018-02-10"), ls, "FUNCTION", " ").hashCode(), ld.hashCode());
  }
  /**
    * Tests the toString method for Leave Details class.
    * @throws ParseException throws the exception.
    */
  @Test
  public final void testToStringLeave() throws ParseException {
    final LeaveStatus ls = LeaveStatus.PENDING;
    final LeaveType lt = LeaveType.EL;
    String str = "empid :" + 2000 + "\t" + "leaveId :" + 1 + "\t" + "leaveNoDays :" + 2 + "\t"
                 + "leaveStartDate :" + sdf.parse(sdate) + "\t"
                 + "leaveEndDate :" + sdf.parse(edate) + "\t"
                 + "leaveType :" + lt + "\t" + "leaveAppliedOn :" + sdf.parse(aod) + "\t"
                 + "leaveStatus :" + ls + "\t" + "leaveReason :" + "Function" + "\t"
                 + "leaveMgrComment :" + "";
    LeaveDetails ld = new LeaveDetails(2000, 1, 2, sdf.parse(sdate), sdf.parse(edate),
        lt, sdf.parse(aod), ls, "Function", "");
    assertEquals(str, ld.toString());
  }


  /**
    * Tests the approve deny method for Leave Details class.
    * @param dao mocking the dao class.
    * @throws ParseException throws the exception.
    */
  @Test
  public final void testapproveOrDeny(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    LeaveDetails ld = new LeaveDetails(2000, 1, 2, sdf.parse("2018-02-21"), sdf.parse("2018-02-22"),
              LeaveType.valueOf("EL"), sdf.parse("2018-02-10"), LeaveStatus.valueOf("PENDING"),
              "Function", "");
    new Expectations() {
        {
          dao.approve(1, "", LeaveStatus.valueOf("APPROVED"));
          //dao.deny(2000, 2);
          }
    };
    new MockUp<LeaveDetails>() {
        @Mock LeaveDetailsDAO dao() {
            return dao;
        }
    };
    String str = LeaveDetails.approveDeny(1, 2001, "", "APPROVED");
    assertEquals("Successfully Approved", str);
    String str1 = LeaveDetails.approveDeny(2, 3000, "", "DENIED");
    assertEquals("Successfully Denied", str1);
    new Expectations() {
        {
          dao.approve(2, "", LeaveStatus.valueOf("APPROVED"));
          //dao.deny(2000, 2);
          }
    };
    new MockUp<LeaveDetails>() {
        @Mock LeaveDetailsDAO dao() {
            return dao;
        }
    };
    String str2 = LeaveDetails.approveDeny(2, 2001, "", "APPROVED");
    assertEquals("Successfully Approved", str2);
    String str3 = LeaveDetails.approveDeny(3, 3000, "", "DENIED");
    assertEquals("Successfully Denied", str3);
  }
  /**
   * Tests the equals methods of the leave details class.
   * @throws ParseException throws the exception.
   */
  @Test
  public final void testEquals() throws ParseException {
    LeaveDetails lev = new LeaveDetails(3000, 14, 5, sdf.parse(sdate), sdf.parse(edate), leavetype,
        sdf.parse(aod), leavestatus, "Headache", "i vl grant");
    LeaveDetails lev1 = new LeaveDetails(3000, 14, 5,  sdf.parse(sdate), sdf.parse(edate), leavetype,
        sdf.parse(aod), leavestatus, "Headache", "i vl grant");
    assertEquals(lev, lev1);
  }
}
