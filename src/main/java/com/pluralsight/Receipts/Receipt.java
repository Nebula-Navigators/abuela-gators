package com.pluralsight.Receipts;

import java.util.ArrayList;
import com.pluralsight.Order;

public class Receipt {
   Order Orders = new Order();
   Receipt(Order ListOfOrder)
   {
       this.Orders = ListOfOrder;
   }

   public void displayReceipt()
   {

   }
}
