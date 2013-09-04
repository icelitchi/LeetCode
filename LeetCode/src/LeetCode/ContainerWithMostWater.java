package LeetCode;


//Given n non-negative integers a1, a2, ..., an, 
//where each represents a point at coordinate (i, ai).
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, 
//such that the container contains the most water.
//
//Note: You may not slant the container.
public class ContainerWithMostWater {

	//类似于2Sum的思想，两边设一个指针，然后计算area，如果height[i] <= height[j]，那么i++，因为在这里height[i]是瓶颈，j往里移只会减少面积，不会再增加area。

	//		这是一个贪心的策略，每次取两边围栏最矮的一个推进，希望获取更多的水

    public int maxArea(int[] height) {
    	int water=0;
    	int i=0,j=height.length-1;
    	while(i<j){
    		int h=height[i]<height[j]?height[i]:height[j];
    		int temp=(j-i)*h;
    		water=water>temp?water:temp;
    		if(height[i]<height[j]){
    			i++;
    		}else if(height[i]>height[j]){
    			j--;
    		}else{
    			i++;
    			j--;
    		}
    	}
        return water;
    }
}
