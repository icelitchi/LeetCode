package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalBottom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		  ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
			if(root==null)
				return result;
		
			  Queue<TreeNode> queue=new  LinkedList<TreeNode>();
			  Queue<TreeNode> nextqueue=new  LinkedList<TreeNode>();
	           queue.add(root);
	           ArrayList<Integer>  currentLevel=new ArrayList<Integer>();
	           while(!queue.isEmpty()){

	        	  //处理node
	        	   TreeNode node=queue.poll();
	        	   currentLevel.add(node.val);
	      
	        	   if(node.left!=null)
	        		   nextqueue.add(node.left);
	        	   if(node.right!=null)
	        		   nextqueue.add(node.right);
	        	   
	        	   if(queue.isEmpty()){
	        		   Queue temp=queue;
	        		   queue=nextqueue;
	        		   nextqueue=temp;
	        		   result.add(0,currentLevel);
	        		   currentLevel=new ArrayList<Integer>();
	        	   }
	        	
	        	   
	           }
	           return result;
	  }

}
