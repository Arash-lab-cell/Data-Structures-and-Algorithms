# Main Diagonal Sum

## Problem Statement
You are given an N x N integer matrix `A`. Return the sum of all elements on the main diagonal, i.e., every element `A[i][j]` where `i == j`.

Constraints:
- 1 <= N <= 10^3
- -1000 <= A[i][j] <= 1000

Input Format: R and C (rows and columns) followed by R*C integers in row-major order.
Output Format: A single integer representing the sum of the main diagonal.

## Example
Input 1:
```
3 3 1 -2 -3 -4 5 -6 -7 -8 9
```
Matrix: [[1,-2,-3],[-4,5,-6],[-7,-8,9]]
Output 1: 15 (1 + 5 + 9)

Input 2:
```
2 2 3 2 2 3
```
Matrix: [[3,2],[2,3]]
Output 2: 6 (3 + 3)

## Approach
Since the main diagonal consists of every element where the row index equals the column index, a single loop can walk both indices together, incrementing row and column in lockstep, accumulating each visited element into a running total.

## Algorithm
1. Determine `n`, the size of the square matrix, from `A.length`.
2. Initialize `sum` to 0.
3. For `i` and `j` both starting at 0 and incrementing together while `i < n`, add `A[i][j]` to `sum`.
4. Return `sum`.

## Dry Run
Input: A = [[1,-2,-3],[-4,5,-6],[-7,-8,9]]

- i=0, j=0: sum += A[0][0] = 1 -> sum = 1
- i=1, j=1: sum += A[1][1] = 5 -> sum = 6
- i=2, j=2: sum += A[2][2] = 9 -> sum = 15

Final Answer: 15

## Why Does This Work?
By definition, the main diagonal is exactly the set of positions where the row and column indices are equal. Incrementing both indices together in a single loop visits precisely these positions, one time each, in order, so the running total correctly equals the sum of the diagonal.

## Complexity Analysis
### Time Complexity
O(N) - the loop visits exactly N diagonal elements.

### Space Complexity
O(1) - only a single accumulator variable is used.

## Solution (Java 8)
```java
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[][] A) {
        int n = A.length;
        int sum = 0;
        for (int i = 0, j = 0; i < n; i++, j++) {
            sum = sum + A[i][j];
        }
        return sum;
    }
}
```

## Key Learning
- Diagonal traversal problems are often the simplest matrix pattern, since a single loop with two lockstep indices suffices instead of nested loops.
- This O(N) approach is optimal since every diagonal element must be visited at least once.
- This pattern extends naturally to anti-diagonal sums by walking `i` upward and `j` downward instead of both upward.
