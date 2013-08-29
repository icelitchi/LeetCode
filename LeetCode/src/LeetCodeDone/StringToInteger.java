package LeetCodeDone;

public class StringToInteger {
	//考虑溢出
	public int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;
		boolean neg = false;
		boolean numStart = false;

		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!numStart) {
				
				if (c == ' ') {
					continue;

				} 
				if (c >= '0' && c <= '9') {
					result = c - '0';
					numStart = true;
					continue;
				} 
				
					if (c == '-') {
						neg = true;
						numStart = true;
						continue;
					} else if (c == '+') {
						numStart = true;
						continue;
					}
				
				
				break;
			} else {
				if (c >= '0' && c <= '9') {
					result = result * 10 + (c - '0');
				} else {
					break;
				}

			}

		}
		//??????溢出应该在哪里考虑
		result= result * (neg ? -1 : 1);
        if(result>2147483647)
        result=2147483647;
        else if(result<-2147483648)
        result=-2147483648;
        return result;
	//	return result * (neg ? -1 : 1);

	}
	public static void main(String[] args){
		StringToInteger s=new StringToInteger();
		System.out.println(s.atoi("-2147483649"));
		System.out.println(Integer.parseInt("214748364"));
	}
}
