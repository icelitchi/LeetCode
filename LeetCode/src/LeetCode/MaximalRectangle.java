package LeetCode;

import java.util.Stack;

//由1组成的最大矩阵

//这个方法太帅了!!!!
// O(n^2)的算法，
//可以把问题看成求多个直方图的最大矩形面积，
//这样就可以从上往下来做例如第i层就是0~i的直方图，
//第i+1就是0~i+1的直方图，这样求直方图的复杂度O(n)，于是就有O(n^2)

//http://www.cnblogs.com/remlostime/archive/2012/11/12/2766566.html
public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix){
		//LargestRectangleinHistogram lrl=new LargestRectangleinHistogram();
		int[] A=new int[matrix[0].length];
		int max=0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				A[j]=matrix[i][j]==1?A[j]+1:0;
			int area=largestRectangleArea(A);
			max=area>max?area:max;
		}
		return max;
	}
    public int largestRectangleArea(int[] height) {
    	Stack<Integer> hstack=new Stack<Integer>();
    	Stack<Integer> istack=new Stack<Integer>();
    	int maxarea=0;
    	hstack.push(height[0]);
    	istack.push(0);
    	int i=1;
    	while(i<height.length){
    	
    		int h=height[i];
    		while(!hstack.empty()){
    			int preh=hstack.pop();
    			int starti=istack.pop();
    			if(preh>h){
    				int area=(i-starti+1)*preh;
    				maxarea=maxarea>area?maxarea:area;
    			}else if(preh<h){
    				hstack.push(preh);
    				istack.push(starti);
    				hstack.push(h);
    				istack.push(starti);
    				break;
    			}else{//preh==h
    				hstack.push(preh);
    				istack.push(starti);
    				break;
    			}	
    		}
    		if(hstack.empty()){
    			hstack.push(h);
				istack.push(i);
    		}
    		i++;
    
    	}
    	while(!hstack.empty()){
    		int preh=hstack.pop();
			int starti=istack.pop();
			int area=(height.length-starti)*preh;
			maxarea=maxarea>area?maxarea:area;
    	}
    	return maxarea;
    	
    }
}
