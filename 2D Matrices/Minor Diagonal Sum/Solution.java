public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[][] A) {
        int sum = 0;
        int n = A.length;
        int m = A[0].length;
        for (int i = 0, j = m - 1; i < n; i++, j--) {
            sum = sum + A[i][j];
        }
        return sum;
    }
}
