package LeetCode;

import java.util.ArrayList;

public class MergekSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	ListNode first=new ListNode(0);
    	ListNode pre=first;
    	if(lists==null||lists.size()==0)
			return null;
    	while(lists.size()>0){
    		while(lists.size()>0&&lists.get(0)==null){//
				lists.remove(0);
			}
    		if(lists.size()==0)
    			return first.next;
    		int minvalue=lists.get(0).val;
    		int minindex=0;
    		//最小值 和 所在索引
    		for(int i=0;i<lists.size();i++){
    			if(lists.get(i)==null){//
    				lists.remove(i);
    				i--;
    			}else if(lists.get(i).val<minvalue){
    				minvalue=lists.get(i).val;
    				minindex=i;
    			}
    		}
    		ListNode minnode=lists.get(minindex);
    		pre.next=minnode;
    		pre=minnode;
    		if(minnode.next==null){//所在list取空
    			lists.remove(minindex);
    		}else{
    			lists.set(minindex, minnode.next);
    		}
    	}
    	
    	return first.next;
        
    }
}
