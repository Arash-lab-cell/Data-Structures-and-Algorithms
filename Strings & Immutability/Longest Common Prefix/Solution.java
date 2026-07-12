public class Solution {
    public String longestCommonPrefix(String[] A) {
        int shortestStringLength = Integer.MAX_VALUE;
        String shortestString = new String();
        for(int i = 0; i < A.length; i++){
            String str = A[i];
            if(str.length() < shortestStringLength){
                shortestStringLength = str.length();
                shortestString = str;
            }
        }
        if(A.length == 0){
            return "";
        }
        int k = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            String str = A[i];
            int l = 0;
            for(int j = 0; j < shortestString.length(); j++){
                if(shortestString.charAt(j) == str.charAt(j)){
                    l++;
                }else{
                    k = Math.min(k, l);
                    return shortestString.substring(0, k);
                }
            }
            k = Math.min(k, l);
        }
        return shortestString.substring(0, k);
    }
}
