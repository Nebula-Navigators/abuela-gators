package com.pluralsight.OrderTypeListFolder;

public enum Size {
    SMALL(5.50,1.00,0.75,2),
    MEDIUM(7,2,1.50,2.50),
    LARGE(8.50,3,2.25,3);

    private final double breadPrice;
    private final double toppingPrice;
    private final double cheesePrice;

    private final double drinkPrice;
    Size(double breadPrice, double toppingPrice, double cheesePrice, double drinkPrice)
    {
        this.breadPrice = breadPrice;
        this.toppingPrice = toppingPrice;
        this.cheesePrice = cheesePrice;
        this.drinkPrice = drinkPrice;
    }
    public double getBreadPrice() {
        return breadPrice;
    }
    public double getCheesePrice() {
        return cheesePrice;
    }
    public double getToppingPrice() {
        return toppingPrice;
    }
}
