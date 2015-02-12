//Given two binary strings, return their sum (also a binary string).

//This solution could not deal with large number

package array;

public class AddBinary {
    public static String addBinary(String a, String b) {
        //int m = Integer.parseInt(a.charAt(0)+"");
        //System.out.println(m);
    	if(a.equals("") && b.equals(""))
    		return "";
    	int deca = Integer.parseInt(a, 2);
    	int decb = Integer.parseInt(b, 2);
    	String sum = convertBinary(deca + decb);
    	
    	return sum;
    }
    
    public static String convertBinary(int n) {
    	if (n == 0) {
            return "0";
        }
        String binary = "";
        while (n > 0) {
            int rem = n % 2;
            binary = rem + binary;
            n = n / 2;
        }
        return binary;
    }
    
    public static void main(String args[]) {
    	String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
    	String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
    	String total = addBinary(a, b);
    	System.out.println(total);
    }
}