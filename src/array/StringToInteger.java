//Implement atoi to convert a string to an integer.

package array;

public class StringToInteger {
    public static int atoi(String str) {
    	//check if str is null
    	if(str.equals(""))
    		return 0;
    	
    	int result;
    	
    	//check the whitespace
    	int leng = str.length();
    	int i=0;
    	int index = 0;
    	boolean bool = false;
    	while(!bool && i<leng) {
    		if(str.charAt(i)!=' ') {
    			index = i;
    			bool = true;
    		} else
    			i++;	
    	}
    	
    	//get rid of the whitespace
    	str = str.substring(index, leng);
    	leng = str.length();
    	
    	//check the additional characters
    	int j = 0;
    	int indexc = 0;
    	char c = ' ';
    	int x = 0;
    	boolean boolc = false;
    	c = str.charAt(0);
		x = c;
		//System.out.println(leng);
    	if(x==43 || x==45)
    		j = 1;
    	while(!boolc && j<leng) {
    		c = str.charAt(j);
    		//System.out.println(c);
    		x = c;
    		//System.out.println(x);
    		if(x<48 || x>57) {
    			indexc = j;
    			boolc = true;
    		} else {
    			//indexc = j;
    			j++;
    			
    		}
    	}
//    	System.out.println(" ");
//    	System.out.println(indexc);
//    	System.out.println(boolc);
    	
    	//check if the characters is the first one
    	if(indexc==0 && boolc)
    		return -1;
    	else if(indexc==0 && !boolc)
    		str = str;
    	else
    		str = str.substring(0, indexc);
    	
    	System.out.println(str);
    	//check if there is still characters
    	c = str.charAt(0);
		x = c;
    	if((x==43 || x== 45) && str.length()==1)
    		return 0;
    	for(int m=0; m<str.length(); m++) {
    		c = str.charAt(m);
    		x = c;
    		if(x<48 || x>57)
    			return 0;
    		else
    			continue;
    	}
    	
    	//check the string to integet number format
    	try {
        	result = Integer.parseInt(str);
        } catch (java.lang.NumberFormatException ex) {
            c = str.charAt(0);
    		x = c;
            if(x==45)
        	    return -2147483648;
        	else
        	    return 2147483647;
        }
        return result;
    }
    
    public static void main(String args[]) {
    	String str = "+-2";
    	int result = atoi(str);
    	//System.out.println(" ");
    	System.out.println(result);
    }
}