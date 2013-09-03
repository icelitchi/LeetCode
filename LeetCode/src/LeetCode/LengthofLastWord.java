package LeetCode;

public class LengthofLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int lengthOfLastWord(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
	if(s==null||s.length()==0)
		return 0;
	int length=0;
	for(int i=s.length()-1;i>=0;i--){
		if(s.charAt(i)==' '){
			break;
		}
		length++;
	}
	return length;
}
}
