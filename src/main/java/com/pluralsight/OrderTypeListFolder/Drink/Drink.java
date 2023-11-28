package com.pluralsight.OrderTypeListFolder.Drink;


import com.pluralsight.OrderTypeListFolder.Size;

public class Drink {
    private final DrinkType drink;
    private final double price;

    public Size getSizeForDrink() {
        return sizeForDrink;
    }

    public void setSizeForDrink(Size sizeForDrink) {
        this.sizeForDrink = sizeForDrink;
    }

    Size sizeForDrink = null;

    public Drink(DrinkType drink, double price, Size size) {
        this.drink = drink;
        this.price = price;
        this.sizeForDrink = size;
    }

    public DrinkType getDrink() {
        return drink;
    }

    public double getPrice() {
        return price;
    }
}
