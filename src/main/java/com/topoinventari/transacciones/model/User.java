package com.topoinventari.transacciones.model;

/**
 * Created by elatha on 8/8/17.
 */
public class User {

    private String name;
    private int credit;
    private int id;

    public User(int id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public void insertCredit(int amount) {
        this.credit += amount;
    }

    public void withdrawCredit(int amount) {
        this.credit -= amount;
    }
}
