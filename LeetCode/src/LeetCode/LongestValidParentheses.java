package LeetCode;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	int result=0;
       int startIndex=0;
       int leftN=0;
       int rightN=0;
       for(int i=0;i<s.length();i++){
    	  if(s.charAt(i)=='('){
    		  if(leftN==0)
    			  startIndex=i;
    		  leftN++;
    	  }else if(leftN==rightN){
    		  result=result>(i-startIndex-1)?result:(i-startIndex-1);
    		  leftN=0;
    	      rightN=0;
    	  }
    	  else{
    		  rightN++;
    	  }
       }
    	return result;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
