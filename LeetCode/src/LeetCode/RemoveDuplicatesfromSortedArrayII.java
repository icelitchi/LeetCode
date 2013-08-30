package LeetCode;

public class RemoveDuplicatesfromSortedArrayII {
	
    public int removeDuplicates(int[] A) {

    	int result=0;
    	int v=A[0];
    	int n=0;
    	for(int i=0;i<A.length;i++){
    		if(A[i]==v){
    			if(n<2){
    				result++;
    				n++;
    			}
    				
    		}else{
    			v=A[i];
    			n=1;
    			result++;
    		}
    	}
        return result;
    }
}
