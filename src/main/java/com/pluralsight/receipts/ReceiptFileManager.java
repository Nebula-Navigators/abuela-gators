package com.pluralsight.receipts;

import com.pluralsight.type.chips.Chip;
import com.pluralsight.type.drink.Drink;
import com.pluralsight.type.sandwich.Sandwich;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileManager {

    public void addReceiptInfile(Receipt receipt, String nameOfFile) {
        String header = String.format("""
                -------------------------------------------------------------
                                            %s
                                            %s
                -------------------------------------------------------------
                Customer name: %s
                
                                             Receipt
                                     
                """, receipt.getStoreName(), receipt.getStoreAddress(),receipt.getCustomerName());

        StringBuilder details = new StringBuilder();

        if(!receipt.getOrders().getSandwiches().isEmpty())
        {
            details.append(String.format("""
                                             Sandwich
                    """));
        }

        for (Sandwich sandwich : receipt.getOrders().getSandwiches()) {
            String extraCheese = sandwich.getToppings().isExtraCheese() ? "Extra Cheese - $" + sandwich.getSize().getExtraCheesePrice() : "";
            String extraMeat = sandwich.getToppings().isExtraMeats() ? "Extra Meat - $" + sandwich.getSize().getExtraMeatPrice() : "";
            String displayMeat = sandwich.getToppings().getMeats().toString() +"- $"+ sandwich.getSize().getMeatPrice();
            String displayCheese = sandwich.getToppings().getCheese().toString() +"- $"+ sandwich.getSize().getCheesePrice();

            details.append(String.format("""
                    Selected Bread: %s -%-15s                               %.2f
                    Qty %d
                    
                    Topping:
                    %-10s                           %-15s
                    %-10s                           %-15s
                    
                    """, sandwich.getBread(), sandwich.getSize(), sandwich.getPrice(), sandwich.getQuantity(),displayMeat, extraMeat, displayCheese, extraCheese));

            for (String regularTopping : sandwich.getToppings().getRegularToppings()) {
                details.append(regularTopping).append("\n");
            }

            for (String s1 : sandwich.getToppings().getSauces()) {
                details.append(s1).append("\n");
            }

            for (String side : sandwich.getToppings().getSides()) {
                details.append(side).append("\n");
            }
        }

        if(!receipt.getOrders().getDrinks().isEmpty())
        {
            details.append(String.format("""
                                            Drinks
                    """));
        }

        for (Drink drink : receipt.getOrders().getDrinks()) {
            details.append(String.format("""
                    %-10s -%-10s                                      %.2f
                    Qty: %d
                    
                    """,
                    drink.getDrink(),
                    drink.getSize(),
                    drink.getPrice(),
                    drink.getQuantity()));
        }

        if(!receipt.getOrders().getChips().isEmpty())
        {
            details.append(String.format("""
                                           Chips
                    """));
        }

        for (Chip chip : receipt.getOrders().getChips()) {
            details.append(String.format("""
                    %-20s                                         %.2f
                    
                    """,
                    chip.getChipName(),
                    chip.getPrice()));
        }

        details.append(String.format("""
                -----------------------------------------------------------------
                
                Your Total Amount                                        %.2f
                Tax Amount - (After Applying 15%s on total)               %02.2f
                
                ----------------------------------------------------------------
                Amount after tax                                         %.2f
                """, receipt.getOrders().getTotal(), "%", receipt.getOrders().getTotal()*receipt.getOrders().getTax(), receipt.getOrders().getTotal()+ (receipt.getOrders().getTotal()*receipt.getOrders().getTax())));

        try (FileWriter writer = new FileWriter(nameOfFile + ".txt", true)) {
            writer.write(header + details.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}