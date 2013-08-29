package LeetCode;

public class ClimbingStairs {
	//递归
	   public int _climbStairs(int n) {
		   if(n==1)
			   return 1;
		   if(n==2)
			   return 2;
		  
	      return climbStairs(n-1)+climbStairs(n-2);
	    }
	   //动态规划
	   public int climbStairs(int n) {
		   int m=1;
		  int pre1=0;
		  int pre2=1;
		  int result=1;
		  while(m<=n){
			  result=pre1+pre2;
			  pre1=pre2;
			  pre2=result;
			  m++;
		  }
		  return result;
	    }
}
