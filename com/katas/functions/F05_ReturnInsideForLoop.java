package com.katas.functions;

import java.util.List;



/*
 * Refactoring flow: "Return inside if statement inside for loop"
 *
 * 1) Intention: "Transform body to single exit-point form". Cursor on extractIndividualLogicOutOfForLoop() method. New variables, result and finished are created.
 * 2) Refactor: "Rename..." variable "finished" to "matchWasFound". Cursor on newly created "finished" variable in extractIndividualLogicOutOfForLoop() method.
 * 3) Refactor: "Rename..." variable "count" to "matchAtElementIndex". Cursor on newly created "count" variable in extractIndividualLogicOutOfForLoop() method.
 * 4) Intention: "Move up into if statement branches". Cursor on "return result;" at the bottom of the extractIndividualLogicOutOfForLoop() method.
 * 5) Intention: "Compute constant value of ''". Cursor on result 1
 * 5) Refactor: "Introduce Constant..." - name DEFAULT_RESULT. Cursor on the magic number "1" in the snippet "int result = 1;"
 * 6) Refactor: "Extract Method": select for loop and all lines above it in extractIndividualLogicOutOfForLoop() method. Name of new variable - "resultCombined"

 * -- int getCountOfUnmatched(list)
 * 3) Refactor: "Introduce Variable": count - select "resultCombined.count()" in extractIndividualLogicOutOfForLoop() method.
 * 4) Refactor: "Inline Variable": resultCombined - cursor on "resultCombined" in "resultCombined.count()" snippet. Select "This reference only".
 * 6) Refactor: "Extract Method": getCount(list) - select "getResult(list).count()" snippet.
 * 7) Refactor: "Inline Method": getResult() inside getCount() method. Select "Inline this usage only, keep the method" option
 * 8) Refactor: "Inline Variable": resultCombined. Inside getCount() method.
 * 9) Manually replace "return new Result(result, finished, count).count()" with "return count;"
 * 10) Remove code inside if statement above "break;" in getCount() method. it is irrelevant for calculating the value of "count" variable.
 * 11) Intention: "Remove local variable 'finished'". Cursor on the definition of "finished" variable in getCount() method.
 * 12) Intention: "Remove local variable 'result'". Cursor on the definition of "result" variable in getCount() method.
 *
 * -- boolean isFinished(list)
 *
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
