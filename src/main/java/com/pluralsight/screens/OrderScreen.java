package com.pluralsight.screens;

import com.pluralsight.OrderManager;

import java.util.Scanner;

public class OrderScreen {
    Scanner scanner = new Scanner(System.in);
    public void display(OrderManager handler) {

        boolean running = true;
        while(running) {

            System.out.println("""
                            Order Screen
                  Follow the following instructions:
                  1. Add Sandwich
                  2. Add Drinks
                  3. Add Chips
                  4. Checkout
                  0. Cancel Order
                   """);
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    SandwichScreen menuForSandwich = new SandwichScreen();
                    menuForSandwich.displayScreen(handler);
                }
                case 2 -> {
                    DrinkScreen drinkMenu = new DrinkScreen();
                    drinkMenu.display(handler);
                }
                case 3 -> {
                    ChipScreen chipMenu = new ChipScreen();
                    chipMenu.display(handler);

                }
                case 4 -> {
                    CheckoutScreen checkoutOption = new CheckoutScreen();
                    checkoutOption.display(handler);

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
