package ds.tree.b;

import java.util.Comparator;

//关键码就用int表示
public class BTree<Key> {
	private int ways;
	private BTreeNode<Key> root;
	private Comparator<Key> c;

	//constructor
	public BTree(int ways, Comparator<Key> c) {
		this.ways = ways;
		this.c = c;
	}

	//modify
	public boolean insert(Key e) {
		boolean flag=false;
		//if()
		return flag;
	}

	public boolean delete(Key e) {
		boolean flag=false;
		
		return flag;
	}

	private Triple<Key> search(Key e){
		Triple<Key> t=new Triple<Key>();
		return t;
	}
	//getter
	public int getWays() {
		return ways;
	}

	public BTreeNode<Key> getRoot() {
		return root;
	}
	
	//private
}

class BTreeNode<Key> {
	int num;
	BTreeNode<Key> parent;
	BTreeNode<Key>[] ptr;
	Object[] keys;

	@SuppressWarnings("unchecked")
	BTreeNode(int ways) {
		num=0;
		ptr = new BTreeNode[ways];
		keys = new Object[ways - 1];
	}
	
}
class Triple<Key>{
	boolean tag=false;
	int index;
	BTreeNode<Key> node;
	//BTreeNode<Key> r;
	
	
}