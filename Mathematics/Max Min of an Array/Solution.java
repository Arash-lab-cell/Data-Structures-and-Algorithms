public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A);
        return (A[0] + A[A.length-1]);
    }
}
