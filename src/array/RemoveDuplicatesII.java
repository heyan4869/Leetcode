/*
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 */

package array;

import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicatesII {
	// time limit exceeded
	public static int removeDuplicatesTLE(int[] A) {
		if (A.length < 3)
			return A.length;
		Stack<Integer> q = new Stack<Integer>();
		q.push(A[0]);
		int count = 1;
		int num = 1;
		int curr = 0;
		for (int i = 1; i < A.length; i++) {
			if (q.peek() != A[i]) {
				System.out.println("curr index is " + i);
				System.out.println("curr count is " + count);
				int n = count;
				while (!q.isEmpty() && n > 0) {
					A[curr + n - 1] = q.pop();
					n--;
				}
				curr = curr + count;
				q.push(A[i]);
				num++;
				count = 1;
			} else if (q.peek() == A[i] && count == 1) {
				q.push(A[i]);
				num++;
				count++;
			} else if (q.peek() == A[i] && count == 2) {
				continue;
			}
		}
		while (!q.isEmpty()) {
			A[curr] = q.pop();
			;
		}
		// System.out.println(" contained in q ");

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		System.out.println(" contained in A ");

		return num;
	}
	
	// compare every element with the last two element of new Array
	// (only be stored in the origin array)
	public static int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;
		int cnt = 1;
		for (int i = 2; i < A.length; i++) {
			if (A[i] == A[cnt] && A[i] == A[cnt - 1])
				continue;
			else
				A[++cnt] = A[i];
		}
		return cnt + 1;

	}

	public static int removeDuplicatesLength(int[] A) {
		if (A.length < 3)
			return A.length;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int result = 0;
		int i = 0;
		boolean flag = false;
		while (i < A.length - 1) {
			if (!h.containsKey(A[i])) {
				h.put(A[i], 1);
				// System.out.println(h.get(2));
				result++;
				i++;
			} else {
				if (h.get(A[i]) == 1) {
					if (!flag) {
						h.put(A[i], h.get(A[i]) + 1);
						result++;
						i++;
					} else {

						A[i] = A[i + 1];
						flag = true;
					}
				} else if (h.get(A[i]) >= 3) {
					// System.out.println(i);

					A[i] = A[i + 1];
					flag = true;
					// i--;
				}
			}
		}
		for (int j = 0; j < A.length; j++) {
			System.out.print(A[j]);
		}
		System.out.println("");

		return result;
	}

	public static void main(String args[]) {
		int[] A = { 1, 1, 1, 2, 2, 2, 3 };
		int result = removeDuplicates(A);
		System.out.println(result);
	}
}