package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates,
			int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if (candidates.length == 0) {
			return res;
		}
		int cursum = 0;
		Arrays.sort(candidates);
		boolean[] used = new boolean[candidates.length];
		assist(candidates, used, target, cursum, 0, temp, res);
		return res;
	}

	private static void assist(int[] candidates, boolean[] used, int target,
			int cursum, int curind, List<Integer> temp, List<List<Integer>> res) {
		if (cursum > target) {
			return;
		}
		if (cursum == target) {
			// Collections.sort is very useful for sorting list
			Collections.sort(temp);
			if (res.contains(temp)) {
				return;
			} else {
				res.add(new ArrayList<Integer>(temp));
				return;
			}
		}
		for (int i = curind; i < candidates.length; i++) {
			if (used[i] == false) {
				cursum += candidates[i];
				used[i] = true;
				temp.add(candidates[i]);
				// be careful, it is (i + 1), not (curind + 1)
				assist(candidates, used, target, cursum, i + 1, temp, res);
				cursum -= candidates[i];
				used[i] = false;
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String args[]) {
		int[] can = { 4, 4, 2, 1, 4, 2, 2, 1, 3 };
		List<List<Integer>> res = combinationSum2(can, 6);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println("");
		}
	}
}