/*
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

package string;

import java.util.Stack;

public class ReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		if (tokens.length == 1)
			return Integer.parseInt(tokens[0]);
		Stack<String> sint = new Stack<String>();
		// Stack<String> sop = new Stack<String>();
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < tokens.length; i++) {
			if (!tokens[i].equals("+") && !tokens[i].equals("-")
					&& !tokens[i].equals("*") && !tokens[i].equals("/")) {
				sint.add(tokens[i]);
			} else {
				int next = Integer.parseInt(sint.pop());
				result = Integer.parseInt(sint.pop());
				if (tokens[i].equals("+")) {
					result = result + next;
					sint.push(Integer.toString(result));

				} else if (tokens[i].equals("-")) {
					result = result - next;
					sint.push(Integer.toString(result));
				} else if (tokens[i].equals("*")) {
					result = result * next;
					sint.push(Integer.toString(result));
				} else {
					result = result / next;
					sint.push(Integer.toString(result));
				}
			}
		}

		return result;
	}

//	public static int evalRPNold(String[] tokens) {
//		if (tokens.length == 0)
//			return 0;
//		Stack<String> sint = new Stack<String>();
//		Stack<String> sop = new Stack<String>();
//		for (int i = tokens.length - 1; i >= 0; i--) {
//			if (tokens[i].equals("+") || tokens[i].equals("-")
//					|| tokens[i].equals("*") || tokens[i].equals("/")) {
//				sop.add(tokens[i]);
//			} else {
//				sint.add(tokens[i]);
//			}
//		}
//
//		// System.out.println(sint.size());
//		// System.out.println(sop.size());
//
//		int result = Integer.MAX_VALUE;
//		while (!sint.isEmpty() || !sop.isEmpty()) {
//			result = Integer.parseInt(sint.pop());
//			// System.out.println("+++" + result + "+++");
//			if (!sint.isEmpty()) {
//				int next = Integer.parseInt(sint.pop());
//				// System.out.println("---" + next + "---");
//				String oper = sop.pop();
//				if (oper.equals("+")) {
//					result = result + next;
//					sint.push(Integer.toString(result));
//
//				} else if (oper.equals("-")) {
//					result = result - next;
//					sint.push(Integer.toString(result));
//				} else if (oper.equals("*")) {
//					result = result * next;
//					sint.push(Integer.toString(result));
//				} else {
//					result = result / next;
//					sint.push(Integer.toString(result));
//				}
//			} else {
//				break;
//			}
//		}
//
//		return result;
//	}

	public static void main(String args[]) {
		String[] s = new String[3];
		s[0] = "4";
		s[1] = "13";
		s[2] = "+";
		//s[3] = "/";
		//s[4] = "+";
		System.out.println(evalRPN(s));
	}
}