public class Solution {
    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
