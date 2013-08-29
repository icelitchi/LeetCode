package LeetCodeDone;
//用链表表示的两个十进制数的加法，
//每个node表示十进制数的一位
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    	ListNode first=null;
    	ListNode last=null;
    	int increasement=0;
      while(l1!=null||l2!=null){
    	  
    	  int v1=l1!=null?l1.val:0;
    	  int v2=l2!=null?l2.val:0;
    	  int v=(v1+v2+increasement)%10;
    	  increasement=(v1+v2+increasement)/10;
    	  
    	  ListNode temp=new ListNode(v);
    	  if(first==null){
    		  first=temp;
    		  last=temp;
    	  }else{
    		  last.next=temp;
    		  last=temp;			  
    	  }
    	  
    	  l1=l1!=null?l1.next:null;
    	  l2=l2!=null?l2.next:null;
    
      }
      if(increasement==1){
    	  ListNode temp=new ListNode(1);
    	  last.next=temp;
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
 