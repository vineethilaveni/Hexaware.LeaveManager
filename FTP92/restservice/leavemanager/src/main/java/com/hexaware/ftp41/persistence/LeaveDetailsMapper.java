package com.hexaware.ftp41.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp41.model.LeaveDetails;
import com.hexaware.ftp41.model.LeaveStatus;
import com.hexaware.ftp41.model.LeaveType;
/**
 * Mapper class to map from result set to leave detail object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
  /**
     * @return Employee
     */
    return new LeaveDetails(rs.getInt("EMP_ID"), rs.getInt("LEAVE_ID"),
    rs.getInt("LEAVE_NUMBER_OF_DAYS"), rs.getDate("LEAVE_START_DATE"),
    rs.getDate("LEAVE_END_DATE"), LeaveType.valueOf(rs.getString("LEAVE_TYPE")),
    rs.getDate("LEAVE_APPLIED_ON"), LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")),
    rs.getString("LEAVE_REASON"), rs.getString("LEAVE_MGR_COMMENT"));
  }
}
