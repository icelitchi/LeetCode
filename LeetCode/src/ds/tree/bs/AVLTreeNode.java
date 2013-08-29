package ds.tree.bs;

public class AVLTreeNode<E> {
	int height;
	E val;
	AVLTreeNode<E> left;
	AVLTreeNode<E> right; 
	AVLTreeNode(E e){
		this.val=e;
		this.height=1;
		this.left=null;
		this.right=null;
	}
	
}
