package LeetCode;

public class ConstructBinaryTreeInorderPostorderTraversal {

	public static void main(String[] args) {


	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder==null||inorder.length==0)
    		return null;
   
        return buildTree(inorder,0,inorder.length,postorder,0,postorder.length);
    }
    TreeNode buildTree(int[] inorder,int start1,int end1, int[] postorder,int start2,int end2) {
    	TreeNode root=new TreeNode(postorder[end2]);
    	if(start1==end1)
    		return root;
    	
    	int rootValue=postorder[end2];
    	int inRootIndex=start1;
    	for(int i=start2;i<=end1;i++){
    		if(inorder[i]==rootValue){
    			inRootIndex=i;
    			break;
    		}
    	}
    	
    	int leftTreeSize=inRootIndex-start1;
    	int rightTreeSize=end1-inRootIndex;
    	if(leftTreeSize>0)
    		root.left=buildTree(inorder,start1,inRootIndex-1,postorder,start2,start2+leftTreeSize-1);
    	if(rightTreeSize>0)
    		root.left=buildTree(inorder,inRootIndex+1,end1,postorder,start2+leftTreeSize,end2-1);
    	return root;
        
    }
}
