package binarySearch;

public class binaryLoop {
    public static int findIndex(int[] array, int target) {
    	int left = 0;
    	int right = array.length - 1;
    	
    	while(left < right) {
    		int mid = left + (right - left) / 2;
    	    if(array[mid] == target)
    	    	return mid;
    	    if(array[mid] <= target)
    	    	left = mid + 1;
    	    if(array[mid] >= target)
    	    	right = mid - 1;
    	}
	    
	    	return -1;
    }
    public static void main(String args[]) {
    	int[] a = {1, 2, 2, 4, 5, 6, 7};
    	int find = 2;
    	int index = findIndex(a, find);
    	System.out.println(index);
    }
}
