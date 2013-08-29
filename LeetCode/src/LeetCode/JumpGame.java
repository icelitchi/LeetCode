package LeetCode;

public class JumpGame {
//返回是否可达
	   public boolean canJump(int[] A) {
		   int maxReachIndex=A[0];
		   int maxIndex=A.length-1;
		   //考虑只有一个元素的情况
		   for(int i=0;i<=maxReachIndex&&i<=maxIndex;i++){
			   int tempReachIndex=i+A[i];
			   maxReachIndex=maxReachIndex>tempReachIndex?maxReachIndex:tempReachIndex;
			   if(maxReachIndex>=maxIndex){
				   return true;
				   }
		   }

	        return false;
	    }
	   
//返回最小跳数的最后一个索引	   
	    public int jump(int[] A) {
	       int lastIndex[]=new int[A.length];
	       int jumpNum[]=new int[A.length];
	       //init
	       for(int i=0;i<A.length;i++){
	    	   lastIndex[i]=-1;
	    	   jumpNum[i]=A.length+1;
	       }
	       lastIndex[0]=0;
	       jumpNum[0]=0;
	       
	       for(int i=0;i<A.length;i++){
	    	   for(int j=1;j<=A[i]&&i+j<A.length;j++){
	    		   int tempJumpNum=1+jumpNum[i];
	    		   if(tempJumpNum<jumpNum[i+j]){
	    			   jumpNum[i+j]=tempJumpNum;
	    			   lastIndex[i+j]=i;
	    		   }
	    			   
	    	   }
	       }
	    	return lastIndex[A.length-1];
	        
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
