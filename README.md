
## Intentions used in Kata

1a."Extract if (condition)"
1b. "Merge nested 'ifs'"
2"Invert if condition"

3a. "Move up into if statement branches"
3b. "Extract common part from 'if'"
3bb "Extract common part from 'if'(may change semantics)"

4a. "Split 'else if'"
4b. Merge 'else if'

5. "Remove redundant else"

6. "Transform body to single exit-point form"


"Reuse previous variable 'message' declaration"
"Split into declaration and assignment"
"Expand boolean to multiple ifs"
"Remove unnecessary 'return'"


Other Intentions that can be used in If statements:
- "Replace && with ||"
- "Extract If Condition" 
- Split 'if else' (on else if)
- Swap if statements (on else if)

Refactorings:
- Extract Variable (Ctrl+Alt+V)
- Extract Method (Ctrl+Alt+M)
- Inline (Ctrl+Alt+N)

Three-step refactoring, "temp-name-rename", is a commonly occuring pattern. Examples:
1) Upstack, Donwstack 
2) De-Duplicate