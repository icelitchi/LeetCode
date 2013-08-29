package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
	
	
//    public int totalNQueens(int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        return 0;
//    }
	//回溯
//	   效率问题？
	  public ArrayList<String[]> solveNQueens(int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		  ArrayList<String[]> resultlist=new ArrayList<String[]> ();
		  for(int i=0;i<n;i++){
			  int[] previous={i};
			  testQ(previous,resultlist,n);
		  }
		  return resultlist;
	    }
	  
	  
	  private void testQ(int[] previous, ArrayList<String[]> resultlist,int n){
		  if(previous.length==n-1){
			  String[] result=new String[n];
			  StringBuffer sb=new StringBuffer(n);
			  for(int i=0;i<n;i++){
				  sb.append('.');
			  }
			  for(int i=0;i<n;i++){
				  int line=previous[i];
				 result[line]=sb.toString().substring(0,i)+'Q'+sb.toString().substring(i+1);
			  }
			  resultlist.add(result);
		  }else{
			  for(int i=0;i<n;i++){
				  
				  if(testValidNext(previous,i)){
					  int[] newPrevious=Arrays.copyOf(previous, previous.length+1);
					  newPrevious[newPrevious.length-1]=i;
					  testQ(newPrevious,resultlist,n);
				  }
				  
			  }
		  }
		  
	  }
	  private boolean testValidNext(int[] previous,int test ){
		  for(int i=0;i<previous.length;i++){
			  if(previous[i]==test||(Math.abs(previous[i]-test)==Math.abs(previous.length-i))){
				  return false;  
			  }
		  }
		  
		  return true;
	  }
}
