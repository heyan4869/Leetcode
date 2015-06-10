package array;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length <= 1) {
			return false;
		}
		Map<Integer, Integer> check = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (check.containsKey(nums[i])) {
				if (i - check.get(nums[i]) <= k) {
					return true;
				}
			}
			check.put(nums[i], i);
		}
		return false;
	}

	public static void main(String args[]) {
		int[] nums = { 99, 1, 12, 99 };
		int k = 2;
		System.out.println(containsNearbyDuplicate(nums, k));
	}
}