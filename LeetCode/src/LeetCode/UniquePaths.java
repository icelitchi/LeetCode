package LeetCode;

public class UniquePaths {


	public static void main(String[] args) {


	}
	//(m-1+n-1)!/m-1!n-1!
	//考虑溢出
	//！！！！是要走 n-1 ，m-1步
    public int uniquePaths(int m, int n) {
      long result=1;
      //注意 
      m--;
      n--;
      int s=n<m?n:m;
      
      for(int i=0;i<s;i++){
    	  result*=n+m-i;
      }
      for(int i=1;i<=s;i++){
    	  result/=i;
      }
        return (int) result;
    }
}
