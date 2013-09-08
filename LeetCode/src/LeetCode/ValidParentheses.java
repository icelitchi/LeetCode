package LeetCode;

import java.util.Stack;

public class ValidParentheses {

	// The brackets must close in the correct order, "()" and "()[]{}" are all
	// valid but "(]" and "([)]" are not.
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String s) {
		if (s.length() % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char lc;
			if (c == ')' || c == '}' || c == ']') {
				if (stack.empty())
					return false;
				else
					lc = stack.pop();
				switch (c) {
				case ')':
					if (lc != '(')
						return false;
					break;
				case ']':
					if (lc != '[')
						return false;
					break;
				case '}':

					if (lc != '{')
						return false;
					break;
				default:
					return false;
				}
			} else {
				stack.push(c);
			}

		}
		return stack.empty();

	}

}
