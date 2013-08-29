package LeetCodeDone;

public class LongestPalindromicSubstring {
	// 以第i个为中心的最大回文
	public String longestPalindrome(String s) {

		if (s == null || s.length() == 0)
			return null;
		int maxLength = 0;
		int start = 0, end = 0;
		int visit = 0;
		while (visit < s.length()) {

			int i = visit, j = visit;

			//先将子串两头的指针 向两端 移到 != s.charAt(visit)的 位置 
			while (i >= 0 && s.charAt(i) == s.charAt(visit))
				i--;
			while (j < s.length() && s.charAt(j) == s.charAt(visit))
				j++;
			//下一个中心点
			visit=j;
			
			while (j < s.length() && i >= 0 && s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			}
			j--;
			i++;
	
			if (maxLength < j - i + 1) {
				maxLength = j - i + 1;
				start = i;
				end = j;
			}
		}
		return s.substring(start, end + 1);
	}
	public static void main(String[] args){
		LongestPalindromicSubstring l=new LongestPalindromicSubstring();
		l.longestPalindrome("a");
	}
}
