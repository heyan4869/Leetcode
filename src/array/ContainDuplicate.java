package array;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(nums[i])) {
				return true;
			} else {
				hm.put(nums[i], 1);
			}
		}
		return false;
	}
}