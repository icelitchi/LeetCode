package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumII {

	public static void main(String[] args) {


	}
	
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
    						int[] c=Arrays.copyOf(r.get(i), num);
    						if(c[i]==0){
    							c[i]++;
    							r.add(c);
    						}
    						
    						
    					}
    					if(r.size()>0)
    						map.put(sum, r);
    						
    				}
    			}
    		}
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
