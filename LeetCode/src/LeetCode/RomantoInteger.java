package LeetCode;

public class RomantoInteger {

	public static void main(String[] args) {
		RomantoInteger test=new RomantoInteger();
		System.out.print(test.romanToInt("II"));
	}

	// M 1000
	// D 500
	// C 100
	// L 50
	// X 10
	// V 5
	// I 1
	public int romanToInt(String s) {
		int value = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'M':
				value += 1000;
				break;
			case 'D':
				value += 500;
				break;
			case 'C':
				if (i + 1 < s.length()) {
					int nextc = s.charAt(i + 1);
					if (nextc == 'M') {
						i++;
						value += 900;
					} else if (nextc == 'D') {
						i++;
						value += 400;
					} else
						value += 100;
				} else {
					value += 100;
				}
				break;
			case 'L':
				value += 50;
				break;
			case 'X'://
				if (i + 1 < s.length()) {
					int nextc = s.charAt(i + 1);
					if (nextc == 'C') {
						i++;
						value += 90;
					} else if (nextc == 'L') {
						i++;
						value += 40;
					} else {
						value += 10;
					}
				} else {
					value += 10;
				}
				break;
			case 'V':
				value += 5;
				break;
			case 'I'://
				if (i + 1 < s.length()) {
					int nextc = s.charAt(i + 1);
					if (nextc == 'X') {
						i++;
						value += 9;
					} else if (nextc == 'V') {
						i++;
						value += 4;
					} else
						value += 1;
				} else {
					value += 1;
				}
				break;

			}
			i++;
		}
		return value;
	}

}
