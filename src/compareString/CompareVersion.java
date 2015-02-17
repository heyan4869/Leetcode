//This program is based on the misunderstanding of the problem
//I just considered the version string with only one "."
//Obviously this is not right

package compareString;

public class CompareVersion {
	public static int compare(String a, String b) {
		String[] sa = a.split("");
    	String[] sb = b.split("");
    	int afh = -1;
    	int bfh = -1;
    	int ash = -1;
    	int bsh = -1;
    	
    	//System.out.println(sa.length);
    	//System.out.println(sa[2]);
    	StringBuilder aFirstHalf = new StringBuilder();
    	StringBuilder aSecondHalf = new StringBuilder();
    	for(int i=0; i<sa.length; i++) {
    		if(sa[i].equals(".")){
    			for(int j=1; j<i; j++) {
    	    		aFirstHalf.append(sa[j]);
    	    	}
    			afh = Integer.parseInt(aFirstHalf.toString());
    			for(int k=i+1; k<sa.length; k++) {
    				aSecondHalf.append(sa[k]);
    			}
    			ash = Integer.parseInt(aSecondHalf.toString());
    		}
    	}
    	
    	StringBuilder bFirstHalf = new StringBuilder();
    	StringBuilder bSecondHalf = new StringBuilder();
    	for(int i=0; i<sb.length; i++) {
    		if(sb[i].equals(".")){
    			for(int j=1; j<i; j++) {
    	    		bFirstHalf.append(sb[j]);
    	    	}
    			bfh = Integer.parseInt(bFirstHalf.toString());
    			for(int k=i+1; k<sb.length; k++) {
    				bSecondHalf.append(sb[k]);
    			}
    			bsh = Integer.parseInt(bSecondHalf.toString());
    		}
    	}
    	
    	if(afh > bfh)
    		return 1;
    	else if(afh < bfh)
    		return -1;
    	else {
    		if(ash > bsh)
    			return 1;
    		else if(ash < bsh)
    			return -1;
    		else
    			return 0;
    	}
    	
    	
	}
	
    public static void main(String args[]) {
    	String a = "1.0";
    	String b = "1.1";
    	
    	int result = compare(a, b);
    	System.out.println(result);
    }
}