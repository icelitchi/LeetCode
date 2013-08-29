package LeetCode;

import java.util.ArrayList;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "This", "is", "an", "example", "of", "text",
				"justification." };
		ArrayList<String> r = new TextJustification().fullJustify(words, 16);
		for (int i = 0; i < r.size(); i++) {
			System.out.println(r.get(i));
		}

	}

	public ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ArrayList<String> result = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		int index = 0;
		int n = words.length;
		while (index < n) {

			int end = index + 1;
			int length = words[index].length();
			while (end < n
					&& (length + words[end].length() + end - index < (L + 1))) {
				length += words[end].length();
				end++;
			}
			int blank = L - length;
			if (end - 1 - index == 0) {
				sb.append(words[index]);
				for (int i = 0; i < blank; i++) {
					sb.append(' ');
				}
			}else if(end==n){
				for (int i = index; i < end; i++) {
					sb.append(words[i]);
					if (i < end - 1)
						sb.append(' ');
				}
			while(sb.length()<L){
				sb.append(' ');
			}
				
			} else {
				int average = blank / (end - 1 - index);
				StringBuffer sb_blank = new StringBuffer();
				while (average > 0) {
					sb_blank.append(' ');
					average--;
				}
				int reminder = blank % (end - index-1);
				for (int i = index; i < end; i++) {
					sb.append(words[i]);
					if (i < end - 1) {
						sb.append(sb_blank);
						if (reminder > 0) {
							sb.append(' ');
							reminder--;
						}
					}
				}
			}
			result.add(sb.toString());
			sb.delete(0, sb.length());
			index = end;
		}
		return result;
	}
}
