package LeetCode;

public class EditDistance {

	public static void main(String[] args) {
	System.out.print(new EditDistance().minDistance("stop", "stop"));

	}
	//source:word1, target: word2
    public int minDistance(String word1, String word2) {
    	int l1=word1.length();
    	int l2=word2.length();
    	//distance matrix距离矩阵
    	int[][] dm=new int[word1.length()+1][word2.length()+1];
    	for(int i=0;i<l1+1;i++){
    		dm[i][0]=i;
    	}
    	for(int i=0;i<l2+1;i++){
    		dm[0][i]=i;
    	}
    	
    	for(int i=1;i<l1+1;i++){
    		for(int j=1;j<l2+1;j++){
    			dm[i][j]=min(dm[i-1][j]+1,dm[i-1][j-1]+substituteCost(word1.charAt(i-1),word2.charAt(j-1)),dm[i][j-1]+1);
    			
    		}
    	}
    	
       return dm[l1][l2];
        
    }
    int min(int d1,int d2,int d3){
    	return Math.min(Math.min(d1, d2), d3);
    }
    //增删的cost是1，改的cost是2
    int substituteCost(char a,char b){
    	if(a==b)
    		return 0;
    	else
    		return 2;
    }
}
