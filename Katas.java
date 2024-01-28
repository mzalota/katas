public class Katas {


    // 1) Intention: "Invert if condition"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifStatmentAtFunctionEnd(boolean firstArgument, boolean secondArgument) {
        if (firstArgument) {
            if (secondArgument) {
                System.out.println("in inner if");
            }
        }
    }

    // 1) Intention: "Extract if"
    // 2) Intention: "Invert if condition"
    // Repeat from start -> Intention: "Transform body to single exit-point form"
    public void ifMultipleConditions(boolean firstArgument, boolean secondArgument, boolean thirdArgument) {
        if (!firstArgument) {
            return;
        }
        if (secondArgument) {
            return;
        }
        if (thirdArgument) {
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

    // 1) Manually add explicit "return;" at the end of the function
    // 2) Intention: "Move up into if statement branches"
    // 3) Intention: "Invert if condition" (code in else condition is much shorter than in if condition, so we bring it to the top of function )
    // 4) Intention: "Remove redundant else"
    // 5) Select all lines at the bottom of the function before if statement, Intention: "Move up into if statement branches"
    // 6) Intention: "Invert if condition"
    // 7) Intention: "Remove redundant else"
    // 8) Intention: Remove unnecessary 'return'
    public void ifWithElseNested (boolean isHungry, boolean foodIsReady) {
        if (isHungry) {
            System.out.println("In if top: she is hungry");
            if (foodIsReady) {
                System.out.println("In inner else: food is ready");
            } else {
                System.out.println("In inner else: food is NOT ready");
                System.out.println("In inner else: ACTION - cook something tasty");
            }
            System.out.println("In if bottom: ACTION - eat the food");
        } else {
            System.out.println("In else: she is NOT hungry");
        }
    }
}
