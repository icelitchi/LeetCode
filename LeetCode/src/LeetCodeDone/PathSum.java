package LeetCodeDone;

import java.util.ArrayList;

public class PathSum {

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null)
			return result;
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				ArrayList<Integer> ilist = new ArrayList<Integer>();
				ilist.add(root.val);
				result.add(ilist);
			}
			return result;
		}
		
	//	ArrayList<ArrayList<Integer>> subResult = new ArrayList<ArrayList<Integer>>();
		result.addAll(pathSum( root.left,  sum-root.val));
		result.addAll(pathSum( root.right,  sum-root.val));
		if(result.size()>0){
			for(ArrayList<Integer> list:result){
				list.add(0,root.val);
			}
		}
		return result;

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return sum == root.val;
		
		boolean left = hasPathSum(root.left, sum - root.val);
		if(left==true)
			return true;
		boolean right = hasPathSum(root.right, sum - root.val);
			return right;

	}

}
