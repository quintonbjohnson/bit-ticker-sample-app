package com.github.quinton.bitserversampleapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * A model class to represent a crptocurrenncy ticker
 */
public class Currency {

    /*
     Retrieve the latest price for the given currency
     */
    @SerializedName("last_price")
    private double price;

    /**
     * Constructor for the cryptocurrency
     * @param price the current price of the cryptocurrency
     */
    public Currency(double price) {
        this.price = price;
    }

    /**
     * Retrieve the last price of the currency
     * @return the price in long form
     */
    public double getPrice() {
        return price;
    }
}
