package array;

public class SetMatrixZeroes {
	public static void setZeroes(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					assist(matrix, i, j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 2147483646) {
					matrix[i][j] = 0;
				}
			}
		}	
	}

	private static void assist(int[][] matrix, int i, int j) {
		for (int row = 0; row < matrix.length; row++) {
			if (row != i) {
				if (matrix[row][j] != 0) {
					matrix[row][j] = 2147483646;
				}
			}
		}
		for (int col = 0; col < matrix[0].length; col++) {
			if (col != j) {
				if (matrix[i][col] != 0) {
					matrix[i][col] = 2147483646;
				}
			}
		}
	}

	public static void main(String args[]) {
		int[][] nums = new int[3][3];
		nums[0][0] = 1;
		nums[0][1] = 2;
		nums[0][2] = 3;
		nums[1][0] = 4;
		nums[1][1] = 0;
		nums[1][2] = 6;
		nums[2][0] = 7;
		nums[2][1] = 8;
		nums[2][2] = 9;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(" " + nums[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");

		setZeroes(nums);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(" " + nums[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
}