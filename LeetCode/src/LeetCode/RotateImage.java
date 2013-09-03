package LeetCode;

//顺时针旋转90度
//先上下称，再关于x=y线对称（坐标轴，x向右，y向下）

public class RotateImage {
    public void rotate(int[][] matrix) {
    	if(matrix==null)
    		return;
    	int lines=matrix.length;
    	int columns=matrix[0].length;
    	if(lines<=1)
    		return;
    	//上下对称
    	for(int i=0;i<lines/2;i++){
    		for(int j=0;j<columns;j++){
    			int temp=matrix[i][j];
    			matrix[i][j]=matrix[lines-1-i][j];
    			matrix[lines-1-i][j]=temp;
    		}
    	}
    	
    	//x=y轴对称
    	for(int i=0;i<lines;i++){
    		for(int j=0;j<i;j++){
    			int temp=matrix[i][j];
    			matrix[i][j]=matrix[j][i];
    			matrix[j][i]=temp;
    		}
    	}
        
    }
}
