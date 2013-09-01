package LeetCode;

//判断树是否镜像
public class SymmetricTree {

	public static void main(String[] args) {
	}
    public boolean isSymmetric(TreeNode root) {

        if(root==null)
        	return true;
        return isSymmetric(root.left,root.right);
    }
    boolean isSymmetric(TreeNode left,TreeNode right) {
    	if(left==null&&right==null)
    		return true;
    	if(left!=null&&right!=null&&left.val==right.val){	
    			return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    	}
        return false;
    }
}
