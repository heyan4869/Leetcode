//	try {

//	} catch (ExceptionType name) {

//	} catch (ExceptionType name) {

//	}


package array;

public class ReverseInteger {
    public static int reverse(int x) {
    	boolean negative = false;
    	if(x<0) {
            x = Math.abs(x);
            negative = true;
        }
        String str = x + "";
        //System.out.println(str);
        StringBuilder sb = new StringBuilder();
        int leng = str.length()-1;
        for(int i=leng; i>=0; i--) {
        	sb.append(str.charAt(i));
        }
        str = sb.toString();
        System.out.println(str);
        int rev;
        try{
        	rev = Integer.parseInt(str, 10);
        }catch (java.lang.NumberFormatException ex) {
        	return 0;
        }
        if(negative)
        	rev = 0 - rev;
    	
    	return rev;
    }
    
    public static void main(String args[]) {
    	int x = 1534236469;
    	int rev = reverse(x);
    	System.out.println(rev);
    }
}