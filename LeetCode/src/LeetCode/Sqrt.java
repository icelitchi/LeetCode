package LeetCode;

//平方根
public class Sqrt {
	public static void main(String[] args) {
		Sqrt test=new Sqrt();
		System.out.println(test.sqrt(2147395599));
		System.out.println(47499*47499);
	}

	int sqrt(int x) {
		int result;
		
		int y = x;
		
		// 位数
		int length = 0;
		int s=1;
		while (y > 99) {
			length++;
			y = y/100;
			s=s*10;
		}
		length++;

		// 最高位值
		int first = _sqrt_lt_100(y);

		int low=first*s;
		int up=((first+1)*s)-1;

		//折半查找
		int mid=(low+up)/2;
		while(mid>low&&mid<up){
			//注意溢出
			long temp=(long)mid*mid;
			if(temp==x){
				result=mid;
				return result;
			}else if(temp>x){
				up=mid;
			}else {
				low=mid;
			}
			 mid=(low+up)/2;
		}
		result=low;

		return result;
	}

	int _sqrt_lt_100(int x) {
		int result = 0;
		if (x == 0) {
			result = 0;
		} else if (x < 4) {
			result = 1;
		} else if (x < 9) {
			result = 2;
		} else if (x < 16) {
			result = 3;
		} else if (x < 25) {
			result = 4;
		} else if (x < 36) {
			result = 5;
		} else if (x < 49) {
			result = 6;
		} else if (x < 64) {
			result = 7;
		} else if (x < 81) {
			result = 8;
		} else if (x < 100) {
			result = 9;
		}
		return result;
	}
}
