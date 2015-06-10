package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
    	if (s.length() == 0) {
    		return true;
    	}
    	return assist(s, t) && assist(t, s);
    }
    
    public static boolean assist(String s, String t) {
    	Map<Character, Character> hm = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
        	if (hm.containsKey(s.charAt(i))) {
    			if (hm.get(s.charAt(i)) == t.charAt(i)) {
    				continue;
    			} else {
    				return false;
    			}
    		} else {
    			hm.put(s.charAt(i), t.charAt(i));
    		}
        }
        return true;
    }
    
    public static void main(String args[]) {
    	String s = "a";
    	String t = "a";
    	System.out.println(isIsomorphic(s, t) && isIsomorphic(t, s));
    }
}