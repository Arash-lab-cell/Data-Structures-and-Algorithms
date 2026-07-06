public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int c = 0; // total good elements and the size of sub array containing all the good elements
        for(int i = 0; i < n; i++){
            if(A[i] <= B){
                c++;
            }
        }
        int count = 0; // good elements in current window
        for(int i = 0; i < c; i++){
            if(A[i] <= B){
                count++;
            }
        }
        int maxSwipe = count;
        for(int i = c; i < n; i++){ 
            if(A[i-c] <= B){ //if c = 3 the, 3-3=0, 4-3=1 this covers all elements from index 0
                count--;
            }
            if(A[i] <= B){ // if c=3, 3,4,5 this covers all elements from index c till n
                count++;
                maxSwipe = Math.max(count, maxSwipe) // after adding A[i] and increasing count, we select the maximum value
            }
        }
        return c - maxSwipe; //c is the best array in which all the elements are good and we subtract the best subarray we found, and the answer is min swipes required
    }
}
