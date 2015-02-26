/*
 * there is one tricky case when A is 1111111111111111111111112111111111111111
 * the worest case run time is O(n), so just using a for loop is alright
 */

package array;

public class SearchRotatedSortedArrayII {
    public static boolean search(int[] A, int target) {
    	if (A.length == 0)
    		return false;
    	if (A.length == 1) {
    		if (target == A[0])
    			return true;
    		else
    			return false;
    	}
    	
        int cut = findCut(A, 0, A.length - 1);
    	System.out.println(cut);
    	if (cut == -1)
    		return findTarget(A, target, 0, A.length - 1);
    	if (target >= A[0])
    		return findTarget(A, target, 0, cut);
    	if (target < A[0])
    		return findTarget(A, target, cut + 1, A.length - 1); 
    	return false;
    }
    
    public static boolean findTarget(int[] A, int target, int begin, int end) {
		if (begin > end)
			return false;
		int mid = begin + (end - begin) / 2;
		if (target == A[mid])
			return true;
		if (target > A[mid])
			return findTarget(A, target, mid + 1, end);
		if (target < A[mid])
			return findTarget(A, target, begin, mid - 1);
		return false;
	}
    
    public static int findCut(int[] A, int begin, int end) {
		if (begin >= end)
			return -1;
		int mid = begin + (end - begin) / 2;
		if (A[mid] > A[mid + 1])
			return mid;
		if (A[mid] <= A[begin] && A[mid] <= A[end])
			return findCut(A, begin, mid);
		if (A[mid] >= A[begin] && A[mid] >= A[end])
			return findCut(A, mid, end);		
		return -1;
	}
    
    public static void main(String args[]) {
    	int[] A = new int[5];
		A[0] = 1;
		A[1] = 1;
		A[2] = 1;
		A[3] = 2;
		A[4] = 1;
		System.out.println(search(A, 2));
    }
}