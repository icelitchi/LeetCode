package LeetCode;

import java.util.Stack;

import LeetCodeDone.StringToInteger;

//由1组成的最大矩阵

//这个方法太帅了!!!!java大数据过不了，C++可以
// O(n^2)的算法，
//可以把问题看成求多个直方图的最大矩形面积，
//这样就可以从上往下来做例如第i层就是0~i的直方图，
//第i+1就是0~i+1的直方图，这样求直方图的复杂度O(n)，于是就有O(n^2)

//http://www.cnblogs.com/remlostime/archive/2012/11/12/2766566.html
public class MaximalRectangle {
	public static void main(String[] args){
		MaximalRectangle test=new MaximalRectangle();
		char[][] m={{'1'}};
		System.out.print(test.maximalRectangle(m));
	}

	public int maximalRectangle(char[][] matrix){
		//LargestRectangleinHistogram lrl=new LargestRectangleinHistogram();
		if(matrix==null||matrix.length==0)
			return 0;
		int[] A=new int[matrix[0].length];
		int max=0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++)
				A[j]=matrix[i][j]=='1'?A[j]+1:0;
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
//int calArea(vector<int> &a, vector<int> &width)
//     {
//         for(int i = 0; i < width.size(); i++)
//             width[i] = 0;
//             
//         stack<int> s;
//       for(int i = 0; i < a.size(); i++)
//            if (s.empty())
//             {
//                 s.push(i);
//                 width[i] = 0;
//             }
//             else
//             {
//                 while(!s.empty())
//                 {
//                     if (a[s.top()] < a[i])
//                     {
//                         width[i] = i - s.top() - 1;
//                         s.push(i);
//                         break;
//                     }
//                     else
//                         s.pop();
//                 }
//                 
//                if (s.empty())
//                 {
//                    s.push(i);
//                     width[i] = i;
//                 }
//             }
//             
//         while(!s.empty())
//             s.pop();
//             
//         for(int i = a.size() - 1; i >= 0; i--)
//             if (s.empty())
//             {
//                 s.push(i);
//                 width[i] = 0;
//             }
//             else
//             {
//                 while(!s.empty())
//                {
//                	 if (a[i] > a[s.top()])
//                     {
//                         width[i] += s.top() - i - 1;
//                         s.push(i);
//                        break;
//                     }
//                     else
//                         s.pop();
//                 }
//                 
//                 if (s.empty())
//                 {
//                     width[i] += a.size() - i - 1;
//                     s.push(i);
//                 }
//             }
//         
//        int maxArea = 0;    
//        for(int i = 0; i < width.size(); i++)
//             maxArea = max(maxArea, (width[i] + 1) * a[i]);
//             
//         return maxArea;
//     }
//     
//     int maximalRectangle(vector<vector<char> > &matrix) {
//         // Start typing your C/C++ solution below
//         // DO NOT write int main() function
//         if (matrix.size() == 0)
//             return 0;
//             
//        vector<int> a(matrix[0].size(), 0);
//         vector<int> width(matrix[0].size());
//         
//         int maxArea = 0;
//         for(int i = 0; i < matrix.size(); i++)
//         {
//             for(int j = 0; j < matrix[i].size(); j++)
//                 a[j] = matrix[i][j] == '1' ? a[j] + 1 : 0;
//                 
//             maxArea = max(maxArea, calArea(a, width));
//         }
//         
//         return maxArea;
//     }
