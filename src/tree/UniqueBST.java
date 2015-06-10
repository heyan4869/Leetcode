package tree;

import java.util.HashMap;
import java.util.Map;

public class UniqueBST {
	public int numTrees(int n) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, 1);
		hm.put(1, 1);
		return numTrees(n, hm);
	}

	private int numTrees(int n, Map<Integer, Integer> hm) {
		// check hashmap
		if (hm.containsKey(n))
			return hm.get(n);
		// recursion
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + numTrees(i - 1, hm) * numTrees(n - i, hm);
		}
		hm.put(n, sum);
		return sum;
	}
}