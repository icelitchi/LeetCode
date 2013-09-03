package LeetCode;

public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpiralMatrixII test=new SpiralMatrixII();
		test.generateMatrix(4);

	}
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int direction=0;
        int i=0,j=0;
        for(int k=1;k<n*n+1;k++){
        	matrix[i][j]=k;
        	switch(direction){
        	case 0://left
        		if(j==n-1||matrix[i][j+1]>0){
        			direction=(direction+1)%4;
        			i++;
        		}else{
        			j++;
        		}
        		break;
        	case 1://down
        		if(i==n-1||matrix[i+1][j]>0){
        			direction=(direction+1)%4;
        			j--;
        		}else{
        			i++;
        		}
        		break;
        	case 2://right
        		if(j==0||matrix[i][j-1]>0){
        			direction=(direction+1)%4;
        			i--;
        		}else{
        			j--;
        		}
        		break;
        	case 3://up
        		if(i==0||matrix[i-1][j]>0){
        			direction=(direction+1)%4;
        			j++;
        		}else{
        			i--;
        		}
        		break;
        	}
        }
        return matrix;
    }
}
