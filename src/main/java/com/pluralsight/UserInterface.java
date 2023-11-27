package com.pluralsight;

import com.pluralsight.Receipts.Receipt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private List<Bread> getBreadType() {
        return Arrays.asList(Bread.values());


    public void displayHomeScreen() {

            Scanner scanner = new Scanner(System.in);
            char choice;

            do {
                System.out.println("Home Screen");
                System.out.println("Welcome To Abuela Gators!");
                System.out.println("O) Order Now");
                System.out.println("X) Exit");
                System.out.print("Please choose an option: ");

                choice = scanner.next().charAt(0);

                switch (Character.toUpperCase(choice)) {
                    case 'O' -> displayOrderScreen();
                    break;
                    case 'X' -> System.out.println("Exiting the application.");
                    break;
                    default -> System.out.println("Invalid Option, Please try again ");
                }
            } while (choice != 'X');

    }

    public void displayOrderScreen() {
            Scanner scanner = new Scanner(System.in);
            char choice;

                do {

                    System.out.println("""
                                     Order Screen
                            ID   Name         4" $6.50    8" $9.00   12" $11.50
                            A    Steak
                            B    Ham
                            C    Salami
                            D    Roast beef
                            E    Chicken
                            F    BLT
                            X    Exit
                            """);
                    System.out.print("Please choose an option: ");

                    choice = scanner.next().charAt(0);

                    switch (Character.toUpperCase(choice)) {
                        case 'A' | 'B' | 'C' | 'D' | 'E' | 'F':
                            displaySandwichScreen();
                            break;
                        case 'X' -> System.out.println("Exiting the application.");
                        break;
                        default:
                            System.out.println("Invalid Option, Please try again ");
                    }
                } while (choice != 'X');


            }
            public void displaySandwichScreen() {

            Scanner scanner = new Scanner(System.in);
            char choice;

                do {
                    System.out.println("Choose Bread type");
                    List<Bread> breadType = getBreadType();

                    for (Bread bread : breadType) {
                        System.out.println(bread);
                    }
                    System.out.println("Choose the Size");


                    System.out.println("Choose the toppings");

                } while (choice != 'X');
                // Show the Sandwich menu with variety of bread and size with price and ask to customer to choose

                //Show menu

                //Ask to select bread

                //Ask to choose size

                //Show the toppings and Ask to choose the toppings

            }
        }


    public void displayDrinkMenuScreen()
    {
        System.out.println("Make it a Meal?");
        System.out.println("Choose your Drink");


    }

    public void ChipsScreen()
    {
  System.out.println("Choose your side");
    }

    public void displayCheckoutScreen(Order order)
    {
        // order summary
        // prices
        // modifiers and extras
        // quantity
        //subtotal
        // tax
      // payment options
        // promo or discounts
        //Ask customer to proceed with the transaction or cancel the order
    }

    public void displayReceipt(Receipt receipt)
    {
        // confirmation
       // transaction Details
        // items purchased
        // prices
        // subtotal
        // tax
        // total
        // payment information
        // store information

        // Add the receipt in the file

    }
}
