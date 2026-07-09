public class Solution {
    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] ans = new int[2*n-1][n];
        int ansRow = 0;
        for(int j = 0; j < n; j++){
                int ansCol = 0;
            for(int r = 0, c = j; r < n && c >= 0; r++, c--){
                ans[ansRow][ansCol] = A[r][c];
                ansCol++;
            }
            ansRow++;
        }
        for(int i = 1; i < n; i++){
            int ansCol = 0;
            for(int r = i, c = n-1; r < n && c >= 0; r++, c--){
                ans[ansRow][ansCol] = A[r][c];
                ansCol++;
            }
            ansRow++;
        }
        return ans;
    }
}
