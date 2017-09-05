package com.topoinventari.transacciones.controllers;

import com.topoinventari.transacciones.model.User;
import com.topoinventari.transacciones.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * API for {@link User}
 */

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersApi {

	private UserService userService = new UserService();

	public UsersApi(UserService userService) {
		this.userService = userService;
	}

	/**
	 * With the URL we get all the {@link User} that match with the search param if it exists, if there are any param it gets all the {@link User}
	 */
	@GET
	public Collection<User> usersList(@QueryParam("search") String search){

		return userService.findByName(search);

	}

	/**
	 * to get the {@link User} with the id in the pathParam
	 */
	@GET
	@Path("{id}")
	public User userDetail(@PathParam("id") int id){
		return userService.getById(id);
	}
}
