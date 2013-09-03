package LeetCode;

public class UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int lines=obstacleGrid.length;
    	int columns=obstacleGrid[0].length;
    	
        int[][] ways=new int[lines][columns];
        if(obstacleGrid[0][0]==0){
        	ways[0][0]=1;
        }else{
        	return 0;
        }
        //初始化两边
        //0表示不可达
        for(int i=1;i<lines;i++){
        	if(obstacleGrid[i][0]==1){
        		ways[i][0]=0;
        	}else{
        		ways[i][0]=ways[i-1][0];
        	}
        }
        for(int i=1;i<columns;i++){
        	if(obstacleGrid[0][i]==1){
        		ways[0][i]=0;
        	}else{
        		ways[0][i]=ways[0][i-1];
        	}
        }
        
        for(int i=1;i<lines;i++){
            for(int j=1;j<columns;j++){
            	if(obstacleGrid[i][j]==1){
            		ways[i][j]=0;
            	}else{
            		ways[i][j]=ways[i-1][j]+ways[i][j-1];
            	}
            }
   
        }
        
        
        
      
        	return ways[lines-1][columns-1];
      
    }
}
