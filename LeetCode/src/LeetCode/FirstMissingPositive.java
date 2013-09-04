package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//第一个missing的正值 在 1到A.length+1之间，
	//先扫一遍，把 A[i] 放到 A[i]-1这个index位置
	//就是 0~length-1上放1~length
	//再扫一遍，第一个A[i]!=i+1的i+1就是 missing
	 public int firstMissingPositive(int[] A) {  
	        if (A == null || A.length == 0) return 1;  
	          
	        for (int i = 0; i < A.length; i++) {  
	            while (A[i] != i + 1) {  
	                //A[i] == A[A[i] - 1] handles the case where there are two identical values  
	                // like A = [1, 1]  
	                if (A[i] <= 0 || A[i] >= A.length || A[i] == A[A[i] - 1]) break;  
	                int temp = A[i];  
	                A[i] = A[temp - 1];  
	                A[temp -1]= temp;  
	            }  
	        }  
	          
	        for (int i = 0; i < A.length; i++) {  
	            if (A[i] != i + 1) {  
	                return i+1;  
	            }  
	        }  
	        return A.length + 1;          
	    }  
}
