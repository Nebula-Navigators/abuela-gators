
package com.pluralsight;

import com.pluralsight.type.chips.Chip;
import com.pluralsight.type.chips.ChipType;
import com.pluralsight.type.drink.Drink;
import com.pluralsight.type.drink.DrinkType;
import com.pluralsight.type.sandwich.BreadType;
import com.pluralsight.type.sandwich.Sandwich;
import com.pluralsight.type.sandwich.Topping;
import com.pluralsight.type.Size;
import com.pluralsight.receipts.Receipt;
import com.pluralsight.receipts.ReceiptFileManager;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OrderManager {


    Order orders = new Order();
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public boolean checkCart() {
        return orders != null && orders.isNotEmpty();
    }

    public void putSandwichOrderInComputer(BreadType bread, Size size, int quantity, Topping topping, boolean isToasted)
    {
        Sandwich sandwich = new Sandwich(bread, size, quantity, topping, isToasted);
        double calculatedPrice = 0.00;
        calculatedPrice +=size.getBreadPrice();
        if(topping.getMeats()!= null)
        {
            calculatedPrice += size.getMeatPrice();
        }
        if(topping.isExtraMeats())
        {
            calculatedPrice += size.getExtraMeatPrice();
        }
        if(topping.getCheese()!=null)
        {
            calculatedPrice += size.getCheesePrice();
        }
        if(topping.isExtraCheese())
        {
            calculatedPrice += size.getExtraCheesePrice();
        }
        sandwich.setPrice(calculatedPrice);

        this.orders.addSandWich(sandwich);


    }

    public void putChipsOrderInComputer(ChipType selectedChip) {
        Chip chip = new Chip();
        chip.setChipName(selectedChip);
        this.orders.addChips(chip);

    }

    public void putDrinkOrderInComputer(DrinkType selectedDrink, Size selectedDrinkSize) {
        Drink drink = new Drink();
        drink.setDrink(selectedDrink);
        drink.setOwnPrice(selectedDrinkSize);
        drink.setSize(selectedDrinkSize);
        this.orders.addDrink(drink);
    }

    public void displayOrders() {

        Receipt dummy = new Receipt();

//        System.out.printf("""
//                %s%s%s
//                Store #%d | %s
//                ---------------------------------------------------------
//                """, ANSI_CYAN, dummy.getStoreName(), ANSI_RESET, dummy.getStoreAddress());
        System.out.println("""
                
                -----------------Order Summary--------------------------------
                
                Orders                                                  price
                --------------------------------------------------------------
                
                """);
        displaySandwich();
        displayDrink();
        displayChips();
        System.out.printf("""
                
                -----------------------------------------------------------------
                
                Your Total Amount                                        %.2f
                Tax Amount - (After Applying 15%s on total)              %.2f
                
                ----------------------------------------------------------------
                Amount after tax                                         %.2f
                """, this.orders.getTotal(), "%", this.orders.getTax()*this.orders.getTotal(), calculateTotalPriceAfterTax());

    }

    public void displaySandwich()
    {
        for(Sandwich sandwich : this.orders.getSandwiches())
        {
            String displayExtra = sandwich.getToppings().isExtraCheese() ? "Extra Meat" : "";
            String displayExtraCheese = sandwich.getToppings().isExtraCheese() ? "Extra Cheese": "";
            System.out.printf("""
            (%s - %s)                                         $%.2f
            Toppings:
            %s                                 %s 
            %s                                 %s
            
            Regular Topping:
          
            """,
                    sandwich.getBread(),
                    sandwich.getSize(),
                    sandwich.getPrice(),
                    sandwich.getToppings().getMeats(),
                    displayExtra,
                    sandwich.getToppings().getCheese(),
                    displayExtraCheese
            );
            for(String regularTopping: sandwich.getToppings().getRegularToppings())
            {
                System.out.println(regularTopping);
            }
            System.out.println("""
                    
                    Sauces:
                 
                    """);
            for (String s: sandwich.getToppings().getSauces())
            {
                System.out.println(s);
            }

            System.out.println("""
                    Sides:
                 
                    """);
            for(String s: sandwich.getToppings().getSides()) {
                System.out.println(s);
            }
        }
    }

    public void displayDrink()
    {
        if(!this.orders.getDrinks().isEmpty()) {
            System.out.println("""      
                                                       Drinks
                    
                    """);
        }
        for(Drink drink: this.orders.getDrinks())
        {
            System.out.printf( """     
                    %s - %s                                         %.2f
                    """,
                    drink.getDrink(),
                    drink.getSize(),
                    drink.getPrice()
            );
        }
    }

    public void displayChips()
    {
        if(!this.orders.getChips().isEmpty()) {
            System.out.println("""      
                    Chips
                    -----------------------------------------------------
                    """);
        }
        for(Chip chip: this.orders.getChips())
        {
            System.out.printf("""
                    %s                                                %.2f
                    """,
                    chip.getChipName(),
                    chip.getPrice()
            );
        }
        double totalPrice = getSandwichTotalPrice()+getAllChipsTotalPrice()+getAllDrinkTotalPrice();
        this.orders.setTotal(totalPrice);

    }

    public Receipt getReceipt(String customerName)
    {
        Receipt receipt = new Receipt();
        receipt.setCustomerName(customerName);
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter yearTime = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = date.format(yearTime);
        receipt.setOrders(this.orders);

        ReceiptFileManager manager = new ReceiptFileManager();
        manager.addReceiptInfile(receipt, fileName);
       return receipt;
    }

    public double getSandwichTotalPrice()
    {
        double res = 0.00;
        for(Sandwich s: this.orders.getSandwiches())
        {
           res += s.getPrice();
        }
        return res;
    }

    public double getAllDrinkTotalPrice()
    {
        double res = 0.00;
        for(Drink d: this.orders.getDrinks())
        {
            res += d.getPrice();
        }
        return res;
    }

    public double getAllChipsTotalPrice()
    {
        double res = 0.00;
        for(Chip c: this.orders.getChips())
        {
            res+= c.getPrice();
        }
        return res;
    }

    public double calculateTotalPriceAfterTax()
    {
        double res = 0.00;
        res = this.orders.getTotal() + (this.orders.getTotal()*this.orders.getTax());
        return res;
    }

    public void CancelOrder() {
        this.orders.getSandwiches().clear();
        this.orders.getChips().clear();
        this.orders.getDrinks().clear();
    }
}
