public class Katas {


    //1) Intention: "Extract common part from 'if'"
    //2) Intention: "Move up into if statement branches"
    public void ifExtractCommonPart (boolean argumentOne) {
        if (argumentOne) {
            barMethod("xxx");
            System.out.println("Message - Done");
        } else {
            fooMethod("yyy");
            System.out.println("Message - Done");
        }
    }


    //--- If there are multiple common statements, IntelliJ gets confused and does not offer Intention "Extract common part from 'if'".
    //Use a trick - extract these lines temporarily into a function.

    //1) Select two lines with barMethod("xxx"); and fooMethod("yyy");. Extract Method (Ctrl+Alt+M). Both sections should be replaced by new method "extracted"
    //2) Intention: "Extract common part from 'if'" -> "extracted()" method moved to below if-else block
    //3) Refactoring: Inline extracted() method (Ctrl+Alt+M)
    public void ifExtractCommonPartMultipleStatements (boolean argumentOne) {
        if (argumentOne) {
            System.out.println("If ACTION");
            barMethod("xxx");
            fooMethod("yyy");
        } else {
            System.out.println("Else ACTION");
            barMethod("xxx");
            fooMethod("yyy");
        }
    }

    //1) Intention: "Extract common part from 'if'(may change semantics)" -> barMethod("xxx") is extracted above if.
    //2a) Select "Message 111" String and extract it into a variable with name String (Ctrl+Alt+V refactoring)
    //2b) Select "Message 222" String and extract it into a variable with name String (Ctrl+Alt+V refactoring)
    //3) Intention: "Split into declaration and assignment" on both message variables
    //4) Move manually (Ctrl+Shift+Up/Down) "String message;" declaration from within if block to above it.
    //5) Click on second declaration of String message; that now is in Error state
    //6) Intention: "Reuse previous variable 'message' declaration"
    //7) Intention: "Extract common part from 'if'" -> "fooMethod(message)" method moved to below if-else block
    public void ifExtractCommonPartBelowAndAbove (boolean argumentOne) {
        if (argumentOne) {
            barMethod("xxx");
            System.out.println("If ACTION");
            fooMethod("Message 111");
        } else {
            barMethod("xxx");
            System.out.println("Else ACTION");
            fooMethod("Message 222");
        }
    }



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


    // 1) Manually add explicit "return;" at the end of the function
    // 2) Intention: "Move up into if statement branches"
    // 3) Intention: "Invert if condition" (code in else condition is much shorter than in if condition, so we bring it to the top of function )
    // 4) Intention: "Remove redundant else"
    // 5) Select all lines at the bottom of the function before if statement, Intention: "Move up into if statement branches"
    // 6) Intention: "Invert if condition"
    // 7) Intention: "Remove redundant else"
    // 8) Intention: Remove unnecessary 'return'
    public void ifWithElseNestedXX (boolean isHungry, boolean foodIsReady) {
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



    private void fooMethod(String message) {
        System.out.println(message);
    }
    private void barMethod(String message) {
        System.out.println(message);
    }

}
