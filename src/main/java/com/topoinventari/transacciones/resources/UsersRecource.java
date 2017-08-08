package com.topoinventari.transacciones.resources;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by elatha on 8/8/17.
 */


@Path("/users")
@Produces(MediaType.TEXT_HTML)
public class UsersRecource {

    private Map<Integer,User> users;

    public UsersRecource() {

        User pepe = new User(1,"Pepe",60);
        User mary = new User(2,"Mary",30);
        User lucy = new User(3,"Lucy",40);
        User johny = new User(4,"Johny",50);

    }


    @GET
    @Path("/{id}")
    public String userDetail(@PathParam("id") int userId){

        User user = users.get(userId);

        if (user != null){
            return user.toString();
        } else {
            return "<h1>User not found!!!</h1>";
        }

    }


}
