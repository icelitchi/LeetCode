package LeetCode;

//字符串穿插组成
public class InterleavingString {

	public static void main(String[] args) {

	}

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length())
			return false;
		
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if(l1==0)
			return s2.equals(s3);
		if(l2==0)
			return s1.equals(s3);
		boolean[][] match = new boolean[l1 + 1][l2 + 1];
		match[0][0] = true;
		for (int i = 1; i <= l1; i++) {
			match[i][0] = match[i - 1][0]&& (s1.charAt(i - 1) == s3.charAt(i - 1));
		}
		for (int j = 1; j <= l2; j++) {
			match[0][j] = match[0][j - 1]&& (s2.charAt(j - 1) == s3.charAt(j - 1));
		}
		for (int i = 1; i <= l1; i++) {
				for(int j = 1; j <= l2; j++){
					if(match[i-1][j]==true&&(s1.charAt(i-1)==s3.charAt(i+j-1))){
						match[i][j]=true;
					}else if(match[i][j-1]==true&&(s2.charAt(j-1)==s3.charAt(i+j-1))){
						match[i][j]=true;
					}else{
						match[i][j]=false;
					}
				}
		}
		return match[l1][l2];
	}
}
