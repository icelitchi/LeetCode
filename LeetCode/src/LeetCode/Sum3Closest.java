package LeetCode;

import java.util.Arrays;

//三个数的和 最接近target
//返回和
public class Sum3Closest {
	   public int threeSumClosest(int[] num, int target) {
		   Arrays.sort(num);
		   //初始化closet
		
	
		   if(num[0]+num[1]+num[2]>=target)
				  return num[0]+num[1]+num[2];
		   if(num[num.length-1]+num[num.length-2]+num[num.length-3]<=target)
			      return num[num.length-1]+num[num.length-2]+num[num.length-3];
					   
		int result=	num[0]+num[1]+num[2];		   
		int closest=Math.abs(num[0]+num[1]+num[2]-target);
	    	int nonmindex=0;//第一个非负数的index
	    	while(num[nonmindex]<0&&nonmindex<num.length){
	    		nonmindex++;
	    	}
	    	
	    	
	    	for(int i=0;i<num.length-2;i++){
	    		int sum=num[i];
	    		for(int j=i+1;j<num.length-1;i++){
	    		   sum=num[i]+num[j];
	    			if(sum-target>=0){//前两个和已经大于target，第三个数越小越好
	    				sum=num[i]+num[j]+num[j+1];
	    				int temp=Math.abs(sum-target);
	    				if(temp<closest){
	    					result=sum;
	    					closest=temp;
	    				}
	    		
	    			}else{//前两个和还小于target，
	
	    						//1,如果加第一个非负数，就>target,则可能+最大的非负的更接近target
		    					//2,如果加第一个非负数，还<target,则遍历 剩下的非负数
	    						//所以从nonmindex-1开始遍历，直到sum大于target为止
	    				for(int k=nonmindex-1;k>0&&k<num.length;k++){
	    					sum=num[i]+num[j]+num[k];
		    				int temp=Math.abs(sum-target);
		    				if(temp<closest){
		    					result=sum;
		    					closest=temp;
		    				}
		    				if(sum>target){
		    					break;
		    				}
	    				}
	    		
	    			
	    			}
	    		}
	    	}
	    	
		   
	     return result;
	        
	    }
}
