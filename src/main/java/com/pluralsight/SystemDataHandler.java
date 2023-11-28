package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.Chip;
import com.pluralsight.OrderTypeListFolder.Chips.ChipType;
import com.pluralsight.OrderTypeListFolder.Drink.Drink;
import com.pluralsight.OrderTypeListFolder.Drink.DrinkType;

import java.util.ArrayList;

public class SystemDataHandler {
    Order orders = new Order();

    public void putSandwichOrderInComputer(String bread, String size, int quantity, ArrayList<String> topping, boolean isToasted)
    {

    }

    public void putChipsOrderInComputer(ChipType selectedChip) {
       Chip chip = new Chip();
       chip.setChipName(selectedChip);
       this.orders.add_Chips(chip);

    }

    public void putDrinkOrderInComputer(DrinkType selectedDrink, double price) {
        Drink drink = new Drink(selectedDrink,price);
        this.orders.add_drink(drink);
    }
}
