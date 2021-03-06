package com.topoinventari.transacciones.controllers;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;
import com.topoinventari.transacciones.services.UserService;
import com.topoinventari.transacciones.util.HandlebarsUtil;
import com.topoinventari.transacciones.util.MustacheUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Get the users of the application, for this use the path url + /users
 * This endpoint produces a complete HTML page
 */
@Path("/users")
@Produces(MediaType.TEXT_HTML)
public class UsersController {

	private UserService userService = new UserService();

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * We get all the users. Using the GET method and the key search we can obtain the list filtered by his name
	 * URL + ?search=
	 */
	@GET
	public String userList(@QueryParam("search") String search) {

		final Collection<User> usersToDisplay = userService.findByName(search);

		final Map<String, Object> values = new HashMap<>();
		values.put("users", usersToDisplay);

		return HandlebarsUtil.processTemplate("users/userList", values);
	}

	/**
	 * if we add to the url the id of the user that we want to see we obtain the HTML of the user detail
	 */
	@GET
	@Path("/{id}")
	public String userDetail(@PathParam("id") int userId) {

		final User user = userService.getById(userId);

		final Map<String, Object> values = new HashMap<>();
		values.put("user", user);

		return HandlebarsUtil.processTemplate("users/userDetail", values);

	}


}
