package excelSheet;

public class ExcelSheetTitle {
    public static void convertToTitle(int n) {
        int num = 10;
        System.out.println(num);
        char[] chartitle = new char[num];
        StringBuilder sb = new StringBuilder();
        for(int i=num-1; i>=0; i--) {
        	//Operator % calculate remainder with range of (0~25),
        	//thus need to -1 every time
        	n--;
        	chartitle[i] = (char) (n%26+'A');
        	sb.insert(0, chartitle[i]);
            n = n/26;
            if(n==0)
            	break;
        }
        System.out.println(n);
        String title = sb.toString();
        System.out.println(title);
    }
    
    public static void main(String args[]) {
    	int n = 29;
    	convertToTitle(n);
    }
}