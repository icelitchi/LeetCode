package LeetCode;

public class ConvertSortedListtoBinarySearchTree {


	public static void main(String[] args) {

		ConvertSortedListtoBinarySearchTree test=new ConvertSortedListtoBinarySearchTree();
		ListNode head=new ListNode(1);
		ListNode node2=new ListNode(3);
		head.next=node2;
		test.sortedListToBST(head);
	}
	   public TreeNode sortedListToBST(ListNode head) {
	
	    int n=0;
	    ListNode node=head;
	    while(node!=null){
	    	node=node.next;
	    	n++;
	    }
	
	    TreeNode root=sortedListToBST(head,n);
	        return root;
	    }
	   
	   public TreeNode sortedListToBST(ListNode head,int size){
		   if(size==1)
			   return new TreeNode(head.val);
		    if(size==0)
		 		   return null;
		   int mid=size/2;
		   ListNode lnode=head;
		   while(mid>0){
			   lnode=lnode.next;
			   mid--;
		   }
		   TreeNode root=new TreeNode(lnode.val);
		   
		   root.left=sortedListToBST(head,size/2);
		   
		   root.right=sortedListToBST(lnode.next,(size+1)/2-1);
		   
		   return root;
	   }

}
