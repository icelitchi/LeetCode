package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		ListNode first = new ListNode(0);
		first.next = head;
		map.put(0, first);
		int num = 0;
		ListNode node = head;
		while (node != null) {
			num++;
			map.put(num, node);
			node = node.next;
		}
		map.put(num + 1, null);
		if (n <= num) {
			int index = num - n;
			map.get(num - n).next = map.get(num - n + 2);
		}

		return first.next;

	}

}
