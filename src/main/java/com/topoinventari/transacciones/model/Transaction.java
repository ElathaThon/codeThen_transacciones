package com.topoinventari.transacciones.model;

/**
 * Created by elatha on 8/8/17.
 */
public class Transaction {

    private int id;
    private User from;
    private User to;
    private int amount;
    private String concept;

    public Transaction(int id, User from, User to, int amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.concept = "";
    }

    public Transaction(int id, User from, User to, int amount, String concept) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.concept = concept;
    }

    public int getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public int getAmount() {
        return amount;
    }

    public String getConcept() {
        return concept;
    }

}
