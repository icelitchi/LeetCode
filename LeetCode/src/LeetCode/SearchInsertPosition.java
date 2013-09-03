package LeetCode;

public class SearchInsertPosition {

	public static void main(String[] args) {


	}
	   public int searchInsert(int[] A, int target) {
		   int p=-1;
		   int low=0;
		   int high=A.length-1;
		  
	        while(low<=high){
	        	int mid=low+high>>>1;
	        	if(A[mid]>target){
	        		high=mid-1;
	        	}else if(A[mid]<target){
	        		low=mid+1;
	        	}else{
	        		p=mid;
	        		break;
	        	}
	        }
	        if(p>0)
	        	return p;
	        else
	        	return low;
	        
	    }

}
