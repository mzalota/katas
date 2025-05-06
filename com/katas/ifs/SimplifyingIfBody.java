package com.katas.ifs;

public class SimplifyingIfBody extends SimplifyingIfConditions {


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
    //3) Refactor: Inline extracted() method (Ctrl+Alt+M)
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

}
