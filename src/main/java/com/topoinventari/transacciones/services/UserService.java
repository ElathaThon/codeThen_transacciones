package com.topoinventari.transacciones.services;

import com.topoinventari.transacciones.model.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * To work with {@link User}
 */
public class UserService {

	private Map<Integer, User> users;

	/**
	 * Initialize with all the users that we have
	 */
	public UserService() {

		this.users = new HashMap<>();
		users.put(1, new User(1, "Pepe", 60));
		users.put(2, new User(2, "Mary", 30));
		users.put(3, new User(3, "Lucy", 40));
		users.put(4, new User(4, "Johny", 50));

	}

	/**
	 * Returns a map with all the users
	 */
	public Map<Integer, User> getUsers() {
		return this.users;
	}

	/**
	 * Return a Collection with all the users that match with the name
	 */
	public Collection<User> findByName(String search) {

		final Collection<User> result;

		if (search != null) {
			result = this.users.values().stream()
					.filter(user -> user.getName().toLowerCase().contains(search.toLowerCase()))
					.collect(Collectors.toList());
		} else {
			result = this.users.values();
		}

		return result;
	}

	/**
	 * Return the user with the actual id, only can be 1 because the id is a primary key
	 */
	public User getById(int id) {
		return users.get(id);
	}
}
