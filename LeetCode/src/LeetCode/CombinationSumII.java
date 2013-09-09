package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumII {

	public static void main(String[] args) {


	}
	// 候选 组合  和 为target
	//侯选值 有重复
//	For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
//	A solution set is: 
//	[1, 7] 
//	[1, 2, 5] 
//	[2, 6] 
//	[1, 1, 6] 
	
	//DP 大数据超时
	
	//DFS 方法
	 public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		 ArrayList<ArrayList<Integer>>  comb=new ArrayList<ArrayList<Integer>>(); 
		 Arrays.sort(candidates);
		 HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();// candidate-index
		 ArrayList<Integer> can=new ArrayList<Integer>();//candidate不含重复的，拍好序的
		 ArrayList<Integer> count=new ArrayList<Integer>();//candidate 对应数量
		 int index=0;
		 
		 for(int i=0;i<candidates.length;i++){
			 if(map.get(candidates[i])==null){
				 map.put(candidates[i], index);
				 count.add(index,1);
				 can.add(candidates[i]);
				 index++;
			 }else{
				 count.set(map.get(candidates[i]), count.get(map.get(candidates[i]))+1);
			 }
		 }
		 combination(can,count,new int[can.size()],0,comb);
		 return comb;
	 }
	
	void combination(ArrayList<Integer> can,ArrayList<Integer> count,int[] num,int dep, ArrayList<ArrayList<Integer>> comb){
		
	}

    
}
