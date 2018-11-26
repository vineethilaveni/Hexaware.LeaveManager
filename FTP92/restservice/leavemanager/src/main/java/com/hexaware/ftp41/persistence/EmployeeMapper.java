package com.hexaware.ftp41.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp41.model.Employee;
/**
 * Mapper class to map from result set to employee object.
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped employee object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Employee map(final int idx, final ResultSet rs, final      StatementContext ctx) throws SQLException {
    /**
     * @return Employee
     */
    return new Employee(rs.getInt("EMP_ID"), rs.getString("EMP_NAME"),
    rs.getString("EMP_EMAIL_ADDRESS"), rs.getLong("EMP_MOBILE_NUMBER"),
    rs.getString("EMP_DEPARTMENT"), rs.getDate("EMP_DATE_JOINED"),
    rs.getInt("EMP_AVAILABLE_LEAVE_BALANCE"), rs.getInt("EMP_MGR_ID"));
  }
}
