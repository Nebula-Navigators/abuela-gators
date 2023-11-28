package com.pluralsight;

import com.pluralsight.OrderTypeListFolder.Chips.ChipType;
import com.pluralsight.OrderTypeListFolder.Drink.DrinkType;
import com.pluralsight.OrderTypeListFolder.Sandwich.BreadType;
import com.pluralsight.OrderTypeListFolder.Sandwich.ListOfToppings.CheeseType;
import com.pluralsight.OrderTypeListFolder.Sandwich.ListOfToppings.MeatType;
import com.pluralsight.OrderTypeListFolder.Sandwich.Topping;
import com.pluralsight.OrderTypeListFolder.Size;
import com.pluralsight.Receipts.Receipt;

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


    public void displaySandwichScreen(){
        // Show the Sandwich menu with variety of bread and size with price and ask to customer to choose
        Size size = null;
        BreadType selectedBread = null;
        boolean passingToasted = false;
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


        Topping selectedTopping = new Topping();
        boolean run = true;
        while(run) {
            System.out.println("Do You want to add Topping? (Y/N)");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'y', 'Y' -> {
                    selectedTopping = getTopping();
                    run = false;
                }
                case 'n', 'N' -> run = false;
                default -> System.out.println("Re- Enter the value. Invalid input.");
            }
        }
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

    private Topping getTopping() {
        Topping dummy = new Topping();
        boolean valid = true;
        while(valid) {
            System.out.println("""
                    Please follow the following instructions for Meat:
                    1. Steak
                    2. Ham
                    3. Salami
                    4. Roast beef
                    5. Chicken
                    6. Bacon
                    0. Cancel
                    """);
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1 -> {
                    dummy.setMeats(MeatType.Steak);
                    valid = false;
                }
                case 2 -> {
                    dummy.setMeats(MeatType.Ham);
                    valid = false;
                }
                case 3 -> {
                    dummy.setMeats(MeatType.Salami);
                    valid = false;
                }
                case 4 -> {
                    dummy.setMeats(MeatType.Roast_beef);
                    valid = false;
                }
                case 5 -> {
                    dummy.setMeats(MeatType.Chicken);
                    valid = false;
                }
                case 6 -> {
                    dummy.setMeats(MeatType.Bacon);
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
                    Do you want to add extra meat? (Y/N)
                    Extra meat will add extra charge based on following:
                    Small - 0.50
                    Medium - 1.00
                    Large - 1.50
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
        valid = true;
        while(valid)
        {
            System.out.println("""
                    If you want to add cheese.
                    Please select the Cheese.
                    1. American
                    2. Provolone
                    3. Cheddar
                    4. Swiss;
                    0. Don't want it.
                    """);
            int option = scanner.nextInt();
            switch (option)
            {
                case 1 -> {
                    dummy.setCheese(CheeseType.American);
                    valid = false;
                }
                case 2 -> {
                    dummy.setCheese(CheeseType.Provolone);
                    valid = false;
                }
                case 3 -> {
                    dummy.setCheese(CheeseType.Cheddar);
                    valid = false;
                }
                case 4 -> {
                    dummy.setCheese(CheeseType.Swiss);
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
                    Do you want extra cheese? (Y/N)
                    Extra Cheese will add extra charge based on following:
                    Small - 0.30
                    Medium - 0.60
                    Large - 0.90
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
        valid = true;
        while(valid)
        {
            System.out.println("""
                    These toppings are regular topping select which one you want to include:
                    
                    1. Lettuce
                    2. Peppers
                    3. Onions
                    4. Tomatoes
                    5. Jalepenos
                    6. cucumbers
                    7. pickles
                    8. guacamole
                    9. mushrooms
                    0. Don't want to add anymore
                    """);
            int option = scanner.nextInt();
            switch (option)
            {
                case 1 -> {
                    dummy.addRegularTopping("Lettuce");
                }
                case 2 -> {
                    dummy.addRegularTopping("Peppers");

                }
                case 3 -> {
                    dummy.addRegularTopping("Onions");

                }
                case 4 -> {
                    dummy.addRegularTopping("Tomatoes");

                }
                case 5 -> {
                    dummy.addRegularTopping("Jalepenos");

                }
                case 6 -> {
                    dummy.addRegularTopping("cucumbers");

                }
                case 7 -> {
                    dummy.addRegularTopping("pickles");

                }
                case 8 -> {
                    dummy.addRegularTopping("guacamole");

                }
                case 9 -> {
                    dummy.addRegularTopping("mushrooms");
                }
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
                    1. Mayo
                    2. Mustard
                    3. Ketchup
                    4. Ranch
                    5. thousand islands
                    6. vinaigrette
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
                    1. au jus
                    2. sauce
                    0. Do not want to include anymore
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
            handler.putDrinkOrderInComputer(selectedDrink, price, selectedDrinkSize);
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

        System.out.println("""
                You are in the CheckOut Screen.
                Here is your Order list and total:
                """);
        handler.displayOrders();
        boolean running = true;
        while (running)

        {
            System.out.println("""
                    Please follow the following instructions:
                        1. Checkout
                        0. Cancel
                        """);
            int checkoutOption = scanner.nextInt();
            switch (checkoutOption) {
                case 1 -> {
                    System.out.println("Please enter your name.");
                    String name = scanner.nextLine();
                    Receipt bill = handler.getReceipt(name);
                    displayReceiptScreen(bill);
                    running = false;
                }
                case 0 -> running = false;
                default -> System.out.println("Invalid entry. Re-enter.");

            }

        }
    }

    private void displayReceiptScreen(Receipt bill) {
    }
}
