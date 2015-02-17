/*
 * If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 
 * due to the constraint of this problem where each number must appear either 
 * three times or once. This will be the ith bit of that "single number".
 */

package hashtable;

public class SingleNumberII {
    public static int singleNumber(int[] A) {
    	int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
            	int curr = (A[j] >> i) & 1;
                count[i] += curr;
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
    
    
    public static void main(String args[]) {
    	int[] A = {1, 1, 2, 1, 2, 2, 3};
    	System.out.println(singleNumber(A));
    }
    
}