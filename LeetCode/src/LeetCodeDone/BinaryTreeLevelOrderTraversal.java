package LeetCodeDone;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	//分层输出
	//！！！ArrayDeque<E> push的时候不能为null
	//！！！LinkedList 也实现了 Deque
	//！！！注意queue 和 stack 的操作不同
	  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		  ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return result;
	
		  Queue<TreeNode> queue=new  LinkedList<TreeNode>();
		  Queue<TreeNode> nextqueue=new  LinkedList<TreeNode>();
           queue.add(root);
           ArrayList<Integer>  currentLevel=new ArrayList<Integer>();
           while(!queue.isEmpty()){

        	  //处理node
        	   TreeNode node=queue.poll();
        	   currentLevel.add(node.val);
      
        	   if(node.left!=null)
        		   nextqueue.add(node.left);
        	   if(node.right!=null)
        		   nextqueue.add(node.right);
        	   
        	   if(queue.isEmpty()){
        		   Queue temp=queue;
        		   queue=nextqueue;
        		   nextqueue=temp;
        		   result.add(currentLevel);
        		   currentLevel=new ArrayList<Integer>();
        	   }
        	
        	   
           }
           return result;
	        
	    }
public static void main(String[] args){
	BinaryTreeLevelOrderTraversal b=new BinaryTreeLevelOrderTraversal();
	TreeNode n1=new TreeNode(1);
	TreeNode n2=new TreeNode(2);
	n1.left=n2;
	b.levelOrder(n1);
}
}
