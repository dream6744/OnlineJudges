package pers.weix.leetcode;

public class AddTwoNumbers {
	public static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode root = new ListNode(0);
			ListNode l3 = root;
			int mod = 0;
			while (l1 != null || l2 != null) {
				int val1 = l1 != null ? l1.val : 0;
				int val2 = l2 != null ? l2.val : 0;
				int val3 = val1 + val2 + mod;
				mod = val3 / 10;
				l3.next = new ListNode(val3 % 10);

				l1 = l1 != null ? l1.next : l1;
				l2 = l2 != null ? l2.next : l2;
				l3 = l3.next;
			}
			if (mod != 0) {
				l3.next = new ListNode(mod);
			}
			return root.next;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = ListNode.create(new int[] { 2, 4, 3, 1 });
		ListNode l2 = ListNode.create(new int[] { 5, 6, 4 });
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(new Solution().addTwoNumbers(l1, l2));
	}

}
