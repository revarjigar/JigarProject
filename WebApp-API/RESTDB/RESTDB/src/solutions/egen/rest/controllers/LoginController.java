package solutions.egen.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import solutions.egen.dao.LoginDAO;
import solutions.egen.exception.AppException;
import solutions.egen.model.Login;

@Path("/login")
@Api(tags={"/Login"})
public class LoginController {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value="Authenticate",
			notes="authenticate in the database"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public boolean authenticate(Login log) throws AppException{
		try {
			return LoginDAO.authenticateUser(log);
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}	
	}
}
