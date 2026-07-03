public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int i = 0;
        int j = A.length - 1;
        while(i < j){
            int sum = A[i] + A[j];
            if(sum == B){
                return 1;
            }else if(sum > B){
                j--;
            }else if(sum < B){
                i++;
            }
        }
        return 0;
        }
    }
