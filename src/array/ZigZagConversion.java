package array;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
    	if(nRows == 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int step = 2*nRows - 2;
        for(int i=0; i<nRows; i++) {
            if(i==0 || i==nRows-1) {
                for(int j=i; j<s.length(); j=j + step) {
                    sb.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2*(nRows - 1 - i);
                int step2 = step - step1;
                while(j < s.length()) {
                    sb.append(s.charAt(j));
                    if(flag)
                        j = j + step1;
                    else
                        j = j + step2;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }

}