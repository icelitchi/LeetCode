package LeetCode;

public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//??有大量重复元素的排序的效率？？
    public void sortColors(int[] A) {
    	int red=0;
        int white=0;
        int blue=0;
        for(int i=0;i<A.length;i++){
        	switch(A[i]){
        	case 0:
        		red++;
        		break;
        	case 1:
        		white++;
        		break;
        	case 2:
        		blue++;
        		break;
        	}
        }
        for(int i=0;i<A.length;i++){
        	if(red>0){
        		A[i]=0;
        		red--;
        	}else if(white>0){
        		A[i]=1;
        		white--;
        	}else if(blue>0){
        		A[i]=2;
        		blue--;
        	}
        		
        }
        
    }

}
