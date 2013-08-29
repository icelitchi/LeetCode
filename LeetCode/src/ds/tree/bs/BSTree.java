package ds.tree.bs;

import java.util.Comparator;


//非递归实现
public class BSTree<E> {
	private TreeNode<E> root;
	private Comparator<? super E> comparator;

	public BSTree(Comparator<? super E> c) {
		this.comparator = c;
	}

	public Comparator<? super E> comparator() {
		return comparator;
	}

	public TreeNode<E> root() {
		return root;
	}

	//已存在e值，返回false
	//else 在适当的位置插入e,返回true
	public boolean insert(E e) {
		// 非递归 实现
		TreeNode<E> key = root;
		TreeNode<E> newNode = new TreeNode<E>(e);
		if(key==null)
		{
			root=newNode;
			return true;
		}
		while (true) {
			if (comparator.compare(key.val, e) > 0) {
				if (key.left == null) {
					key.left = newNode;
					break;
				} else
					key = key.left;
			} else if (comparator.compare(key.val, e) < 0) {
				if (key.right == null) {
					key.right = newNode;
					break;
				} else
					key = key.right;
			} else {
				return false;
			}

		}
		return true;
	}

	//存在e，删除节点，返回true
	//不存在e，返回false
	public boolean delete(E e) {
		TreeNode<E> pkey = null;//key 的 parent 节点
		TreeNode<E> key = root;//从root 开始比较，和e比较的节点key
		while (true) {
			if (comparator.compare(key.val, e) == 0) {//e == key.val
				_delete(key, pkey);
				return true;
			} else if (comparator.compare(key.val, e) > 0) { //e < key.val
				if (key.left == null)
					return false;
				else {
					pkey = key;
					key = key.left;
				}
			} else if (comparator.compare(key.val, e) < 0) {//e > key.val
				if (key.right == null)
					return false;
				else {
					pkey = key;
					key = key.right;
				}
			}
		}

	}

	//如果 node中记录 parent的信息，删除操作就比较简单
	public boolean delete(TreeNode<E> node) {
		TreeNode<E> pkey = null;
		TreeNode<E> key = root;
		while (true) {
			if (key.equals(node)) {
				_delete(key, pkey);
				return true;
			} else if (comparator.compare(key.val, node.val) > 0) {
				if (key.left == null)
					return false;
				else {
					pkey = key;
					key = key.left;
				}
			} else if (comparator.compare(key.val, node.val) < 0) {
				if (key.right == null)
					return false;
				else {
					pkey = key;
					key = key.right;
				}
			}
		}
	}

	//找到返回treeNode
	//无匹配e，返回null
	public TreeNode<E> search(E e) {
		// 非递归 实现
		TreeNode<E> key = root;
		while (true) {
			if (comparator.compare(key.val, e) > 0) {
				if (key.left == null) {
					break;
				} else
					key = key.left;
			} else if (comparator.compare(key.val, e) < 0) {
				if (key.right == null) {
					break;
				} else
					key = key.right;
			} else {
				return key;
			}
		}
		return null;
	}

	private void _delete(TreeNode<E> node, TreeNode<E> pnode) {//pnode 为node的parent 节点
		TreeNode<E> res=node;
		if(node.left==null){//左子树空
			res=node.right;
		}else if(node.right==null){//右子树空
			res=node.left;
		}else{//左右字数都不空，将node的值改为左子树中的最大值，将做大值节点删除
			res=node;
			TreeNode<E> temp=node.left;
			if(temp.right==null){
				node.val=node.left.val;
				node.left=node.left.left;
			}else{
				while(temp.right!=null&&temp.right.right!=null){
					temp=temp.right;
				}
					node.val=temp.right.val;
					temp.right=temp.right.left;
			}
			
		}
		if(pnode==null)//node 为 根节点
			this.root=res;
		else if(node.equals(pnode.left)){//node 为 left child
			pnode.left=res; 
		}else { //node 为 right child
			pnode.right=res;
		}
	}
	public void printTree() {
		printTree(root);
		}
	private void printTree(TreeNode<E> root) {
	
			
	
        	System.out.print("[");
        	System.out.print(root==null?"#":root.val);
        	if(root!=null){
        	printTree(root.left);
        	System.out.print(" , ");
        	printTree(root.right);
        	}
        	System.out.print("]");
        
	}
	public  static void main(String[] args){
		BSTree<Integer> tree=new BSTree<Integer>(new Comparator<Integer> (){
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}});
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		tree.insert(2);
		tree.insert(5);
		tree.insert(7);
		tree.insert(-3);
		tree.insert(-2);
		tree.insert(-1);
		tree.delete(7);
		tree.delete(1);
		tree.printTree();
	}
}
