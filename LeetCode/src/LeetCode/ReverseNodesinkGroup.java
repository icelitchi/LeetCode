package LeetCode;

public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

    	if(head==null)
    		return head;
    		
    	int i=1;
    	ListNode end=head;
    	
    	ListNode p=head.next;
    	ListNode pre=head;
    	ListNode next=null;
    	while(i<k&&p!=null){
    
    		next=p.next;
    		p.next=pre;
    		pre=p;
    		p=next;
    		i++;
    	}
    	end.next=p;
    	
        return pre;
        
    }

}
