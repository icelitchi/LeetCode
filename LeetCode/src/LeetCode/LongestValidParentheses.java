package LeetCode;

import java.util.Stack;

//case "()(()"
//case  "()(()(()(()()"
//不是有左括号在栈中，遇到 右括号就加2
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	int max=0;
     Stack<Integer> stack=new Stack<Integer>();
     int[] l=new int[s.length()];
  
     for(int i=0;i<s.length();i++){
    	 char c=s.charAt(i);
    	 switch(c){
    	 case '(':
    		 stack.push(i);
    		 l[i]=0;
    		 break;
    	 case ')':
    		 if(!stack.empty()){
    			 int start=stack.pop();
    			 int lbefore=0;
    			if(start-1>0){
    				lbefore=l[start-1];
    			}
    			l[i]=i-start+1+lbefore;
    			 max=max>l[i]?max:l[i];
    			
    		 }else{
    			l[i]=0;
    			
    		
    		 }
    			 
    		 break;
    	 }
     }
  
    	return max;
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
