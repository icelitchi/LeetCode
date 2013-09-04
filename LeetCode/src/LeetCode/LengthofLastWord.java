package LeetCode;

public class LengthofLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public int lengthOfLastWord(String s) {

    if(s==null||s.length()==0)
		return 0;
	int length=0;
	int end=s.length()-1;
	while(end>=0&&s.charAt(end)==' ')
		end--;
	while(end>=0&&s.charAt(end)!=' '){
		length++;
        end--;
	}
    return length;
}
}
