package LeetCode;

import java.util.Stack;

public class LargestRectangleinHistogram {
	
	public static void main(String[] args) {
		LargestRectangleinHistogram test=new LargestRectangleinHistogram();
		int[] h={2,1,2};
System.out.print(test.largestRectangleArea(h));
	}
	//更好的办法？？
	//http://blog.csdn.net/beiyetengqing/article/details/8258232
	//两个辅助栈， 高度栈，索引栈，扫一遍
    public int largestRectangleArea(int[] height) {
    	Stack<Integer> hstack=new Stack<Integer>();
    	Stack<Integer> istack=new Stack<Integer>();
    	int maxarea=0;
    	if(height==null||height.length==0)
    		return 0;
    	hstack.push(height[0]);
    	istack.push(0);
    	int i=1;
    	while(i<height.length){
    	
    		int h=height[i];
    		int start=i;
    		while(!hstack.empty()){
    			int preh=hstack.pop();
    			int starti=istack.pop();
    			if(preh>h){
    				int area=(i-starti)*preh;
    				maxarea=maxarea>area?maxarea:area;
    				start=starti;
    			}else if(preh<h){
    				hstack.push(preh);
    				istack.push(starti);
    				hstack.push(h);
    				istack.push(start);
    				break;
    			}else{//preh==h
    				hstack.push(preh);
    				istack.push(starti);
    				break;
    			}	
    		}
    		if(hstack.empty()){
    			hstack.push(h);
				istack.push(start);
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
