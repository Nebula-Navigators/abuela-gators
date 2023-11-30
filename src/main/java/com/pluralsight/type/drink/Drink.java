package com.pluralsight.type.drink;


import com.pluralsight.type.Size;

public class Drink {
    private DrinkType drink;
    private double price;

    double [] listPrices = {2.00,2.50,3.00};

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    Size size = null;

    public void setDrink(DrinkType drink) {
        this.drink = drink;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOwnPrice(Size size)
    {
    if(size == Size.SMALL)
    {
        this.price = listPrices[0];
    }
    else if (size == Size.MEDIUM)
    {
        this.price = listPrices[1];
    }
    else
    {
        this.price = listPrices[2];
    }
    }

    public DrinkType getDrink() {
        return drink;
    }

    public double getPrice() {
        return price;
    }
}
