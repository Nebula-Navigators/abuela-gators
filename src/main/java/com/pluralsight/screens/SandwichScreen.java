package com.pluralsight.screens;

import com.pluralsight.OrderManager;
import com.pluralsight.type.Size;
import com.pluralsight.type.sandwich.BreadType;
import com.pluralsight.type.sandwich.Topping;
import com.pluralsight.type.sandwich.toppings.CheeseType;
import com.pluralsight.type.sandwich.toppings.MeatType;

import java.util.Scanner;

public class SandwichScreen {
    Scanner scanner = new Scanner(System.in);
    public void displayScreen(OrderManager handler){
        // Show the Sandwich menu with variety of bread and size with price and ask to customer to choose
        Size size = null;
        BreadType selectedBread = null;
        boolean passingToasted = false;
        size = askForSize();
        selectedBread = askForSelectingBread();
        Topping selectedTopping = new Topping();
        selectedTopping = askForTopping();
        boolean run;
        System.out.println("Quantity of particular sandwich: ");
        int quantity = scanner.nextInt();
        run = true;
        while(run) {
            System.out.println("Do you want your sandwich to be toasted? (Y/N)");
            char choice = scanner.next().charAt(0);

            if(choice == 'y' || choice == 'Y')
            {
                passingToasted = true;
                run = false;
            } else if (choice == 'n' || choice =='N') {
                run = false;
            }


        }
        handler.putSandwichOrderInComputer(selectedBread, size, quantity, selectedTopping, passingToasted);

        //handler.putSandwichOrderInComputer(bread, size, topping, quantity, boolean isToasted);
    }

