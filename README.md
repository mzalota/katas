
# Refactoring Katas
## Reorganizing code within a function
1) B01_DeDuplicateLongStrings
2) Ifs: (See linked to a video tutorial below)
   - B02_SimplifyingIfBody
   - B03_SimplifyingIfConditions
3) B04_SplitVariable 
4) B05a_ExtractMultiMethods_SplitLoop
5) B05b_ExtractMultiMethods_SplitIf
6) B05c_ExtractMultiMethods_SplitLoopWithReturnInside
7) B06_SplitLoop_thru_middle_list

## Reorganizing code between neighbouring functions.
8) F01_UpAndDownStack 
9) F02_TryCatchDownStack 
10) F03_AddFactoryMethods 
11) F04_DeDuplicateFunctions 
12) F05a_ParamToConstructor
13) F05b_ParamToConstructor_advanced

## Reorganizing code between classes
14) IdentifierType
   - C01_IdentifierTypeFromParam
   - C02_IdentifierTypeFromField
15) C03_ExtractRepository 
16) C04_MergeTwoRepositories


# Intentions used in Katas
1) Extract if (condition)
2) Invert if condition
3) Merge nested 'ifs'
4) Replace && with ||
5) Move up into if statement branches
6) Extract common part from 'if'
7) Extract common part from 'if' (may change semantics)
8) Split 'else if'
9) Merge 'else if'
10) Remove redundant else
11) Swap if statements (on else if)
12) Transform body to single exit-point form
13) Reuse previous variable 'message' declaration
14) Split into declaration and assignment
15) Join declaration and assignment
16) Expand boolean to multiple ifs
17) Replace constructor with factory method
18) Reuse previous variable 'message' declaration
19) Change access modifier: public
20) Join concatenated string literals
21) Remove unnecessary 'return'
22) Convert record to class
23) Remove unnecessary parentheses
24) Remove empty string operand
25) Replace constructor with factory method
26) Replace '+' with 'String.format()'
27) Move 'return' closer to computation of the value of 'xyzVariable'
28) Move declaration of 'xyzVariable' closer to usages
29) Delete catch for 'xyzException'
30) Make 'xyzMethod()' return java.lang.xyz of ancestor 
31) Compute constant value of 'xyzVariable'
32) Replace for-each loop with indexed 'for' loop
33) Add 'this' qualifier
34) Safe delete

- Replace Stream API chain with loop
- Collapse loop with Stream API

## References to additional refactoring tutorials

### By JetBrains (https://www.jetbrains.com/help/idea/refactoring-source-code.html):
- Rename (Shift+F6): https://www.jetbrains.com/help/idea/rename-refactorings.html#invoke-rename-refactoring
- Extract Method (Ctrl+Alt+M):  https://www.jetbrains.com/help/idea/extract-method.html
- Introduce Variable (Ctrl+Alt+V): https://www.jetbrains.com/help/idea/extract-variable.html
- Introduce Field (Ctrl+Alt+F):  https://www.jetbrains.com/help/idea/extract-field.html
- Introduce Parameter (Ctrl+Alt+P):  https://www.jetbrains.com/help/idea/extract-parameter.html
- Inline (Ctrl+Alt+N): https://www.jetbrains.com/help/idea/inline.html
- Introduce Parameter Object: https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html#extract_parameter_object
- Move Instance Method: https://www.jetbrains.com/help/idea/move-refactorings.html#instance_method_example
- Move Members: https://www.jetbrains.com/help/idea/move-refactorings.html,  https://www.jetbrains.com/help/idea/move-members-dialog.html
- Pull Members Up: https://www.jetbrains.com/help/idea/pull-members-up.html
- Extract Superclass: https://www.jetbrains.com/help/idea/extract-superclass.html
- Invert Boolean: https://www.jetbrains.com/help/idea/invert-boolean-refactoring.html
- Make Static: https://www.jetbrains.com/help/idea/make-method-static.html 
- Generate Constructor: https://www.jetbrains.com/guide/java/tips/generate-getters-and-setters/

### By Emily Bache (https://www.youtube.com/@EmilyBache-tech-coach):
- Split Variable: https://www.youtube.com/watch?v=wPmJz2ynb3k
- Split Loop: https://www.youtube.com/watch?v=yYC7eaRVc7M (https://github.com/emilybache/Theatrical-Players-Refactoring-Kata)
- Conditionals/Ifs (Guard clause): https://www.youtube.com/watch?v=fLaXlBVUb0c

### By Dmitry Kandalov - IDEAs
- Gilded Rose Refactoring Kata https://www.youtube.com/watch?v=AxxNHKCldzA
