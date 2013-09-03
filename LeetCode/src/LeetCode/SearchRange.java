package LeetCode;

public class SearchRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchRange test=new SearchRange();
		int[] A={2,2};
		test.searchRange(A, 3);

	}
	   public int[] searchRange(int[] A, int target) {
	   int[] range=new int[2];
	        range[0]=-1;
	        range[1]=-1;
	        
	        
	        int low=0;
	        int high=A.length-1;
	        int postion=-1;
	        while(low<=high){
	        	int mid=low+high>>>1;
	        	if(A[mid]>target){
	        		high=mid-1;
	        	}else if(A[mid]<target){
	        		low=mid+1;
	        	}else{
	        		postion=mid;
	        		break;
	        	}
	        }
	        if(postion>=0){
	        	int i=postion;
	        	while(i>=0&&target==A[i]){
	        		i--;
	        	}
	        	range[0]=i+1;
	        	i=postion;
	        	while(i<A.length&&target==A[i]){
	        		i++;
	        	}
	        	range[1]=i-1;
	        }
	        return range;
	    }

}
