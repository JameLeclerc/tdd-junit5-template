package com.WardrobeKata.project;

public abstract class Wardrobe{
    private int size;
    private int price;
    public Wardrobe(int size, int price){
        this.size = size;
        this.price = price;
    }
    public int getSize(){return size;}
    public int getPrice(){return price;}
}