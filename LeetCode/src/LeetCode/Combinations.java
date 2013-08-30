package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
	   public ArrayList<ArrayList<Integer>> combine(int n, int k) {

		   ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>> ();
		   
		   combine(new Integer[k],1,n,k,0,result);
		
		   return result;
	    }
	   //递归实现
	   //p要填写的位
	   //p位可填的值位s到n
	   //A正在填写的组合
	   public void combine(Integer[] A,int s,int n, int k, int p,ArrayList<ArrayList<Integer>> result){
	
		   if(p>=k){
			   ArrayList<Integer> e=new ArrayList<Integer>();
			   Collections.addAll(e, A);
			   result.add(e);
			   return;
		   }

		   
		   for(int i=s;i<=n;i++){
			   A[p]=i;
			   combine(A,s+1,n,k,p+1,result);
		   }
	   }
}
