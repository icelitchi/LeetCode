package LeetCode;

import java.util.ArrayList;

public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "0000";
		RestoreIPAddresses test = new RestoreIPAddresses();
		test.restoreIpAddresses(s);
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ips = new ArrayList<String>();
		restoreIpAddresses(0, new int[3], s, ips);
		return ips;
	}

	void restoreIpAddresses(int k, int partion[], String s,
			ArrayList<String> ips) {
		if (k == 4) {
			// StringBuffer sb = new StringBuffer();
			// sb.append(s.substring(0, partion[0] + 1));
			// sb.append('.');
			// sb.append(s.substring(partion[0] + 1, partion[1] + 1));
			// sb.append('.');
			// sb.append(s.substring(partion[1] + 1, partion[2] + 1));
			// sb.append('.');
			// sb.append(s.substring(partion[2] + 1));
			// ips.add(sb.toString());
			ips.add(s.substring(0, partion[0] + 1) + '.'
					+ s.substring(partion[0] + 1, partion[1] + 1) + '.'
					+ s.substring(partion[1] + 1, partion[2] + 1) + '.'
					+ s.substring(partion[2] + 1));
			return;
		}
		int start = k == 0 ? 0 : (partion[k - 1] + 1);
		//！！！！！注意 是不是 0 开头
		if (k == 3) {// 判断最后一个ip段
		     if(s.charAt(start)!='0'||start==s.length()-1){
                 int x = Integer.parseInt(s.substring(start));
		    	if (x < 256) {
			    	restoreIpAddresses(k + 1, partion, s, ips);
		    	}   
            }
		} else {
			for (int i = 1; i <= 3; i++) {
				int l = s.length() - start - i;
				// 剩余长度满足要求
				if (l >= (3 - k) && l <= 3 * (4 - k)) {

					int x = Integer.parseInt(s.substring(start, start + i));

					// 划分的数<256，
					if (x < 256) {
						partion[k] = start + i - 1;
						restoreIpAddresses(k + 1, partion, s, ips);
					}
					if(s.charAt(start)=='0')
						break;
				}
			}
		}

	}
}
