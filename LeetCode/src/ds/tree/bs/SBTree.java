package ds.tree.bs;

import java.util.Comparator;
import java.util.Stack;
//http://www.nocow.cn/index.php/Size_Balanced_Tree
//size balanced tree
//定义递归满足：
// size(l)>= size(rl) size(rr)
// size(r)>= size(ll) size(lr)


//实现 insert的时候 递归 不错
//实现 delete的时候 栈 更方便
public class SBTree<E> {
	private SBTreeNode<E> root;
	private Comparator<? super E> comparator;

	public SBTree(Comparator<? super E> c) {
		this.comparator = c;
	}

	//需要向上 维持树的平衡，所以可以用递归或者栈：递归
	
	public boolean insert(E e) {
		boolean flag = false;

		if(root==null){
			root=new SBTreeNode<E> (e);
			flag=true;
		}else{
			flag=insert(e,root);		
		}		
		return flag;
	}

	private boolean insert(E e,SBTreeNode<E> c){
		boolean flag=false;
		if(comparator.compare(c.val, e)==0){
			flag=false;
		}else if(comparator.compare(c.val, e)>0){
			if(c.left==null){
				c.left=new SBTreeNode<E> (e);
			}else{
				flag=insert(e,c.left);
			}
		}else{
			if(c.right==null){
				c.right=new SBTreeNode<E> (e);
			}else{
				flag=insert(e,c.right);
			}
		}
		
		if(flag==true){
			c.size++;
			maintain(c);
		}
			
		return flag;
	}
	
	public boolean delete(E e) {
		boolean flag = false;
		Stack<SBTreeNode<E>> stack=new Stack<SBTreeNode<E>>();

			SBTreeNode<E> key=root;
			while(key!=null){
				if(this.comparator.compare(key.val, e)==0){	
					_delete(key,stack);
					while(!stack.isEmpty()){
						SBTreeNode<E> node=stack.pop();
						int sbefore=node.size;
						this.maintain(node);
						int safter=node.size;
						if(sbefore==safter){
							break;
						}	
					}
					return true;
				}else if(this.comparator.compare(key.val, e)>0){
					stack.push(key);
					key=key.left;
				}else{
					stack.push(key);
					key=key.right;
				}
			}	
		return flag;
	}
	//找前驱，或者后继
	//BS 通用， 父类实现
	private void _delete(SBTreeNode<E> node,Stack<SBTreeNode<E>> stack){
		if(node.left==null&&node.right==null){//无子女
			if(stack.isEmpty())//删根节点
				this.root=null; 
			else{
				SBTreeNode<E> pnode=stack.peek();
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
			stack.push(node);
			SBTreeNode<E> key=node.left;
			while(key.right!=null){
				stack.push(key);
				key=key.right;
			}
			node.val=key.val;
			SBTreeNode<E> pnode=stack.peek();
			if(node==pnode.left){
				pnode.left=node.right;
			}else{
				pnode.right=node.right;
			}		
		}
	}
	public void printTree() {
		printTree(root);
		System.out.println();
	}
	private void printTree(SBTreeNode<E> root) {
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
	private void maintain(SBTreeNode<E> c) {
		if(c==null)
			return;
		BalanceType type = this.getBalanceType(c);
		switch (type) {
		case balanced:
			break;
		case L_lt_RR:
			rotate_left(c);
			maintain(c.left);
			maintain(c);
			break;	
		case L_lt_RL:
			rotate_right(c.right);
			rotate_left(c);
			maintain(c.left);
			maintain(c.right);
			maintain(c);
			break;
		case R_lt_LL:
			rotate_right(c);
			maintain(c.right);
			maintain(c);
			break;	
		case R_lt_LR:
			rotate_left(c.left);
			rotate_right(c);
			maintain(c.left);
			maintain(c.right);
			maintain(c);
			break;	
		}
		this.updateSize(c);
	}

	private void rotate_left(SBTreeNode<E> c) {
		if(c==null)
			return;
		SBTreeNode<E> privot = c.right;

		E temp = privot.val;
		privot.val = root.val;
		root.val = temp;

		root.right = privot.right;
		privot.right = privot.left;
		privot.left = root.left;
		root.left = privot;
		
		this.updateSize(privot);
		this.updateSize(root);
	}

	private void rotate_right(SBTreeNode<E> c) {
		if(c==null)
			return;
		SBTreeNode<E> privot = c.left;

		E temp = privot.val;
		privot.val = root.val;
		root.val = temp;

		root.left = privot.left;
		privot.left = privot.right;
		privot.right = root.right;
		root.right = privot;
		
		this.updateSize(privot);
		this.updateSize(root);
		
	}

	private BalanceType getBalanceType(SBTreeNode<E> c) {
		BalanceType type = BalanceType.balanced;
		
		int ls = c.left != null ? c.left.size : 0;
		int lls =(c.left!=null) ? (c.left.left != null ? c.left.left.size : 0):0;
		int lrs = (c.left!=null)?(c.left.right != null ? c.left.right.size : 0):0;

		int rs = c.right != null ? c.right.size : 0;
		int rls =(c.right!=null)? (c.right.left != null ? c.left.left.size : 0):0;
		int rrs = (c.right!=null)?(c.right.right != null ? c.left.right.size : 0):0;

		if (ls < rls) {
			type = BalanceType.L_lt_RL;
		} else if (ls < rrs) {
			type = BalanceType.L_lt_RR;
		} else if (rs < lls) {
			type = BalanceType.R_lt_LL;
		} else if (rs < lrs) {
			type = BalanceType.R_lt_LR;
		}

		return type;
	}

	private void updateSize(SBTreeNode<E> c) {
		int ls = c.left != null ? c.left.size : 0;
		int rs = c.right != null ? c.right.size : 0;
		c.size = ls + rs + 1;
	}

	enum BalanceType {
		balanced, 
		L_lt_RR,
		L_lt_RL, 
		R_lt_LL, 
		R_lt_LR;
	}

	
	
	
	
	public static void main(String[] args){
		SBTree<Integer> avltree=new SBTree<Integer>(new Comparator<Integer> (){
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
	//	avltree.printTree();
		avltree.delete(16);
	//	avltree.printTree();
		
	}
}

class SBTreeNode<E> {
	E val;
	int size;
	SBTreeNode<E> left;
	SBTreeNode<E> right;

	public SBTreeNode(E e) {
		this.val = e;
		this.size = 1;
		left = null;
		right = null;
	}
}
