package LeetCode;

public class NextPermutation {
	//数组代表整数，调整数组，下一个比它大的顺序
	   public void nextPermutation(int[] num) {
		   boolean doneflag=false;
		   int tempMax=num[num.length-1];
		 //从后往前扫	 局部调整
		   for(int i=num.length-2;i>=0;i--){
			   if(num[i]>=tempMax){
				   tempMax=num[i];
			   }
			   else{
				   for(int j=num.length;j>=i-1;j--){
					   if(num[j]>num[i]){
						   int temp=num[j];
						   num[j]=num[i];
						   num[i]=temp;
						   doneflag=true;
					   }
						   
				   }
			   }
				   
		   }
		//没有局部调整   反转数组
		   if(!doneflag){
			   for(int i=0;i<num.length/2;i++){
				   int temp=num[i];
				   num[i]=num[num.length-1-i];		   
				   num[num.length-1-i]=temp;
			   }
		   }
	        
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
