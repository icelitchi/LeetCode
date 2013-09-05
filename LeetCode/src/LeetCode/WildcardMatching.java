package LeetCode;

public class WildcardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WildcardMatching t=new WildcardMatching();
		System.out.print(t.isMatch("bbabb", "?**?"));

	}
	//大数据内存溢出，时间超出//同样的方法java过不了，c++能过
	//s string
	//p pattern
	//只考虑* 和 ？的匹配
	//动态规划  能做！！！
	//http://www.iteye.com/topic/1131749
    public boolean isMatch(String s, String p) {
      int a=0,b=0;
      boolean[][] match=new boolean[p.length()+1][s.length()+1];
    	  match[0][0]=true;
    	  //初始化矩阵两边，空串匹配的情况
      for(int i=1;i<p.length()+1;i++){
    	  if(match[i-1][0]&&p.charAt(i-1)=='*')
    		 match[i][0]=true;
    	  else  match[i][0]=false;
    	
      }
      for(int j=1;j<s.length()+1;j++){
      		  match[0][j]=false;
    	
      }
    
      int count=0;
      for(int i=1;i<p.length()+1;i++){
    	  //if(p.charAt(i-1)!='*')count++;
    	  char pc=p.charAt(i-1);
    	  for(int j=1;j<s.length()+1;j++){
    		 char sc=s.charAt(j-1);
    		 match[i][j]=false;
    		 switch(pc){
    		 case '?':
    			 if(match[i-1][j-1]==true)
    				 match[i][j]=true;
    			 
    			 break;
    		 case '*':
    			 if(match[i-1][j-1]||match[i][j-1]||match[i-1][j])
    				 match[i][j]=true;
    			 break;
    		 default:
    			 if(pc==sc){
    				 if(match[i-1][j-1])
    					 match[i][j]=true;
    				 
    			 }
    		 }
    	  }
      }
      return match[p.length()][s.length()];
    }


}
