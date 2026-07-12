# Simple Reverse

## Problem Statement
Given a string `A`, reverse the string and return the reversed string.

**Constraints:**
`1 <= |A| <= 10^5`
`A` consists only of lowercase characters.

**Input Format:** A single string `A`.

**Output Format:** A string denoting the reversed string.

## Example(s)

| Input | Output | Why |
|---|---|---|
| `A = "scaler"` | `"relacs"` | Characters are reversed end to start |
| `A = "academy"` | `"ymedaca"` | Characters are reversed end to start |

## Approach
Since Java strings are immutable, build a new string by walking the original from its last character to its first, appending each character to a mutable `StringBuilder` along the way.

## Algorithm
1. Create an empty `StringBuilder sb`.
2. Loop `i` from `A.length() - 1` down to `0`.
3. Append `A.charAt(i)` to `sb` on each iteration.
4. Return `sb.toString()`.

## Dry Run
`A = "scaler"` (length 6)
- i=5: append 'r' → sb = "r"
- i=4: append 'e' → sb = "re"
- i=3: append 'l' → sb = "rel"
- i=2: append 'a' → sb = "rela"
- i=1: append 'c' → sb = "relac"
- i=0: append 's' → sb = "relacs"
- Return "relacs"

## Why Does This Work?
Walking the string from the last index to the first and appending each character in that order produces exactly the reverse of the original sequence — every character is visited exactly once, in strictly decreasing index order.

## Complexity Analysis
**Time Complexity:** O(N) — a single pass over the string.
**Space Complexity:** O(N) — the `StringBuilder` holds a full copy of the reversed string.

## Solution
```java
public class Solution {
    public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        for(int i = A.length()-1; i >= 0; i--){
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }
}
```

## Key Learning
Because Java strings are immutable, in-place character swapping (like the classic two-pointer array reversal) isn't directly possible on a `String` — `StringBuilder` is the standard tool for building a reversed (or otherwise transformed) string efficiently instead of repeatedly concatenating immutable `String` objects, which would be O(N²).
