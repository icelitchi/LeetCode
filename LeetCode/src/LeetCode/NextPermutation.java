package LeetCode;

public class NextPermutation {
	//数组代表整数，调整数组，下一个比它大的顺序
	   public void nextPermutation(int[] num) {
		   boolean doneflag=false;
		   int tempMax=num[num.length-1];
		   
		 //从后往前扫	 局部调整
		   int i;//从后往前 第一个非增的数的索引
		   for(i=num.length-2;i>=0&&!doneflag;i--){
			   if(num[i]>=tempMax){
				   tempMax=num[i];
			   }
			   else{
				
				   for(int j=num.length-1;j>=0&&j>=i-1&&!doneflag;j--){
					   if(num[j]>num[i]){
						   int temp=num[j];
						   num[j]=num[i];
						   num[i]=temp;
						   doneflag=true;
					   }
						   
				   }
				   
				   
				   
			   }
				   
		   }
		   //如果  局部调整   反转 调整位置后面的数组
		   //此时 i 为 调整位置的前一个 位子，所以需反转的素组启示index是i+2
		   
		   //如果 未局部调整 反转整个数组，此时i=-1
		   int startindex=0;
		   if(doneflag){
			   startindex=i+2;
		   }
			   for(int j=startindex;j<(i+2+num.length)/2;j++){
				   int temp=num[j];
				   num[j]=num[num.length-1+startindex-j];		   
				   num[num.length-1+startindex-j]=temp;
			   }

	        
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextPermutation test=new NextPermutation();
		 int[] a={3,2,1};
		test.nextPermutation(a);

	}

}
