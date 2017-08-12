package com.topoinventari.transacciones.controllers;

import com.topoinventari.customutils.MustacheUtil;
import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by elatha on 8/8/17.
 */

@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionController {

    private Map<Integer,Transaction> transactions;

    public TransactionController() {

        User pepe = new User(1,"Pepe",60);
        User mary = new User(2,"Mary",30);
        User lucy = new User(3,"Lucy",40);
        User johny = new User(4,"Johny",50);

        this.transactions = new HashMap<>();
        transactions.put(1, new Transaction(1, pepe, mary,10));
        transactions.put(2, new Transaction(2, lucy, johny,5));
        transactions.put(3, new Transaction(3, mary, pepe,7));

    }

    @GET
    public String transactionsList() {
        String html = "<h1>TRANSACTIONS</h1>";

        html += "<ul>";
        for (Transaction transaction : transactions.values()) {

            int id = transaction.getId();
            String from = transaction.getFrom().getName();
            int idFrom = transaction.getFrom().getId();
            String to = transaction.getTo().getName();
            int idTo = transaction.getTo().getId();
            int amount = transaction.getAmount();

//            html += "<li>" + id +" - " + generateHref("/users/" + idFrom, from) + " gives "
//                    + generateHref("/transactions/" + id,amount + " bitcoins")
//                    + " to " + generateHref("/users/" + idTo, to) + "</li>";

            html += "<li>" + id +" - " + MustacheUtil.generateHref("/users/" + idFrom, from) + " gives "
                    + generateHref("/transactions/" + id,amount + " bitcoins")
                    + " to " + generateHref("/users/" + idTo, to) + "</li>";

        }
        html += "</ul>";

        return html;
    }


    @GET
    @Path("/{id}")
    public String transactionDetail(@PathParam("id") int transactionId){

        Transaction transaction = transactions.get(transactionId);

        if (transaction != null) {
            return transaction.toString();
        } else {
            return "Transaction not found! :(";
        }


    }






    /** Generates a href string that goes to the destination and shows the text */
    private String generateHref(String destination, String text) {
        return "<a href='"+ destination + "'>" + text + "</a>";
    }



}
