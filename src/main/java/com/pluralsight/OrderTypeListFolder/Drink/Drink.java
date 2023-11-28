package com.pluralsight.OrderTypeListFolder.Drink;


public class Drink {
    private final DrinkType drink;
    private final double price;

    public Drink(DrinkType drink, double price) {
        this.drink = drink;
        this.price = price;
    }

    public DrinkType getDrink() {
        return drink;
    }

    public double getPrice() {
        return price;
    }
}
