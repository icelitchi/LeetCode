package LeetCode;

import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber vn=new ValidNumber();
		System.out.println(vn._isNumber("0.1"));
	}
	 public boolean isNumber(String s) {  
	        // Start typing your Java solution below  
	        // DO NOT write main() function  
	        s = s.toLowerCase();  
	        try {  
	            Double.parseDouble(s);  
	        }  
	        catch (Exception e) {  
	            return false;  
	        }          
	        return s.charAt(s.length() -1) != 'f' && s.charAt(s.length() - 1) != 'd';  
	    }  
	 //正则表达式法//通过
    public boolean _isNumber(String s) {

    	String regex="^(-|\\+)?((\\d+(\\.\\d*)?)|(\\d*(\\.\\d+)))((e|E)(-|\\+)?\\d+)?$";
        Pattern p=Pattern.compile(regex);
        return p.matcher(s.trim()).matches();
    }

}
