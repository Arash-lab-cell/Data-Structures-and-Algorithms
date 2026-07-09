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
