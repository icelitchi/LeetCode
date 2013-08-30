package LeetCode;
import java.util.ArrayList;
public class Subsets {
	  public ArrayList<ArrayList<Integer>> subsets(int[] S) {

		  ArrayList<ArrayList<Integer>> subsets=new ArrayList<ArrayList<Integer>>();
		  subsets(S,0,new ArrayList<Integer>(),subsets);
	        return subsets;
	    }
	  //S中的第i个元素
	  //
	  
	  public void subsets(int[] S,int i,ArrayList<Integer> e,ArrayList<ArrayList<Integer>> subsets){
		  if(i==S.length){
			  subsets.add(e);
			  return;
		  }
		  //不包含元素i 
		  e.remove(S[i]);
		  subsets(S,i+1,e,subsets);
		  
		  //包含元素i
		  e.add(S[i]);
		  subsets(S,i+1,e,subsets);
	  }
}
