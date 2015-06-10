package array;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		if (n == 0) {
			return res;
		}
		int i = 0;
		int j = 0;
		String dir = "right";

		for (int curr = 1; curr <= n * n; curr++) {
			if (res[i][j] == 0) {
				res[i][j] = curr;
			}

			if (dir.equals("right")) {
				if (i < n && i >= 0 && j + 1 < n && j >= 0) {
					if (res[i][j + 1] == 0) {
						j++;
						// flag = true;
						continue;
					} else {
						dir = "down";
					}
				} else {
					dir = "down";
				}
			}

			if (dir.equals("down")) {
				if (i + 1 < n && i + 1 >= 0 && j < n && j >= 0) {
					if (res[i + 1][j] == 0) {
						i++;
						// flag = true;
						continue;
					} else {
						dir = "left";
					}
				} else {
					dir = "left";
				}
			}

			if (dir.equals("left")) {
				if (i < n && i >= 0 && j - 1 >= 0 && j - 1 < n) {
					if (res[i][j - 1] == 0) {
						j--;
						// flag = true;
						continue;
					} else {
						dir = "up";
					}
				} else {
					dir = "up";
				}
			}

			if (dir.equals("up")) {
				if (i - 1 >= 0 && i - 1 < n && j < n && j >= 0) {
					if (res[i - 1][j] == 0) {
						i--;
						// flag = true;
						continue;
					} else {
						dir = "right";
						j++;
					}
				} else {
					dir = "right";
				}
			}
		}

		return res;
	}

	public static void main(String args[]) {
		int[][] res = generateMatrix(5);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(" " + res[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}