public class Solution {
    public int solve(String A) {
        int n = A.length();
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(A.charAt(i) == 'b' &&
               A.charAt(i-1) == 'o' &&
               A.charAt(i-2) == 'b'){
                    ans++;
            }
        }
        return ans;
    }
}
