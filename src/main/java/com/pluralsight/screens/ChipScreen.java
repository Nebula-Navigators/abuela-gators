package com.pluralsight.screens;

import com.pluralsight.OrderManager;
import com.pluralsight.type.chips.ChipType;

import java.util.Scanner;

public class ChipScreen {
    Scanner scanner = new Scanner(System.in);
    HomeScreen h = new HomeScreen();
    public void display(OrderManager handler)
    {
        ChipType selectedChip = null;

        boolean running = true;
        while(running) {
            System.out.println("""
                        You are in Chips Menu Screen:
                        Please follow the following instructions:
                        -------------------------------------------------
                        |    1. Lays         |  2. Doritos              |
                        -------------------------------------------------
                        |    3. Cheetos      |  4. Pringles             |
                        -------------------------------------------------
                        |   5. Takis         |  6. Fritos               |
                        -------------------------------------------------
                        |                0. Go back                     |
                        -------------------------------------------------
                            """);
            int chipsOption = scanner.nextInt();

            switch (chipsOption)
            {
                case 1 -> {
                    selectedChip = ChipType.Lays;
                    handler.putChipsOrderInComputer(selectedChip);
                    h.loading();
                    System.out.println("Your Chip has been added!!!!");
                }

                case 2 -> {
                    selectedChip = ChipType.Doritos;
                    handler.putChipsOrderInComputer(selectedChip);
                    h.loading();
                    System.out.println("Your Chip has been added!!!!");
                }
                case 3 -> {
                    selectedChip = ChipType.Cheetos;
                    handler.putChipsOrderInComputer(selectedChip);
                    h.loading();
                    System.out.println("Your Chip has been added!!!!");
                }
                case 4 ->
                {
                    selectedChip = ChipType.Pringles;
                    handler.putChipsOrderInComputer(selectedChip);
                    h.loading();
                    System.out.println("Your Chip has been added!!!!");
                }
                case 5 -> {
                    selectedChip = ChipType.Takis;
                    handler.putChipsOrderInComputer(selectedChip);
                    h.loading();
                    System.out.println("Your Chip has been added!!!!");
                }
                case 6 -> {
                    selectedChip = ChipType.Fritos;
                    handler.putChipsOrderInComputer(selectedChip);
                    h.loading();
                    System.out.println("Your Chip has been added!!!!");
                }
                case 0 -> running = false;
                default -> System.out.println("Invalid entry. Re-enter.");
            }

        }

    }


}
