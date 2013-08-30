package LeetCode;

public class MaximalRectangle {

	public int maximalRectangle(char[][] A){
		int area=0;
		
		int line=A.length;
		int colunm=A[0].length;
		
		int left=A[0].length-1;
		int right=0;
		int up=A.length-1;
		int down=0;
		for(int i=0;i<line;i++){
			for(int j=0;j<colunm;j++){
				if(A[i][j]=='1'){
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
