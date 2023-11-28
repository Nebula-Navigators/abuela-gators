package com.pluralsight.Receipts;

import java.time.LocalDate;
import java.util.ArrayList;
import com.pluralsight.Order;

public class Receipt {
   Order orders = new Order();
   LocalDate date;
   String customerName;
   final String storeName = "Abuela-Gators";


   public Order getOrders() {
      return orders;
   }

   public String getCustomerName() {
      return customerName;
   }

   public void setCustomerName(String customerName) {
      this.customerName = customerName;
   }

   public void setOrders(Order orders) {
      this.orders = orders;
   }
}
