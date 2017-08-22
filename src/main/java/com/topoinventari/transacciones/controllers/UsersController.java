package com.topoinventari.transacciones.controllers;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;
import com.topoinventari.transacciones.util.HandlebarsUtil;
import com.topoinventari.transacciones.util.MustacheUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by elatha on 8/8/17.
 */


@Path("/users")
@Produces(MediaType.TEXT_HTML)
public class UsersController {

    private Map<Integer,User> users;

    public UsersController() {

        this.users = new HashMap<>();
        users.put(1, new User(1,"Pepe",60));
        users.put(2, new User(2,"Mary",30));
        users.put(3, new User(3,"Lucy",40));
        users.put(4, new User(4,"Johny",50));

    }

    @GET
    public String userList(@QueryParam("search") String search) {

        final Map<String, Object> values = new HashMap<>();
        if (search != null) {

            //Es filtra la llista de users que tenim
            for (int i=1; i < users.size()+1; i++) {

                User actualUser = users.get(i);
                String actualName = actualUser.getName();
                if (actualName.toLowerCase().equals(search.toLowerCase())) {
                    values.put("users", actualUser);
                }
            }

            System.out.println("Se han encontrado: " + values.size() + " resultados");

        } else {
            values.put("users", users.values());
        }

        return HandlebarsUtil.processTemplate("users/userList", values);
    }

    @GET
    @Path("/{id}")
    public String userDetail(@PathParam("id") int userId){

        User user = users.get(userId);
        final Map<String, Object> values = new HashMap<>();
        values.put("user", user);

        return HandlebarsUtil.processTemplate("users/userDetail",values);

    }


}
