package LeetCode;

import java.util.ArrayList;

import java.util.Stack;

//双栈实现蛇形遍历
public class BinaryTreeZigzagLevelOrderTraversal {

	
	public static void main(String[] args) {

	}
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	
    	 ArrayList<ArrayList<Integer>> order=new  ArrayList<ArrayList<Integer>>();
    	 
    	 if(root==null){
    		 return order;
    	 }
    	 
    	 Stack<TreeNode> stackl=new Stack<TreeNode>();
    	 Stack<TreeNode> stackr=new Stack<TreeNode>();
    	 stackl.add(root);
    	 boolean direction=true;
    	 ArrayList<Integer> zagzig=new ArrayList<Integer>();
    	 while(!stackl.isEmpty()||!stackr.empty()){
    		 if(direction){//正向遍历
    			 TreeNode node=stackl.pop();
    			 zagzig.add(node.val);
    			 if(node.left!=null)
    				 stackr.push(node.left);
    			 if(node.right!=null)
    				 stackr.push(node.right);
    			 	//一层遍历完，遍历下一层
    			 if(stackl.empty()){
    				 direction=false;
    				 order.add(zagzig);
    				 zagzig=new ArrayList<Integer>();
    		 }
    		}else{
    			TreeNode node=stackr.pop();
    			 zagzig.add(node.val);
    			 if(node.right!=null)
    				 stackl.push(node.right);
    			 if(node.left!=null)
    				 stackl.push(node.left);
    			 if(stackr.empty()){
    				 direction=true;
    				 order.add(zagzig);
    				 zagzig=new ArrayList<Integer>();
    		 }
    		}
    	 }
    	 return order;
    }
}
