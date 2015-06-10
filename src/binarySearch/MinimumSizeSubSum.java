// nice solution, window slides

package binarySearch;

public class MinimumSizeSubSum {
	public static int minSubArrayLen(int s, int[] nums) {
		// since it asks for subarray, we could not sort the array
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int low = 0;
		int high = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		while (high < nums.length) {
			sum += nums[high];
			if (sum >= s) {
				while (low <= high && sum - nums[low] >= s) {
					sum -= nums[low];
					low++;
				}
				minLen = Math.min(minLen, high - low + 1);
			}
			high++;
		}

		return minLen != Integer.MAX_VALUE ? minLen : 0;
	}

	public static void main(String args[]) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 7;
		System.out.println(minSubArrayLen(s, nums));
	}
}