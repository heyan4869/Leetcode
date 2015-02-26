package string;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
    	if (strs.length == 0)
    		return "";
    	if (strs.length == 1)
    		return strs[0];
    	int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
        	if (strs[i].length() < minLen)
        		minLen = strs[i].length();
        	else
        		continue;
        }
        //System.out.println(minLen);
        //StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < minLen) {
        	char curr = strs[0].charAt(index);
        	//System.out.println(curr);
        	for (int i = 1; i < strs.length; i++) {
        		if (strs[i].charAt(index) == curr) {
        			//System.out.println("in");
        			continue;
        		} else {
        			//System.out.println("in");
        			if (index == 0)
        				return "";
        			else
        				return strs[0].substring(0, index);
        		}
        	}
        	index++;
        }
    	
    	return strs[0].substring(0, index);
    }
    
    public static void main(String args[]) {
    	String[] strs = new String[3];
    	strs[0] = "a";
    	strs[1] = "a";
    	strs[2] = "b";
    	//System.out.println(strs[0].substring(0, 0));
    	System.out.println(longestCommonPrefix(strs));
    }
}