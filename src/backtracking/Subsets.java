// Similar to Permutations

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		int pre = Integer.MIN_VALUE;
		res.add(temp);
		for (int i = 0; i < nums.length; i++) {
			arr.add(nums[i]);
		}
		for (int i = 1; i <= nums.length; i++) {
			assist(pre, res, arr, temp, i);
		}
		return res;
	}

	private static void assist(int pre, List<List<Integer>> res,
			List<Integer> arr, List<Integer> temp, int k) {
		if (temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < arr.size(); i++) {
			int curr = arr.get(i);
			if (curr > pre) {
				arr.remove(i);
				temp.add(curr);
				assist(curr, res, arr, temp, k);
				temp.remove(Integer.valueOf(curr));
				arr.add(i, curr);
			}
		}
	}

	public static void main(String args[]) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = subsets(nums);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j));
			}
			System.out.println("");
		}
	}
}