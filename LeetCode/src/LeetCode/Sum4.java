package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

//四个输的和为target

//！！！好暴力的方法

//解法：首先(当然最首先的还是要排序数组)，固定i(for i from 0 to last)。
//对每个i，有j=i+1,k=last。对三者取和，如果大于0，说明k的那边取大了，k向前移动；
//如果小于0呢，说明j取得太小了，向后移动。如果等于0，记录i,j,k并同时移动j和k。
public class Sum4 {
	public static void main(String[] args) {

		Sum4 test=new Sum4();
		int[] n={0,0,0,0};
		test.fourSum(n, 0);
	}
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> sums=new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	for(int i=0;i<num.length-3;i++){
    		for(int j=i+1;j<num.length-2;j++){
    			for(int k=j+1;k<num.length-1;k++){
    				int l=num.length-1;
    				int sum=num[i]+num[j]+num[k]+num[l];
    				if(sum<target){
    					continue;
    				}
    				while(sum>target&&l>j){
    					l--;
    					sum=num[i]+num[j]+num[k]+num[l];
    				}
    				if(sum==target){
    					ArrayList<Integer> e=new ArrayList<Integer>();
    					e.add(num[i]);
    					e.add(num[j]);
    					e.add(num[k]);
    					e.add(num[l]);
    					sums.add(e);
    				}
    			}
    		}
    	}
    	return sums;
        
    }

}
