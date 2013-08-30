package LeetCode;

public class AddBinary {
	public String addBinary(String a, String b) {
		int la = a.length();
		int lb = b.length();
		int index = 0;
		StringBuffer sb = new StringBuffer();
		int q = 0;

		while (index < la || index < lb) {
			int n = 0, m = 0;
			if (index < la) {
				n = (a.charAt(la-index-1) == '1') ? 1 : 0;
			}
			if (index < lb) {
				m = (b.charAt(lb-index-1) == '1') ? 1 : 0;
			}

			switch (m + n + q) {
			case 0:
				q = 0;
				sb.insert(index, 0);
				break;
			case 1:
				q = 0;
				sb.insert(index, 1);
				break;
			case 2:
				q = 1;
				sb.insert(index, 0);
				break;
			case 3:
				q = 1;
				sb.insert(index, 1);
				break;
			}
			index++;
		}
		if (q == 1)
			sb.insert(index, 1);

		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("11", "111"));
	}

}
