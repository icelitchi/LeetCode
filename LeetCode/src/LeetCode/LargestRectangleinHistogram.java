package LeetCode;

public class LargestRectangleinHistogram {
	//更好的办法？？
    public int largestRectangleArea(int[] height) {

    	int max=0;
    	for(int i=0;i<height.length;i++){
    		int h=height[i];
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
    		int area=h*width;
    		max=max>area?max:area;
    	}
    	return max;
        
    }

}
