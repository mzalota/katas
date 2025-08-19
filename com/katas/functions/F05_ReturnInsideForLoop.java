package com.katas.functions;

import java.util.List;


/*
 * Refactoring flow: "Return inside if statement inside for loop"
 *
 * 1) Intention: "Transform body to single exit-point form". Cursor on extractIndividualLogicOutOfForLoop() method. New variables created: result and finished.
 * 2) Refactor: "Rename..." variable "finished" to "matchWasFound". Cursor on newly created "finished" variable in extractIndividualLogicOutOfForLoop() method.
 * 4) Intention: "Move up into 'if' statement branches". Cursor on "return result;" at the bottom of the extractIndividualLogicOutOfForLoop() method.
 * 5) Intention: "Compute constant value of 'result'". Cursor on "return result;" in if statement body.
 * 5) Refactor: "Introduce Constant..." - name DEFAULT_RESULT. Cursor on the magic number "1" in the snippet "return 1;". Select checkbox "Replace all occurences".
 * 6) Refactor: "Extract Method": select for loop and all lines above it in extractIndividualLogicOutOfForLoop() method. Name of new variable - "resultCombo"
 *
 * -- boolean isMatchWasFound(list)
 * A1) Refactor: "Introduce Variable": matchWasFound - select "resultCombo.matchWasFound()" in extractIndividualLogicOutOfForLoop() method.
 * A2) Refactor: "Inline Variable": resultCombo - cursor on "resultCombo" in "resultCombo.matchWasFound()" snippet. Select "This reference only".
 * A3) Refactor: "Extract Method": isMatchWasFound(list) - select "getResult(list).matchWasFound()" snippet.
 * A4) Refactor: "Inline Method": getResult() inside isMatchWasFound() method. Select "Inline this usage only, keep the method" option.
 * A5) Refactor: "Inline Variable": resultCombo.
 * A6) Manually replace "return new Result(result, matchWasFound, matchAtElementIndex).matchWasFound()" with "return matchWasFound;"
 * A7) Manually remove two lines of code inside if statement above "matchWasFound = true;". They are irrelevant for determining if matchWasFound.
 * A8) Intention: "Remove local variable 'result'". Cursor on the definition of "result" variable.
 * A9) Intention: "Remove local variable 'matchAtElementIndex'". Cursor on the definition of "matchAtElementIndex".
 * A10) Intention: "Move 'return' closer to computation of the value of 'matchWasFound'". Cursor on "return matchWasFound;".
 *
 * -- int getMatchAtElementIndex(list)
 * B1) Refactor: "Introduce Variable": matchAtElementIndex - select "resultCombo.matchAtElementIndex()" in extractIndividualLogicOutOfForLoop() method.
 * B2) Refactor: "Inline Variable": resultCombo - cursor on "resultCombo" in "resultCombo.matchAtElementIndex()" snippet. Select "This reference only".
 * B3) Refactor: "Extract Method": getMatchAtElementIndex(list) - select "getResult(list).matchAtElementIndex()" snippet.
 * B4) Refactor: "Inline Method": getResult() inside getMatchAtElementIndex() method. Select "Inline this usage only, keep the method" option.
 * B5) Refactor: "Inline Variable": resultCombo.
 * B6) Manually replace "return new Result(result, matchWasFound, matchAtElementIndex).matchAtElementIndex()" with "return matchAtElementIndex;".
 * B7) Manually remove code inside if statement above "break;". It is irrelevant for calculating the value of the "matchAtElementIndex" variable.
 * B8) Intention: "Remove local variable 'matchWasFound'". Cursor on the definition of "matchWasFound" variable.
 * B9) Intention: "Remove local variable 'result'". Cursor on the definition of "result" variable.
 *
 * -- int getResultFromForLoop(list)
 * C1) Refactor: "Introduce Variable": resultFromForLoop - select "resultCombo.result()" in extractIndividualLogicOutOfForLoop() method.
 * C2) Refactor: "Inline Variable": resultCombo - cursor on "resultCombo" in "resultCombo.result()" snippet. Select "This reference only".
 * C3) Refactor: "Extract Method": getResultFromForLoop(list) - select "getResult(list).result()" snippet.
 * C4) Refactor: "Inline Method": getResult() inside getResultFromForLoop() method. Select "Inline this usage only, keep the method" option
 * C5) Refactor: "Inline Variable": resultCombo. Inside getResultFromForLoop() method.
 * C6) Manually replace "return new Result(result, matchWasFound, matchAtElementIndex).result()" with "return result;"
 * C7) Manually remove line "matchWasFound = true;" inside if statement inside for loop. It is irrelevant for calculating the value of the "result" variable.
 * C6) Intention: "Remove local variable 'matchWasFound'". Cursor on the definition of "matchWasFound" variable.
 * C9) Intention: "Move 'return' closer to computation of the value of 'result'". Cursor on "return result;".
 * -- Optionally you can try to convert for-each loop to indexed for loop and notice that
 * C10) Intention "Replace for-each loop with indexed 'for' loop". Cursor on 'for' keyword "matchAtElementIndex" can be replaced with "i"
 *
 */
public class F05_ReturnInsideForLoop {

    public int extractIndividualLogicOutOfForLoop(List<Integer> list) {

        int matchAtElementIndex = 0;
        for (Integer element : list) {
            if (element < 0) {
                System.out.println("Match found at element number:"+matchAtElementIndex);
                return computeFactor(matchAtElementIndex, element);
            }
            matchAtElementIndex++;
        }

        System.out.println("Match not found. Total number of elements:"+matchAtElementIndex);
        return 1;
    }

    private int computeFactor(int count, Integer element) {
        return element*count;
    }
}
