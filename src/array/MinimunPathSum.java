package array;

public class MinimunPathSum {
	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		if (row == 0 || col == 0) {
			return 0;
		}
		int[][] res = new int[row][col];
		res[0][0] = grid[0][0];
		
		for (int i = 1; i < row; i++) {
			res[i][0] = grid[i][0] + res[i - 1][0];
		}
		
		for (int j = 1; j < col; j ++) {
			res[0][j] = grid[0][j] + res[0][j - 1];
		}
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
			}
		}
		
		return res[row - 1][col - 1];
	}
	
//	public static int[][] assist(int[][] grid, int[][] res, int hor, int ver, int row, int col) {
//		while (hor <= row - 1 && ver <= col - 1) {
//			
//		}
//		
//		return res;
//	}
	
	// time limit exceeded
	public static int minpathsum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		if (row == 0 || col == 0) {
			return 0;
		}
		int res = grid[0][0];
		return assis(grid, res, 0, 0, row, col);
	}

	private static int assis(int[][] grid, int res, int hor, int ver, int row,
			int col) {
		if (hor >= row || ver >= col) {
			return -1;
		}
		if (hor == row - 1 && ver == col - 1) {
			return res;
		}
		if (hor < row - 1 && ver == col - 1) {
			return assis(grid, res + grid[hor + 1][ver], hor + 1, ver, row,
							col);
		}
		if (hor == row - 1 && ver < col - 1) {
			return assis(grid, res + grid[hor][ver + 1], hor, ver + 1, row,
							col);
		}
		if (hor < row - 1 && ver < col - 1) {
			return Math.min(
							assis(grid, res + grid[hor + 1][ver], hor + 1,
									ver, row, col),
							assis(grid, res + grid[hor][ver + 1], hor,
									ver + 1, row, col));
		}
		return -1;
	}

	public static void main(String args[]) {
		int[][] nums = new int[2][3];
		nums[0][0] = 1;
		nums[0][1] = 2;
		nums[1][0] = 1;
		nums[1][1] = 2;
		nums[0][2] = 3;
		nums[1][2] = 4;
		System.out.println(minPathSum(nums));
	}
}