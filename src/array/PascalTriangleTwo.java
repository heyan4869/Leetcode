package array;

import java.util.*;

public class PascalTriangleTwo {
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> tri = new ArrayList<Integer>(rowIndex+1);
    	for(int i=0; i<=rowIndex; i++) {
    		tri.add(0);
    	}
    	tri.set(0, 1);
    	for(int i=1; i<=rowIndex; i++) {
    		tri.set(i, 1);
    		for(int j=i-1; j>0; j--) {
    			tri.set(j, tri.get(j) + tri.get(j-1)); 
    		}
    	}
    	
    	return tri;
    	
    }
    
    public static void main(String args[]) {
    	int row = 3;
    	List<Integer> result = getRow(row);
    	System.out.println();
    }
}