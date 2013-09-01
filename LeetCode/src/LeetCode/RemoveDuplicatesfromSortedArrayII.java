package LeetCode;

public class RemoveDuplicatesfromSortedArrayII {
	
    public int removeDuplicates(int[] A) {
    	 if(A==null||A.length==0)
    	        return 0;
    	
    	 //合法的个数，即当前的指针
    	int result=0;
    	int v=A[0];
    	int n=0;
 
    	for(int i=0;i<A.length;i++){
    		if(A[i]==v){
    			if(n<2){
    				A[result]=A[i];
    				result++;
    				n++;
    			}
    				
    		}else{
    			v=A[i];
    			n=1;
    			A[result]=A[i];
    			result++;
    		}
    	}
        return result;
    }
}
