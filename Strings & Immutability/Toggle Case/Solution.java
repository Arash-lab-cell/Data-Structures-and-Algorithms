public class Solution {
    public String solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        int n = sb.length();
        for(int i = 0; i < n; i++){
            char ch = sb.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                sb.setCharAt(i, (char)(ch + 32));
            }else{
                sb.setCharAt(i, (char)(ch - 32));
            }
        }
        return sb.toString();
    }
}
