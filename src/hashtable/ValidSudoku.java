package hashtable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		int row = board.length;
		// check each row and column
		for (int i = 0; i < row; i++) {
			if (!check(board, i, 0, i, 8))
				return false;
			if (!check(board, 0, i, 8, i))
				return false;
		}

		// check each box
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!check(board, i*3, j*3, i*3 + 2, j*3 + 2))
					return false;
			}
		}

		return true;
	}

	public static boolean check(char[][] board, int m, int n, int row,
			int column) {
		Set<Character> s = new HashSet<Character>();
		for (int r = m; r <= row; r++) {
			for (int c = n; c <= column; c++) {
				if (board[r][c] == '.') {
					continue;
				} else {
					if (!s.contains(board[r][c]))
						s.add(board[r][c]);
					else
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[]) {
		char[][] board = new char[9][9];
		board[0][0] = '5';
		board[0][1] = '3';
		board[0][4] = '7';
		board[1][0] = '6';
		board[1][3] = '1';
		board[1][4] = '9';
		board[1][5] = '5';
		board[2][1] = '9';
		board[2][2] = '8';
		board[2][7] = '6';
		System.out.println(isValidSudoku(board));
	}
}