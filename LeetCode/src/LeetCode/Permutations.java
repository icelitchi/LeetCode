package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;





//全排列（不含重复元素）
//非递归实现,思路：
// 按照字典序输出
//初始化 第一个，如1234
//找到当前的排列的下一个排列：从后往前扫描排列，找到第一个逆序对，类NextPermutation实现了
//直到 扫描时找不到逆序对

public class Permutations {
	public static void main(String[] args) {
		Permutations p = new Permutations();
	int[] num={3,1,2};
	p.permute(num);
	}
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> per=new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	ArrayList<Integer> e=new ArrayList<Integer>();
    	//初始化第一个
    	for(int i=0;i<num.length;i++){
    		e.add(num[i]);
    	}
    	per.add(e);
    	//找下一个字典序
    	while(findNextPermutations(num)){
    		 e=new ArrayList<Integer>();
    	   	for(int i=0;i<num.length;i++){
    	    	
    	    		e.add(num[i]);
    	    	}
    	    	per.add(e);
    	}
    	return per;
        
    }
    boolean findNextPermutations(int[] num){

    	for(int j=num.length-1;j>0;j--){
    		if(num[j]>num[j-1]){//第一个逆序j-1,j
    			int temp=num[j-1];
    			for(int i=num.length-1;i>=j;i--){
    				if(num[i]>temp){
    				    num[j-1]=num[i];
    				    num[i]=temp;
    				    break;
    				}
    			}
    			
    			//倒转数组j到最后 注意！！！！是<=
    			for(int i=j;i<=(j+num.length-1)/2;i++){
    				 temp=num[i];
    				 num[i]=num[j+num.length-1-i];
    				 num[j+num.length-1-i]=temp;
    				
    			}
    			return true;
    		}
    	}

    	return false;
    }

}
