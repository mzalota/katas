package com.katas.functions;

import java.util.List;


/*
* Refactoring flow: "Push logic down-stack" and "Pull logic up-stack"
*
* ---Push logic "down-stack" (to the function "below")
* 1) Refactor: "Extract Method": lookupPriceInDBNew() - select last two lines in the method getBaselinePrice().
* 2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
* 3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
*
* --- Pull logic "up-stack" (to the function "above")
* 1) Refactor: "Extract Method": lookupPriceInDBNew() - content last line in the method lookupPriceInDB().
* 2) Refactor: "Inline Method...": lookupPriceInDB(). Select first option: "Inline all and remove the method"
* 3) Refactor: "Rename..." lookupPriceInDBNew() to lookupPriceInDB()
*
*/
public class ReturnInsideForLoop {

    public int extractIndividualLogicOutOfForLoop(List<Integer> list) {

        int count = 0;
        for (Integer element : list) {
            if (element < 0) {
                System.out.println("Match found at element number:"+count);
                return getAnInt(count, element);
            }
            count++;
        }

        System.out.println("Match not found. Total count of elements:"+count);
        return 1;
    }

    private int getAnInt(int count, Integer element) {
        return element*count;
    }
}
