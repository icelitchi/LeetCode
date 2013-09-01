package LeetCode;

import java.util.Arrays;

//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
public class SearchRotatedSortedArray {
    public int search(int[] A, int target) {

        int low=0;
        int high=A.length-1;
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
        			return mid;
        	}else if(target<A[low]){
        		if(target<A[mid]){
        			if(A[low]<=A[mid]){
        				low=mid+1;
        			}
        			else{
        				high=mid-1;
        			}
        		}else if(target>A[mid]){
        			low=mid+1;
        		}else
        			return mid;
        	}else
        		return low;
        
        }
        return -1;
        
    }

}
