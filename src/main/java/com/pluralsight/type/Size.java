package com.pluralsight.type;

public enum Size {
    SMALL(5.50,1.00,0.75,0.50,0.30),
    MEDIUM(7.00,2.00,1.50,1.00,0.60),
    LARGE(8.50,3.00,2.25,1.50,0.90);


    private final double breadPrice;
    private final double meatPrice;
    private final double cheesePrice;

    private final double extraMeatPrice;

    private final double extraCheesePrice;

    Size(double breadPrice, double meatPrice, double cheesePrice, double extraMeatPrice, double extraCheesePrice)
    {
        this.breadPrice = breadPrice;
        this.meatPrice = meatPrice;
        this.cheesePrice = cheesePrice;
        this.extraMeatPrice = extraMeatPrice;
        this.extraCheesePrice = extraCheesePrice;
    }
    public double getBreadPrice() {
        return breadPrice;
    }
    public double getCheesePrice() {
        return cheesePrice;
    }
    public double getMeatPrice() {
        return meatPrice;
    }
    public double getExtraMeatPrice() {return extraMeatPrice;}
    public double getExtraCheesePrice() {return extraCheesePrice;}

}
