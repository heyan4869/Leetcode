//Given a string, determine if it is a palindrome, 
//considering only alphanumeric characters and ignoring cases.

package array;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s == "")
        	return true;
        int leng = s.length();
        int start = 0;
        int end = leng-1;
        String first = "";
        String last = "";
        while(start<leng/2) {
        	if(check(s.charAt(start))==0) {
        		start++;
        		continue;
        	}
        	if(check(s.charAt(end))==0) {
        		end--;
        		continue;
        	}
        	if(check(s.charAt(start))==1 && check(s.charAt(end))==1) {
        		first = s.charAt(start)+"";
        		last = s.charAt(end)+"";
        		if(first.toLowerCase().equals(last.toLowerCase())) {
        			start++;
        			end--;
        		} else
        			return false;
        	} else if(check(s.charAt(start)) == -1 && check(s.charAt(end)) == -1) {
        		if(s.charAt(start) == s.charAt(end)) {
        			start++;
        			end--;
        		} else
        			return false;
        	} else
        		return false;
        }
    	
    	
    	return true;
    }
    
    public static int check(char c) {
    	int ascii = c;
    	if((ascii>=65 && ascii<=90) ||(ascii>=97 && ascii<=122))
    		return 1;
    	else if(ascii>=48 && ascii<=57)
    		return -1;
    	else
    		return 0;  	
    }
    
    public static void main(String args[]) {
    	String s = "race a car";
    	boolean bool = isPalindrome(s);
    	System.out.println(bool);
    }
}