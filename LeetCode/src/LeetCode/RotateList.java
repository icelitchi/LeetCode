package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RotateList {

	public static void main(String[] args) {

	}

	// 向右轮转
	public ListNode rotateRight(ListNode head, int n) {
		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		ListNode first = new ListNode(0);
		first.next = head;
		map.put(0, first);
		int num = 0;
		while (head != null) {
			num++;
			map.put(num, head);
			head = head.next;
		}
		// map.put(num + 1, null);

		if (num > 0) {
			n = n % num;
			if (n > 0) {
				int index = num - n + 1;
				map.get(num).next = first.next;
				map.get(index - 1).next = null;
				first.next = map.get(index);
			}

		}

		return first.next;
	}

}
