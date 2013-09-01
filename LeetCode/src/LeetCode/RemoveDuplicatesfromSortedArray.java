package LeetCode;

public class RemoveDuplicatesfromSortedArray {


	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray test=new RemoveDuplicatesfromSortedArray();
		int[] a={1,1,2};
		test.removeDuplicates(a);
	}
    public int removeDuplicates(int[] A) {
    	   int[] B=new int[A.length];
    	     int num=0;
    	     int i=0;
    	     while(i<A.length){
    	    	 B[num]=A[i];
    	    	 num++;
    	    	 int temp=A[i];
    	    	 i++;
    	    	 while(i<A.length&&A[i]==temp){
    	    		 i++;
    	    	 }
    	
    	  
    	     }
    	     for(int j=0;j<num;j++){
    	    	A[j]=B[j];
    	     }
    	     return num;
        
    }

}
