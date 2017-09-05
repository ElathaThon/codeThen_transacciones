package com.topoinventari.transacciones.services;


import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * To work with {@link Transaction}
 */
public class TransactionService {

	private Map<Integer, Transaction> transactions;

	/**
	 * Initalize with all the transactions
	 */
	public TransactionService() {

		UserService userService = new UserService();

		User pepe = userService.getById(1);
		User mary = userService.getById(2);
		User lucy = userService.getById(3);
		User johny = userService.getById(4);

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

	/**
	 * Return a Collection with the transactions that match with the name of the user in From transaction
	 * */
	public Collection<Transaction> findByFrom(String search) {

		final Collection<Transaction> result;

		if (search != null) {
			result = this.transactions.values().stream()
					.filter(transaction -> transaction.getFrom().getName().toLowerCase().contains(search.toLowerCase()))
					.collect(Collectors.toList());
		} else {
			result = this.transactions.values();
		}

		return result;
	}

	/**
	 * Returns the Transaction with the id given
	 * */
	public Transaction getById(int id){
		return transactions.get(id);
	}

}
