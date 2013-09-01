package LeetCode;

//动态规划
public class MinimumPathSum {

	public static void main(String[] args) {


	}
    public int minPathSum(int[][] grid) {
    	int lines=grid.length;
    	int colunms=grid[0].length;
       int[][] sum=new int[lines][colunms];
       sum[0][0]=grid[0][0];
       //初始化两边
       for(int i=1;i<lines;i++){
    	   sum[i][0]=sum[i-1][0]+ grid[i][0];
       }
       for(int i=1;i<colunms;i++){
    	   sum[0][i]=sum[0][i-1]+ grid[0][i];
       }
       
       
       
    	return sum[lines-1][colunms-1];
        
    }
}
