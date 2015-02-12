//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//
//Note: The sequence of integers will be represented as a string.


package array;

public class CountAndSay {
    public static String countAndSay(int n) {
        if(n==1)
        	return "1";
        String s = "1";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int round = 0;
        int i;
        
        while(++round<n) {
        	count = 1;
        	sb.setLength(0);
        	for(i=1; i<s.length(); i++) {
        		if(s.charAt(i)==s.charAt(i-1)) {
        			count++;
        		} else {
        			sb.append(count).append(s.charAt(i-1));
        			count = 1;
        		}
        	}
        	sb.append(count).append(s.charAt(i-1));
        	s = sb.toString();
        }
        return sb.toString();

    }
    
    public static void main(String args[]) {
    	int n = 5;
    	String seq = countAndSay(n);
    	System.out.println(seq);
    }
}