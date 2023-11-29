package com.pluralsight.type.sandwich;

import com.pluralsight.type.sandwich.toppings.CheeseType;
import com.pluralsight.type.sandwich.toppings.MeatType;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    private MeatType meats = null;
    private boolean extraMeats;
    private CheeseType cheese = null;
    private boolean extraCheese;
    ArrayList<String> regularToppings = new ArrayList<>();
    ArrayList<String> sauces = new ArrayList<>();
    ArrayList<String> Sides = new ArrayList<>();

    public void setMeats(MeatType meats) {
        this.meats = meats;
    }

    public void setExtraMeats(boolean extraMeats) {
        this.extraMeats = extraMeats;
    }

    public void setCheese(CheeseType cheese) {
        this.cheese = cheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public MeatType getMeats() {
        return meats;
    }

    public boolean isExtraMeats() {
        return extraMeats;
    }

    public CheeseType getCheese() {
        return cheese;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public ArrayList<String> getSauces() {
        return sauces;
    }

    public List<String> getSides() {
        return Sides;
    }

    public void addRegularTopping(String toppingName)
    {
        this.regularToppings.add(toppingName);
    }

    public void addSauces(String sauce)
    {
        this.sauces.add(sauce);
    }
    public void addSides(String sides)
    {
        this.Sides.add(sides);
    }

}
