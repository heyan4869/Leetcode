package array;

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
    	int count = 0;
        for(int i=0; i<A.length; i++) {
        	while(A[i] == elem) {
        		for(int j=i; j<A.length-1; j++) {
        			A[j] = A[j+1];
        		}
        		count++;
        	}
        }
        int[] newA = Arrays.copyOfRange(A, 0, A.length-count);
        for(int j=0; j<newA.length; j++) {
        	System.out.print(newA[j]);
        }
        System.out.println("");
    	return A.length-count;
    }
    
    public static void main(String args[]) {
    	int[] A = {1, 2, 3, 3, 4, 3, 5, 3, 2};
    	int leng = removeElement(A, 3);
    	System.out.println(leng);
    }
}