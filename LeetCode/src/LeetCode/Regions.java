package LeetCode;

public class Regions {

	public void solve(char[][] board){
		int length=board.length;
		int hight=0;
		if(length>0)
			hight=board[0].length;
		for(int i=0;i<hight;i++){
			if(board[0][i]=='O'){
				board[0][i]='S';
				inject(board,0,i);
				}
			if(board[length-1][i]=='O'){
				board[length-1][i]='S';
				inject(board,length-1,i);
				}
		}
		for(int i=0;i<length;i++){
			if(board[i][0]=='O'){
				board[i][0]='S';
				inject(board,i,0);
				}
			if(board[i][hight-1]=='O'){
				board[i][hight-1]='S';
				inject(board,i,hight-1);
			}
		}
		for(int i=0;i<length;i++){
			for(int j=0;j<hight;j++){
				if(board[i][j]=='S')
					board[i][j]='O';
				else if(board[i][j]=='O')
					board[i][j]='X';
			}
		}
		}
	
	public void inject(char[][] board,int i,int j){
		int h=board.length;
		int l=board[0].length;
		if(i+1<h&&board[i+1][j]=='O'){
			board[i+1][j]='S';
			inject(board,i+1,j);
		}
		if(i-1>0&&board[i-1][j]=='O'){
			board[i-1][j]='S';
			inject(board,i-1,j);
		}
		if(j+1<l&&board[i][j+1]=='O'){
			board[i][j+1]='S';
			inject(board,i,j+1);
		}
		if(j-1>0&&board[i][j-1]=='O'){
			board[i][j-1]='S';
			inject(board,i,j-1);
		}
		
	}
	public  static void main(String[] args){
		Regions r=new Regions();
		char[][] test=new char[9][6];
		r.solve(test);
	}
}
