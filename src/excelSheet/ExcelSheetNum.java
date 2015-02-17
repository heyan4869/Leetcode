package excelSheet;

public class ExcelSheetNum {
    public int titleToNumber(String s) {
        int digit = s.length();
        int result = 0;
        for(int i = 0; i < digit; i++) {
            result = result * 26 + ((int)s.charAt(i) % 65 + 1);
        }
        return result;
    }
}