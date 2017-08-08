package com.topoinventari.transacciones.resources;

import com.topoinventari.transacciones.model.Transaction;
import com.topoinventari.transacciones.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by elatha on 8/8/17.
 */
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

}
