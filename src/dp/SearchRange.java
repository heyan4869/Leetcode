package dp;

public class SearchRange {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if (nums.length == 0) {
			return res;
		}

		if (nums[0] == target) {
			res[0] = 0;
		} else {
			res[0] = searchLeft(nums, target, 0, nums.length - 1);
		}

		if (nums[nums.length - 1] == target) {
			res[1] = nums.length - 1;
		} else {
			res[1] = searchRight(nums, target, 0, nums.length - 1);
		}

		return res;
	}

	private static int searchLeft(int[] nums, int target, int head, int end) {
		if (head > end) {
			return -1;
		}
		int mid = (head + end) / 2;
		if (nums[mid] == target) {
			if (nums[mid] > nums[mid - 1]) {
				return mid;
			} else {
				return searchLeft(nums, target, head, mid - 1);
			}
		}
		if (nums[mid] > target) {
			return searchLeft(nums, target, head, mid - 1);
		}
		if (nums[mid] < target) {
			return searchLeft(nums, target, mid + 1, end);
		}

		return -1;
	}

	private static int searchRight(int[] nums, int target, int head, int end) {
		if (head > end) {
			return -1;
		}
		int mid = (head + end) / 2;
		if (nums[mid] == target) {
			if (nums[mid] < nums[mid + 1]) {
				return mid;
			} else {
				return searchRight(nums, target, mid + 1, end);
			}
		}
		if (nums[mid] > target) {
			return searchRight(nums, target, head, mid - 1);
		}
		if (nums[mid] < target) {
			return searchRight(nums, target, mid + 1, end);
		}

		return -1;
	}

	public static void main(String args[]) {
		int[] nums = { 5 };
		int[] res = searchRange(nums, 5);
		for (int i = 0; i < res.length; i++) {
			System.out.print(" " + res[i] + " ");
		}
	}
}