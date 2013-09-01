package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LargestRectangleinHistogram {
	//更好的办法？？
    public int largestRectangleArea(int[] height) {
    	//记录当前高度计算面积到达的最远柱子
    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    	int max=0;
    	for(int i=0;i<height.length;i++){
    		int h=height[i];
    		Integer farPostion=map.get(h);
    		if(farPostion!=null&&i<=farPostion){
    			continue;
    		}
    		
    		
    		int width=1;
    		int j=i-1;
    		while(j>=0&&height[j]>=h){
    			width++;
    			j--;
    		}
    		j=i+1;
    		while(j<height.length&&height[j]>=h){
    			width++;
    			j++;
    		}
    		map.put(h, j-1);
    		
    		int area=h*width;
    		max=max>area?max:area;
    	}
    	return max;
        
    }

}
