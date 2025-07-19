package com.katas.functions;

import java.util.List;



/*
 * Refactoring flow: "Return inside if statement inside for loop"
 *
 * 1) Intention: "Transform body to single exit-point form". Cursor on extractIndividualLogicOutOfForLoop() method. New variables, result and finished are created.
 * 2) Refactor: "Rename..." variable "finished" to "matchWasFound". Cursor on newly created "finished" variable in extractIndividualLogicOutOfForLoop() method.
 * 3) Refactor: "Rename..." variable "count" to "matchAtElementIndex". Cursor on newly created "count" variable in extractIndividualLogicOutOfForLoop() method.
 * 4) Intention: "Move up into 'if' statement branches". Cursor on "return result;" at the bottom of the extractIndividualLogicOutOfForLoop() method.
 * 5) Intention: "Compute constant value of 'result'". Cursor on "return result;" in if statement body.
 * 5) Refactor: "Introduce Constant..." - name DEFAULT_RESULT. Cursor on the magic number "1" in the snippet "return 1;"
 * 6) Refactor: "Extract Method": select for loop and all lines above it in extractIndividualLogicOutOfForLoop() method. Name of new variable - "resultCombo"
 *
 *
 * -- int getCountOfUnmatched(list)
 * 3) Refactor: "Introduce Variable": resultFromForLoop - select "resultCombined.result()" in extractIndividualLogicOutOfForLoop() method.
 * 4) Refactor: "Inline Variable": resultCombo - cursor on "resultCombo" in "resultCombined.result()" snippet. Select "This reference only".
 * 6) Refactor: "Extract Method": getResultFromForLoop(list) - select "getResult(list).result()" snippet.
 * 7) Refactor: "Inline Method": getResult() inside getResultFromForLoop() method. Select "Inline this usage only, keep the method" option
 * 8) Refactor: "Inline Variable": resultCombined. Inside getResultFromForLoop() method.
 * 9) Manually replace "return new Result(result, matchWasFound, matchAtElementIndex).result()" with "return result;"
 * 10) Remove line "matchWasFound = true;" inside if statement inside for loop. It is irrelevant for calculating the value of "count" variable.
 * 11) Intention: "Remove local variable 'matchWasFound'". Cursor on the definition of "matchWasFound" variable in getResultFromForLoop() method.
 * 12) Move 'return' closer to computation of the value of 'result'. Cursor on "return result;" in getResultFromForLoop() method.
 *
 * -- int getCountOfUnmatched(list)
 * 3) Refactor: "Introduce Variable": count - select "resultCombined.count()" in extractIndividualLogicOutOfForLoop() method.
 * 4) Refactor: "Inline Variable": resultCombined - cursor on "resultCombined" in "resultCombined.count()" snippet. Select "This reference only".
 * 6) Refactor: "Extract Method": getCount(list) - select "getResult(list).count()" snippet.
 * 7) Refactor: "Inline Method": getResult() inside getCount() method. Select "Inline this usage only, keep the method" option
 * 8) Refactor: "Inline Variable": resultCombined. Inside getCount() method.
 * 9) Manually replace "return new Result(result, finished, count).count()" with "return count;"
 * 10) Remove code inside if statement above "break;" in getCount() method. It is irrelevant for calculating the value of "count" variable.
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
                return computeFactor(count, element);
            }
            count++;
        }

        System.out.println("Match not found. Total count of elements:"+count);
        return 1;
    }

    private int computeFactor(int count, Integer element) {
        return element*count;
    }
}
