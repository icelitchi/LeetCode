package LeetCode;

public class SetMatrixZeroes {

	//？？更好的方法
    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}    
        	}
        }
        for(int i=0;i<matrix.length;i++){
        	if(matrix[i][0]==0)
        	for(int j=0;j<matrix[0].length;j++){
        		matrix[i][j]=0;
        	    
        	}
        }
        for(int i=0;i<matrix[0].length;i++){
        	if(matrix[0][i]==0)
        	for(int j=0;j<matrix.length;j++){
        		matrix[i][j]=0;
        	    
        	}
        }
    }

}
