package LeetCodeDone;

public class BalancedBinaryTree {

	   public boolean isBalanced(TreeNode root) {
		   if(_isBalanced(root)==-1)
			   return false;
		   else 
			   return true;
	        
	    }
	 //not balanced return -1
	   // balanced return hight
	  private int _isBalanced(TreeNode root){
		  if(root==null)
			  return 0;
		  int left=_isBalanced(root.left);
		  int right=_isBalanced(root.right);
		  if(left==-1||right==-1)
			  return -1;
		  if(Math.abs(left-right)<=1)
			  return Math.max(left, right)+1;
		  else 
			  return -1;
	  }

}
