package com.topoinventari.transacciones.services;


import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * To work with transactions
 */
public class TransactionService {

	private Map<Integer, Transaction> transactions;

	/**
	 * Initalize with all the transactions
	 */
	public TransactionService() {

		UserService userService = new UserService();

		User pepe = userService.userSelectionById(1);
		User mary = userService.userSelectionById(2);
		User lucy = userService.userSelectionById(3);
		User johny = userService.userSelectionById(4);

		this.transactions = new HashMap<>();
		transactions.put(1, new Transaction(1, pepe, mary, 10));
		transactions.put(2, new Transaction(2, lucy, johny, 5));
		transactions.put(3, new Transaction(3, mary, pepe, 7));

	}

	/**
	 * Return a map with all the transactions
	 */
	public Map<Integer, Transaction> getTransactions() {
		return this.transactions;
	}


}
