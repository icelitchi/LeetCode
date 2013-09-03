package LeetCode;


//递归
//非递归  not done
public class ConstructBinaryTreePreorderInorderTraversal {


	public static void main(String[] args) {


	}
	//前 1245367
	//中4251637
    public TreeNode buildTree(int[] preorder, int[] inorder) { 
    	if(preorder==null||preorder.length==0)
    		return null;
    	return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }
    TreeNode buildTree(int[] preorder,int start1,int end1,  int[] inorder,int start2,int end2){
    	TreeNode root=new TreeNode(preorder[start1]);
    	if(start1==end1){
    		return root;
    	}
    	int rootValue=preorder[start1];
    	int inRootIndex=start2;
    	for(int i=start2;i<=end2;i++){
    		if(inorder[i]==rootValue){
    			inRootIndex=i;
    			break;
    		}
    	}
    	int leftTreeSize=inRootIndex-start2;
    	int rightTreeSize=end2-inRootIndex;
    	if(leftTreeSize>0)
    		root.left=buildTree(preorder,start1+1,start1+leftTreeSize,inorder,start2,inRootIndex-1);
    	if(rightTreeSize>0)
        	root.right=buildTree(preorder,start1+leftTreeSize+1,start1+leftTreeSize+rightTreeSize,inorder,inRootIndex+1,end2);
        	
    	
    	return root;
    }
    

}
