package LeetCode;
import java.util.ArrayList;

public class Palindrome {
	public int minCut(String s) {

		int length = s.length();
		return mincut(s, 0, length - 1);

	}

	public ArrayList<ArrayList<String>> partion(String s) {

		return partioning(s, 0);
	}

	private int mincut(String s, int start, int end) {
		if (isparlidrom(s, start, end))
			return 0;
		else {
			int cut = Integer.MAX_VALUE;
			int index = start;
			while (index < end) {
				int temp = mincut(s, start, index) + mincut(s, index + 1, end);
				if (temp < cut)
					cut = temp;
				index++;
			}
			return cut + 1;
		}
	}

	private ArrayList<ArrayList<String>> partioning(String s, int start) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start >= s.length()) {
			result.add(new ArrayList<String>());
			return result;
		}

		int p = start;
		int index = start;
		int length = s.length();
		char pc = s.charAt(p);
		index = s.indexOf(pc, p);
		while (index >= 0 && index < length) {
			if (isparlidrom(s, p, index)) {

				ArrayList<ArrayList<String>> subResult = partioning(s,
						index + 1);
				String parlidrom = s.substring(p, index + 1);
				for (ArrayList<String> sl : subResult) {
					sl.add(0, parlidrom);
				}
				result.addAll(subResult);
			}
			index = s.indexOf(pc, index + 1);
		}

		return result;
	}

	private boolean isparlidrom(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		String s1 = "a";
		p.partion(s1);
	}
}
