package com.example.ottmanager;

public class Subscription {
    String ottName;
    long expiryDate;
    int cost;
    String favouriteShow;

    public Subscription(String ottName, long expiryDate, int cost, String favouriteShow) {
        this.ottName = ottName;
        this.expiryDate = expiryDate;
        this.cost = cost;
        this.favouriteShow = favouriteShow;
    }
}
