package LeetCode;

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix){
		//空矩阵
		  if(matrix==null||matrix.length==0)
				return 0;
		int area=0;
		
		int line=matrix.length;
		int colunm=matrix[0].length;
		
		int left=matrix[0].length;
		int right=0;
		int up=matrix.length;
		int down=0;
		for(int i=0;i<line;i++){
			for(int j=0;j<colunm;j++){
				if(matrix[i][j]=='1'){
					left=Math.min(left, j);
					right=Math.max(right, j);
					up=Math.min(up, i);
					down=Math.max(down, i);
				}
			}
		}
		
		if(left<=right){
			area=(right+1-left)*(down+1-up);
		}
		return area;
	}
}
