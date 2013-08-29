package ds.tree.bs;

import java.util.Comparator;
//保持二叉搜索树的性质，不保持平衡
//find 或 insert的节点调整到root
//
public class SplayTree<E> {
private SplayTreeNode<E> root;
private Comparator<? super E> comparator;
public SplayTree(Comparator<? super E> c){
	this.comparator=c;
}
public boolean insert(E e){
	if(root==null){
		root=new SplayTreeNode<E>(e);
		return true;
	}
	
	SplayTreeNode<E> key=root;
	while(key!=null){
		if(comparator.compare(key.val, e)==0){
			splay(key);
			return false;
		}else if(comparator.compare(key.val, e)>0){
			if(key.left==null){
				key.left=new SplayTreeNode<E>(e);
				splay(key.left);
				return true;
			}else{
				key=key.left;
			}
		}else{
			if(key.right==null){
				key.right=new SplayTreeNode<E>(e);
				splay(key.right);
				return true;
			}else{
				key=key.right;
			}
				
		}
	}
	return false;
}
//not found return null
public SplayTreeNode<E> find(E e){
	 SplayTreeNode<E> key=root;
	while(key!=null){
		if(comparator.compare(key.val, e)==0){
			splay(key);
			return root;
		}else if(comparator.compare(key.val, e)>0){
			key=key.left;
		}else{
			key=key.right;
		}
	}
	return null;
}
public boolean delete(E e){
	 SplayTreeNode<E> key=root;
	 SplayTreeNode<E> pkey=null;
		while(key!=null){
			if(comparator.compare(key.val, e)==0){			
				_delete(key,pkey);
			}else if(comparator.compare(key.val, e)>0){
				pkey=key;
				key=key.left;
			}else{
				pkey=key;
				key=key.right;
			}
		}
	return false;
}
//splay the node to root
//node val < root val, 右旋
//node val > root val, 左旋
//node val = root val, 停止
private void splay(SplayTreeNode<E> node){
	E e=node.val;
	while(comparator.compare(e, root.val)!=0){
		if(comparator.compare(e,root.val)>0){
			if(comparator.compare(e,root.right.val)<0){
				rotateRight(root.right);
			}
			rotateLeft(root);
		}else{
			if(comparator.compare(e,root.left.val)>0){
				rotateLeft(root.left);
			}
			rotateRight(root);
		}
	}
}
private void rotateRight(SplayTreeNode<E> node){
	SplayTreeNode<E> privot=node.left;
	E temp=privot.val;
	
	privot.val=node.val;
	node.val=temp;
	
	node.left=privot.left;
	privot.left=privot.right;
	privot.right=node.right;
	node.right=privot;
	
}
private void rotateLeft(SplayTreeNode<E> node){
	SplayTreeNode<E> privot=node.right;
	E temp=privot.val;
	
	privot.val=node.val;
	node.val=temp;
	
	node.right=privot.right;
	privot.right=privot.left;
	privot.left=node.left;
	node.left=privot;
}

private void _delete(SplayTreeNode<E> node, SplayTreeNode<E> pnode) {//pnode 为node的parent 节点
	SplayTreeNode<E> res=node;
	if(node.left==null){//左子树空
		res=node.right;
	}else if(node.right==null){//右子树空
		res=node.left;
	}else{//左右字数都不空，将node的值改为左子树中的最大值，将做大值节点删除
		res=node;
		SplayTreeNode<E> temp=node.left;
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
}
class SplayTreeNode<E>{
	 E val;
	 SplayTreeNode<E> left;
	 SplayTreeNode<E> right;
//	 SplayTreeNode<E> parent;
	 SplayTreeNode(E e){
		 this.val=e;
		 this.right=null;
		 this.left=null;
	 }
} 