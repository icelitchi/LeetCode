package LeetCode;

import java.util.ArrayList;

//http://blog.csdn.net/sunjilong/article/details/8263151
//中序遍历//逆序的两个
//栈是n
//用 递归 实现   space constant
public class RecoverBinarySearchTree {

	public static void main(String[] args) {

	}
    public void recoverTree(TreeNode root) {
    	if(root==null)
    		return;
    	ArrayList<TreeNode> inorder=new ArrayList<TreeNode>();
    	inordervisit(root,inorder);
    	int first=-1,second=-1;
    	TreeNode pre=inorder.get(0);
    	for(int i=1;i<inorder.size();i++){
    		TreeNode current=inorder.get(i);
    		if(pre.val>current.val){
    			if(first==-1)
    				first=i-1;
    			else
    				second=i;
    		}
    		
    			pre=current;
    	}
    	
    	if(second==-1){
    		int val1=inorder.get(first).val;
    		int val2=inorder.get(first+1).val;
    		inorder.get(first).val=val2;
    		inorder.get(first+1).val=val1;
    	}else
    	{
    		int val1=inorder.get(first).val;
    		int val2=inorder.get(second).val;
    		inorder.get(first).val=val2;
    		inorder.get(second).val=val1;
    	}
    }
    void inordervisit(TreeNode root ,ArrayList<TreeNode> inorder){
    	
    	if(root.left!=null){
    		inordervisit(root.left,inorder);
    	}
    	inorder.add(root);
    	if(root.right!=null){
    		inordervisit(root.right,inorder);
    	}
    }
    
}