    private Topping askForTopping() {
        boolean run = true;
        while(run) {
            System.out.println("Do You want to add Topping? (Y/N)");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'y', 'Y' -> {
                    run = false;
                    return getTopping();
                }
                case 'n', 'N' -> run = false;
                default -> System.out.println("Re- Enter the value. Invalid input.");
            }
        }
        return null;
    }

    private BreadType askForSelectingBread() {
        boolean valid = true;
        while (valid) {
            System.out.println("""
                    Select bread:
       -----------------------------------------------
       |    1. Wheat      |        2. White          |
       |    3. Rye        |        4. Wrap           |
       -----------------------------------------------
                    """);
            int answer = scanner.nextInt();
            switch (answer) {
                case 1 -> {
                    valid = false;
                    return BreadType.WHEAT;
                }
                case 2 -> {
                    valid = false;
                    return BreadType.WHITE;
                }
                case 3 -> {
                    valid = false;
                    return BreadType.RYE;
                }
                case 4 -> {
                    valid = false;
                    return BreadType.WRAP;
                }
                default -> System.out.println("Invalid Entry. Re-try again");
            }

        }
        return null;
    }

    private Size askForSize() {
        boolean running = true;
        while (running) {
            System.out.println("""
            
            You are in Sandwich Menu:
         -----------------------------------------------
         |   Size                  4''     8''    12'' |
         |  Price for bread        5.50    7      8.50 |
         |                                             |
         |  Select size:                               |
         |   1. Small - 4''                            |
         |   2. Medium - 8''                           |
         |   3. Large - 12''                           |
         -----------------------------------------------
            """);

            int choose = scanner.nextInt();

            switch (choose)
            {
                case 1 -> {
                    running = false;
                    return Size.SMALL;
                }
                case 2 -> {
                    running = false;
                   return Size.MEDIUM;
                }
                case 3 -> {
                    running = false;
                    return Size.LARGE;
                }
                default -> System.out.println("Invalid Entry retry.");
            }

        }
        return null;
    }

    private Topping getTopping() {
        Topping dummy = new Topping();
        boolean valid = true;
        while(valid) {
            System.out.println("""
                    Please follow the following instructions for Meat:
                    -----------------------------------------------
                    |    1. Steak        |        2. Ham          |
                    |    3. Salami       |        4. Roast beef   |
                    |    5. Chicken      |        6. Bacon        |
                    -----------------------------------------------
                    |            0. Don't want it                 |
                    -----------------------------------------------
                    """);
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1 -> {
                    dummy.setMeats(MeatType.Steak);
                    askForExtraMeat(dummy);
                    valid = false;
                }
                case 2 -> {
                    dummy.setMeats(MeatType.Ham);
                    askForExtraMeat(dummy);
                    valid = false;
                }
                case 3 -> {
                    dummy.setMeats(MeatType.Salami);
                    askForExtraMeat(dummy);
                    valid = false;
                }
                case 4 -> {
                    dummy.setMeats(MeatType.Roast_beef);
                    askForExtraMeat(dummy);
                    valid = false;
                }
                case 5 -> {
                    dummy.setMeats(MeatType.Chicken);
                    askForExtraMeat(dummy);
                    valid = false;
                }
                case 6 -> {
                    dummy.setMeats(MeatType.Bacon);
                    askForExtraMeat(dummy);
                    valid = false;
                }
                case 0 -> valid = false;
                default -> System.out.println("Invalid entry. Re-enter");
            }
        }


        valid = true;
        while(valid)
        {
            System.out.println("""
                    If you want to add cheese.
                    Please select the Cheese.
                    ---------------------------------------
                    |    1. American  |    2. Provolone   |
                    |    3. Cheddar   |    4. Swiss;      |
                    ---------------------------------------
                    |           0. Don't want it.         |
                    ---------------------------------------
                    """);
            int option = scanner.nextInt();
            switch (option)
            {
                case 1 -> {
                    dummy.setCheese(CheeseType.American);
                    askForExtraCheese(dummy);
                    valid = false;
                }
                case 2 -> {
                    dummy.setCheese(CheeseType.Provolone);
                    askForExtraCheese(dummy);
                    valid = false;
                }
                case 3 -> {
                    dummy.setCheese(CheeseType.Cheddar);
                    askForExtraCheese(dummy);
                    valid = false;
                }
                case 4 -> {
                    dummy.setCheese(CheeseType.Swiss);
                    askForExtraCheese(dummy);
                    valid = false;
                }
                case 0 -> valid = false;
                default -> System.out.println("Invalid, Re-enter.");
            }
        }

        valid = true;
        while(valid)
        {
            System.out.println("""
                    These toppings are regular topping select which one you want to include:
                    ------------------------------------------------------------------------
                    |         1. Lettuce           |         2. Peppers                    |
                    |         3. Onions            |         4. Tomatoes                   |
                    |         5. Jalepenos         |         6. cucumbers                  |
                    |         7. pickles           |         8. guacamole                  |
                    |         9. mushrooms         |         0. Don't want to add anymore  |
                    ------------------------------------------------------------------------
                    """);
            int option = scanner.nextInt();
            switch (option)
            {
                case 1 -> dummy.addRegularTopping("Lettuce");
                case 2 -> dummy.addRegularTopping("Peppers");
                case 3 -> dummy.addRegularTopping("Onions");
                case 4 -> dummy.addRegularTopping("Tomatoes");
                case 5 -> dummy.addRegularTopping("Jalepenos");
                case 6 -> dummy.addRegularTopping("cucumbers");
                case 7 -> dummy.addRegularTopping("pickles");
                case 8 -> dummy.addRegularTopping("guacamole");
                case 9 -> dummy.addRegularTopping("mushrooms");
                case 0 -> valid = false;
                default -> System.out.println("Enter valid entry.");

            }
        }

        int count = 0;
        valid = true;
        while(valid || count<2)
        {
            System.out.println("""
                    Do you want sauces if yes select but cannot be more than 2:
                    ----------------------------------------------------------
                    |       1. Mayo              |        2. Mustard         |
                    |       3. Ketchup           |        4. Ranch           |
                    |       5. thousand islands  |        6. vinaigrette     |
                    ----------------------------------------------------------
                    |                0. Don't want to add anymore            |
                    ----------------------------------------------------------
                    """);
            int option = scanner.nextInt();
            switch (option)
            {
                case 1 -> {
                    dummy.addSauces("Mayo");
                    valid = false;
                    count++;
                }
                case 2 -> {
                    dummy.addSauces("Mustard");
                    valid = false;
                    count++;
                }
                case 3 -> {
                    dummy.addSauces("Ketchup");
                    valid = false;
                    count++;
                }
                case 4 -> {
                    dummy.addSauces("Ranch");
                    valid = false;
                    count++;
                }
                case 5 -> {
                    dummy.addSauces("Thousand island");
                    valid = false;
                    count++;
                }
                case 6 -> {
                    dummy.addSauces("Vinaigrette");
                    valid = false;
                    count++;
                }
                case 0 -> valid = false;
                default -> System.out.println("Invalid re-enter");

            }
        }

        valid = true;
        while(valid)
        {
            System.out.println("""
                    Following sides are available select one if you want to add;
                    ------------------------------------------------------------
                    |        1. au jus         |             2. sauce          |
                    ------------------------------------------------------------
                    |                0. Do not want to include anymore         |
                    ------------------------------------------------------------
                    """);
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1 -> {
                    dummy.addSides("au jus");
                    valid = false;
                }
                case 2 -> {
                    dummy.addSides("sauce");
                    valid = false;
                }
                case 0 -> valid = false;
                default -> System.out.println("Invalid entry. re -enter");

            }
        }


        return dummy;
    }

    private void askForExtraCheese(Topping dummy) {
        boolean valid = true;
        while(valid)
        {
            System.out.println("""
                    Do you want extra cheese? 
                    Extra Cheese will add extra charge based on following:
                    --------------------------------------------------------------
                    |    Small - 0.30  |    Medium - 0.60    |    Large - 0.90   |
                    --------------------------------------------------------------
                    |                         Enter (Y/N)                        |
                    --------------------------------------------------------------
                    """);
            char choice = scanner.next().charAt(0);

            switch (choice)
            {
                case 'y', 'Y' -> {
                    dummy.setExtraCheese(true);
                    valid = false;
                }
                case 'n', 'N' -> {
                    dummy.setExtraCheese(false);
                    valid = false;
                }

                default -> System.out.println("Invalid Re-enter.");
            }

        }
    }

    private void askForExtraMeat(Topping dummy) {
        boolean valid = true;
        while(valid)
        {
            System.out.println("""
                    Do you want to add extra meat? 
                    Extra meat will add extra charge based on following:
                    ----------------------------------------------------------
                    |   Small - 0.50  |   Medium - 1.00   |  Large - 1.50    |
                    ----------------------------------------------------------
                    |                    Enter (Y/N)                         |
                    ----------------------------------------------------------
                    """);
            char choice = scanner.next().charAt(0);

            switch (choice)
            {
                case 'y', 'Y' -> {
                    dummy.setExtraMeats(true);
                    valid = false;
                }
                case 'n', 'N' -> {
                    dummy.setExtraMeats(false);
                    valid = false;
                }

                default -> System.out.println("Invalid Re-enter.");
            }
        }
    }
}
