package binarySearch;

public class PowN {
	public double myPow(double x, int n) {
		if (n > 0)
			return myPowInner(x, n);
		else
			return 1.0 / myPowInner(x, -n);
	}

	public double myPowInner(double x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		double inter = myPowInner(x, n / 2);
		if (n % 2 == 1)
			return inter * inter * x;
		else
			return inter * inter;
	}
}