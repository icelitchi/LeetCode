package ds.tree;

public class MinHeap<E> {

	
}
class HeapNode<E>{
	E val;
	HeapNode<E> left;
	HeapNode<E> right;
	public HeapNode(E e){
		this.val=e;
		this.left=null;
		this.right=null;
	}
}