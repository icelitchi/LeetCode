package LeetCodeDone;

import java.util.Stack;

public class BinaryTreeToLinkedList {
	public void flattenByStack(TreeNode root){
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(root!=null){
			if(root.left!=null){
				if(root.right!=null)
					stack.push(root.right);
				root.right=root.left;
				root.left=null;
				root=root.right;
			}
			else if(root.right!=null){
				root=root.right;
			}else if(!stack.empty()){
				TreeNode next=stack.pop();
				root.right=next;
				root=next;
			}else{
				root=null;
			}
		}
	}
	   public void flatten(TreeNode root) {
		   subFlattern( root);
	        
	   }
	   TreeNode  subFlattern(TreeNode root){
		   if(root==null)			   
			   return null;
		   
		 
		   TreeNode left=subFlattern(root.left);
		   TreeNode right=subFlattern(root.right);
	
		   if(left!=null){
			   left.right=root.right;
			   root.right=root.left;
			   //不要忘记把左子树清空
			   root.left=null;
		   }
		   
		  if(right!=null)
			  return right;
		  else if(left!=null)
			  return left;
		  else
			  return root;
	   }
}