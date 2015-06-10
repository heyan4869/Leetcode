// CC 1.6

package array;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
        	return;
        }
        for (int layer = 0; layer < n / 2; layer++) {
        	int first = layer;
        	int last = n - 1 - layer;
        	for (int i = first; i < last; ++i) {
        		int diff = i - first;
        		// save the top
        		int top = matrix[first][i];
        		
        		// left -> top
        		matrix[first][i] = matrix[last - diff][first];
        		
        		// bottom -> left
        		matrix[last - diff][first] = matrix[last][last - diff];
        		
        		// right -> bottom
        		matrix[last][last - diff] = matrix[i][last];
        		
        		// top -> right
        		matrix[i][last] = top;
        	}
        }
    }
}