package com.WardrobeKata.project;

public abstract class Wardrobe implements Comparable<Wardrobe>{
    private int size;
    private int price;
    public Wardrobe(int size, int price){
        this.size = size;
        this.price = price;
    }
    public int getSize(){return size;}
    public int getPrice(){return price;}

    public int compareTo(Wardrobe other) {
        return other.getSize() - this.size;
    }
}