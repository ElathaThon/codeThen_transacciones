package com.topoinventari.transacciones.controllers;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;
import com.topoinventari.transacciones.util.HandlebarsUtil;
import com.topoinventari.transacciones.util.MustacheUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



/**
 * Get the transactions of the application, for this use the path url + /transactions
 * This endpoint produces a complete HTML page
 * */
@Path("/transactions")
@Produces(MediaType.TEXT_HTML)
public class TransactionController {

    /**
     * For the moment the transactions is initalized by hand. We need a Map with all transactions for the class
     * */
    private Map<Integer,Transaction> transactions;

    /**
     * Constructor and the iniziallition of all the transactions
     * */
    public TransactionController() {

        User pepe = new User(1, "Pepe", 60);
        User mary = new User(2, "Mary", 30);
        User lucy = new User(3, "Lucy", 40);
        User johny = new User(4, "Johny", 50);

        this.transactions = new HashMap<>();
        transactions.put(1, new Transaction(1, pepe, mary, 10));
        transactions.put(2, new Transaction(2, lucy, johny, 5));
        transactions.put(3, new Transaction(3, mary, pepe, 7));

    }

    /**
     * With the URL we get all the transactions
     * */
    @GET
    public String transactionsList() {

        final Map<String, Object> values = new HashMap<>();
        values.put("transactions", transactions.values());

        return HandlebarsUtil.processTemplate("transactions/transactionList", values);

    }


    /**
     * if we add to the url the id of the transaction that we want to see we obtain the HTML of the transaction detail
     * */
    @GET
    @Path("/{id}")
    public String transactionDetail(@PathParam("id") int transactionId) {

        final Transaction transaction = transactions.get(transactionId);
        final Map<String, Object> values = new HashMap<>();
        values.put("transaction", transaction);

        return HandlebarsUtil.processTemplate("transactions/transactionDetail",values);

    }

}
