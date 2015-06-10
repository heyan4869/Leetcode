// *****Good solution*****

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList());

		Arrays.sort(num);

		for (int i : num) {
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for (List<Integer> sub : res) {
				List<Integer> inner = new ArrayList<Integer>(sub);
				inner.add(i);
				if (!res.contains(inner)) {
					temp.add(inner);
				}
			}
			res.addAll(temp);
		}
		return res;
	}
}