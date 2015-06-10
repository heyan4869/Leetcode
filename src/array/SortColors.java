/*
 * the colors in the order red, white and blue
 * use the integers 0, 1, and 2 to represent the color red, white, and blue
 * we could use two pointers
 */

package array;

public class SortColors {
    public static void sortColors(int[] A) {
    	int zeroPosition = 0;
        int onePosition = 0;
        int twoPosition = 0;
        for(int i = 0; i < A.length; i++){
            if (A[i] == 0){
                A[twoPosition] = 2;
                A[onePosition] = 1;
                A[zeroPosition] = 0;
                zeroPosition++;
                onePosition++;
                twoPosition++;
            }
            else if (A[i] == 1){
                A[twoPosition] = 2;
                A[onePosition] = 1;
                onePosition++;
                twoPosition++;
            }
            else if (A[i] == 2){
                A[twoPosition] = 2;
                twoPosition++;
            }
        }
    }
    
    public static void main(String args[]) {
    	int[] A = {1, 2, 0};
    	sortColors(A);
    	for (int i = 0; i < A.length; i++) {
    		System.out.print(A[i]);
    	}
    	System.out.println(" this is sorted A");
    }
}