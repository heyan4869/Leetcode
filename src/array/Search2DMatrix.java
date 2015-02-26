package array;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int column = matrix[0].length;
		if (row == 1) {
			if (biSearch(matrix[0], target, 0, column - 1) == -1)
				return false;
			else
				return true;
		}
		
		if (column == 1) {
			if (findSingleLevel(matrix, target, 0, row - 1) == -1)
				return false;
			else
				return true;
		}
			
		int level = findLevel(matrix, target, 0, row - 1);
		System.out.println(level);
    	if (level == -1)
    		return false;
    	else {
    		if (biSearch(matrix[level], target, 0, column - 1) == -1)
    			return false;
    		else
    			return true;
    	}
    }
    
    public static int findSingleLevel(int[][] matrix, int target, int first, int last) {
		if (first > last)
			return -1;
		int midLevel = (first + last) / 2;
		if (target == matrix[midLevel][0])
			return midLevel;
		if (target < matrix[midLevel][0])
			return findSingleLevel(matrix, target, first, midLevel - 1);
		if (target > matrix[midLevel][0])
			return findSingleLevel(matrix, target, midLevel + 1, last);
		return -1;
	}

	public static int findLevel(int[][] matrix, int target, int first, int last) {
    	if (first > last)
    		return -1;
    	int column = matrix[0].length;
		int midLevel = (first + last) / 2;
		if (matrix[midLevel][0] <= target && matrix[midLevel][column - 1] >= target)
			return midLevel;
		// be careful about this, have to compare within the midLevel
		if (matrix[midLevel][0] > target)
			return findLevel(matrix, target, first, midLevel - 1);
		if (matrix[midLevel][column - 1] < target)
			return findLevel(matrix, target, midLevel + 1, last);
		return -1;
	}
    
    public static int biSearch(int[] array, int target, int left, int right) {
		 if(left > right)
			 return -1;
		 else {
			 int mid = left + (right - left) / 2;
			 if(array[mid] < target)
				 return biSearch(array, target, mid + 1, right);
			 if(array[mid] > target)
				 return biSearch(array, target, left, mid - 1);
			 else
				 return mid;
       }
    }

	public static void main(String args[]) {
    	int[][] matrix = new int[2][2];
    	matrix[0][0] = 1;
    	matrix[0][1] = 1;
//    	matrix[0][2] = 5;
//    	matrix[0][3] = 7;
    	matrix[1][0] = 2;
    	matrix[1][1] = 2;
//    	matrix[1][2] = 16;
//    	matrix[1][3] = 20;
//    	matrix[2][0] = 23;
//    	matrix[2][1] = 30;
//    	matrix[2][2] = 34;
//    	matrix[2][3] = 50;
    	System.out.println(searchMatrix(matrix, 10));
    }
}