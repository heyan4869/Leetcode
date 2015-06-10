package string;

public class GenerateZeroOne {
	public static String generate(String str, int m, int n, int num0, int num1) {
		if (num0 == 2 || num1 == 3) {
			return "";
		}
		if (m == 0 && n == 0) {
			return str;
		}
		if (m > 0 && n == 0) {
			return generate(str + "0", m - 1, n, num0 + 1, num1);
		}
		if (n > 0 && m == 0) {
			return generate(str + "1", m, n - 1, num0, num1 + 1);
		}
		if (m > 0 && n > 0) {
			if (num0 == 0 && num1 == 0) {
				return generate(str + "0", m - 1, n, 1, 0)
						+ generate(str + "1", m, n - 1, 0, 1);
			}
			if (num0 == 1 && num1 == 0) {
				return generate(str + "1", m, n - 1, 0, 1);
			}
			if (num0 == 0 && num1 == 1) {
				return generate(str + "0", m - 1, n, 1, 0)
						+ generate(str + "1", m, n - 1, 0, num1 + 1);
			}
			if (num0 == 0 && num1 == 2) {
				return generate(str + "0", m - 1, n, 1, 0);
			}
		}
		return null;
	}

	public static void main(String args[]) {
		System.out.println(generate("", 5, 5, 0, 0));
	}
}