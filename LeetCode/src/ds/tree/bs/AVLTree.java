package ds.tree.bs;

import java.util.Comparator;
import java.util.Stack;


//得用递归或者栈实现 ：栈
//记录height 或者 balance的值： height
public class AVLTree<E> {

	private AVLTreeNode<E> root;
	private Comparator<? super E> comparator;

	public AVLTree(Comparator<? super E> comparator) {
		this.comparator = comparator;
	}

	public boolean delete(AVLTreeNode<E> node) {
		//TODO
		return false;
	}
	//没有e 返回false
	//已有e ，删除e，返回true
	//用栈记录走过的节点
	public boolean delete(E e) {
		Stack<AVLTreeNode<E>> stack=new Stack<AVLTreeNode<E>> ();
		AVLTreeNode<E> key=root;
		if(key==null)
			return false;
		
		while(true){
			if(comparator.compare(key.val, e)==0){
				_delete(key,stack);
				//需要对stack 中的 tree node 做平衡,如果平衡后 height 没有变 可以终止向上
				while(!stack.isEmpty()){
					// balance the tree
					AVLTreeNode<E> node=stack.pop();
					int hbefore=node.height;
					this.balance(node);
					int hafter=node.height;
					if(hbefore==hafter){
						break;
					}
				}
				return true;
			}else if(comparator.compare(key.val, e)>0){
				if(key.left==null)
					return false;
				else{
					stack.push(key);
					key=key.left;
				}						
			}else{
				if(key.right==null)
					return false;
				else{
					stack.push(key);
					key=key.right;
				}
		}
	}
}

	//已有e 返回false
	//没有e ，插入e，返回true
	public boolean insert(E e) {
		boolean flag=false;
		if (root == null) {
			root = new AVLTreeNode<E>(e);
			flag= true;
		} else{
			flag= this.insert(e, root);
		}
		//this.printTree();
		return flag;
	}
	//递归插入
	//4种情况
	//左左 左右    右右 右左
	private boolean insert(E e, AVLTreeNode<E> c) {
		boolean flag = false;
		AVLTreeNode<E> newNode = new AVLTreeNode<E>(e);

		if (comparator.compare(c.val, e) == 0) {      //c.val == e
			flag = false;
		} else if (comparator.compare(c.val, e) > 0) {//c.val > e 左
			if (c.left == null) {
				c.left = newNode;
				flag = true;
			} else {
				flag = insert(e, c.left);
				int balance = this.getBalance(c);
				if (balance >= 2) {
					if(this.getBalance(c.left)>0)//左左 右旋
					{
						rotate_right(c);
					}else{            //左右  左旋右旋
						rotate_left(c.left);
						rotate_right(c);
					}
				}
			}
		} else {                                  //c.val < e 右
			if (c.right == null) {
				c.right = newNode;
				flag=true;
			} else {
				flag = insert(e, c.right);
				int balance = this.getBalance(c);
				if (balance <= -2) {
					if(this.getBalance(c.right)<0){ //右右 左旋
						rotate_left(c);
					}
					else{                       //右左 右旋 左旋
						rotate_right(c.right);
						rotate_left(c);
					}
				}
			}
		}

		if(flag)
		c.height=calHight(c);
		
		return flag;
	}

	public AVLTreeNode<E> search() {
		return null;
		//TODO
	}

	public void printTree() {
		printTree(root);
		System.out.println();
	}

	//
	//node 有 双子女,找 前驱 或者 后继 ：前驱
	//node 有 单子女，单子女一定是 只有一个节点
	//node 无 子女
	//return false ，不需要向上回溯 平衡树
	//return true ,需要向上回溯 平衡树
	private void _delete(AVLTreeNode<E> node, 	Stack<AVLTreeNode<E>> travalledStack) {

		if(node.left==null&&node.right==null){//无子女
			if(travalledStack.isEmpty())//删根节点
				this.root=null; 
			else{
				AVLTreeNode<E> pnode=travalledStack.peek();
				if(node.equals(pnode.left)){
					pnode.left=null;
				}else{
					pnode.right=null;
				}
			}
		}else if(node.left==null){//单 右子女 
			node.val=node.right.val;
			node.right=null;
		}else if(node.right==null){//单 左子女
			node.val=node.left.val;
			node.left=null;
		}else{//双子女
			travalledStack.push(node);
			AVLTreeNode<E> key=node.left;
			while(key.right!=null){
				travalledStack.push(key);
				key=key.right;
			}
			node.val=key.val;
			AVLTreeNode<E> pnode=travalledStack.peek();
			if(node==pnode.left){
				pnode.left=node.right;
			}else{
				pnode.right=node.right;
			}		
		}
	}

