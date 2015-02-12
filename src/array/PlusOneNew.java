package array;

public class PlusOneNew {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return digits;
        }

        int leng = digits.length - 1;
        int carry = 1;

        boolean everydigit = true;
        for (int j = 0; j <= leng; j++) {
        	if(digits[j]!=9)
        		everydigit = false;
        }
        if (everydigit == true) {
        	int[] result = new int[digits.length + 1];
            result[0] = 1;  
            return result;
        }
        

        for (int i = leng; i >= 0; i--) {
            if(digits[i] == 9){
                digits[i]= 0;
            }
            else if(digits[i] != 9){
                digits[i] = digits[i] + carry;
                return digits;
            }
        }
        return digits;
        }
}