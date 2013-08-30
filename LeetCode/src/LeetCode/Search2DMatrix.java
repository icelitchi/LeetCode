package LeetCode;

public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//拍好序的矩阵
	//折半查找
    public boolean searchMatrix(int[][] matrix, int target) {
      
    	int line=matrix.length;
    	int colunm=matrix[0].length;
    	
    	//step 1 折半查找在哪一行
    	int targetline=0;
    	if(target<matrix[0][0]){
    		return false;
    	}else if(target>=matrix[line-1][0]){
    		targetline=line-1;
    	}else{
    		int low = 0;
    		int high = line - 1;
    		while(low<high-1){
        	 int mid=(low+high)/2;
        	 if(target>=matrix[mid][0])
        		 low=mid;
        	 else
        		 high=mid;
    		}
    		targetline=low;
    	}
    	//step 2 在锁定行折半查找
    	int low=0;
    	int high=colunm-1;
    	while(low<high){
    		 int mid=(low+high)/2;
    		if(target>matrix[targetline][mid]){
    			low=mid+1;
    		}else if(target<matrix[targetline][mid]){
    			high=mid-1;
    		}else{
    			return true;
    		}
    	}
    	
        return true;
    }
}
