package com.pluralsight.Receipts;

import com.pluralsight.OrderTypeListFolder.Chips.Chip;
import com.pluralsight.OrderTypeListFolder.Drink.Drink;
import com.pluralsight.OrderTypeListFolder.Sandwich.Sandwich;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileManager {

    public void addReceiptInfile(Receipt receipt, String nameOfFile) {
        String header = String.format("""
                --------------------------------------------------------
                                           %s
                ---------------------------------------------------------
                """, receipt.getCustomerName());

        StringBuilder details = new StringBuilder();

        for (Sandwich sandwich : receipt.getOrders().getSandwiches()) {
            // Sandwich details here...

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

        for (Drink drink : receipt.getOrders().getDrinks()) {
            details.append(String.format("""
                    Drinks
                    -----------------------------------------------------
                    %s - %s                                         %.2f
                    """,
                    drink.getDrink(),
                    drink.getSizeForDrink(),
                    drink.getPrice()));
        }

        for (Chip chip : receipt.getOrders().getChips()) {
            details.append(String.format("""
                    Chips
                    -------------------------------------------------------
                    %s                                                %.2f
                    """,
                    chip.getChipName(),
                    chip.getPrice()));
        }

        try (FileWriter writer = new FileWriter(nameOfFile + ".txt", true)) {
            writer.write(header + details.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
