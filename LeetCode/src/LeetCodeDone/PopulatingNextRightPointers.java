package LeetCodeDone;

public class PopulatingNextRightPointers {

	public void connect(TreeLinkNode root) {

		subConnect(root, null);
	}

	//完全二�?�樹
	void subConnect(TreeLinkNode root, TreeLinkNode next) {
		if (root == null)
			return;
		root.next = next;
		subConnect(root.left, root.right);
		if (next != null)
			subConnect(root.right, root.next.left);
		else
			subConnect(root.right, null);
	}
	//�?�完全二�?�樹
	void subConnect2(TreeLinkNode root, TreeLinkNode next) {
		if (root == null)
			return;
		 root.next = next;
		 TreeLinkNode lnext=null;
		 TreeLinkNode rnext=null;
		 TreeLinkNode temp=null;
		 
		 //先找到�?� 兄弟树中下一个，�?一定为root的 next的左�?��?女
		 while(next!=null){
			 if(next.left!=null)
				 temp=next.left;
			 else
				 temp=next.right;
			 if(temp!=null)
				 break;
			 next=next.next;
		 }
		 if(root.right!=null){
			 lnext=root.right;
	          rnext=temp;
				 
			 }
		 else {
			 lnext=temp;
		 }
		
			 //先�?��?�左
		subConnect2(root.right, rnext);
		subConnect2(root.left, lnext);
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
