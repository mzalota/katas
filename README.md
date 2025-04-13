# Refactoring Katas
1) DeDuplicateLongStrings
2) Ifs: 
   2a) SimplyfingIfs
   2b) NetstedIfsToPreconditions
   2c) DoingMoreThanOneThing
3) UpAndDownStack
4) De-Duplicate
5) ExtractIdentifierType
6) ExtractRepository
7) MergeRepositories


## Intentions used in Katas
1a) Extract if (condition)
1b) Merge nested 'ifs'

2a) Invert if condition
2b) Replace && with ||

3a) Move up into if statement branches
3b) Extract common part from 'if'
3bb) Extract common part from 'if' (may change semantics)

4a) Split 'else if'
4b) Merge 'else if'

5) Remove redundant else

6) Swap if statements (on else if)

7) Transform body to single exit-point form


Other Intentions:
- Reuse previous variable 'message' declaration
- Split into declaration and assignment
- Expand boolean to multiple ifs
- Remove unnecessary 'return'


## References to additional refactoring tutorials

### By Emily Bache (https://www.youtube.com/@EmilyBache-tech-coach):
- Split Variable: https://www.youtube.com/watch?v=wPmJz2ynb3k
- Split Loop: https://www.youtube.com/watch?v=yYC7eaRVc7M
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

### By Dmitry Kandalov - IDEAs
- Gilded Rose Refactoring Kata https://www.youtube.com/watch?v=AxxNHKCldzA
