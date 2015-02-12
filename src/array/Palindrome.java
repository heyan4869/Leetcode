package array;

public class Palindrome {
    public static boolean isPalindrome(int x) {
    	if(x < 0) 
            return false;
        int divisor = 1;
        while(x/divisor >= 10)
            divisor *= 10;
        while(divisor >= 10 && (x / divisor == x % 10)){
            x = (x % divisor)/10;
            divisor /= 100;
        }
        return divisor >= 10 ? false : true;
    	
    }
    
    public static void main(String args[]) {
    	int x = 12345321;
    	boolean bool = isPalindrome(x);
    	System.out.println(bool);
    }
}