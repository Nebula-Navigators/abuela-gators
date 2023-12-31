package com.pluralsight.screens;


import com.pluralsight.ui.ANSIColors;
import com.pluralsight.order.OrderManager;

import java.util.Scanner;

import static com.pluralsight.ui.ANSIColors.bold;

public class HomeScreen {
    OrderManager handler = new OrderManager();
    Scanner scanner = new Scanner(System.in);
    public void display() {

        // Greet the customer and give customer option to select from make an order or exit
        // Contributed by Hally
        System.out.println(ANSIColors.blue + ANSIColors.bold +"""
                                          --------------------------------------------------------------------------------------------------------------
                                          |                                       Welcome to Abuela - Gators:                                          |
                                          |                                                                                                            |
                                          |  "Indulge in Flavorful Creations at Abuela-Gators                                                          |
                                          |   Where Every Bite is a Journey! Fresh ingredients, creative combinations, and a passion for perfection.   |
                                          |   Bite into happiness today!                                                                               |
                                          |                                                                                                            |
                                          --------------------------------------------------------------------------------------------------------------
                    """+ ANSIColors.resetBold);
        boolean running = true;
        while(running)
        {
            System.out.println( ANSIColors.green + bold + """
                              Follow the following instructions:
                              ------------------------------------------------
                              | 1. Make Order        |  0. Exit              |
                              ------------------------------------------------
        """+ ANSIColors.resetBold);
            int answer = scanner.nextInt();
            switch (answer)
            {
                case 1 -> {
                    OrderScreen menu = new OrderScreen();
                    loading();
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

    }

    public void loading()
    {
        try {
            spinner();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void spinner() throws InterruptedException
    {
        String[] spinner = { "|", "/", "-", "\\" };

        for (int i = 0; i < 20; i++) {
            System.out.print("\r" + spinner[i % spinner.length] + " Loading...");
            Thread.sleep(150); // Adjust the sleep duration for the desired speed
        }

        System.out.println("\nLoading complete!");
    }

}
