package LeetCode;

public class ReverseLinkedListII {

	public static void main(String[] args) {


	}
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
     
    	if(head==null||n<=m)
    		return head;
    		
    	int i=-1;
    	ListNode first=new ListNode(0);
    		first.next=head;
    	ListNode mid=first,p=first;
    	//p和pre都知道要开始倒转的前一个node
    	while(i<m-2&&p!=null){
    		p=p.next;
    		i++;
    	}
    	if(p!=null){
    		mid=p;
    	}else{
    		return first.next;
    	}
    
    	//开始倒转
    	p=p.next;i++;
    	ListNode first2=p;
    	ListNode pre=p;
    	ListNode pre2=null;
    	ListNode next=null;
    	while(i<n&&p!=null){
    		pre2=p;
    		next=p.next;
    		p.next=pre;
    		pre=p;
    		p=next;
    		i++;
    	}
    	if(pre!=null){
    		mid.next=pre;
    		first2.next=p;
    	}else if(pre2!=null){
    		mid.next=pre2;
    	}
    	
        return first.next;
    }

}
