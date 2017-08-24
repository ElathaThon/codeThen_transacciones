package com.topoinventari.transacciones.services;

import com.topoinventari.transacciones.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * To work with users
 */
public class UserService {

    private Map<Integer,User> users;

    public UserService() {

        this.users = new HashMap<>();
        users.put(1, new User(1, "Pepe", 60));
        users.put(2, new User(2, "Mary", 30));
        users.put(3, new User(3, "Lucy", 40));
        users.put(4, new User(4, "Johny", 50));

    }

    public Map<Integer, User> getUsers() {
        return users;
    }
}
