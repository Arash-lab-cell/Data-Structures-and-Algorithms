public class Solution {
    public long solve(String A) {
        long g = 0;
        long ag = 0;
        for(int i = (A.length() - 1); i >= 0; i--){
            if(A.charAt(i) == 'G'){
                g++;
            }else if(A.charAt(i) == 'A'){
                ag = ag + g;
            }
        }
        return ag;
    }
}
