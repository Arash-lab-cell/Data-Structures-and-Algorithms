public class Solution {
    public int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        int n = sb.length();
        int countOf1 = 0;
        for(int i = 0; i < n; i++){
            if(sb.charAt(i) == '1'){
                countOf1++;
            }
        }
        if(countOf1 == n){
            return n;
        }else if(countOf1 == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < n; i++)
        if(sb.charAt(i) == '0'){
            int j = i-1, l = 0;
            while(j >= 0 && sb.charAt(j) == '1'){
                j--;
                l++;
            }
            int k = i+1, r = 0;
               while(k < n && sb.charAt(k) == '1'){
                   k++;
                   r++;
            }
            if(l+r < countOf1){
                ans = Math.max(ans, l+r+1);
            }else {
                ans = Math.max(ans, l+r);
            }
        }
        return ans;
    }
}
