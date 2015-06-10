package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		// collect possible candidates from small to large to eliminate
		// duplicates,
		assist(new ArrayList<Integer>(), target, candidates, 0, res);
		return res;
	}

	// the index here means we are allowed to choose candidates from that index
	private static void assist(List<Integer> temp, int target,
			int[] candidates, int index, List<List<Integer>> res) {
		if (target == 0) {
			res.add(temp);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			int newTarget = target - candidates[i];
			if (newTarget >= 0) {
				List<Integer> copy = new ArrayList<Integer>(temp);
				copy.add(candidates[i]);
				assist(copy, newTarget, candidates, i, res);
			} else {
				break;
			}
		}
	}
	
	public static void main(String args[]) {
		int[] n = {2, 3, 6, 7};
		List<List<Integer>> res = combinationSum(n, 7);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println("");
		}
	}
}