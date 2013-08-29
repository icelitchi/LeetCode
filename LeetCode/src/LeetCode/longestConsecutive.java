package LeetCode;
public class longestConsecutive {
	public int lConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		mergesort(num, 0, num.length-1);

		int length = 0;
		int temp = 0;
		for (int i = 0; i < num.length; i++) {
			if (temp == 0) {
				temp++;

			} else {
				if (num[i] >num[i - 1]) {
					temp++;

				} else {
					if (temp > length)
						length = temp;
					temp = 0;
				}

			}
		}
		if (temp > length)
			length = temp;
		return length;
	}

	void mergesort(int[] num, int low, int high) {
		if (low == high)
			return;
		int mid = (low + high) >> 1;
		mergesort(num, low, mid);
		mergesort(num, mid+1, high);
		for (int i = mid + 1; i <= high; i++) {
			int p = num[i];
			for (int j = i - 1; j >= low; j--) {
				if (p >= num[j]) {
					num[j + 1] = p;
					break;
				} else {
					num[j + 1] = num[j];
				}
			}
		}

	}
	public  static void main(String[] args){
		longestConsecutive r=new longestConsecutive();
	int [] num={0,3,7,2,5,8,4,6,0,1};
	
	int ll=r.lConsecutive(num);
System.out.println(ll);
System.out.println(num);
	}
}
