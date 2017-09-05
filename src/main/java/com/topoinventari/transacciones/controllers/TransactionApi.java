package com.topoinventari.transacciones.controllers;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.services.TransactionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * The API for the transactions
 */

@Path("/api/transactions")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionApi {

	private TransactionService transactionService;

	public TransactionApi(TransactionService transactionService){
		this.transactionService = transactionService;
	}

	/**
	 * With the URL we get all the transactions that match with the search param if it exists, if there are any param it gets all the transactions
	 */
	@GET
	public Collection<Transaction> transactionsList(@QueryParam("search") String search){

		return transactionService.findByFrom(search);

	}

	/**
	 * to get the transaction with the id in the pathParam
	 */
	@GET
	@Path("{id}")
	public Transaction transactionDetail(@PathParam("id") int id){
		return transactionService.getById(id);
	}

}
