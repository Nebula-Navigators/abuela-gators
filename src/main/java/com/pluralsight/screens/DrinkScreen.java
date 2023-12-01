package com.pluralsight.screens;

import com.pluralsight.ui.ANSIColors;
import com.pluralsight.order.OrderManager;
import com.pluralsight.type.Size;
import com.pluralsight.type.drink.DrinkType;

import java.util.Scanner;

public class DrinkScreen {
    Scanner scanner = new Scanner(System.in);
    HomeScreen h = new HomeScreen();
    public void display(OrderManager handler) {
        Size selectedDrinkSize = null; // Initialize to null as a default value
        DrinkType selectedDrink = null; // Initialize to null as a default value
        double price = 0.00;
        boolean running = true;
        while (running) {
            System.out.println(ANSIColors.green + ANSIColors.bold + """
                                       You are in Drink Menu Screen:
                                       Please follow the following instructions:
                                          Choose Drink
                                          ----------------------------------------------------
                                          | 1. Lemonade       |     2. Smoothie              |
                                          | 3. Coffee         |     4. Water                 |
                                          | 5. Soda           |     0. Go back               |
                                          ----------------------------------------------------
                """);
            int drinkChoice = scanner.nextInt();

            switch (drinkChoice) {
                case 1 -> {
                    selectedDrink = DrinkType.Lemonade;
                    selectedDrinkSize = askForDrinkSize();
                    int quantity = askForQuantity();
                    handler.putDrinkOrderInComputer(selectedDrink, selectedDrinkSize, quantity);
                    h.loading();
                    System.out.println("your drink has been added!!!");
                }
                case 2 -> {
                    selectedDrink = DrinkType.Smoothie;
                    selectedDrinkSize = askForDrinkSize();
                    int quantity = askForQuantity();
                    handler.putDrinkOrderInComputer(selectedDrink, selectedDrinkSize, quantity);
                    h.loading();
                    System.out.println("your drink has been added!!!");
                }
                case 3 -> {
                    selectedDrink = DrinkType.Coffee;
                    selectedDrinkSize = askForDrinkSize();
                    int quantity = askForQuantity();
                    handler.putDrinkOrderInComputer(selectedDrink, selectedDrinkSize, quantity);
                    h.loading();
                    System.out.println("your drink has been added!!!");

                }
                case 4 -> {
                    selectedDrink = DrinkType.Water;
                    selectedDrinkSize = askForDrinkSize();
                    int quantity = askForQuantity();
                    handler.putDrinkOrderInComputer(selectedDrink, selectedDrinkSize, quantity);
                    h.loading();
                    System.out.println("your drink has been added!!!");
                }
                case 5 -> {
                    selectedDrink = DrinkType.Soda;
                    selectedDrinkSize = askForDrinkSize();
                    int quantity = askForQuantity();
                    handler.putDrinkOrderInComputer(selectedDrink, selectedDrinkSize, quantity);
                    h.loading();
                    System.out.println("your drink has been added!!!");
                }
                case 0 -> {
                    running = false;
                    return;
                }
                default -> System.out.println("Invalid re-enter");
            }



        }

        // Check if the user made a selection before calling putDrinkOrderInComputer
    }

    public Size askForDrinkSize() {
        boolean valid = true; // Set to true to enter the loop initially
        while (valid) {
            System.out.println("""
                                      Select the size for drink:
                                      -----------------------------------------
                                      |  Size                |     Price      |
                                      -----------------------------------------
                                      | 1. Small             |     $2.00      |
                                      | 2. Medium            |     $2.50      |
                                      | 3. Large             |     $3.00      |
                                      -----------------------------------------
                                      |             0. Go back                |
                                      -----------------------------------------
                """ + ANSIColors.resetBold);
            int ans = scanner.nextInt();
            switch (ans) {
                case 1 -> {return Size.SMALL;}
                case 2 -> {return Size.MEDIUM;}
                case 3 -> {return Size.LARGE;}
                case 0 -> {
                    valid = false; // Exit the loop when 0 is selected
                }
                default -> System.out.println("Invalid entry, please retry.");
            }
        }

        return null;
    }
    public int askForQuantity() {
        int quantity = 0;

        while (true) {
            System.out.println("Quantity of particular drink: ");

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();

                // Check if the quantity is greater than 0
                if (quantity > 0) {
                    break; // Exit the loop if the input is valid
                } else {
                    System.out.println("Quantity must be greater than 0. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        return quantity;
    }

}
