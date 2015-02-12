package array;

public class AddBinaryNew {
    public static String addBinary(String a, String b) {
        //int m = Integer.parseInt(a.charAt(0)+"");
        //System.out.println(m);
    	int enda = a.length()-1;
    	int endb = b.length()-1;
    	String check[] = new String[2];
		check[0] = "0";
		check[1] = "0";
    	StringBuilder sb = new StringBuilder();
    	while(enda>=0 && endb>=0) {
    		check = addIndex(check, a.charAt(enda), b.charAt(endb));
    		sb.insert(0, check[1]);
    		enda--;
    		endb--;
    	}
    	if(a.length()>b.length()) {
    		int extra = a.length()-b.length()-1;
    		while(extra>=0) {
    			check = addIndex(check, a.charAt(extra), '0');
    			sb.insert(0, check[1]);
    			extra--;
    		}
    		if(check[0]=="1")
    			sb.insert(0, check[0]);
    	} else if(a.length()<b.length()) {
    		int extrb = b.length()-a.length()-1;
    		while(extrb>=0) {
    			check = addIndex(check, '0', b.charAt(extrb));
    			sb.insert(0, check[1]);
    			extrb--;
    		}
    		if(check[0]=="1")
    			sb.insert(0, check[0]);
    	} else {
    		if(check[0]=="1")
    			sb.insert(0, check[0]);
    	}
    	
        return sb.toString();
    }
    
    public static String[] addIndex(String[] result, char m, char n) {
    	if(result[0]=="0") {
    		if(m=='0' && n=='0') {
        		result[0] = "0";
        		result[1] = "0";
        		return result;
        	} else if(m=='0' && n=='1'){
        		result[0] = "0";
        		result[1] = "1";
        		return result;
        	} else if(m=='1' && n=='0') {
        		result[0] = "0";
        		result[1] = "1";
        		return result;
        	} else {
        		result[0] = "1";
        		result[1] = "0";
        		return result;
        	}
    	} else {
    		if(m=='0' && n=='0') {
        		result[0] = "0";
        		result[1] = "1";
        		return result;
        	} else if(m=='0' && n=='1'){
        		result[0] = "1";
        		result[1] = "0";
        		return result;
        	} else if(m=='1' && n=='0') {
        		result[0] = "1";
        		result[1] = "0";
        		return result;
        	} else {
        		result[0] = "1";
        		result[1] = "1";
        		return result;
        	}
    	}
    		
    }
    
    public static void main(String args[]) {
    	String a = "1100";
    	String b = "10000";
    	String total = addBinary(a, b);
    	System.out.println(total);
    }
}