public class Solution {
    public int solve(int[] A, int B, int C) {
        if(B <= A.length){
            int n = A.length;
            int sum = 0;
            for(int i = 0; i < B; i++){
                sum = sum + A[i];
            }
            if(sum == C){
                return 1;
            }
        for(int i = 1, j = B; j < n; i++,j++){
            sum = sum - A[i-1] + A[j];
            if(sum == C){
                return 1;
            }
        }
        return 0;
        }else{
            return 0;
        }
    }
}
