package com.topoinventari.transacciones.controllers;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;
import com.topoinventari.transacciones.services.TransactionService;
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

    private TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/**
     * With the URL we get all the transactions
     * */
    @GET
    public String transactionsList() {

        Map<Integer, Transaction> transactions = transactionService.getTransactions();

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

        Map<Integer, Transaction> transactions = transactionService.getTransactions();

        final Transaction transaction = transactions.get(transactionId);
        final Map<String, Object> values = new HashMap<>();
        values.put("transaction", transaction);

        return HandlebarsUtil.processTemplate("transactions/transactionDetail",values);

    }

}
