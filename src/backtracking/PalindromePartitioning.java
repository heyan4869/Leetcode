// ***** think about this problem again*****

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> resultList;
	ArrayList<String> currList;
	
	public List<List<String>> partition(String s) {
        resultList = new ArrayList<List<String>>();
        currList = new ArrayList<String>();
        backTrack(s,0);
        return resultList;
    }
	
	private void backTrack(String s, int l) {
		if (currList.size() > 0 && l >= s.length()) {
			List<String> r = (ArrayList<String>) currList.clone();
			resultList.add(r);
		}
		for (int i = l; i < s.length(); i++) {
			if (isPalindrome(s, l, i)) {
				if (l == i) {
					currList.add(Character.toString(s.charAt(i)));
				} else {
					currList.add(s.substring(l, i + 1));
				}
				backTrack(s, i + 1);
				currList.remove(currList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str, int l, int r) {
		if (l == r) {
			return true;
		}
		while (l < r) {
			if(str.charAt(l)!=str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}