//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid.

//The brackets must close in the correct order, "()" and "()[]{}" are all valid
//but "(]" and "([)]" are not.


package array;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
    	if(s==null)
    		return true;
    	if(!check(s.charAt(0))) {
    		return false;
    	}
    	Stack<Character> st = new Stack<Character>();
    	for(int i=0; i<s.length(); i++) {
    		if(check(s.charAt(i))) {
    			st.push(s.charAt(i));
    		} else {
    			if(!st.empty()) {
    				if(compare(st.peek(), s.charAt(i)))
        				st.pop();
        			else
        				return false;
    			} else
    				return false;
    		}
    	}
    	
    	if(st.empty())
    		return true;
    	else
    		return false;
    }
    
    public static boolean check(char c) {
    	if(c=='{' || c=='[' || c=='(')
    		return true;
    	else
    		return false;
    }
    
    public static boolean compare(char s, char c) {
    	if((s=='{' && c=='}') || (s=='[' && c==']') || (s=='(' && c==')'))
    		return true;
    	else
    		return false;
    }
    
    public static void main(String args[]) {
    	String str = "[])";
    	boolean check = isValid(str);
    	System.out.println(check);
    }
}