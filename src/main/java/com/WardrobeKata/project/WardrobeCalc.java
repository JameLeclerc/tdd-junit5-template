package com.WardrobeKata.project;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WardrobeCalc {
    private ArrayList<Wardrobe> wrdbs;
    public WardrobeCalc(List<Wardrobe> wrdbs){
        this.wrdbs = new ArrayList<Wardrobe>(wrdbs);
        Collections.sort(this.wrdbs);
    }

    public ArrayList<Wardrobe> getWrdbs() {
        return wrdbs;
    }

    public ArrayList<ArrayList<Wardrobe>> combosCalc(int wallSize){
        ArrayList<ArrayList<Wardrobe>> combos = new ArrayList<ArrayList<Wardrobe>>();
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


        int closest = 0;
        int sum;
        for(ArrayList<Wardrobe> aCombo : combos){
            sum = 0;
            for(Wardrobe aWrdb : aCombo){
                sum += aWrdb.getSize();
            }
            if(wallSize - sum < wallSize - closest){
                closest = sum;
            }
        }

        ArrayList<ArrayList<Wardrobe>> smallestCombos = new ArrayList<ArrayList<Wardrobe>>();
        for(ArrayList<Wardrobe> aCombo : combos){
            sum = 0;
            for(Wardrobe aWrdb : aCombo){
                sum += aWrdb.getSize();
            }
            if(sum == closest){
                smallestCombos.add(aCombo);
            }
        }
        
        return(smallestCombos);
    }
}
