//Given an array and a value, remove all instances of that value in place and return the new length.
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

package array;

public class RemoveElementFast {
    public static int removeElement(int[] A, int elem) {
    	int index = 0;
        for (int i=0; i<A.length; i++){
            if (A[i]!=elem) {
                A[index++]=A[i];
            }
        }
        for(int j=0; j<A.length; j++) {
        	System.out.print(A[j]);
        }
        System.out.println("");
        return index;
    }
    
    public static void main(String args[]) {
    	int[] A = {1, 2, 3, 3, 4, 3, 5, 3, 2};
    	int leng = removeElement(A, 3);
    	System.out.println(leng);
    }
}