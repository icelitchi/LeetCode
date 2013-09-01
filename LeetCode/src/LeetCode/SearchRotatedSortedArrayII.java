package LeetCode;

public class SearchRotatedSortedArrayII {
	//当privot（第一个元素）为重复元素时，privote分布在字符串两侧，这样折半查找就会出错
	//故要讲privot去重
    public boolean search(int[] A, int target) {
    	   int low=0;
           int high=A.length-1;
           
          //privot去重
           //防止如果全一样
           if(A[0]==target)
        	   return true;
           while(A[high]==A[0]&&high>0)
        	   high--;
         
           while(low<=high){
           	int mid=(low+high)>>>1;
           	if(target>A[low]){
           		
           		if(target>A[mid]){
           			if(A[mid]>=A[low])
           				low=mid+1;
           			else
           				high=mid-1;
           		}
           		else if(target<A[mid])
           			high=mid-1;
           		else 
           			return true;
           	}else if(target<A[low]){
           		if(target<A[mid]){
           			if(A[low]<=A[mid]){
           				low=mid+1;
           			}
           			else{
           				high=mid-1;
           			}
           		}else if(target>=A[mid]){
           			low=mid+1;
           		}else
           			return true;
           	}else
           		return true;
           
           }
           return false;

    }
}
