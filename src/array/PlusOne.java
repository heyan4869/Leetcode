package array;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
        int leng = digits.length;
        
        //if the last digit is not 9, then just plus 1
        if(digits[leng-1] != 9) {
        	int[] result = new int[digits.length];
        	for (int i=0;i<leng;i++) {
        		result[i] = digits[i];
        	}
        	
        	result[leng-1]++;
        	return result;
        }
		
        //if the last digit is 9, then we need to deal with more
        int decimal = 0;
        int count = 0;
        for(int i=leng-1; i>=0; i--) {
        	decimal = (int) (decimal + digits[i]*Math.pow(10, count));
        	count++;
        }
        decimal++;
        String str = decimal + "";
        String[] digitstr = str.split("");
        int[] newdigits = new int[digitstr.length-1];
        for(int j=1; j<digitstr.length; j++) {
        	newdigits[j-1] = Integer.parseInt(digitstr[j]);
        }
        int[] result = new int[digitstr.length-1];
        for(int k=0; k< digitstr.length-1; k++) {
        	result[k] = newdigits[k];
        }
        return result;
    }
	
	public static void main(String args[]) {
//		int[] plus = new int[1];
//		plus[0] = 9;
		int [] plus ={1, 9, 9};
		//plus[1] = 9;
		//plus[2] = 9;
		
		int[] result = plusOne(plus);
		for(int m=0; m<result.length; m++) {
        	System.out.print(result[m]);
        }
	}
}