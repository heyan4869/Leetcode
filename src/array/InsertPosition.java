package array;

public class InsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[0] >= target) {
        	return 0;
        }
        if (nums[nums.length - 1] < target) {
        	return nums.length;
        }
        return assist(nums, target, 0, nums.length - 1);
    }
    
    // use binary search, if the target exists in the array, return its position
    private static int assist(int[] nums, int target, int left, int right) {
		if (left == right) {
			return left;
		}
		int mid = (left + right) / 2;
		if (target == nums[mid]) {
			return mid;
		}
		if (target < nums[mid]) {
			return assist(nums, target, left, mid);
		}
		return assist(nums, target, mid + 1, right);
	}

	public static void main(String args[]) {
    	int[] nums = {1, 3, 5, 6};
    	System.out.println(searchInsert(nums, 4));
    }
}