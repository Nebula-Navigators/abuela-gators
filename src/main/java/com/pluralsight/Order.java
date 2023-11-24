package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.Chip;
import com.pluralsight.OrderTypeListFolder.Drink.Drink;
import com.pluralsight.OrderTypeListFolder.Sandwich.Sandwich;

import java.util.ArrayList;

public class Order {
    ArrayList<Sandwich> sandwiches = new ArrayList<>();
    ArrayList<Drink> drinks = new ArrayList<>();
    ArrayList<Chip> chips = new ArrayList<>();


    public void addSandwich(Sandwich sandwich)
    {
       this.sandwiches.add(sandwich);

    }
    public void add_drink(Drink d)
    {
        this.drinks.add(d);

    }
    public void add_Chips(Chip c)
    {
        this.chips.add(c);
    }




}
