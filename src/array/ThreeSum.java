package array;

import java.util.Arrays;

public class ThreeSum {
	public static int threeSumClosest(int[] nums, int target) {
		int result = 0;
		if (nums.length <= 3) {
			for (int i : nums) {
				result += i;
			}
			return result;
		}
		result = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int currsum = nums[i] + nums[start] + nums[end];
				if (currsum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(currsum - target) < Math.abs(result - target)) {
					result = currsum;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int[] nums = { -1, 2, 1, 4 };
		System.out.println(threeSumClosest(nums, 1));
	}
}