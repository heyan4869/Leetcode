package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {	
	public static List<Integer> graycode(int n) {
		List<Integer> gc = new ArrayList<Integer>();
		gc.add(0);
		for (int num = 0; num < n; num++) {
			for (int ref = gc.size() - 1; ref >= 0; ref--) {
				gc.add(1 << num | gc.get(ref));
			}
		}
		return gc;
	}

	public static void main(String args[]) {
		List<Integer> gc = graycode(2);
		for (int i = 0; i < gc.size(); i++) {
			System.out.println(gc.get(i));
		}
	}
}