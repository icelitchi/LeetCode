package ds.tree.bs;

import java.util.Comparator;

import ds.tree.bs.RedBlackTree.COLOR;
//http://zh.wikipedia.org/wiki/%E7%BA%A2%E9%BB%91%E6%A0%91
public class RedBlackTree<E> {
	private RedBlackTreeNode<E> root;
	private Comparator<? super E> comparator;
	public RedBlackTree(Comparator<? super E> c){
		this.comparator=c;
	}
	public boolean insert(E e){
		if(root==null){
			root=new RedBlackTreeNode<E>(e,null);
			root.color=COLOR.BLACK;
			return true;
		}else{
			RedBlackTreeNode<E> key=root;
			while(key!=null){
				if(comparator.compare(key.val, e)==0)
				{
					return false;
				}else if(comparator.compare(key.val, e)>0){
					if(key.left!=null){
						key=key.left;
					}else{
						key.left=new RedBlackTreeNode<E>(e,key);
						if(key.color==COLOR.RED)
							insert_balance(key.left);
					}
				
				}else{
					if(key.right!=null){
						key=key.right;
					}else{
						key.right=new RedBlackTreeNode<E>(e,key);
						if(key.color==COLOR.RED)
							insert_balance(key.right);
					}
				}
			}
		}
		return false;
	}
	private void insert_balance( RedBlackTreeNode<E> node){

		RedBlackTreeNode<E> parent=parent(node);
	
		if(parent==null){//1 node 为根节点
			node.color=COLOR.BLACK;
		}else if(parent.color==COLOR.BLACK){//2 父节点 黑 不需要调整
			return;
		}else{//3 父节点 红
			RedBlackTreeNode<E> uncle=this.uncle(node);
			if(uncle!=null&&uncle.color==COLOR.RED){ //3.1 父节点  红 ；叔节点 红
				parent.color=COLOR.BLACK;
				parent.parent.color=COLOR.RED;
				uncle.color=COLOR.BLACK;
				insert_balance(parent.parent);
			}else{ //3.2 父红 ；叔 黑 或 null
				if(parent==parent.parent.left){//3.2.1
					if(node==parent.right){//左右
						rotate_left(parent);
					}else{//左左
						rotate_right(parent.parent);
					}			
				}else{//3.2.2 与 3.2.1 对称
					if(node==parent.left){//右左
						rotate_right(parent);
					}else{//右右
						rotate_left(parent.parent);
					}	
				}
			}
		}	
	}
	public boolean delete(E e){
		RedBlackTreeNode<E> key=root;
		while(key!=null){
			if(comparator.compare(key.val, e)==0){
				_delete(key);
				return true;
			}else if(comparator.compare(key.val, e)>0){
				key=key.left;
			}else{
				key=key.right;
			}
		}
		return false;
	}
	//只做delete 不做delete之后的balance
	//TODO::
	private void _delete(RedBlackTreeNode<E> node){
		//双子女
		if(node.left!=null&&node.right!=null){
			RedBlackTreeNode<E> sl=node.left;
			while(sl.right!=null)
				sl=sl.right;
			E temp=sl.val;
			sl.val=node.val;
			node.val=temp;
			_delete(sl);
		}else {//单或无子女
			if(node.color==COLOR.RED){//红(一定为无子女)
				if(node.parent!=null){
					if(node.parent.left==node)
						node.parent.left=null;
					else
						node.parent.right=null;
				}else{
					root=null;
				}
			}
			else{//黑
				
				if(node.left!=null&&node.left.color==COLOR.RED){//单 左子女 红(删除后，将子改黑,作为父的子)
					if(node.parent.left==node){
						node.parent.left=node.left;}
					else {
						node.parent.right=node.left;}
				}else if(node.right!=null&&node.right.color==COLOR.RED){//单 右子女 红(删除后，将子改黑,作为父的子)
					if(node.parent.left==node){
						node.parent.left=node.right;}
					else {
						node.parent.right=node.right;}
				}else {//黑，无子女
					if(node.parent==null){
						root=null;
					}else{
						if(node.parent.color==COLOR.RED){//父 红
							node.parent.color=COLOR.BLACK;
							if(node==node.parent.left){
								node.parent.left=null;
								node.parent.right.color=COLOR.RED;
							}else{
								node.parent.right=null;
								node.parent.left.color=COLOR.RED;
							}
						}//end 父 红
						else{//父 黑
							RedBlackTreeNode<E> slibing;
							if(node==node.parent.left){
								slibing=node.parent.right;
								if(slibing.color==COLOR.RED){//右兄弟 红
									rotate_left(node.parent);
									_delete(node);
								}else{//右兄弟 黑
									node.parent.right.color=COLOR.RED;
									node.parent.left=null;
									balance_delete(node.parent);
								}
							}else{
								slibing=node.parent.left;
								if(slibing.color==COLOR.RED){//左兄弟 红
									rotate_right(node.parent);
									_delete(node);
								}else{//左兄弟 黑
									node.parent.left.color=COLOR.RED;
									node.parent.right=null;
									balance_delete(node.parent);
								}
							}		
						}//end 父黑
					}
				}
			}//end 黑
		}//end 单或无子女
	}
	//TODO::
	private void balance_delete(RedBlackTreeNode<E> node){
		
	}
	private void rotate_right(RedBlackTreeNode<E> root){
		RedBlackTreeNode<E> privot=root.left;
		//
		E e=root.val;
		root.val=privot.val;
		privot.val=e;
		//
		root.left=privot.left;
		if(root.left!=null)
			root.left.parent=root;
		privot.left=privot.right;
		
		privot.right=root.right;
		if(privot.right!=null)
			privot.right.parent=privot;
		
		root.right=privot;
		//

	
	}
	private void rotate_left(RedBlackTreeNode<E> root){
		RedBlackTreeNode<E> privot=root.right;
		//
		E e=root.val;
		root.val=privot.val;
		privot.val=e;
		//
		root.right=privot.right;
		if(root.right!=null)
			root.right.parent=root;
		privot.right=privot.left;
		
		privot.left=root.left;
		if(privot.left!=null)
			privot.left.parent=privot;
		
		root.left=privot;
	//	if(privot!=null)
	//		privot.parent=root;
		

		
	}
	private RedBlackTreeNode<E> parent(RedBlackTreeNode<E> node){
		return node.parent;
	}
	private RedBlackTreeNode<E> uncle(RedBlackTreeNode<E> node){
		if(node.parent==null)
			return null;
		if(node.parent.left==node)
			return node.parent.right;
		else 
			return node.parent.left;
	}
	public static enum COLOR{
		BLACK,
		RED;
	}
}
class RedBlackTreeNode<E>{
	
	RedBlackTreeNode<E> left,right;
	RedBlackTreeNode<E> parent;
	E val;
	COLOR color;
	RedBlackTreeNode(E e, RedBlackTreeNode<E> parent){
		this.val=e;
		this.color=COLOR.RED;
		this.left=null;
		this.right=null;
		this.parent=parent;
	}

}