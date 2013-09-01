package LeetCode;

public class MaximumDepthofBinaryTree {

	public static void main(String[] args) {

	}
    public int maxDepth(TreeNode root) {

        return maxDepthR(root);
    }
    int maxDepthR(TreeNode root){
    	if(root==null)
    		return 0;
    	int l=maxDepthR(root.left);
    	int r=maxDepthR(root.right);
    	return l>r?(l+1):(r+1);
    }
}
