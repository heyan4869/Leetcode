//Returns the index of the first occurrence of needle in haystack,
//or -1 if needle is not part of haystack.

package array;

public class ImplementStr {
	public static int strStr(String haystack, String needle) {
    	if(haystack.equals("") && needle.equals(""))
            return 0;
        else if(haystack.equals("") && !needle.equals(""))
            return -1;
        else if(!haystack.equals("") && needle.equals(""))
            return 0;
        else {
            int leng = needle.length();
            for(int i=0; i<=haystack.length()-leng; i++) {
        	    if(needle.charAt(0)==haystack.charAt(i)) {
        	    	if(needle.equals(haystack.substring(i, i+leng)))
        		    	return i;
        	    	else
        		    	continue;
        	}
        }
     
        return -1;
        }
    }
    public static void main(String args[]) {
    	String haystack = "abc";
    	String needle = "bc";
    	int result = strStr(haystack, needle);
    	System.out.println(result);
    }
}