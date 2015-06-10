package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations {
	public static List<List<Integer>> permute(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		for (int i : num) {
			arr.add(i);
		}
		permute(res, arr, temp, num.length);
		return res;
	}

	public static void permute(List<List<Integer>> res, List<Integer> arr,
			List<Integer> temp, int len) {
		if (temp.size() == len) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = 0; i < arr.size(); i++) {
			int curr = arr.remove(i);
			temp.add(curr);
			permute(res, arr, temp, len);
			temp.remove(Integer.valueOf(curr));
			arr.add(i, curr);
		}
	}

	// public static int len;
	// public static List<List<Integer>> res;
	// public static List<Integer> temp;
	// public static boolean[] used;
	//
	// public static List<List<Integer>> permute(int[] nums) {
	// len = nums.length;
	// res = new ArrayList<List<Integer>>();
	// temp = new ArrayList<>();
	// used = new boolean[len];
	// if (nums.length == 0) {
	// return res;
	// }
	//
	// assist(nums, 0);
	// return res;
	// }
	//
	// public static void assist(int[] n, int count) {
	// if (count == len) {
	// res.add(new ArrayList<Integer>(temp));
	// }
	//
	// for (int i = 0; i < len; i++) {
	// if (used[i]) {
	// continue;
	// }
	// temp.add(n[i]);
	// used[i] = true;
	// assist(n, count + 1);
	// used[i] = false;
	// temp.remove(count);
	// }
	// }

	// public static List<List<Integer>> permute(int[] nums) {
	// int len = nums.length;
	// List<List<Integer>> res = new ArrayList<List<Integer>>();
	// if (len == 0) {
	// return res;
	// }
	// for (int head = 0; head < len; head++) {
	// List<Integer> temp = new ArrayList<Integer>();
	// Map<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
	// int curr = nums[head];
	// temp.add(curr);
	// hm.put(head, true);
	// res.add(assist(temp, hm, nums));
	// hm.put(head, false);
	// }
	// return res;
	// }
	//
	// private static List<Integer> assist(List<Integer> temp,
	// Map<Integer, Boolean> hm, int[] nums) {
	// for (int i = 0; i < nums.length; i++) {
	// if (hm.containsKey(i)) {
	// if (hm.get(i)) {
	// continue;
	// }
	// }
	// temp.add(nums[i]);
	// hm.put(i, true);
	// assist(temp, hm, nums);
	// hm.put(i, false);
	// }
	// return temp;
	// }

	public static void main(String args[]) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> lis = permute(nums);
		for (int i = 0; i < lis.size(); i++) {
			List<Integer> curr = lis.get(i);
			for (int j = 0; j < curr.size(); j++) {
				System.out.print(" " + curr.get(j) + " ");
			}
			System.out.println(" ");
		}
	}
}