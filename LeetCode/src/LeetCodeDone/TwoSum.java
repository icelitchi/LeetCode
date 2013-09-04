package LeetCodeDone;

//返回index
//方法一：n*n的暴力算法
//（若拍好序）方法二n：先对number排序，从两边扫，和>target,右指针--；和<target,左指针++
//方法三：用map存放number和index对，map搜索remainder在map中有没有
public class TwoSum {

	   public int[] twoSum(int[] numbers, int target) {
	 
		   int[] result=new int[2];
		   
		   for(int i=0;i<numbers.length-1;i++){
			   int remain=target-numbers[i];
			   for(int j=i+1;j<numbers.length;j++){
				   if(numbers[j]==remain)
				   {
					   result[0]=i+1;
					   result[1]=j=1;
					   return result;
				   }
			   }
		   }
	        return result;
	    }
	   
	   
	   //
}
