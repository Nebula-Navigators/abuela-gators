
package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.Chip;
import com.pluralsight.OrderTypeListFolder.Chips.ChipType;
import com.pluralsight.OrderTypeListFolder.Drink.Drink;
import com.pluralsight.OrderTypeListFolder.Drink.DrinkType;
import com.pluralsight.OrderTypeListFolder.Sandwich.BreadType;
import com.pluralsight.OrderTypeListFolder.Sandwich.Sandwich;
import com.pluralsight.OrderTypeListFolder.Sandwich.Topping;
import com.pluralsight.OrderTypeListFolder.Size;
import com.pluralsight.Receipts.Receipt;
import com.pluralsight.Receipts.ReceiptFileManager;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SystemDataHandler {
    Order orders = new Order();

    public void putSandwichOrderInComputer(BreadType bread, Size size, int quantity, Topping topping, boolean isToasted)
    {
        Sandwich sandwich = new Sandwich(bread, size, quantity, topping, isToasted);
        double calculatedPrice = 0.00;
        calculatedPrice +=size.getBreadPrice();
        if(topping.getMeats()!= null)
        {
            calculatedPrice += size.getMeatPrice();
        }
        if(topping.isExtraMeats())
        {
            calculatedPrice += size.getExtraMeatPrice();
        }
        if(topping.getCheese()!=null)
        {
            calculatedPrice += size.getCheesePrice();
        }
        if(topping.isExtraCheese())
        {
            calculatedPrice += size.getExtraCheesePrice();
        }
        sandwich.setPrice(calculatedPrice);

        this.orders.add_Sandwich(sandwich);


    }

    public void putChipsOrderInComputer(ChipType selectedChip) {
        Chip chip = new Chip();
        chip.setChipName(selectedChip);
        this.orders.add_Chips(chip);

    }

    public void putDrinkOrderInComputer(DrinkType selectedDrink, double price, Size selectedDrinkSize) {
        Drink drink = new Drink(selectedDrink,price, selectedDrinkSize);
        this.orders.add_drink(drink);
    }

    public void displayOrders() {


        System.out.println("""
                
                -----------------Order Summary------------------------
                
                Orders                                           price
                -------------------------------------------------------
                
                """);
        for(Sandwich sandwich : this.orders.getSandwiches())
        {
            String displayExtra = "";
            if(sandwich.getToppings().isExtraMeats())
            {
                displayExtra = "Extra Meat";
            }
            String displayExtraCheese = "";
            if(sandwich.getToppings().isExtraCheese())
            {
                displayExtraCheese = "Extra Cheese";
            }
            System.out.printf("""
            (%s - %s)                                         $%.2f
            Toppings:
            %s                                 %s 
            %s                                 %s
            
            Regular Topping
            --------------------------------------------------------------
            """,
                    sandwich.getBread(),
                    sandwich.getSize(),
                    sandwich.getPrice(),
                    sandwich.getToppings().getMeats(),
                    displayExtra,
                    sandwich.getToppings().getCheese(),
                    displayExtraCheese,
                    "---------------------------------------------------"
            );
            for(String regularTopping: sandwich.getToppings().getRegularToppings())
            {
                System.out.println(regularTopping);
            }
            System.out.println("""
                    
                    Sauces
                    ------------------------------------------------------
                    """);
            for (String s: sandwich.getToppings().getSauces())
            {
                System.out.println(s);
            }

            System.out.println("""
                    Sides
                    ------------------------------------------
                    """);
            for(String s: sandwich.getToppings().getSides()) {
                System.out.println(s);
            }
        }
        for(Drink drink: this.orders.getDrinks())
        {
            System.out.printf("""
                    Drinks
                    -----------------------------------------------------
                    %s - %s                                         %.2f
                    """,
                    drink.getDrink(),
                    drink.getSizeForDrink(),
                    drink.getPrice()
            );
        }
        for(Chip chip: this.orders.getChips())
        {
            System.out.printf("""
                    Chips
                    -------------------------------------------------------
                    %s                                                %.2f
                    """,
                    chip.getChipName(),
                    chip.getPrice()
            );
        }

    }

    public Receipt getReceipt(String customerName)
    {
        Receipt receipt = new Receipt();
        receipt.setCustomerName(customerName);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter yearTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = date.format(yearTime);
        receipt.setOrders(this.orders);

        ReceiptFileManager manager = new ReceiptFileManager();
        manager.addReceiptInfile(receipt, fileName);
       return receipt;
    }

}
