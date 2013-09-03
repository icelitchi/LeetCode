package LeetCodeDone;

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
}
