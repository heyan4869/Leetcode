package array;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerFast {
    public static int romanToInt(String s) {
    	Map<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        char prev = '#';
        for (int i = s.length() - 1; i >= 0; i--) {
            char letter = s.charAt(i);
            int value = roman.get(letter);
            if (value < result && letter != prev) {
                result = result - value;
            } else {
                result = result + value;
            }
            prev = letter;
        }
        return result;
    }
    
    public static void main(String args[]) {
    	String s = "MCCXXI";
    	int numerial = romanToInt(s);
    	System.out.println(numerial);
    }
}