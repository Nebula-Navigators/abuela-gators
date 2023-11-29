package com.pluralsight.type.drink;


import com.pluralsight.type.Size;

public class Drink {
    private DrinkType drink;
    private double price;

    public Size getSizeForDrink() {
        return sizeForDrink;
    }

    public void setSizeForDrink(Size sizeForDrink) {
        this.sizeForDrink = sizeForDrink;
    }

    Size sizeForDrink = null;

    public void setDrink(DrinkType drink) {
        this.drink = drink;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DrinkType getDrink() {
        return drink;
    }

    public double getPrice() {
        return price;
    }
}
