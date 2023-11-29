package com.pluralsight.type.chips;


public class Chip {
    private ChipType chipName;

    public double getPrice() {
        return price;
    }

    private final double price = 1.50;


    public void setChipName(ChipType chipName) {
        this.chipName = chipName;
    }

    public ChipType getChipName() { return this.chipName; }

}
