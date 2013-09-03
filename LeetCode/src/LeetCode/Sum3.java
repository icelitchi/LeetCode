package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;


//三个数的值=target=0
public class Sum3 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> sums=new ArrayList<ArrayList<Integer>>();
    	
    	Arrays.sort(num);
    	int nonmindex=0;//第一个非负的index
    	while(num[nonmindex]<0){
    		nonmindex++;
    	}
    	
    	
    	for(int i=0;i<num.length-2;i++){
    		int sum=num[i];
    		for(int j=i+1;j<num.length-1;i++){
    		   sum=num[i]+num[j];
    			if(sum>=0){
    				break;//排好序的三个数，第三个一定>0,所以前两个数的和一定 小于0
    			}else{
    				int k=nonmindex>j+1?nonmindex:j+1;
    				for(;k<num.length;k++){
    					  sum=num[i]+num[j]+num[k];
    					  if(sum==0){
    						  ArrayList<Integer> e=new ArrayList<Integer>();
    						  e.add(num[i]);
    						  e.add(num[j]);
    						  e.add(num[k]);
    						  sums.add(e);
    					  }
    				}
    			
    			}
    		}
    	}
    	
    	
    	return sums;
        
    }
}
