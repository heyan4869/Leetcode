package array;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        if (nums.length == 0)
        	return;
        int len = nums.length;
        if (k > len)
        	k = k % len;
        int count = len - k;
    	int start = len - k - 1;
    	int end = len - 1;
    	while (count > 0) {
        	helper(nums, start, end);
        	start--;
        	end--;
        	count--;
        }
        
    }
    
    public static void helper(int[] nums, int start, int end) {
    	int temp = 0;
    	int count = end - start;
    	while (count > 0) {
    		temp = nums[start];
    		nums[start] = nums[start + 1];
    		nums[start + 1] = temp;
    		start++;
    		count--;
    	}
    }
    
    
    public static void main(String args[]) {
    	int[] nums = {1, 2, 3, 4, 5, 6, 7};
    	int k = 7;
    	rotate(nums, k);
    	for (int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i]);
    	}
    	System.out.println(" rotated");
    }
}