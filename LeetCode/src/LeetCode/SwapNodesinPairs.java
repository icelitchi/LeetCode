package LeetCode;

public class SwapNodesinPairs {

	public static void main(String[] args) {


	}
    public ListNode swapPairs(ListNode head) {
    	ListNode first=new ListNode(0);
      //  boolean mark=false;
        ListNode pre=first;
        ListNode node=head;
        while(node!=null){
        	if(node.next==null){//最后的单个
        		pre.next=node;
        		node=node.next;
        	}else{
        		ListNode temp=node.next.next;
        		pre.next=node.next;
        		node.next.next=node;
        		
        		pre=node;
        		//现将pre指空，不然最后一个pre不会重新赋值
        		pre.next=null;
        		node=temp;
        		
        	}
        }
    	return first.next;
    }
}
