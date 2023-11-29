package com.pluralsight.screens;


import com.pluralsight.OrderManager;

import java.util.Scanner;

public class HomeScreen {
    OrderManager handler = new OrderManager();
    Scanner scanner = new Scanner(System.in);
    public void display() {
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
                case 1 -> {
                    OrderScreen menu = new OrderScreen();
                    menu.display(handler);
                    return;
                }
                case 0 -> {
                    running = false;
                    return;
                }
                default -> System.out.println("Invalid Entry re-enter.");
            }
        }
        // Accounting Project
    }

}
