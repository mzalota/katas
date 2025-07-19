package com.katas.functions;

import java.util.List;


/*
* Refactoring flow: "Return inside if statement inside for loop"
*
* ---Push logic "down-stack" (to the function "below")
*
*/
public class F05_ReturnInsideForLoop {

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
