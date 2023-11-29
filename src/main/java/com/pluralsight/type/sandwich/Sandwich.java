package com.pluralsight.type.sandwich;
import com.pluralsight.type.Size;

public class Sandwich {
    private final BreadType bread;
    private final Size size;
    private final int quantity;
    Topping toppings = new Topping();

    private final boolean isToasted;
    private double price = 0.00;

    public Sandwich(BreadType bread, Size size, int quantity, Topping topping, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.quantity = quantity;
        this.toppings = topping;
        this.isToasted = isToasted;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public BreadType getBread() {
        return bread;
    }

    public Size getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public Topping getToppings() {
        return toppings;
    }

    public void setToppings(Topping toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public double getPrice() {
        return this.price;
    }
}
