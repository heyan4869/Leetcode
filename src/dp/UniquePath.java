package dp;

public class UniquePath {
	public static int uniquePaths(int m, int n) {
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			map[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			map[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		return map[m - 1][n - 1];
	}

	// solution with recursion is Time Limit Exceeded
	public static int uniquePathsII(int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		return assist(m, n);
	}

	public static int count = 0;

	private static int assist(int m, int n) {
		if (m == 0 || n == 0 || (m == 1 && n == 1)) {
			return count;
		} else if (m == 1 || n == 1) {
			return 1;
		}
		count = assist(m - 1, n) + assist(m, n - 1);
		return count;
	}

	public static void main(String args[]) {
		int m = 2;
		int n = 2;
		System.out.println(uniquePaths(m, n));
	}
}