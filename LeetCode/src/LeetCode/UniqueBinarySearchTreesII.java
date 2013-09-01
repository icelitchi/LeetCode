package LeetCode;

import java.util.ArrayList;


public class UniqueBinarySearchTreesII {


	public static void main(String[] args) {
		UniqueBinarySearchTreesII test=new UniqueBinarySearchTreesII();
		test.generateTrees(2);

	}
    public ArrayList<TreeNode> generateTrees(int n) {
    
    	return generateTrees(1,n);
        
    }
    ArrayList<TreeNode> generateTrees(int start,int end){
    	
    	 ArrayList<TreeNode> list=new  ArrayList<TreeNode>();
    	 if(start>end){
    		 list.add(null);
     		return list;
    	 }
    	 if(start==end){
    		 list.add(new TreeNode(start));
    		 return list;
    	 }
    	 
    	 for(int i=start;i<=end;i++){
    		 ArrayList<TreeNode> listleft=generateTrees(start,i-1);
    		 ArrayList<TreeNode> listright=generateTrees(i+1,end);
    		 for(int j=0;j<listleft.size();j++){
    			 for(int k=0;k<listright.size();k++){
    				 TreeNode node=new TreeNode(i);
    				 node.left=listleft.get(j);
    				 node.right=listright.get(k);
    				 list.add(node);
    				 
    			 }
    		 }
    	 }
    	return list;
    }

}
