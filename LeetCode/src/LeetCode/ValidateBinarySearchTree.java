package LeetCode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {

	}
	//！！！注意 左树 *所有* 的值都要<root ！！！！ 右树所有的值 都要>root 左右 和 右左 子树
	//所以都有一个范围
	   public boolean isValidBST(TreeNode root) {
		   if(root==null)
			   return true;

		return isLeftTreeValidBST(root.val,null,root.left)&&isRightTreeValidBST(null,root.val,root.right);
	    }
	   boolean isLeftTreeValidBST(Integer max,Integer min, TreeNode root){
		  if(root==null)
			  return true;
		  if(root.val>=max)
			  return false;
		  if(min!=null&&root.val<=min){
			  return false;
		  }
		  if(!isLeftTreeValidBST(root.val,min,root.left)||!isRightTreeValidBST(max,root.val,root.right)){
			  return false;
		  }
		  return true;
	   }
	   boolean isRightTreeValidBST(Integer max,Integer min, TreeNode root){
		  if(root==null)
			  return true;
		  if(root.val<=min)
			  return false;
		  if(max!=null&&root.val>=max)
			  return false;

		  if(!isLeftTreeValidBST(root.val,min,root.left)||!isRightTreeValidBST(max,root.val,root.right)){
			  return false;
		  }
		  return true;
	   }
}
