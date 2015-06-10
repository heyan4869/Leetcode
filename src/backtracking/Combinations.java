// Given two integers n and k, return all possible combinations of k numbers out of 1...n
// Similar to LeetCode problem Permutations
// Later number must larger than the previous

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		int pre = 0;
		for (int i = 1; i <= n; i++) {
			arr.add(i);
		}
		assist(pre, res, arr, temp, k);

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
		List<List<Integer>> res = combine(4, 2);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j));
			}
			System.out.println("");
		}
	}
}