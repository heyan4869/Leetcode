/*Binary search is a famous question in algorithm.

For a given sorted array (ascending order) and a target number,
find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.*/

package binarySearch;
//import java.util.Arrays;
//no need to import this, already contained by java.lang

public class binarySearch {
	public static int findTarget(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        return biSearch(array, target, left, right); //this has to be returned      
        }
	 private static int biSearch(int[] array, int target, int left, int right) {
		 if(left > right)
			 return -1;
		 else {
			 int mid = left + (right - left) / 2;
			 if(array[mid] < target)
				 return biSearch(array, target, mid + 1, right); //same as before
			 if(array[mid] > target)
				 return biSearch(array, target, left, mid - 1); //same as before
			 else
				 return mid;
        }
     }
     public static void main(String args[]) {
		 int[] a = {1, 2, 3, 4, 5, 5, 7};
         int find = 5;
	     int index = findTarget(a, find);
         System.out.println(index);
    }
}

