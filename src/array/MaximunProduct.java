//Find the contiguous subarray within an array (containing 
//at least one number) which has the largest product.

package array;

public class MaximunProduct {
    public static int maxProduct(int[] A) {
    	if(A.length==0 || A==null)
    		return 0;
    	if(A.length==1)
    		return A[0];
    	int currMax = A[0];
    	int currMin = A[0];
    	int prevMax = A[0];
    	int prevMin = A[0];
    	int result = A[0];
    	for(int i=1; i<A.length; i++) {
    		currMax = Math.max(prevMax*A[i], Math.max(prevMin*A[i], A[i]));
    		currMin = Math.min(prevMax*A[i], Math.min(prevMin*A[i], A[i]));
    		result = Math.max(result, currMax);
    		prevMax = currMax;
    		prevMin = currMin;
    	}    	
    	
    	return result;
    }
    
    public static void main(String args[]) {
    	int[] anArray = new int[2];
        anArray[0] = -3;
        anArray[1] = -4;
//        anArray[2] = 5;
//        anArray[3] = 6;
//        anArray[4] = 7;
//        anArray[5] = 1;
//        anArray[6] = 2;
    	System.out.println(maxProduct(anArray));
    }
}