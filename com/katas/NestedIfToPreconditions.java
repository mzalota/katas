package com.katas;

public class NestedIfToPreconditions {

    // 1) Intention: "Invert if condition"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifStatmentAtFunctionEnd(boolean firstArgument) {
        if (firstArgument) {
            System.out.println("in inner if");
        }
    }


    // 1) Intention: "Extract if"
    // 2) Intention: "Invert if condition"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifNested(boolean firstArgument, boolean secondArgument, boolean thirdArgument) {
        if (firstArgument) {
            if (!secondArgument) {
                if (thirdArgument) {
                    System.out.println("in if");
                }
            }
        }
    }

    // 1) Intention: "Extract if (!firstArgument)"
    // 2) Intention: "Invert if condition"
    // 3) Intention: "Extract if ((!secondArgument != null))"
    // 4) Intention: "Invert if condition"
    // 5) Intention: "Invert if condition" (on third if)
    //
    // To repeat from start:
    // A) Intention: "Transform body to single exit-point form"
    // B) Intention: "Merge nested 'ifs'
    public void ifMultipleConditions(boolean firstArgument, Boolean secondArgument) {
        if (!firstArgument && (secondArgument != null) && !secondArgument) {
            System.out.println("in if");
        }
    }


    // 1) Manually add explicit "return;" at the end of the function
    // 2) Intention: "Move up into if statement branches"
    // 3) Intention: "Remove redundant else"
    // 4) Intention: "Remove unnecessary 'return'"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifWithElse(boolean firstArgument, boolean secondArgument) {
        if (firstArgument) {
            System.out.println("in if");
        } else {
            System.out.println("in else");
        }
    }

    // 1) Put cursor on else before if - Intention: Split 'else if'
    // 2) Manually add explicit "return;" at the end of the function
    // 3) Intention: "Move up into if statement branches"
    // 4) Intention: "Remove redundant else"
    // 3) Intention: "Move up into if statement branches" (return; into if-else)
    // 4) Intention: "Remove unnecessary 'return'"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifWithElseIf(boolean firstArgument, boolean secondArgument) {
        if (firstArgument) {
            System.out.println("in if");
        } else if (secondArgument) {
            System.out.println("in else-if");
        } else {
            System.out.println("in else");
        }
    }


    // 1) Intention: "Move up into if statement branches"
    // 2) Manually add explicit "return;" at the end of the function
    // 3) Intention: "Move up into if statement branches"
    // 4) Intention: "Invert if condition"
    // 5) Intention: "Remove redundant else"
    // 6) Intention: "Remove unnecessary 'return'"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifNotAtFunctionEnd(boolean firstArgument, boolean secondArgument) {
        if (firstArgument) {
            System.out.println("in inner if");
        }
        System.out.println("At function end");
    }


    // 1) Manually add explicit "return;" at the end of the function
    // 2) Intention: "Move up into if statement branches"
    // 3) Intention: "Invert if condition" (code in else condition is much shorter than in if condition, so we bring it to the top of function )
    // 4) Intention: "Remove redundant else"
    // 5) Select all lines at the bottom of the function before if statement, Intention: "Move up into if statement branches"
    // 6) Intention: "Invert if condition"
    // 7) Intention: "Remove redundant else"
    // 8) Intention: "Remove unnecessary 'return'"
    public void realisticExample(boolean isHungry, boolean foodIsReady) {
        if (isHungry) {
            System.out.println("In if top: she is hungry");
            if (foodIsReady) {
                System.out.println("In inner else: food is ready");
            } else {
                System.out.println("In inner else: food is NOT ready");
                fooMethod("ACTION - cook something tasty");
            }
            barMethod("ACTION - eat the food");
        } else {
            System.out.println("In else: she is NOT hungry");
        }
    }

    protected void fooMethod(String message) {
        System.out.println(message);
    }

    protected void barMethod(String message) {
        System.out.println(message);
    }
}
