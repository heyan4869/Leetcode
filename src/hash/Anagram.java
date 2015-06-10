package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
	public static List<String> anagrams(String[] strs) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			String temp = "";
			if (!strs[i].equals("")) {
				char[] array = strs[i].toCharArray();
				Arrays.sort(array);
				temp = Arrays.toString(array);
			}
			if (hm.containsKey(temp)) {
				res.add(strs[i]);
				if (hm.get(temp) != -1) {
					res.add(strs[hm.get(temp)]);
					hm.put(temp, -1);
				}
			} else {
				hm.put(temp, i);
			}
		}
		return res;
	}

	public static void main(String args[]) {
		String[] strs = { "abcd", "abdc", "cbad" };
		List<String> res = anagrams(strs);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
