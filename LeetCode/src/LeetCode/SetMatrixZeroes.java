package LeetCode;

public class SetMatrixZeroes {

	//？？更好的方法
	//~！！！！不能用原来的第一行第一列来标记，因为[0][0]标记就不知道是标记了行 或者 列
    public void setZeroes(int[][] matrix) {
    	int[] lines=new int[matrix.length];
    	int[] colunms=new int[matrix[0].length];
    	for(int e:lines){
    		e=0;
    	}
    	for(int e:colunms){
    		e=0;
    	}
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			lines[i]=1;
        			colunms[j]=1;
        		}    
        	}
        }

        for(int i=0;i<matrix.length;i++){
        	if(lines[i]==1)
        	for(int j=0;j<matrix[0].length;j++){
        		matrix[i][j]=0;
        	    
        	}
        }
        for(int i=0;i<matrix[0].length;i++){
        	if(colunms[i]==1)
        	for(int j=0;j<matrix.length;j++){
        		matrix[j][i]=0;
        	    
        	}
        }
 
    }
	public static void main(String[] args){

		SetMatrixZeroes test=new SetMatrixZeroes();
		int[][] matrix=new int[1][2];
		matrix[0][0]=0;
		matrix[0][1]=1;
		test.setZeroes(matrix);
	}
}
