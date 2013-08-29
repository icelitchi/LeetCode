package LeetCode;


public class SumRootLeafNumbers {
	public int sum(TreeNode root) {
		int sum = visit(root, 0, 0);

		return sum;
	}

	int visit(TreeNode root, int sum, int number) {
		if(root==null)
			return sum;
		if (root.left == null && root.right == null) {
			sum = sum+number * 10 + root.val;

		}
		if (root.left != null) {
			sum = visit(root.left, sum, number * 10 + root.val);
		}
		if (root.right != null) {
			sum = visit(root.right, sum, number * 10 + root.val);
		}
		return sum;
	}
	public  static void main(String[] args){
		SumRootLeafNumbers r=new SumRootLeafNumbers();
	
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		t1.left=t2;
		t1.right=t3;
		int sum=r.sum(t1);
System.out.println(sum);
	}
}

