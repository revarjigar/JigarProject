package solutions.egen.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import solutions.egen.dao.SettingsDAO;
import solutions.egen.exception.AppException;
import solutions.egen.model.Settings;

@Path("/settings")//jigar
@Api(tags={"/Settings"})
public class SettingsController {
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value="Update",
			notes="updates an employee"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public Settings update(@PathParam("id") int empID,Settings sett){
		try {
			SettingsDAO dao = new SettingsDAO();
			return dao.update(sett);
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
