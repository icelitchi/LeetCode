package LeetCode;

public class PartitionList {
	//遍历，将小于和大于的分别放在两个list里，最后合并
	public ListNode partitionList(ListNode head,int k){
		ListNode ls=new ListNode(0);
		ListNode le=null;
		
		ListNode gs=new ListNode(0);
		ListNode ge=null;
		ListNode p=head;
		while(p!=null){
			if(p.val<k){
				if(ls.next==null)
				{
					ls.next=p;		
				}else{
					le.next=p;		
				}
				le=p;
			}else{
				if(gs.next==null)
				{
					gs.next=p;		
				}else{
					ge.next=p;		
				}
				ge=p;
			}
			ListNode temp=p;
			p=p.next;
			temp.next=null;
		}
		
		if(le!=null){
			le.next=gs.next;
			return ls.next;
		}else{
			return gs.next;
		}
	}

}
