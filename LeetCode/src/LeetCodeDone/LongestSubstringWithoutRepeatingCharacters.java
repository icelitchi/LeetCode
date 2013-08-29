package LeetCodeDone;

public class LongestSubstringWithoutRepeatingCharacters {

	// 动态规划
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;

		// 用来记录26个字母,最近在s中出现的位子
		int[] aph = new int[26];

		for (int i = 0; i < 26; i++) {
			aph[i] = -1;
		}
		int max = 0;
		// 到当前位置，无重复字符子串的启示位置subStart
		int subStart = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int lastAppare = aph[c - 'a'];
			if (lastAppare < subStart) {
				if (max < (i - subStart + 1)) {
					max = i - subStart + 1;
				}
			} else {
				subStart = lastAppare + 1;
			}

			aph[c - 'a'] = i;
		}

		return max;
	}
}
