package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {


	public static void main(String[] args) {
	

	}
	
	   public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		   ArrayList<ArrayList<Integer>> subsets=new ArrayList<ArrayList<Integer>>();
		   if(num.length==0){
			   subsets.add(new  ArrayList<Integer>());
			   return subsets;
		   }
			 //排序
		   Arrays.sort(num);
		   //计算出现 元素 和 次数
		   ArrayList<Integer> elements=new ArrayList<Integer>();
		   ArrayList<Integer> count=new ArrayList<Integer>();
		   
		   int n=0;
		   int pre=num[0];
		   elements.add(pre);
		   count.add(1);
		   for(int i=1;i<num.length;i++){
			   int x=num[i];
			   if(x==pre){
				   count.set(n, count.get(n)+1);
			   }else{
				   elements.add(x);
				   count.add(1);
				   pre=x;
				   n++;
			   }
		   }
		   subsetsWithDup(0,new int[elements.size()],elements,count,subsets);
	      return subsets;
	    }
	   void subsetsWithDup(int k,int[] mark,ArrayList<Integer> elements,ArrayList<Integer> count,ArrayList<ArrayList<Integer>> subsets){
		   if(k==mark.length){
			   ArrayList<Integer> e=new ArrayList<Integer>();
			   for(int i=0;i<mark.length;i++){
				   
				   for(int j=0;j<mark[i];j++){
					   e.add(elements.get(i));
				   }
			   }
			   subsets.add(e);
			   return;
		   }
		   
		   for(int i=0;i<=count.get(k);i++){
			   mark[k]=i;
			   subsetsWithDup(k+1,mark,elements,count,subsets);
		   }
	
	   }

}
