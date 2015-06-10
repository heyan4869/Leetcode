package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static List<String> generateParenthesis(int n) {
		if (n <= 0) {
			return null;
		}
		List<String> rs = new ArrayList<String>();
		char[] curr = new char[n * 2];
		int count = 0;
		return assist(curr, rs, n, n, count);
	}

	private static List<String> assist(char[] curr, List<String> rs, int left,
			int right, int count) {
		if (left < 0 || right < left) {
			return null;
		}
		if (left == 0 && right == 0) {
			String s = String.copyValueOf(curr);
			rs.add(s);
		} else {
			if (left > 0) {
				curr[count] = '(';
				assist(curr, rs, left - 1, right, count + 1);
			}
			if (right > 0) {
				curr[count] = ')';
				assist(curr, rs, left, right - 1, count + 1);
			}
		}
		return rs;
	}

	public static void main(String args[]) {
		List<String> list = generateParenthesis(2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}