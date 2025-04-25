package com.WardrobeKata.project;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WardrobeCalc {
    private ArrayList<Wardrobe> wrdbs;
    private ArrayList<ArrayList<Wardrobe>> combos;
    private int wallSize;
    public WardrobeCalc(List<Wardrobe> wrdbs){
        this.wrdbs = new ArrayList<Wardrobe>(wrdbs);
        Collections.sort(this.wrdbs);
    }

    public ArrayList<Wardrobe> getWrdbs() {
        return wrdbs;
    }

    public ArrayList<ArrayList<Wardrobe>> combosCalc(int wallSize){
        combos = new ArrayList<ArrayList<Wardrobe>>();
        this.wallSize = wallSize;
        ArrayList<Wardrobe> currCombo = new ArrayList<Wardrobe>();
        int currWallSize = wallSize;
        for(int currInd = 0; currInd < wrdbs.size(); currInd++){
            int currSize = wrdbs.get(currInd).getSize();
            if(currSize <= currWallSize){
                while(currWallSize - currSize >= 0){
                    currCombo.add(wrdbs.get(currInd));
                    currWallSize -= currSize;
                }
                if(!currCombo.equals(new ArrayList<Wardrobe>())){
                    combos.add(currCombo);
                }
                currCombo = new ArrayList<Wardrobe>();
                currWallSize = wallSize;
            }
        }
        return(onlyClosest());
    }

    private ArrayList<ArrayList<Wardrobe>> onlyClosest(){
        
        int closest = findClosestSum();

        ArrayList<ArrayList<Wardrobe>> closestCombos = new ArrayList<ArrayList<Wardrobe>>();
        for(ArrayList<Wardrobe> currCombo : combos){
            int sum = 0;
            for(Wardrobe currWrdb : currCombo){
                sum += currWrdb.getSize();
            }
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
            sum = 0;
            for(Wardrobe currWrdb : currCombo){
                sum += currWrdb.getSize();
            }
            if(wallSize - sum < wallSize - closest){
                closest = sum;
            }
        }
        return closest;
    }
}
