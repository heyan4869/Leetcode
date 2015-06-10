// review this problem

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		// for the first digit, pick the k/(n-1)! from the list
		// drop the selected digit, k=k*(n-1)!
		// the second digit, pick the k/(n-2)! from the new list again,
		// until only one digit left in the list, append it to the string.
		// the time complexity is O(n), space complextiy is O(n).
		
		ArrayList<String> candidates = new ArrayList<String>();
		int size = 1;
		// create n! and build the candidates list
		for (int i = 0; i < n; i++) {
			candidates.add(Integer.toString(i + 1));
			size *= i + 1;
		}
		StringBuilder sb = new StringBuilder();
		k--;
		
		// loop to append 1th to (n-1)th digit
		for (int j = n; j > 1; j--) {
			size = size / j;
			int select = k / size;
			k = k % size;
			String str = candidates.get(select);
			sb.append(str);
			candidates.remove(select);
		}
		// append the last digit
		sb.append(candidates.get(0));
		return sb.toString();
	}

	// *****this is TLE*****
	public static String getpermutation(int n, int k) {
		List<String> res = new ArrayList<String>();
		if (n == 0) {
			return "";
		}
		String temp = "";
		boolean[] flag = new boolean[n];
		assist(n, k, flag, temp, res);

		return res.get(k - 1);
	}

	private static void assist(int n, int k, boolean[] flag, String temp,
			List<String> res) {
		if (res.size() == k) {
			return;
		}
		if (temp.length() == n) {
			res.add(temp);
		}
		for (int i = 1; i <= n; i++) {
			if (flag[i - 1] == false) {
				temp = temp + i;
				flag[i - 1] = true;
				assist(n, k, flag, temp, res);
				temp = temp.substring(0, temp.length() - 1);
				flag[i - 1] = false;
			}
		}
	}

	public static void main(String args[]) {
		System.out.println(getPermutation(3, 4));
	}
}