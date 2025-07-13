

# Refactoring Katas
## Reorganizing code within a function
1) DeDuplicateLongStrings
2) Ifs: (See linkt to a video tutorial below)
   - SimplifyingIfBody
   - SimplifyingIfConditions
   - SplitIfs
3) Split Loop and Split Variable (see links below)

## Reorganizing code between neighbouring functions.
3) UpAndDownStack
4) TryCatchDownStack
5) AddFactoryMethods
6) DeDuplicateFunctions

## Reorganizing code between classes
7) IdentifierType
   - IdentifierTypeFromField
   - IdentifierTypeFromParam
8) ExtractRepository
9) MergeRepositories


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
27) Move 'return' closer to computation of the value of ''
28) Delete catch for 'xyzException'


- Replace Stream API chain with loop
- Collapse loop with Stream API

## References to additional refactoring tutorials

### By Emily Bache (https://www.youtube.com/@EmilyBache-tech-coach):
- Split Variable: https://www.youtube.com/watch?v=wPmJz2ynb3k
- Split Loop: https://www.youtube.com/watch?v=yYC7eaRVc7M (https://github.com/emilybache/Theatrical-Players-Refactoring-Kata)
- Conditionals/Ifs (Guard clause): https://www.youtube.com/watch?v=fLaXlBVUb0c

### By JetBrains (https://www.jetbrains.com/help/idea/refactoring-source-code.html):
- Rename (Shift+F6): https://www.jetbrains.com/help/idea/rename-refactorings.html#invoke-rename-refactoring
- Extract Variable (Ctrl+Alt+V): https://www.jetbrains.com/help/idea/extract-variable.html
- Extract Method (Ctrl+Alt+M):  https://www.jetbrains.com/help/idea/extract-method.html
- Extract Field (Ctrl+Alt+F):  https://www.jetbrains.com/help/idea/extract-field.html
- Extract Parameter (Ctrl+Alt+P):  https://www.jetbrains.com/help/idea/extract-parameter.html
- Inline (Ctrl+Alt+N): https://www.jetbrains.com/help/idea/inline.html
- Introduce Parameter Object: https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html#extract_parameter_object
- Move Instance Method: https://www.jetbrains.com/help/idea/move-refactorings.html#instance_method_example
- Extract Superclass: https://www.jetbrains.com/help/idea/extract-superclass.html
- Pull Members Up: https://www.jetbrains.com/help/idea/pull-members-up.html
- Invert Boolean: https://www.jetbrains.com/help/idea/invert-boolean-refactoring.html

### By Dmitry Kandalov - IDEAs
- Gilded Rose Refactoring Kata https://www.youtube.com/watch?v=AxxNHKCldzA
