package LeetCode;

public class MaximumSubarray {

//和最大的 子数组
	public static void main(String[] args) {

	}
	  public int maxSubArray(int[] A) {
		   int max=A[0];//!!!如果全是负数就不对了,所以初始化为 A[0]，不能为0
	       int sum=0;
	       for(int i=0;i<A.length;i++){
	    	   int temp=sum+A[i];
	    	   if(temp>0){
	    		   sum=sum+A[i];
	    		 //  max=max>sum?max:sum;
	    	   }else{
	    		   sum=0;
	    	   }
	    	   max=max>temp?max:temp;//!!!如果全是负数就不对了，所以应在这里判断 max
	       }
	        return max;
	    }
}
