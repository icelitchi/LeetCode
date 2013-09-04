package LeetCode;

public class WildcardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//s string
	//p pattern
	//只考虑* 和 ？的匹配
	//不晓得动态规划能不能做
    public boolean isMatch(String s, String p) {
      int a=0,b=0;
      boolean[][] match=new boolean[p.length()][s.length()];
      if(p.charAt(0)=='?'||p.charAt(0)==s.charAt(0))
    	  match[0][0]=true;
      for(int i=1;i<p.length();i++){
    	 if(match[i-1][0]==true){
    		 if(p.charAt(i-1)=='*'&&isMatch(s.charAt(0),p.charAt(i))){
    			 match[i][0]=true;
    		 }else if(p.charAt(i))
    	 }else{
    		 match[i][0]=false;
    	 }
      }
      for(int j=1;j<s.length();j++){
    	  if(p.charAt(0)=='*')
    		  match[0][j]=true;
    	  else
    		  match[0][j]=false;
      }
    
      
      for(int i=1;i<p.length();i++){
    	  for(int j=0;j<s.length();j++){
    		  if()
    	  }
      }
      return match[p.length()-1][s.length()-1];
    }
    public boolean isMatch(char a,char p){
    	if(a==p||p=='?'||p=='*')
    		return true;
    	else
    		return false;
    }

}
