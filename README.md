
## Intentions used in Kata

1a) "Extract if (condition)"
1b) "Merge nested 'ifs'"
2) "Invert if condition"

3a) "Move up into if statement branches"
3b) "Extract common part from 'if'"
3bb) "Extract common part from 'if'(may change semantics)"

4a) "Split 'else if'"
4b) Merge 'else if'

5)"Remove redundant else"

6)"Transform body to single exit-point form"


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

Three-step refactoring, "extract-inline-rename" with introducing a temporary name, is a commonly occuring pattern. Examples:
1) Upstack, Donwstack 
2) De-Duplicate

References to additional refactoring videos
By Dmitry Kandalov - IDEAs
- Gilded Rose Refactoring Kata https://www.youtube.com/watch?v=AxxNHKCldzA

By Emily Bache (https://www.youtube.com/@EmilyBache-tech-coach):
- Split Variable: https://www.youtube.com/watch?v=wPmJz2ynb3k
- Split Loop: https://www.youtube.com/watch?v=yYC7eaRVc7M
- Conditionals/Ifs (Guard clause): https://www.youtube.com/watch?v=fLaXlBVUb0c

