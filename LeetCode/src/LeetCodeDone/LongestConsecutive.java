package LeetCodeDone;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutive {

    public int longestConsecutive(int[] num) {
    	HashMap<Integer,Integer> ranges=new HashMap<Integer,Integer>();
    	HashSet<Integer> unique=new HashSet<Integer>();
    	int size=num.length;
    	if(size==0)
    		return 0;
    	int max=0;
    	for(int i=0;i<size;i++){
    		int v=num[i];
    		if(unique.contains(v))
    			continue;
    		else
    			unique.add(v);
    		int left=v;
    		int right=v;
    		if(ranges.containsKey(v-1)&&ranges.get(v-1)<=v-1){
    			left=ranges.get(v-1);
    			ranges.remove(v-1);
    		}
    		if(ranges.containsKey(v+1)&&ranges.get(v+1)>=v+1){
    			right=ranges.get(v+1);
    			ranges.remove(v+1);
    		}
    	
    			ranges.put(left, right);
    			ranges.put(right, left);
    			
    			if(right-left+1>max)
    				max=right-left+1;
    				
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
