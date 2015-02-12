package tree;

public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
    	TreeNode head = builder(num, 0, num.length - 1);
        return head;
        
    }

	public TreeNode builder(int[] num, int lowerBound, int higherBound) {
		if (lowerBound > higherBound)
			return null;
		int middle = (lowerBound + higherBound) / 2;
		TreeNode curr = new TreeNode(num[middle]);
		curr.left = builder(num, lowerBound, middle - 1);
		curr.right = builder(num, middle + 1, higherBound);
		return curr;
	}
}