package LeetCode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {

	}
	  public TreeNode sortedArrayToBST(int[] num) {
	
		  if(num==null||num.length==0)
			  return null;
		  
		 return  sortedArrayToBST(num,0,num.length-1);
	        
	    }
	  
	  TreeNode sortedArrayToBST(int[] num, int startIndex,int endIndex){
		  if(startIndex>endIndex)
			  return null;

		  
		  int mid=(startIndex+endIndex+1)>>>1;
		  TreeNode root=new TreeNode(num[mid]);
		  root.left=sortedArrayToBST(num,startIndex,mid-1);
		  root.right=sortedArrayToBST(num,mid+1,endIndex);
		  return root;
	  }
}
