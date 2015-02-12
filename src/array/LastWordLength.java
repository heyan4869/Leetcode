package array;

public class LastWordLength {
    public static int lengthOfLastWord(String s) {
    	int start = -1;
    	int end = -1;
    	for(int i=s.length()-1; i>=0; i--) {
    		if(s.charAt(i) != ' ') {
    			end = i;
    			break;
    		}
    	}
    	if(end == -1)
    	    return 0;
        else if(end == 0)
            return 1;
    	for(int j=end-1; j>=0; j--) {
    		if(s.charAt(j) == ' ') {
    			start = j;
    			break;
    		}
    	}
    	//System.out.println(end);
    	//System.out.println(start);
    	return end-start;
    }
    
    public static void main(String args[]) {
    	String s = "    day";
    	int length = lengthOfLastWord(s);
    	System.out.print(length);
    }
}