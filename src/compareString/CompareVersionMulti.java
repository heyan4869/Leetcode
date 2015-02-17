package compareString;

public class CompareVersionMulti {
	public static int compareVersion(String version1, String version2) {
		String[] sa = version1.split("\\.");
		String[] sb = version2.split("\\.");
		int[] va = new int[sa.length];
		int[] vb = new int[sb.length];
		
		for(int i=0; i<sa.length; i++) {
			va[i] = Integer.parseInt(sa[i]);
		}
		for(int i=0; i<sb.length; i++) {
			vb[i] = Integer.parseInt(sb[i]);
		}
		
		//System.out.println(sb[1]);
		
		int compare = 0;
		int leng = 0;
		if(sa.length == sb.length) {
			compare = 0;
			leng = sa.length;
		} else if(sa.length > sb.length) {
			compare = 1;
			leng = sb.length;
		} else {
			compare = -1;
			leng = sa.length;
		}
		
		for(int j=0; j<leng; j++) {
			if(va[j]<vb[j])
				return -1;
			else if(va[j]>vb[j])
				return 1;
		}
		
		int longer = 0;
		if(compare == -1) {
			for(int k=leng; k<sb.length; k++){
				longer = longer + vb[k];
			}
			if(longer == 0)
				return 0;
			else 
				return -1;
		} else if(compare == 1) {
			for(int k=leng; k<sa.length; k++){
				longer = longer + va[k];
			}
			if(longer == 0)
				return 0;
			else 
				return 1;
		}
		else
			return 0;
	}
	
	public static void main(String args[]) {
    	String a = "1.1";
    	String b = "1.1.0";
    	
    	int result = compareVersion(a, b);
    	System.out.println(result);
    }
}