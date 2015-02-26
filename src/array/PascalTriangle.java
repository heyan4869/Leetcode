package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int n = 0; n < numRows; n++) {
			List<Integer> tri = new ArrayList<Integer>(n+1);
	    	for(int i=0; i<=n; i++) {
	    		tri.add(0);
	    	}
	    	tri.set(0, 1);
	    	
	    	// this is core
	    	for(int i=1; i<=n; i++) {
	    		tri.set(i, 1);
	    		for(int j=i-1; j>0; j--) {
	    			tri.set(j, tri.get(j) + tri.get(j-1)); 
	    		}
	    	}
	    	result.add(tri);
		}

		return result;
	}

	public static void main(String args[]) {
		int n = 5;
		List<List<Integer>> result = generate(n);
		System.out.println(result.get(4).get(2));
	}
}