public class Solution {
    public int solve(int[] A) {
        int count = 0;
        int n = A.length;
        for (int i = 1; i < n - 1; i++) {
            int leftSmaller = 0;
            int rightLarger = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    leftSmaller++;
                }
            }
            for (int k = i + 1; k < n; k++) {
                if (A[k] > A[i]) {
                    rightLarger++;
                }
            }
            count += leftSmaller * rightLarger;
        }
        return count;
    }
}
