package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
   
    	ArrayList<Integer> inorderlist=new ArrayList<Integer>();
    	if(root==null)
    		return inorderlist;
    	Stack<TreeNode> stack=new Stack<TreeNode>();
  
    	
    	TreeNode node=root;
    	while(!stack.empty()||node!=null){
    	
    		while(node!=null){
    			stack.add(node);
    			node=node.left;
    		}
    		 node=stack.pop();
    		 inorderlist.add(node.val);
    		 node=node.right;

    	}
        return inorderlist;
    }

}
