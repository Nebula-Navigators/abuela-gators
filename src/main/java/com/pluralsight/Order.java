package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.Chip;
import com.pluralsight.OrderTypeListFolder.Drink.Drink;
import com.pluralsight.OrderTypeListFolder.Sandwich.Sandwich;

import java.util.ArrayList;

public class Order {
    ArrayList<Sandwich> sandwiches = new ArrayList<>();
    ArrayList<Drink> drinks = new ArrayList<>();
    ArrayList<Chip> chips = new ArrayList<>();

    private final double tax = 0.15;

    double total;

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public void setChips(ArrayList<Chip> chips) {
        this.chips = chips;
    }

    public void add_drink(Drink d) {
        this.drinks.add(d);
    }

    public void add_Chips(Chip c) {
        this.chips.add(c);
    }

    public void add_Sandwich(Sandwich s) {
        this.sandwiches.add(s);
    }
}