	private void printTree(AVLTreeNode<E> root) {
		if(root==null)
			System.out.print("#");
		else{
			System.out.print(root.val);
			System.out.print("[");
			printTree(root.left);
			System.out.print("],[");
			printTree(root.right);
			System.out.print("]");
		}
	}
	private void rotate_right(AVLTreeNode<E> root){
		AVLTreeNode<E> privot=root.left;
		//
		E e=root.val;
		root.val=privot.val;
		privot.val=e;
		//
		root.left=privot.left;
		privot.left=privot.right;
		privot.right=root.right;
		root.right=privot;
		//
		privot.height=calHight(privot);
		root.height=calHight(root);
	}
	private void rotate_left(AVLTreeNode<E> root){
		AVLTreeNode<E> privot=root.right;
		//
		E e=root.val;
		root.val=privot.val;
		privot.val=e;
		//
		root.right=privot.right;
		privot.right=privot.left;
		privot.left=root.left;
		root.left=privot;
		//
		privot.height=calHight(privot);
		root.height=calHight(root);
		
	}
	private int getBalance(AVLTreeNode<E> c){
		return (c.left!=null?c.left.height:0) - (c.right!=null?c.right.height:0);
		
	}
	private int calHight(AVLTreeNode<E> root){
		int lh=root.left!=null?root.left.height:0;
		int rh=root.right!=null?root.right.height:0;
		return (lh) >(rh)?(lh+1):(rh+1);
	}
	private void balance(AVLTreeNode<E> c){
		if(c==null)
			return;
		BalanceType type=this.getBalanceType(c);
		switch(type){
			case Balanced :
				break;
			case LL:
				rotate_right(c);
				break;
			case LR:
				rotate_left(c.left);
				rotate_right(c);
				break;
			case LB:
				rotate_right(c);
				break;
			case RR:
				rotate_left(c);
				break;
			case RL:
				rotate_right(c.right);
				rotate_left(c);
				break;
			case RB:
				rotate_left(c);
				break;
		}
		c.height=calHight(c);
	}
	//树不平衡的类型
	private BalanceType getBalanceType(AVLTreeNode<E> c){
		BalanceType type=BalanceType.Balanced;
		int balance=this.getBalance(c);
		if(balance<2&&balance>-2)//平衡
			type= BalanceType.Balanced;
		else if(balance>=2){//不平衡 左树高
			switch(this.getBalance(c.left)){
			case 1:
				type=BalanceType.LL; //左树的左子树高 单旋
				break;
			case -1:
				type=BalanceType.LR;//左树的右子树高 双旋
				break;
			case 0:
				type=BalanceType.LB;//左树的左右字树一样高 同LL处理，单旋
				break;
			}
		}else{//不平衡  右树高
			switch(this.getBalance(c.right)){
			case 1:
				type=BalanceType.RL;//右树的左子树高 单旋
				break;
			case -1:
				type=BalanceType.RR;//右树的右子树高 双旋
				break;
			case 0:
				type=BalanceType.RB;//右树的左右字树一样高 单旋
				break;
			}
		}
		
		return type;
	}
	private enum BalanceType {
		Balanced,
		LB,
		LL,
		LR,
		RB,
		RR,
		RL;
	}
public static void main(String[] args){
	AVLTree<Integer> avltree=new AVLTree<Integer>(new Comparator<Integer> (){
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(o1, o2);
		}});
	
	avltree.insert(11);
	//avltree.printTree();
	avltree.insert(6);
	avltree.insert(9);
	avltree.insert(7);
	avltree.insert(8);
	avltree.insert(22);
	avltree.insert(15);
	avltree.insert(12);
	avltree.insert(14);
	avltree.insert(16);
	avltree.insert(23);
	avltree.insert(26);
	avltree.insert(13);
	avltree.insert(33);
	avltree.insert(21);
	avltree.printTree();
	avltree.delete(21);
	avltree.printTree();
	avltree.delete(16);
	avltree.printTree();
	
}
}
