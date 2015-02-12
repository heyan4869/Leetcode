package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public class RepeatedDNA {
	
	// Submission Result: Memory Limit Exceeded
    public static List<String> findRepeatedDna(String s) {
    	List<String> result = new ArrayList<String>();
    	HashSet<String> dna = new HashSet<String>();
    	HashSet<String> unique = new HashSet<String>();
        int len = s.length();
        int count = len - 9;
        for (int i = 0; i < count; i++) {
        	String str = s.substring(i, i + 10);
        	if (!dna.contains(str)) {
        		dna.add(str);
        		
        	} else if (dna.contains(str) && !unique.contains(str)) {
        		result.add(str);
        		unique.add(str);
        	} else {
        		continue;
        	}
        }
    	
    	return result;
    }
    
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new ArrayList<String>();
    	HashMap<Integer, Boolean> dna = new HashMap<Integer, Boolean>();
    	int len = s.length();
        int count = len - 9;
        for (int index = 0; index < count; index++) {
        	int v = transfer(s, index);
        	if(!dna.containsKey(v))
                dna.put(v, false);
            else{
                if(dna.get(v) == false){
                    result.add(s.substring(index, index+10));
                    dna.put(v, true);
                }  
            }
        }
        
    	
    	return result;
    }
    
    public static int transfer(String s, int index) {
    	int v = 0;
		for(int i = index; i<index+10; i++){
            int vv = 0;
            if(s.charAt(i) == 'A') 
            	vv = 0;
            else if(s.charAt(i) == 'C') 
            	vv = 1;
            else if(s.charAt(i) == 'G') 
            	vv = 2;
            else 
            	vv = 3;
            v <<= 2;
            v |= vv;
        }
        return v;
				
	}

	public static void main(String args[]) {
    	String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	List<String> l = findRepeatedDnaSequences(s);
    	System.out.println(l.toString());
    }
}