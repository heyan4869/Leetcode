// first rectangle: (A, B), (C, D)
// second rectangle: (E, F), (G, H)

package math;

public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F,
			int G, int H) {
		// top left point for second rectangle is (E, H)
		// bottom right point for first rectangle is (C, B)

		int overlap;
		if (C <= E || A >= G || B >= H || D <= F) {
			overlap = 0;
		} else {
			int x = Math.min(C, G) - Math.max(A, E);
			int y = Math.min(D, H) - Math.max(B, F);
			overlap = x * y;
		}
		return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
	}

	public static void main(String args[]) {
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}
}