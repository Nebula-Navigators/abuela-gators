package com.pluralsight;

import com.pluralsight.type.chips.Chip;
import com.pluralsight.type.drink.Drink;
import com.pluralsight.type.sandwich.Sandwich;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chip> chips = new ArrayList<>();

    private final double tax = 0.15;

    private double total;

    private double totalAmountAfterTax;

    public double getTotalAmountAfterTax() {
        return totalAmountAfterTax;
    }
    public boolean isNotEmpty() {
        return !sandwiches.isEmpty() || !drinks.isEmpty() || !chips.isEmpty();
    }

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

    public void addDrink(Drink d) {
        this.drinks.add(d);
    }

    public void addChips(Chip c) {
        this.chips.add(c);
    }

    public void addSandWich(Sandwich s) {
        this.sandwiches.add(s);
    }
}
