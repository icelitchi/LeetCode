package LeetCodeDone;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class BinaryTreeLevelOrderTraversal {

	//分层输出
	//！！！ArrayDeque<E> push的时候不能为null
	//！！！LinkedList 也实现了 Deque
	//！！！注意queue 和 stack 的操作不同
	  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		  ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		  ArrayList<Integer>  currentLevel=null;
		  int nodeNum=0;//访问的node数(先将上一次null node的子node)
		  int level=0;//当前层数，root为0
		  int nullNodeNum=0;//当前层有的空node个数
		  Deque<TreeNode> queue=new  LinkedList<TreeNode>();
           queue.addLast(root);
           while(!queue.isEmpty()){
        	   nodeNum++;
        	//换层
        	   if(nodeNum>=Math.pow(2, level)){
        		   level++;
        		   if(currentLevel!=null&&currentLevel.size()>0)
        			   result.add(currentLevel);
        		   currentLevel=new  ArrayList<Integer>();
        		   nullNodeNum=nullNodeNum*2;
        		   nodeNum+=nullNodeNum;
        	   }
        	  //处理node
        	   TreeNode node=queue.pollFirst();
        	   if(node==null){
        		   nullNodeNum+=1;
        	   }else{
        		   queue.addLast(node.left);
        		   queue.addLast(node.right);
        		   currentLevel.add(node.val);
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
