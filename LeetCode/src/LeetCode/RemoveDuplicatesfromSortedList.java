package LeetCode;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode current=head;
    	ListNode temp=current;
    	while(temp!=null){
    		while(temp.next!=null&&temp.next.val==temp.val){
    			temp=temp.next;
    		}
    		temp=temp.next;
    		current.next=temp;
    		current=temp;
    		
    	}
        
    	return head;
    }
    
}
