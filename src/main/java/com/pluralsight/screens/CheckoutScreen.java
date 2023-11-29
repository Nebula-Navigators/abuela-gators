package com.pluralsight.screens;

import com.pluralsight.OrderManager;
import com.pluralsight.receipts.Receipt;

import java.util.Scanner;

public class CheckoutScreen {
    Scanner scanner = new Scanner(System.in);
    public void display(OrderManager handler)
    {
        //display the checkout Screen
        //Ask customer to proceed with the transaction or cancel the order
        if(handler.checkCart()) {
            System.out.println("""
                    You are in the CheckOut Screen.
                    Here is your Order list and total:
                    """);
            handler.displayOrders();
            boolean running = true;
            while (running) {
                System.out.println("""
                        Please follow the following instructions:
                            1. Checkout
                            0. Cancel
                            """);
                int checkoutOption = scanner.nextInt();
                switch (checkoutOption) {
                    case 1 -> {
                        System.out.println("Please enter your name.");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        Receipt bill = handler.getReceipt(name);
                        displayReceiptScreen(bill);
                        running = false;
                        return;
                    }
                    case 0 -> running = false;
                    default -> System.out.println("Invalid entry. Re-enter.");

                }

            }
        }
        else {
            System.out.println("""
                    Your Cart is empty. Please add order and proceed Checkout.
                    """);
        }
    }

    private void displayReceiptScreen(Receipt bill) {
        System.out.println("Thank you for visiting us Here is your receipt!!!");
    }

}
