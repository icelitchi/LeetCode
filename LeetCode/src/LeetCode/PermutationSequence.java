package LeetCode;

public class PermutationSequence {

	public static void main(String[] args) {
		PermutationSequence p=new PermutationSequence();
		p.getPermutation(1, 1);
	}
	//全排列中的 第     k 个
    public String getPermutation(int n, int k) {
      
        StringBuffer persb=new StringBuffer();
        
        int[] num=new int[n];
      
        for(int i=0;i<n;i++){
        	num[i]=i+1;
        }
        
        for(int i=1;i<k;i++){
        	nextPermutation(num);
        }
        for(int i=0;i<n;i++){
        	persb.append(num[i]);
        }
        return persb.toString();
    }
   void nextPermutation(int[] num){
	   for(int i=num.length-1;i>0;i--){
		   if(num[i-1]<num[i]){
			   int temp=num[i-1];
			   for(int j=num.length-1;j>=i;j--){
				   if(num[j]>num[i-1]){
					   num[i-1]=num[j];
					   num[j]=temp;
					   break;
				   }
			   }
			   for(int j=i;j<=(i+num.length-1)/2;j++){
				   temp=num[j];
				   num[j]=num[i+num.length-1-j];
				   num[i+num.length-1-j]=temp;
			   }
			   return;
		   }
	   }
   }
}
