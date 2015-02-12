package array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
    	
        if(s.equals(""))
        	return 0;
        //System.out.println(letter.length);
        int result = roman.get(s.charAt(0));
        //System.out.println(result);
        //int[] romanNum = new int[letter.length-1];
        for(int i=1; i<s.length(); i++) {
        	if(roman.get(s.charAt(i))<=roman.get(s.charAt(i-1))) {
        		result = result + roman.get(s.charAt(i));
        	} else {
        		result = result + roman.get(s.charAt(i)) - 2*roman.get(s.charAt(i-1));
        	}
        	
        	//System.out.print(romanNum[i-1]+" ");
        }
        return result;
        
    }
    
    public static void main(String args[]) {
    	String s = "MMCCXXI";
    	int numerial = romanToInt(s);
    	System.out.println(numerial);
    }
}