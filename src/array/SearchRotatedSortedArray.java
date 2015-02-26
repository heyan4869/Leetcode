/*
 * You are given a target value to search. If found in the array return
 * its index, otherwise return -1. You may assume no duplicate exists in the array.
 */

package array;

public class SearchRotatedSortedArray {
    public static int search(int[] A, int target) {
    	if (A.length == 0)
    		return -1;
    	if (A.length == 1) {
    		if (target == A[0])
    			return 0;
    		else
    			return -1;
    	}
    		
    	int cut = findCut(A, 0, A.length - 1);
    	//System.out.println(cut);
    	int index = -1;
    	if (cut == -1)
    		return findTarget(A, target, 0, A.length - 1);
    	if (target >= A[0])
    		index = findTarget(A, target, 0, cut);
    	if (target < A[0])
    		index = findTarget(A, target, cut + 1, A.length - 1);    	
    	return index;
    }

	public static int findTarget(int[] A, int target, int begin, int end) {
		if (begin > end)
			return -1;
		int mid = begin + (end - begin) / 2;
		if (target == A[mid])
			return mid;
		if (target > A[mid])
			return findTarget(A, target, mid + 1, end);
		if (target < A[mid])
			return findTarget(A, target, begin, mid - 1);
		return -1;
	}

	public static int findCut(int[] A, int begin, int end) {
		if (begin > end)
			return -1;
		int mid = begin + (end - begin) / 2;
		if (A[mid] > A[mid + 1])
			return mid;
		if (A[mid] < A[begin] && A[mid] < A[end])
			return findCut(A, begin, mid);
		if (A[mid] > A[begin] && A[mid] > A[end])
			return findCut(A, mid, end);		
		return -1;
	}
    
    public static void main(String args[]) {
    	int[] A = new int[4];
		A[0] = 5;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		//A[4] = 9;
		//A[5] = 1;
		//A[6] = 2;
		System.out.println(search(A, 3));
    }
}