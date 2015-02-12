package array;

public class RotatedMinimum {
    public static int findMin(int[] num) {
    	if(num == null || num.length==0)
            return 0;
    	int start = 0;
    	int end = num.length-1;
    	int mid;
    	while(start<end){
    		mid = (start+end)/2;
    		if(num[mid]>=num[start] && num[start] > num[end])
    			start = mid + 1;
    		else 
    			end = mid;
    	}
    	return num[start];
    	
    }
    
    public static void main(String args[]) {
    	int[] anArray = new int[10];
        anArray[0] = 3;
        anArray[1] = 4;
        anArray[2] = 5;
        anArray[3] = 6;
        anArray[4] = 7;
        anArray[5] = 1;
        anArray[6] = 2;
    	System.out.println(findMin(anArray));
    }
}