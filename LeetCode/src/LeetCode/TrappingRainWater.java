package LeetCode;

public class TrappingRainWater {

	public static void main(String[] args) {


	}
	
	
    public int trap(int[] A) {
    	int water=0;
    	int start=0;
    	while(start<A.length-2){
    		int[] res=findNextBow(start,A);
       		start=res[0];
       		water+=res[1];
    	}
        return water;
    }
   int[]  findNextBow(int start,int[] A){
	   int end=start;
	   int water=0;
	   //找到碗的入口
	   while(start<A.length-1&&A[start]<=A[start+1]){
		   start++;
	   }
	   //
	   end=start+1;
	   int hill=-1;
	   while(end<A.length&&A[end]<A[start]){
		   if(A[end]>=A[end-1]){
			   if(hill==-1||A[end]>=A[hill]){
				   hill=end;
			   }
		   }
		   end++;
	   }
	   if(end==A.length){
		   if(hill==-1)
			   water=0;
		   else{
			   end=hill;
			   water=countwater(start,end,A[hill],A);
			   
		   }
	   }else {
		   
		   water=countwater(start,end,A[start],A);
	   }
		   
	   int[] result={end,water};
	   return result;
   }
   
   int countwater(int start, int end ,int hight,int[] A){
	   int water=0;
	   for(int i=start+1;i<end;i++){
		   if( hight-A[i]>0)
			   water+= hight-A[i];
	   }
	   return water;
   }
}
