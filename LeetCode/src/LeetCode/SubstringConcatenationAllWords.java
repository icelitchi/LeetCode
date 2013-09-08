package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringConcatenationAllWords {

	public static void main(String[] args) {

		// String S="barfoothefoobarman";
		// String[] L= {"foo","bar"};
		//String S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		//String[] L = { "fooo", "barr", "wing", "ding", "wing" };
	
		String S="abababa";
		String[] L= {"a","b"};
		SubstringConcatenationAllWords test = new SubstringConcatenationAllWords();
		test.findSubstring(S, L);
	}

	// 暴力解法//超时
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		// boolean[] c=new boolean[L.length];
		int wordlength = L[0].length();

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < S.length() - L.length * wordlength + 1; i++) {

			if (res.contains(new Integer(i - wordlength))) {
				if (S.substring(i - wordlength, i).equals(
						S.substring(i + L.length * wordlength-wordlength, i + L.length * wordlength))) {
					res.add(i);
				}
			} else if (isValid(S.substring(i, i + L.length * wordlength), L)) {

				res.add(i);
			}

		}

		return res;
	}

	//优化
	// 暴力解法//超时
		public ArrayList<Integer> _findSubstring(String S, String[] L) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			// boolean[] c=new boolean[L.length];
			int wordlength = L[0].length();

			Map<String, Boolean> map = new HashMap<String, Boolean>();
			for(int k=0;k<wordlength;k++){
				for (int i = k; i < S.length() - L.length * wordlength + 1; i+=wordlength) {
					if (res.contains(new Integer(i - wordlength))) {
					if (S.substring(i - wordlength, i).equals(
							S.substring(i + L.length * wordlength-wordlength, i + L.length * wordlength))) {
						res.add(i);
					}
				} else if (isValid(S.substring(i, i + L.length * wordlength), L)) {

					res.add(i);
				}

			}
			}

			return res;
		}

	boolean isValid(String sub, String[] L) {
		int count = 0;
		int wordlength = L[0].length();
		// L中的元素有重复
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			Integer n = map.get(L[i]);
			if (null == n) {
				map.put(L[i], 1);
			} else {
				map.put(L[i], 1 + n);
			}
		}
		for (int i = 0; i < sub.length(); i += wordlength) {
			Integer b = map.get(sub.substring(i, i + wordlength));
			if (b == null || b == 0)
				return false;
			else {
				map.put(sub.substring(i, i + wordlength), b - 1);
				count++;
			}
		}
		return count == L.length;
	}

}
