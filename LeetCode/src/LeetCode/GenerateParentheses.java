package LeetCode;

import java.util.ArrayList;

public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateParentheses test=new GenerateParentheses();
		ArrayList<String> parents=test.generateParenthesis(3);
	}
	 public ArrayList<String> generateParenthesis(int n) {
	        
		 ArrayList<String> parents=new ArrayList<String> ();
		 Character[] p=new Character[2*n];
		 generateParenthesis(0,n,1,p,parents);
		 return parents;
	    }
	 //lcount：要填第lcount个左括号;
	 void generateParenthesis(int i,int n,int lcount,Character[] p,ArrayList<String> parents){
	
		 p[i]='(';
		 if(lcount==n){
			 StringBuffer sb=new StringBuffer();
			 for(int  k=0;k<2*n;k++){
				 if(null==p[k])
					 sb.append(')');
				 else
					 sb.append('(');
			 }
			 parents.add(sb.toString());
			 p[i]=null;
			 return;
		 }
		 //下一个‘(’可填的位置
		 //j+1-(lcount+1)<lcount+1（左括号数小于左括号数）
		for(int j=i+1;j<2*lcount+1&&j<2*n;j++){
		
			generateParenthesis(j,n,lcount+1,p,parents);
			
		}
		p[i]=null;
		
		 
	 }

}
