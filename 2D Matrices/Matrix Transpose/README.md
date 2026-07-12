# Matrix Transpose

## Problem Statement
Given a 2D integer array `A`, return the transpose of `A`. The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices — element `A[i][j]` moves to position `[j][i]` in the result.

**Constraints:**
`1 <= A.size() <= 1000`
`1 <= A[i].size() <= 1000`
`1 <= A[i][j] <= 1000`

**Input Format:** A 2D matrix `A` of integers (not necessarily square).

**Output Format:** The transposed 2D matrix.

## Example(s)

| Input | Output | Why |
|---|---|---|
| `[[1,2,3],[4,5,6],[7,8,9]]` | `[[1,4,7],[2,5,8],[3,6,9]]` | Row 0 `[1,2,3]` becomes column 0 of the result |
| `[[1,1,1],[2,2,2]]` | `[[1,2],[1,2],[1,2]]` | A non-square 2×3 matrix transposes into a 3×2 matrix |

## Approach
Since the matrix isn't guaranteed to be square, transposing can't safely be done in place (the dimensions actually change from `n x m` to `m x n`). Instead, allocate a brand-new result array with swapped dimensions, then copy every element `A[i][j]` into the mirrored position `ans[j][i]`.

## Algorithm
1. Let `n = A.length` (number of rows) and `m = A[0].length` (number of columns).
2. Allocate a new 2D array `ans` of size `m x n`.
3. For each row `i` from `0` to `n-1`, for each column `j` from `0` to `m-1`: set `ans[j][i] = A[i][j]`.
4. Return `ans`.

## Dry Run
`A = [[1,2,3],[4,5,6],[7,8,9]]` (n=3, m=3)
- i=0: ans[0][0]=1, ans[1][0]=2, ans[2][0]=3
- i=1: ans[0][1]=4, ans[1][1]=5, ans[2][1]=6
- i=2: ans[0][2]=7, ans[1][2]=8, ans[2][2]=9
- Result: `[[1,4,7],[2,5,8],[3,6,9]]`

## Why Does This Work?
Every element's row and column indices are simply swapped when writing into the output array, which is the literal definition of a transpose. Because the output array is sized `m x n` (columns become rows) rather than reusing the input's `n x n` shape, the algorithm correctly handles rectangular (non-square) matrices, unlike an in-place swap approach which only works when rows and columns are the same length.

## Complexity Analysis
**Time Complexity:** O(N × M) — every element of the input matrix is visited and copied exactly once.
**Space Complexity:** O(N × M) — a new output matrix of the same total size is allocated.

## Solution
```java
public class Solution {
    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0]. length;
        int[][] ans = new int [m][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}
```

## Key Learning
Transpose and "rotate 90 degrees" are related but distinct operations — transpose alone just mirrors across the diagonal, while rotation (as in the Rotate Matrix problem) additionally reverses rows or columns. For non-square matrices, a fresh output array with swapped dimensions is required since there's no way to transpose a rectangular matrix truly in place.
