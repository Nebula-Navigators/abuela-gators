package com.pluralsight.OrderTypeListFolder.Chips;


public class Chip {
    private ChipType chipName;
    private final double price = 1.50;


    public void setChipName(ChipType chipName) {
        this.chipName = chipName;
    }

    public ChipType getChipName() { return this.chipName; }
}
