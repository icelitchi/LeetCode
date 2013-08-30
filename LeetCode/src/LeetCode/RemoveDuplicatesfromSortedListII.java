package LeetCode;

//有重复的值，全去掉
public class RemoveDuplicatesfromSortedListII {
	  public ListNode deleteDuplicates(ListNode head) {
		  ListNode first=head;
		  ListNode temp=head;
		  //找到第一个node
	        while(temp.next!=null&&first.val==temp.next.val){
	        	temp=temp.next;
	        }
	        first=temp.next;
	        
	        //其它节点去重
	        ListNode pre=first;
	        temp=first.next;
	        while(temp!=null){
	        	if(temp.next!=null){
	        		if(temp.next.val!=temp.val){
	        			pre=temp;
	        			temp=temp.next;
	        		}else{
	        			while(temp.next!=null&&temp.next.val==temp.val)
	        				temp=temp.next;
	        			pre.next=temp;
	        		}
	        	}
	        	
	        }
	        return first;
	        
	        
	    }
}

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
 
