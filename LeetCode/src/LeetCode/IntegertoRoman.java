package LeetCode;

public class IntegertoRoman {

	public static void main(String[] args) {

	}

	public String intToRoman(int num) {
		String roman = "";
		int thou = num / 1000;
		int hun = (num % 1000) / 100;
		int tens = (num % 100) / 10;
		int ones = num % 10;
		switch (thou) {
		case 1:
			roman += "M";
			break;
		case 2:
			roman += "MM";
			break;
		case 3:
			roman += "MMM";
			break;

		}
		switch (hun) {
		case 1:
			roman += "C";
			break;
		case 2:
			roman += "CC";
			break;
		case 3:
			roman += "CCC";
			break;
		case 4:
			roman += "CD";
			break;
		case 5:
			roman += "D";
			break;
		case 6:
			roman += "DC";
			break;
		case 7:
			roman += "DCC";
			break;
		case 8:
			roman += "DCCC";
			break;
		case 9:
			roman += "CM";
			break;
		}
		switch (tens) {
		case 1:
			roman += "X";
			break;
		case 2:
			roman += "XX";
			break;
		case 3:
			roman += "XXX";
			break;
		case 4:
			roman += "XL";
			break;
		case 5:
			roman += "L";
			break;
		case 6:
			roman += "LX";
			break;
		case 7:
			roman += "LXX";
			break;
		case 8:
			roman += "LXXX";
			break;
		case 9:
			roman += "XC";
			break;
		}
		switch (ones) {
		case 1:
			roman += "I";
			break;
		case 2:
			roman += "II";
			break;
		case 3:
			roman += "III";
			break;
		case 4:
			roman += "IV";
			break;
		case 5:
			roman += "V";
			break;
		case 6:
			roman += "VI";
			break;
		case 7:
			roman += "VII";
			break;
		case 8:
			roman += "VIII";
			break;
		case 9:
			roman += "IX";
			break;
		}
		return roman;
	}

}
