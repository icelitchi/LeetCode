package LeetCode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
  
    	if(null==p||null==q)
    		return p==q;
    	else
    		return q.val==p.val&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
      
    }
}
