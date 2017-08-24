package com.topoinventari.transacciones.services;

import com.topoinventari.transacciones.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * To work with users
 */
public class UserService {

    private Map<Integer,User> users;

    /**
     * Initialize with all the users that we have
     * */
    public UserService() {

        this.users = new HashMap<>();
        users.put(1, new User(1, "Pepe", 60));
        users.put(2, new User(2, "Mary", 30));
        users.put(3, new User(3, "Lucy", 40));
        users.put(4, new User(4, "Johny", 50));

    }

    /**
     * Returns a map with all the users
     * */
    public Map<Integer, User> getUsers() {
        return users;
    }

    /**
     * Return a list with all the users that mach with the name
     * */
    public List<User> userSelectionByName(String name) {

        final List<User> values = new ArrayList<User>();

        for (int i = 0; i < users.size(); i++) {

            User actualUser = users.get(i);
            String actualName = actualUser.getName();
            if (actualName.toLowerCase().equals(name.toLowerCase())) {
                values.add(actualUser);
            }
        }

        return values;
    }

    /**
     * Return the user with the actual id, only can be 1 because the id is a primary key
     * */
    public User userSelectionById(Integer id) {
        return users.get(id);
    }
}
