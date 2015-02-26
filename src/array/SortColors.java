/*
 * the colors in the order red, white and blue
 * use the integers 0, 1, and 2 to represent the color red, white, and blue
 * we could use two pointers
 */

package array;

public class SortColors {
    public static void sortColors(int[] A) {
        
    }
    
    public static void main(String args[]) {
    	int[] A = {1, 2, 0, 0, 1, 1, 2, 0};
    	sortColors(A);
    	for (int i = 0; i < A.length; i++) {
    		System.out.print(A[i]);
    	}
    	System.out.println(" this is sorted A");
    }
}