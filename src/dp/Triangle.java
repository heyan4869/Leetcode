// Given a triangle, find the minimum path sum from top to bottom. 
// Each step you may move to adjacent numbers on the row below.

package dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int level = triangle.size();
		if (level == 0) {
			return 0;
		}
		if (level == 1) {
			return triangle.get(0).get(0);
		}
		List<List<Integer>> map = triangle;
		int res = Integer.MAX_VALUE;
		return assist(map, triangle, res);
	}

	private static int assist(List<List<Integer>> map,
			List<List<Integer>> triangle, int res) {
		for (int currlevel = 1; currlevel < triangle.size(); currlevel++) {
			map.get(currlevel).set(
					0,
					triangle.get(currlevel - 1).get(0)
							+ triangle.get(currlevel).get(0));
			if (currlevel == triangle.size() - 1) {
				res = Math.min(res, map.get(currlevel).get(0));
			}

			map.get(currlevel).set(
					map.get(currlevel).size() - 1,
					triangle.get(currlevel - 1).get(
							triangle.get(currlevel - 1).size() - 1)
							+ triangle.get(currlevel).get(
									triangle.get(currlevel).size() - 1));
			if (currlevel == triangle.size() - 1) {
				res = Math.min(
						res,
						map.get(currlevel).get(
								triangle.get(currlevel).size() - 1));
			}
		}
		for (int level = 2; level < triangle.size(); level++) {
			for (int index = 1; index < triangle.get(level).size() - 1; index++) {
				int ele = Math.min(
						triangle.get(level).get(index)
								+ map.get(level - 1).get(index - 1), triangle
								.get(level).get(index)
								+ map.get(level - 1).get(index));
				map.get(level).set(index, ele);
				if (level == triangle.size() - 1) {
					res = Math.min(res, ele);
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {
		List<Integer> top = new ArrayList<Integer>(1);
		top.add(-1);
		List<Integer> two = new ArrayList<Integer>(2);
		two.add(-2);
		two.add(-3);
		// List<Integer> tri = new ArrayList<Integer>(3);
		// tri.add(6);
		// tri.add(5);
		// tri.add(7);
		// List<Integer> four = new ArrayList<Integer>(2);
		// four.add(4);
		// four.add(1);
		// four.add(8);
		// four.add(3);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(top);
		triangle.add(two);
		// triangle.add(tri);
		// triangle.add(four);
		System.out.println(minimumTotal(triangle));
	}
}