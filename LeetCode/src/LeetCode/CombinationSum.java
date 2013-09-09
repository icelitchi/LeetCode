package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//可重复的背包问题（不同，背包问题是有重量和价值的问题）
//组合 和 问题

//所选货物的值==target



//DP动态规划，大数据集 超时,DP适合计算有几种情况
//DFS 深度优先搜索
//http://www.cnblogs.com/remlostime/archive/2012/10/29/2745083.html
public class CombinationSum {


	public static void main(String[] args) {
		CombinationSum test=new CombinationSum();
		int[] c={1,2,3,7,9};
		
		test.combinationSum(c, 100);
	}
	  public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
			ArrayList<ArrayList<Integer>>  comb=new ArrayList<ArrayList<Integer>>();
			combination(candidates,new int[candidates.length],0,target,comb);
			return comb;
	  }
	  void combination(int[] can,int[] count,int dep,int target,ArrayList<ArrayList<Integer>>  comb){
		  if(dep==can.length){
			  if(target==0){
				  ArrayList<Integer> res=new ArrayList<Integer>();
				  for(int i=0;i<count.length;i++){
					  for(int j=0;i<count[i];i++){
						  res.add(can[i]);
					  }
				  }
				  comb.add(res);
			  }
			  return ;
		  }
		  for(int i=0;i<=target/can[dep];i++){
			  count[dep]=i;
			  combination(can,count,dep+1,target-can[dep]*(i+1),comb);
		  }
	  }
	  
    public ArrayList<ArrayList<Integer>> _combinationSum(int[] candidates, int target) {

    	ArrayList<ArrayList<Integer>>  comb=new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(candidates);
    	int num=candidates.length;
    	int sum=candidates[0];
    	//存放 sum 和 sum 对应每个candidates个数的int[] list
    	Map<Integer,ArrayList<int[]>> map=new HashMap<Integer,ArrayList<int[]>>();
    	//初始化map
    	for(int i=0;i<num;i++){
    		ArrayList<int[]> c=new ArrayList<int[]>();
    		int[] r=new int[num];
    		r[i]=1;
    		c.add(r);
    		map.put(candidates[i], c);
    	}

    	while(sum<=target){
    		for(int i=0;i<num;i++){
    			int remainder=sum-candidates[i];
    			if(remainder<=0){
    				break;
    			}else{
    				ArrayList<int[]> r1=map.get(remainder);
    				if(r1!=null){
    					ArrayList<int[]> r=map.get(sum);
    					if(r==null)
    						r=new ArrayList<int[]>();
    					for(int j=0;j<r.size();j++){
    						int[] c=new int[num];
    						int[] temp=r.get(j);
    						for(int k=0;k<num;k++)c[k]=temp[k];
    						c[i]++;
    						r.add(c);
    					}
    					map.put(sum, r);
    						
    				}
    			}
    		}
    		sum++;
    	}
    	
    	ArrayList<int[]> r=map.get(target);
    	if(r!=null){
    		for(int i=0;i<r.size();i++){
    			int[] c=r.get(i);
    			ArrayList<Integer> e=new ArrayList<Integer>();
    			for(int j=0;j<num;j++){
    			
    					while(c[j]>0){
    						e.add(candidates[j]);
    						c[j]--;
    					}
    			}
    			comb.add(e);
    		}
    	}
    	return comb;
        
    }
    
    
    
    
}
