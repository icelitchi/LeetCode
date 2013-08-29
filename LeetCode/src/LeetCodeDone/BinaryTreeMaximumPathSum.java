package LeetCodeDone;

public class BinaryTreeMaximumPathSum {
    int maxPath=0;
    public int maxPathSum(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
         if(root!=null)
         maxPath=root.val;
		   longestPath( root);
		   return maxPath;
	        
	    }
	/**
	 * @param args
	 */
	   int longestPath(TreeNode root){
		   if(root==null)
			   return 0;
		   
		  int  left= longestPath( root.left);
		  int  right= longestPath( root.right);
		  if(left+right+root.val>maxPath)
			  maxPath=left+right+root.val;
       if(right+root.val>maxPath)
 		  maxPath=right+root.val;
       if(left+root.val>maxPath)
 		  maxPath=left+root.val;
       if(root.val>maxPath)
     	  maxPath=root.val;
          int max= left>right?(root.val+left):(root.val+right);
           max=max>root.val?max:root.val;
		  return max;
	   }

}

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }