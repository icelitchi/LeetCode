package LeetCode;

import java.util.regex.Pattern;

public class ValidNumber {

	public static void main(String[] args) {
		ValidNumber vn=new ValidNumber();
		System.out.println(vn.isNumber("234"));
	}
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	String regex1="^*$";
    	String regex="^(-?//d+)|(//d+(e|E)//d+)|((0x)|(0X)//d+)|(-?/d+//.//d+)$";
        Pattern p=Pattern.compile(regex1);
        return p.matcher(s).matches();
    }

}
