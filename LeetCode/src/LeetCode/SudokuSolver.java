package LeetCode;

public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  char[][] board={{'.','.','9','7','4','8','.','.','.'},
			  		{'7','.','.','.','.','.','.','.','.'},
			  		{'.','2','.','1','.','9','.','.','.'},
			  		{'.','.','7','.','.','.','2','4','.'},
			  		{'.','6','4','.','1','.','5','9','.'},
			  		{'.','9','8','.','.','.','3','.','.'},
			  		{'.','.','.','8','.','3','.','2','.'},
			  		{'.','.','.','.','.','.','.','.','6'},
			  		{'.','.','.','2','7','5','9','.','.'}};
		  SudokuSolver ss=new SudokuSolver();
		  ss.solveSudoku(board);

	}
    public void solveSudoku(char[][] board) {

    	solveSudokuR(board);
    }
    boolean solveSudokuR(char[][] board){
    
    	for(int n=0;n<9;n++){
    		for(int m=0;m<9;m++){
    			if(board[n][m]=='.'){
    				for(int k=0;k<9;k++){
    					board[n][m]=(char) ('1'+k);
    					if(isValid(board,n,m)&&solveSudokuR(board))
    						return true;
    				}
    				board[n][m]='.';
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    boolean isValid(char[][]board,int i, int j){
    	char c=board[i][j];
    	int boxi=(i/3)*3;
    	int boxj=(j/3)*3;
    	for(int n=boxi;n<boxi+3;n++){//所在盒子
    		for(int m=boxj;m<boxj+3;m++){
    			if(board[n][m]==c&&(n!=i||m!=j))
    				return false;
    		}
    	}
    	for(int k=0;k<9;k++){
    		if(board[k][j]==c&&k!=i)//列
    			return  false;
    		if(board[i][k]==c&&k!=j)//行
    			return false;
    	}
    	return true;
    }
    

}
