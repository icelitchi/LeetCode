package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
public class Subsets {
	

	public static void main(String[] args) {
	
		Subsets test=new Subsets();
		int[] S={1,2};
		test.subsets(S);
	}

	
	
	  public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		  //集合中的元素要非递减，故先排好序
		  Arrays.sort(S);

		  ArrayList<ArrayList<Integer>> subsets=new ArrayList<ArrayList<Integer>>();
		  subsets(S,0,new int[S.length],subsets);
	        return subsets;
	    }
	  //S中的第i个元素
	  //
	  
	  public void subsets(int[] S,int i,int[] mark,ArrayList<ArrayList<Integer>> subsets){
		  if(i==S.length){
			  ArrayList<Integer> temp=new ArrayList<Integer>();
			  for(int index=0;index<S.length;index++){
				  if(mark[index]==1)
					  temp.add(S[index]);
			  }
			  subsets.add(temp);
			  return;
		  }
		  //不包含元素i 
		  mark[i]=0;
		  subsets(S,i+1,mark,subsets);
		  
		  //包含元素i
		  mark[i]=1;
		  subsets(S,i+1,mark,subsets);
	  }
}
