package LeetCode;


//求更简单的方法？？？？
public class WordSearch {

	public static void main(String[] args) {
		WordSearch test=new WordSearch();
		char[][] board={{'a','a'}};
		String word="aaa";
		test.exist(board, word);
	}
	//TODO
    public boolean exist(char[][] board, String word) {
    	int line=board.length;
    	int col=board[0].length;
    	int[][] mark=new int[line][col];
    	for(int i=0;i<line;i++){
    		for(int j=0;j<col;j++){
    			if(board[i][j]==word.charAt(0)){
    				mark[i][j]=1;
    				if(exist(board,mark,i,j,1,word))
    					return true;
    				mark[i][j]=0;
    			}
    		}
    	}
    	return false;
        
    }
    //mark表示char是否被用过   	//0未走过，1表示走过
    //p表示word匹配的位置
    public boolean exist(char[][] board,int[][] mark,int i,int j,int p,String word){
    	
    	if(p==word.length())
    		return true;
    	boolean flag=false;
    	char c=word.charAt(p);
    	if(i>0&&mark[i-1][j]==0&&board[i-1][j]==c){

    		mark[i-1][j]=1;
    		flag=flag||exist(board,mark,i-1,j,p+1,word);
    		if(flag)
    			return flag;
    		else
    			mark[i-1][j]=0;
    	}
     	if(j>0&&mark[i][j-1]==0&&board[i][j-1]==c){

    		mark[i][j-1]=1;
    		flag=flag||exist(board,mark,i,j-1,p+1,word);
    		if(flag)
    			return flag;
    		else
    			mark[i][j-1]=0;	
    	}
     	if(i<(board.length-1)&&mark[i+1][j]==0&&board[i+1][j]==c){

    		mark[i+1][j]=1;
    		flag=flag||exist(board,mark,i+1,j,p+1,word);
    		if(flag)
    			return flag;
    		else
    			mark[i+1][j]=0;	
    		
    	}
     	if(j<(board[0].length-1)&&mark[i][j+1]==0&&board[i][j+1]==c){
 
    		mark[i][j+1]=1;
    		flag=flag||exist(board,mark,i,j+1,p+1,word);
    		if(flag)
    			return flag;
    		else
    			mark[i][j+1]=0;	
    	}
    	return false;
    }

}
