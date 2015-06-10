/*
 * 2 -- "abc", 3 -- "def", 4 -- "ghi", 5 -- "jkl",
 * 6 -- "mno", 7 -- "pqrs", 8 -- "tuv", 9 -- "wxyz"
 */

package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits.length() == 0) {
			return res;
		}
		Map<Character, String> hm = new HashMap<Character, String>();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");
		
		String temp = "";
		String digitsback = digits;
		assist(digits, digitsback, hm, temp, res);
		return res;
	}
	
	private static void assist(String digits, String digitsback, Map<Character, String> hm,
			String temp, List<String> res) {
		if (temp.length() == digitsback.length()) {
			res.add(new String(temp));
		}
		for (int i = 0; i < digits.length(); i++) {
			Character curr = digits.charAt(i);
			String button = hm.get(curr);
			for (int j = 0; j < button.length(); j++) {
				Character letter = button.charAt(j);
				temp = temp + letter;
				assist(digits.substring(i + 1, digits.length()), digitsback, hm, temp, res);
				temp = temp.substring(0, temp.length() - 1);
			}
		}
	}

	public static void main(String args[]) {
		List<String> res = letterCombinations("23");
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}