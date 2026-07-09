# Matrix Scalar Product

## Problem Statement
You are given a 2D integer matrix `A` and an integer `B`. Perform scalar multiplication of matrix `A` with `B` and return the resulting matrix.

Constraints:
- 1 <= A.size() <= 1000
- 1 <= A[i].size() <= 1000
- 1 <= A[i][j] <= 1000
- 1 <= B <= 1000

Input Format: A 2D array of integers A, and an integer B.
Output Format: A 2D array of integers after scalar multiplication.

## Example
Input 1:
```
A = [[1,2,3],[4,5,6],[7,8,9]], B = 2
```
Output 1:
```
[[2,4,6],[8,10,12],[14,16,18]]
```

Input 2:
```
A = [[1]], B = 5
```
Output 2:
```
[[5]]
```

## Approach
Every element of the output matrix is simply the corresponding element of the input matrix multiplied by the scalar B. The solution walks every row and every column of the matrix exactly once, multiplying each element by B and storing it in a new answer matrix of the same dimensions.

## Algorithm
1. Determine the number of rows `n` and columns `m` of `A`.
2. Create an answer matrix `ans` of size n x m.
3. For every row index `i` from 0 to n-1, and every column index `j` from 0 to m-1:
   1. Set `ans[i][j] = B * A[i][j]`.
4. Return `ans`.

## Dry Run
Input: A = [[1,2,3],[4,5,6],[7,8,9]], B = 2

- Row 0: [1*2, 2*2, 3*2] = [2, 4, 6]
- Row 1: [4*2, 5*2, 6*2] = [8, 10, 12]
- Row 2: [7*2, 8*2, 9*2] = [14, 16, 18]

Final Answer: [[2,4,6],[8,10,12],[14,16,18]]

## Why Does This Work?
Scalar multiplication of a matrix is defined element-wise: each output entry depends only on the corresponding input entry and the scalar. Visiting every cell exactly once and applying the multiplication guarantees every entry of the output matrix is computed correctly, independent of the order of traversal.

## Complexity Analysis
### Time Complexity
O(N x M) - every element of the matrix is visited and multiplied exactly once.

### Space Complexity
O(N x M) - for the output matrix (input size is not counted as extra space).

## Solution (Java 8)
```java
public class Solution {
    public int[][] solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = B * A[i][j];
            }
        }
        return ans;
    }
}
```

## Key Learning
- Element-wise matrix operations (scalar multiplication, addition, etc.) generally follow the same nested-loop traversal pattern.
- Allocating a new answer matrix keeps the original input matrix unmodified, which is generally preferable unless in-place mutation is explicitly required.
- This is one of the simplest matrix problems, useful as a warm-up before tackling more complex element-wise or structural matrix transformations.
