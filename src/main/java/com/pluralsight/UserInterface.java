package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.ChipType;
import com.pluralsight.OrderTypeListFolder.Drink.DrinkType;
import com.pluralsight.OrderTypeListFolder.Sandwich.BreadType;
import com.pluralsight.OrderTypeListFolder.Size;

import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    SystemDataHandler handler = new SystemDataHandler();

    public void displayHomeScreen() {
        // Greet the customer and give customer option to select from make an order or exit
        // Contributed by Hally
        System.out.println("""
                    Welcome to Abuela - Gators:
                    
                    Indulge in Flavorful Creations at Abuela-Gators
                    Where Every Bite is a Journey! Fresh ingredients, creative combinations, and a passion for perfection.
                    Bite into happiness today!
                    
                    """);
        boolean running = true;
        while(running)
        {
            System.out.println("""
        Follow the following instructions:
        1. Make Order
        0. Exit
        """);
            int answer = scanner.nextInt();
            switch (answer)
            {
                case 1 -> displayOrderScreen();
                case 0 -> running = false;
                default -> System.out.println("Invalid Entry re-enter.");
            }
        }
        // Accounting Project
    }

    public void displayOrderScreen() {

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
                case 1 -> displaySandwichScreen();
                case 2 -> displayDrinkMenuScreen();
                case 3 -> displayChipsScreen();
                case 4 -> displayCheckoutScreen();
                case 0 -> running = false;
                default -> System.out.println("Invalid Option, Please try again ");
            }
        }
    }


    public void displaySandwichScreen() {
        // Show the Sandwich menu with variety of bread and size with price and ask to customer to choose
        Size size = null;
        BreadType selectedBread = null;
        boolean running = true;
        while (running) {
            System.out.println("""
            You are in Sandwich Menu:
            Size                   4''     8''    12''
            Price for bread        5.50    7      8.50
                                
            Select size:
            1. Small - 4''
            2. Medium - 8''
            3. Large - 12''
            """);

            int choose = scanner.nextInt();

            switch (choose)
            {
                case 1 -> {
                    size = Size.SMALL;
                    running = false;
                }
                case 2 -> {
                    size = Size.MEDIUM;
                    running = false;
                }
                case 3 -> {
                    size = Size.LARGE;
                    running = false;
                }
                default -> System.out.println("Invalid Entry retry.");
            }

        }
        boolean valid = true;
        while (valid) {
            System.out.println("""
                  Select bread:
                  1. Wheat
                  2. White
                  3. Rye
                  4. Wrap
                  """);
            int answer = scanner.nextInt();
            switch (answer)
            {
                case 1 -> {
                    selectedBread = BreadType.WHEAT;
                    valid = false;
                }
                case 2 -> {
                    selectedBread = BreadType.WHITE;
                    valid = false;
                }
                case 3 -> {
                    selectedBread = BreadType.RYE;
                    valid = false;
                }
                case 4 -> {
                    selectedBread = BreadType.WRAP;
                    valid = false;
                }
                default -> System.out.println("Invalid Entry. Re-try again");
            }

        }
        //handler.putSandwichOrderInComputer(bread, size, topping, quantity, boolean isToasted);
    }





    public void displayDrinkMenuScreen() {
        Size selectedDrinkSize = null; // Initialize to null as a default value
        DrinkType selectedDrink = null; // Initialize to null as a default value
        double price = 1.35; // By default, it's the price for Soda and Water
        boolean running = true;

        while (running) {
            System.out.println("""
                 You are in Drink Menu Screen:
                 Please follow the following instructions:
                    Choose Drink
                    1. Lemonade
                    2. Smoothie
                    3. Coffee
                    4. Water
                    5. Soda
                    0. Cancel
                """);
            int drinkChoice = scanner.nextInt();

            switch (drinkChoice) {
                case 1 -> {
                    selectedDrink = DrinkType.Lemonade;
                    selectedDrinkSize = askForDrinkSize();
                    price = selectedDrinkSize.getDrinkPrice();
                }
                case 2 -> {
                    selectedDrink = DrinkType.Smoothie;
                    selectedDrinkSize = askForDrinkSize();
                    price = selectedDrinkSize.getDrinkPrice();
                }
                case 3 -> {
                    selectedDrink = DrinkType.Coffee;
                    selectedDrinkSize = askForDrinkSize();
                    price = selectedDrinkSize.getDrinkPrice();
                }
                case 4 -> selectedDrink = DrinkType.Water;
                case 5 -> selectedDrink = DrinkType.Soda;
                case 0 -> running = false;
                default -> System.out.println("Invalid re-enter");
            }
        }

        // Check if the user made a selection before calling putDrinkOrderInComputer
        if (selectedDrink != null && selectedDrinkSize != null) {
            handler.putDrinkOrderInComputer(selectedDrink, price);
            System.out.println("your drink has been added!!!");
        }
    }

    public Size askForDrinkSize() {
        boolean valid = true; // Set to true to enter the loop initially
        while (valid) {
            System.out.println("""
                Select the size for drink:
                1. Small - $2.00
                2. Medium - $2.50
                3. Large - $3.00
                0. Go back
                """);
            int ans = scanner.nextInt();
            switch (ans) {
                case 1 -> {return Size.SMALL;}
                case 2 -> {return Size.MEDIUM;}
                case 3 -> {return Size.LARGE;}
                case 0 -> valid = false; // Exit the loop when 0 is selected
                default -> System.out.println("Invalid entry, please retry.");
            }
        }

        return null;
    }


    public void displayChipsScreen()
    {
        ChipType selectedChip = null;

        boolean running = true;
        while(running) {
            System.out.println("""
                        You are in Chips Menu Screen:
                        Please follow the following instructions:
                            1. Lays
                            2. Doritos
                            3. Cheetos
                            4. Pringles
                            5. Takis
                            6. Fritos
                            0. Cancel
                            """);
            int chipsOption = scanner.nextInt();

            switch (chipsOption)
            {
                case 1 -> selectedChip = ChipType.Lays;
                case 2 -> selectedChip = ChipType.Doritos;
                case 3 -> selectedChip = ChipType.Cheetos;
                case 4 -> selectedChip = ChipType.Pringles;
                case 5 -> selectedChip = ChipType.Takis;
                case 6 -> selectedChip = ChipType.Fritos;
                case 0 -> running = false;
                default -> System.out.println("Invalid entry. Re-enter.");
            }
        }
        if(selectedChip!=null) {
            handler.putChipsOrderInComputer(selectedChip);
            System.out.println("Your Chip has been added!!!!");
        }

    }



    public void displayCheckoutScreen()
    {
        //display the checkout Screen
        //Ask customer to proceed with the transaction or cancel the order

    }

    public void displayReceipt ()
    {
        //After Checkout show the receipt and Add the receipt in the file

    }
}
