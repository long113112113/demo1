package com.example.model;

import java.util.Date;

public class Food {
    private int id;
    private String name;
    private int price;
    private int stock;
    private Date expired_date;

    public Food(int id, String name, int price, int stock, Date expired_date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.expired_date = expired_date;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }
    public Date getExpired_date() {
        return expired_date;
    }
}
