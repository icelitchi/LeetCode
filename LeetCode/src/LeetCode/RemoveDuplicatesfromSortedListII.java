package LeetCode;

//有重复的值，全去掉
public class RemoveDuplicatesfromSortedListII {
	  public ListNode deleteDuplicates(ListNode head) {

		  ListNode first=new ListNode(0);
		  ListNode pre=null;
		  ListNode temp=head;

	        while(temp!=null){
	        	if(temp.next!=null){
	        		if(temp.next.val!=temp.val){
	        			if(pre==null){
	        				first.next=temp;
	        			}else{
	        				pre.next=temp;
	        			}
	        			pre=temp;
	        			temp=temp.next;
	        			pre.next=null;
	        		}else{
	        			while(temp.next!=null&&temp.next.val==temp.val)
	        				temp=temp.next;
	        			temp=temp.next;
	        		
	        		}
	        	}else{
	        		if(pre==null){
        				first.next=temp;
        			}else{
        				pre.next=temp;
        			}
	        		
	        	}
	        	
	        }

	        return first.next;
	        
	        
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
 
