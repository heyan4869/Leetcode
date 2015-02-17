package string;

public class ReverseWordsInString {
	public static String reverseWord(String s) {
		if (s.equals(""))
			return "";
		String[] s1 = s.split(" ");
		// System.out.println(s1[3]);
		String temp = "";

		String[] cut = new String[s1.length];
		int count = 0;
		for (int i = 0; i < s1.length; i++) {
			if (!s1[i].equals("")) {
				cut[i - count] = s1[i];
			} else {
				count++;
			}
		}
//		System.out.println(cut.length);
//		for (int i = 0; i < cut.length; i++) {
//			System.out.print("-*" + cut[i] + "*-");
//		}
//		System.out.println("");


		String[] reduce = new String[cut.length - count];
		for (int i = 0; i < reduce.length; i++) {
			reduce[i] = cut[i];
		}

//		System.out.println(reduce.length);
//		for (int i = 0; i < reduce.length; i++) {
//			System.out.print("-*" + reduce[i] + "*-");
//		}
//		System.out.println("");

		for (int i = 0; i < reduce.length / 2; i++) {
			temp = reduce[i];
			reduce[i] = reduce[reduce.length - 1 - i];
			reduce[reduce.length - 1 - i] = temp;
		}
		
//		System.out.println(reduce.length);
//		for (int i = 0; i < reduce.length; i++) {
//			System.out.print("-*" + reduce[i] + "*-");
//		}
//		System.out.println("");

		// System.out.println(cut.length);
		if (reduce.length > 1) {
			String result = reduce[0];
			for (int j = 1; j < reduce.length; j++) {
				result = result + " " + reduce[j];
			}
			return result;
		} else if (reduce.length == 1) {
			return reduce[0];
		} else
			return "";
	}

	public static void main(String args[]) {
		String s = "  b     a   ";
		System.out.println("***" + reverseWord(s) + "***");

	}

}