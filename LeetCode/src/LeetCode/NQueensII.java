package LeetCode;

//1110379080，如果有密码的话，应该是6900108
public class NQueensII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	}
	//递归法
	  public int totalNQueens(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(n<=0)
	        	return 0;
	      return  total( n,new int[n],0);
	    }
	  int total(int n,int[] q,int index){
		  int num=0;
		  if(index==n)
			  return 1;
		  
		  
		 outer: for(int i=0;i<n;i++){
			 		for(int k=0;k<index;k++)
			 			if(q[k]==i||Math.abs(q[k]-i)==index-k)
			 				continue outer;
			 		
			 		q[index]=i;
			 		num+=total(n,q,index+1);
				  
		 		}
		  return num;
	  }

}
