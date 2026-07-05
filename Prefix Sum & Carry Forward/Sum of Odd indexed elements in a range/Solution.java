public class Solution {
    public int[] sumOfOddIndexedElements(int[] A, int[][] B) {
        int n = A.length;
        int[] ps_odd = new int[n];
        ps_odd[0] = 0;
        for(int i = 1; i < n; i++){
            if(i%2 != 0){
                ps_odd[i] = ps_odd[i-1] + A[i];
            }else{
                ps_odd[i] = ps_odd[i-1];
            }
        }
        int m = B.length;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            int l = B[i][0];
            int r = B[i][1];
            if(l == 0){
                ans[i] = ps_odd[r];
            }else{
                ans[i] = ps_odd[r] - ps_odd[l-1];
            }
        }
        return ans;
    }
}
