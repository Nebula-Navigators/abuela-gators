package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.Chip;
import com.pluralsight.OrderTypeListFolder.Drink.Drink;
import com.pluralsight.OrderTypeListFolder.Sandwich.Sandwich;

import java.util.ArrayList;

public class Order {
    ArrayList<Sandwich> sandwiches = new ArrayList<Sandwich>();
    ArrayList<Drink> drinks = new ArrayList<Drink>();
    ArrayList<Chip> chips = new ArrayList<Chip>();


    public void addSandwich(Sandwich sandwich)
    {
       this.sandwiches.add(sandwich);

    }
    public void addDrink(Drink d)
    {
        this.addDrink(d);

    }
    public void addChips(Chip c)
    {
        this.addChips(c);
    }




}
