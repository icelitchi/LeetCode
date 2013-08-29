package LeetCode;

public class PlusOne {
	public int[] plusOne(int[] digits) {

		int length = digits.length;
		
		int[] result = new int[length + 1];
		result[length] = 1;
		
		int location = 0;
		while (location < length) {
			//进位
			if (digits[location] == 9) {
				digits[location] = 0;
				result[location] = 0;
				location++;
			} else {
				//遇到不用进位， 就可以直接返回原有数组
				digits[location]++;
				return digits;
			}
		}
		return result;
	}
	public static void main(String[] args){
		PlusOne test=new PlusOne();
		int[] n={9,9,9};
		int[] m=test.plusOne(n);
		System.out.println(m[0]+""+m[1]+""+m[2]+""+m[3]);
	}
}
