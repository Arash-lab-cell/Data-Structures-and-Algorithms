public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for(int s = 0; s < n; s++){
            int sum = 0;
            for(int e = s; e < n; e++){
                int m = e - s + 1;
                sum = sum + A[e];
                if(m % 2 == 0 && sum < B){
                    count++;
                }else if(m % 2 != 0 && sum > B){
                    count++;
                }
            }
        }
        return count;
    }
}
