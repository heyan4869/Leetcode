//Given a sorted array, remove the duplicates in place 
//such that each element appear only once and return the new length.
//Do not allocate extra space for another array,
//you must do this in place with constant memory.


package array;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] A) {
    	if(A.length<2)
    		return A.length;
    	
        int i = 1;
        int j = 0;
        while(i<A.length) {
        	if(A[i]==A[j])
        		i++;
        	else {
        		j++;
        		A[j] = A[i];
        		i++;
        	}
        }
    	//System.out.println(count);
    	
    	for(int k=0; k<A.length; k++) {
        	System.out.print(A[k]);
        }
        System.out.println("");
        
    	return j+1;
    }
    
    public static void main(String args[]) {
    	int[] A = {1, 1, 2, 2, 3, 4, 4};
    	int result = removeDuplicates(A);
    	System.out.println(result);
    }
}