public class Solution {
    int leader(int[] A){
        int count = 1;
        int n = A.length;
        int max = A[n-1];
        for(int i = n-2; i >= 0; i--){
            if(A[i] > max){
                max = A[i];
                count++;
            }
        }
        return count;
    }
    public int[] solve(int[] A) {
        int count = leader(A);
        int[] ans = new int[count];
        ans[count - 1] = A[A.length-1];
        int n = A.length;
        int max = A[n-1];
        for(int i = n-2, m = ans.length -2 ; i >= 0; i--){
            if(A[i] > max){
                max = A[i];
                ans[m] = A[i];
                m--;
            }
        }
        return ans;
    }
    }
