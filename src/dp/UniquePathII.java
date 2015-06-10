package dp;

public class UniquePathII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[][] map = new int[row][col];

		for (int j = 0; j < col; j++) {
			if (obstacleGrid[0][j] == 1) {
				if (row == 1)
					return 0;
				break;
			} else {
				map[0][j] = 1;
			}
		}

		for (int i = 0; i < row; i++) {
			if (obstacleGrid[i][0] == 1) {
				if (col == 1)
					return 0;
				break;
			} else {
				map[i][0] = 1;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (obstacleGrid[i][j] != 1) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}

		return map[row - 1][col - 1];
	}

	public static void main(String args[]) {
		int[][] nums = new int[3][3];
		nums[0][0] = 0;
		nums[0][1] = 0;
		nums[0][2] = 0;
		nums[1][0] = 0;
		nums[1][1] = 1;
		nums[1][2] = 0;
		nums[2][0] = 0;
		nums[2][1] = 0;
		nums[2][2] = 0;
		System.out.println(uniquePathsWithObstacles(nums));
	}
}