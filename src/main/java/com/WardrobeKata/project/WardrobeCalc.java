package com.WardrobeKata.project;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WardrobeCalc {
    private ArrayList<Wardrobe> wrdbs;
    
    private ArrayList<ArrayList<Wardrobe>> combos;
    private ArrayList<Wardrobe> currCombo; 
    private int wallSize;
    private int currWallSize;
    
    public WardrobeCalc(List<Wardrobe> wrdbs){
        this.wrdbs = new ArrayList<Wardrobe>(wrdbs);
        Collections.sort(this.wrdbs);
    }

    public ArrayList<Wardrobe> getWrdbs() {
        return wrdbs;
    }

    
    public ArrayList<ArrayList<Wardrobe>> combosCalc(int wallSize){
        combos = new ArrayList<ArrayList<Wardrobe>>();
        currCombo = new ArrayList<Wardrobe>();
        this.wallSize = wallSize;
        this.currWallSize = wallSize;
        genCombos(0);
        return(onlyClosest());
    }
    
    private void genCombos(int currWrdbInd){
        int currWrdbSize = wrdbs.get(currWrdbInd).getSize();
        while(currWallSize - currWrdbSize >= 0){
            currCombo.add(wrdbs.get(currWrdbInd));
            currWallSize -= currWrdbSize;
        }
        if(currWallSize != 0){
            for(int nxtWrdbInd = currWrdbInd+1; nxtWrdbInd < wrdbs.size(); nxtWrdbInd++){
                int nxtWrdbSize = wrdbs.get(nxtWrdbInd).getSize();
                if(nxtWrdbSize <= currWallSize){
                    genCombos(nxtWrdbInd);
                }
            }
        }
        if(!currCombo.equals(new ArrayList<Wardrobe>()) && !combos.contains(currCombo)){
            combos.add(currCombo);
        }
        currCombo = new ArrayList<Wardrobe>();
        currWallSize = wallSize;
        if(currWrdbInd + 1 < wrdbs.size())
            genCombos(currWrdbInd+1);
    }

    private ArrayList<ArrayList<Wardrobe>> onlyClosest(){
        int closest = findClosestSum();
        ArrayList<ArrayList<Wardrobe>> closestCombos = new ArrayList<ArrayList<Wardrobe>>();
        for(ArrayList<Wardrobe> currCombo : combos){
            int sum = sumCombo(currCombo);
            if(sum == closest){
                closestCombos.add(currCombo);
            }
        }
        return closestCombos;
    }

    private int findClosestSum(){
        int closest = 0;
        int sum;
        for(ArrayList<Wardrobe> currCombo : combos){
            sum = sumCombo(currCombo);
            if(wallSize - sum < wallSize - closest){
                closest = sum;
            }
        }
        return closest;
    }

    private int sumCombo(ArrayList<Wardrobe> combo){
        int sum = 0;
        for(Wardrobe currWrdb : combo){
            sum += currWrdb.getSize();
        }
        return sum;
    }
}