package solutions.egen.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import solutions.egen.dao.ReservationDAO;
import solutions.egen.exception.AppException;
import solutions.egen.model.Reservation;

@Path("/rsv")
@Api(tags={"/Reservation"})
public class ReservationController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value="Find all Reservations",
			notes="finds all reservations in the database"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public List<Reservation> findAll(){
		try {
			ReservationDAO dao=new ReservationDAO();
			return dao.fetchAll();
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value="Find one Reservation",
			notes="finds a reservation with its id in the database"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=404,message="Not Found"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public Reservation findOne(@PathParam("id") int rsvId) {
		try {
			ReservationDAO dao = new ReservationDAO();
			Reservation rsv= dao.fetchOne(rsvId);
			if(rsv == null){
				throw new WebApplicationException(Status.NOT_FOUND);
			}else{
				return rsv;
			}
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value="Create",
			notes="creates an reservation"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public Reservation create(Reservation rsv){
		try {
			ReservationDAO dao = new ReservationDAO();
			return dao.create(rsv);
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value="Update",
			notes="updates a reservation"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public Reservation update(@PathParam("id") int empId,Reservation rsv){
		try {
			ReservationDAO dao = new ReservationDAO();
			return dao.update(empId, rsv);
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@ApiOperation(
			value="Delete",
			notes="deletes a reservation"
	)
	@ApiResponses(value={
			@ApiResponse (code=200,message="Success"),
			@ApiResponse (code=500,message="Internal Server Error")
	})
	public Reservation delete(@PathParam("id") int rsvId){
		try {
			ReservationDAO dao = new ReservationDAO();
			Reservation rsv= dao.delete(rsvId);
			if(rsv == null){
				throw new WebApplicationException(Status.NOT_FOUND);
			}else{
				return rsv;
			}
		} catch (AppException e) {
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}	
	}
}
