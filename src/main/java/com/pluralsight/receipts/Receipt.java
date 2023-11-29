package com.pluralsight.receipts;

import com.pluralsight.Order;

public class Receipt {
   private Order orders = new Order();
   private String customerName;

   public String getStoreName() {
      return storeName;
   }

   public String getStoreAddress() {
      return storeAddress;
   }

   final String storeName = "Abuela-Gators";

   final String storeAddress = "23-34 NewYork, NY";


//   final float storeNumber = 7182337187;


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
