package LeetCode;


public class UniqueBinarySearchTrees {

	public static void main(String[] args) {


	}
	//动态规划， 第i个元素为根，则左右 子树 的元素个数确定
	
	   public int numTrees(int n) {
		      int[] num=new int[n+1];
		      if(n==1)
		          return 1;
		      num[0]=1;
		      num[1]=1;
		      for(int i=2;i<=n;i++){
		    	  for(int j=0;j<i;j++){
		    		  num[i]+=num[j]*num[i-1-j];
		    	  }
		      }
		    	return num[n];
		        
		    }

}
