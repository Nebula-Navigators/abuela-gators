package com.pluralsight.Receipts;
import com.pluralsight.Order;
import com.pluralsight.Order;
import com.pluralsight.OrderTypeListFolder.Sandwich.Sandwich;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReceiptFileManager {

    public void addReceiptInfile(Order order, LocalDate date)
    {

        try(FileWriter writer = new FileWriter(date + "txt", true))
        {
            writer.write(order.getSandwiches().toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }



}
