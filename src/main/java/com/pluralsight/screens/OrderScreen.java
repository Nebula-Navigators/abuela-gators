package com.pluralsight.screens;

import com.pluralsight.ANSIColors;
import com.pluralsight.OrderManager;

import java.util.Scanner;

public class OrderScreen {
    Scanner scanner = new Scanner(System.in);
    public void display(OrderManager handler) {
        HomeScreen h = new HomeScreen();

        boolean running = true;
        while(running) {

            System.out.println(ANSIColors.green + ANSIColors.bold +"""
                                                      Order Screen
                                        Follow the following instructions:
                                        -----------------------------------------------
                                        | 1. Add Sandwich    |   2. Add Drinks        |
                                        | 3. Add Chips       |   4. Checkout          |
                                        -----------------------------------------------
                                        |            0. Cancel Order                  |
                                        -----------------------------------------------
                   """ + ANSIColors.resetBold);
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    SandwichScreen menuForSandwich = new SandwichScreen();
                    h.loading();
                    menuForSandwich.displayScreen(handler);
                }
                case 2 -> {
                    DrinkScreen drinkMenu = new DrinkScreen();
                    h.loading();
                    drinkMenu.display(handler);
                }
                case 3 -> {
                    ChipScreen chipMenu = new ChipScreen();
                    h.loading();
                    chipMenu.display(handler);

                }
                case 4 -> {
                    CheckoutScreen checkoutOption = new CheckoutScreen();
                    h.loading();
                    checkoutOption.display(handler);
                    if(checkoutOption.checked)
                    {

                        return;
                    }

                }
                case 0 -> {
                    handler.CancelOrder();
                    running = false;
                    return;
                }
                default -> System.out.println("Invalid Option, Please try again ");
            }
        }
    }
}
