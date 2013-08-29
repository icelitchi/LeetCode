package LeetCode;





public class BinaryTreeToLinkedList {
	   public void flatten(TreeNode root) {
		   subFlattern( root);
	        
	   }
	   TreeNode  subFlattern(TreeNode root){
		   if(root==null)			   
		   return null;
		   
		 
		   TreeNode left=subFlattern(root.left);
		   TreeNode right;
		   if(left!=null)
			   right= subFlattern(root.right);
		   else{
			   right= subFlattern(root.right);
		   }
		   if(root.left!=null){
			   left.right=root.right;
			   root.right=root.left;
		   }
		   
		  if(right!=null)
			  return right;
		  else
			  return root;
	   }
}
