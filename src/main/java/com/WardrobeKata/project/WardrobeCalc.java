package com.WardrobeKata.project;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class WardrobeCalc {
    private List<Wardrobe> wrdbs;
    public WardrobeCalc(List<Wardrobe> wrdbs){
        this.wrdbs = new ArrayList<Wardrobe>(wrdbs);
    }

    public ArrayList<ArrayList<Wardrobe>> combosCalc(int wallSize){
        ArrayList<ArrayList<Wardrobe>> combos = new ArrayList<ArrayList<Wardrobe>>();
        combos.add(new ArrayList<Wardrobe>(Arrays.asList(wrdbs.get(0))));
        return(combos);
    }
}
