package com.hexaware.ftp41.util;
import com.hexaware.ftp41.model.LeaveDetails;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * This class provides a REST interface for the LeaveDeatails entity.
 */
@Path("/LeaveDetails")
public class LeaveDetailsRest {

  /**
   * Returns a list of all the employees.
   * @param id to store employee id.
   * @return a list of all the employees
   */
  @Path("{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsListById(@PathParam("id") final int id) {
    System.out.println("LeaveDetails List");
    final LeaveDetails[] lev = LeaveDetails.listById(id);
    if (lev == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return lev;
  }
  /**
   * Returns a list of all the employees.
   * @param id to store employee id.
   * @return a list of all the employees
   */
  @Path("{id}/pendingleave")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] leaveDetailsListByEmpId(@PathParam("id") final int id) {
    System.out.println("LeaveDetails List");
    final LeaveDetails[] leve = LeaveDetails.listByEid(id);
    if (leve == null) {
      throw new NotFoundException("No such Employee ID: " + id);
    }
    return leve;
  }
}
