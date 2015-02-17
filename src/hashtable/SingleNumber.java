package hashtable;

import java.util.HashMap;

public class SingleNumber {
	
	// time exceeded
    public static int findSingleNumber(int[] A) {
        HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
        	if (!s.containsKey(A[i]))
        		s.put(A[i], i);
        	else
        		s.remove(A[i]);
        }
        Object[] array = s.keySet().toArray();
        return (int)array[0];
    }
    
    //XOR will return 1 only on two different bits. So if two numbers are the same,
    //XOR will return 0. Finally only one number left. A ^ A = 0 and A ^ B ^ A = B.
    public static int singleNumber(int[] A) {
    	int result = A[0];
        for(int i = 1; i < A.length; i++)
        {
            result = result^A[i];  /* Get the xor of all elements */
        }
        return result;
    }
    
    public static void main(String args[]) {
    	int[] A = {1, 1, 2, 2, 3};
    	System.out.println(singleNumber(A));
    }
}