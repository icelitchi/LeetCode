package LeetCode;

public class ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

    	if(head==null||k==1)
    		return head;
    		
    	
    	ListNode first=new ListNode(0);
    	first.next=head;
    	ListNode pre=first;
    	ListNode current=head;
    	int count=k;
    	while(current!=null){
    		count--;
    		ListNode  next=current.next;
    		if(count==0){
    			
    			ListNode l1=pre.next;
    			pre.next=current;
    			pre=l1;
    			ListNode l2=next;
    			for(int i=0;i<k;i++){
    				ListNode temp=l1.next;
    				
    				l1.next=l2;
    				l2=l1;
    				l1=temp;
    			}
    			count=k;
    		}
    		current=next;
    	}
    	
    	
    
    	
        return first.next;
        
    }

}
