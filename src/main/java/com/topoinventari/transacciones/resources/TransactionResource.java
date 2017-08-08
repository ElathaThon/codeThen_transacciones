package com.topoinventari.transacciones.resources;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by elatha on 8/8/17.
 */

@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionResource {

    private Map<Integer,Transaction> transactions;

    public TransactionResource() {

        User pepe = new User("Pepe",60);
        User mary = new User("Mary",30);
        User lucy = new User("Lucy",40);
        User johny = new User("Johny",50);

        transactions = new HashMap<>();
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
            String to = transaction.getTo().getName();
            int amount = transaction.getAmount();

            html += "<li>" + id +" - " + generateHref("/user", from) + " gives "
                    + generateHref("/detail",amount + " bitcoins")
                    + " to " + generateHref("/user", to) + "</li>";
        }
        html += "</ul>";

        return html;
    }

    /** Generates a href string that goes to the destination and shows the text */
    private String generateHref(String destination, String text) {
        return "<a href='"+ destination + "'>" + text + "</a>";
    }

}
