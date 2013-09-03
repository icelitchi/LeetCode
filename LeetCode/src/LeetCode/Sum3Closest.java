package LeetCode;

import java.util.Arrays;

//三个数的和 最接近target
//返回和
public class Sum3Closest {
	
	public static void main(String[] args) {

		Sum3Closest test=new Sum3Closest();
		int[] n={-4,2,-1,1};
		int[] m={87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
		System.out.println(test.threeSumClosest(m,-275));
	}
	   public int threeSumClosest(int[] num, int target) {
		   Arrays.sort(num);
		   //初始化closet
		
		   if(num[0]+num[1]+num[2]>=target)
				  return num[0]+num[1]+num[2];
		   if(num[num.length-1]+num[num.length-2]+num[num.length-3]<=target)
			      return num[num.length-1]+num[num.length-2]+num[num.length-3];
					   
		int result=	num[0]+num[1]+num[2];		   
		int closest=Math.abs(num[0]+num[1]+num[2]-target);
//	    	int nonmindex=0;//第一个非负数的index
//	    	while(num[nonmindex]<0&&nonmindex<num.length){
//	    		nonmindex++;
//	    	}
//	    	
	    	
	    	for(int i=0;i<num.length-2;i++){
	    		int sum=num[i];
	    		for(int j=i+1;j<num.length-1;j++){
	    		   sum=num[i]+num[j];
//	    			if(sum-target>=0){//前两个和已经大于target，第三个数越小越好!!!(这是错的)
//	    				sum=num[i]+num[j]+num[j+1];
//	    				int temp=Math.abs(sum-target);
//	    				if(temp<closest){
//	    					result=sum;
//	    					closest=temp;
//	    				}
//	    		
//	    			}else{
	    				//前两个和还小于target，
	
	    						//1,如果加第一个非负数，就>target,则可能+最大的非负的更接近target
		    					//2,如果加第一个非负数，还<target,则遍历 剩下的非负数
	    						//所以从nonmindex-1开始遍历，直到sum大于target为止
	    				for(int k=j+1;k>0&&k<num.length;k++){
	    					sum=num[i]+num[j]+num[k];
		    				int temp=Math.abs(sum-target);
		    				if(temp<closest){
		    					result=sum;
		    					closest=temp;
		    				}
		    		
	    				}
	    		
	    			
//	    			}
	    		}
	    	}
	    	
		   
	     return result;
	        
	    }
}
