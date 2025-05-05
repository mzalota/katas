package com.katas.ifs;

public class NestedIfToPreconditions {

    // 1) Intention: "Invert if condition". Cursor on the if keyword
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifStatmentAtFunctionEnd(boolean firstArgument) {
        if (firstArgument) {
            System.out.println("in inner if");
        }
    }

    // 1) Intention: "Invert if condition". Cursor on the first if keyword
    // 2) Intention: "Invert if condition". Cursor on the second if keyword
    // 3) Intention: "Invert if condition". Cursor on the third if keyword
    //
    // To repeat from the start:
    // Intention: "Transform body to single exit-point form". Cursor on the function name
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
    // To repeat from the start:
    // A) Intention: "Transform body to single exit-point form". Cursor on the function name
    // B) Intention: "Merge nested 'ifs'. Cursor on the first if keyword
    public void ifMultipleConditions(boolean firstArgument, Boolean secondArgument) {
        if (!firstArgument && secondArgument != null && !secondArgument) {
            System.out.println("in if");
        }
    }

    // 1) Manually add explicit "return;" at the end of the function
    // 2) Intention: "Move up into if statement branches"
    // 3) Intention: "Remove redundant else"
    // 4) Intention: "Remove unnecessary 'return'"

    // To repeat from start:
    // Intention: "Transform body to single exit-point form". Cursor on the first if keyword
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

    // 1) Place cursor on the first if statement
    // 2) Intention: "Invert if condition"
    // 3) Intention: "Remove unnecessary 'return'"
    // 4) Place cursor on the else word
    // 5) Intention: Merge 'else if'
    // 6) Place cursor on the else word
    // 7) Intention: "Swap if statements"
    public void simplifyExample(boolean firstArgument, boolean secondArgument) {
        if (secondArgument) {
            if (firstArgument) {
                barMethod("ACTION - eat the food");
            }
            return;
        }
        barMethod("ACTION - drink water");
    }


    // 1) Place cursor in an "if" word
    // 2) Intention: "merge sequential if statements"
    // 3) Intention: invert if condition
    public void mergeIdenticalBodiesOfIfStatements(boolean firstArgument, boolean secondArgument) {
        if (firstArgument) {
            barMethod("Identical Strings");
        } else if (secondArgument) {
            barMethod("Identical Strings");
        }
    }

    // 1) Place cursor on the first if statement
    // 2) Intention: "Invert if condition"
    // 3) Place cursor in the "else" word
    // 4) Intention: Merge 'else if'
    // 5) Place cursor in an "if" word
    // 6) Intention: "merge sequential if statements"
    // 7) Intention: invert if condition
    public void mergeIdenticalBodiesOfIfStatements2(boolean firstArgument, boolean secondArgument) {
        if (firstArgument) {
            if (!secondArgument) {
                barMethod("ACTION - eat the food");
            }
        } else {
            barMethod("ACTION - eat the food");
        }
    }


    protected void fooMethod(String message) {
        System.out.println(message);
    }

    protected void barMethod(String message) {
        System.out.println(message);
    }
}
