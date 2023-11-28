package com.pluralsight.OrderTypeListFolder.Sandwich;

import com.pluralsight.OrderTypeListFolder.Size;

import java.util.ArrayList;

// Assuming you have the BreadType and Topping classes in the same package or correctly imported

public class Sandwich {
    private final BreadType bread;
    private final Size size;
    private final int quantity;
    Topping toppings = new Topping();

    private final boolean isToasted;
    private final double price;

    public Sandwich(BreadType bread, Size size, int quantity, boolean isToasted, double price) {
        this.bread = bread;
        this.size = size;
        this.quantity = quantity;
        this.isToasted = isToasted;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("""
               %s, %s, %d, %b, %.2f
                """, bread, size, quantity, isToasted, price);
    }
}
