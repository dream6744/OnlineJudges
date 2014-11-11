package pers.weix.leetcode;

public class LinkedListCycle2 {

	/**
	 * Definition for singly-linked list.
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return String.valueOf(val);
		}
	}

	public static class Solution {
		public ListNode detectCycle(ListNode head) {
			if (head == null || head.next == null) {
				return null;
			}
			ListNode temp = new ListNode(-1);
			temp.next = head;
			head = temp;
			ListNode fast = head;
			ListNode slow = head;
			while (true) {
				for (int i = 0; i < 2; ++i) {
					fast = fast.next;
					if (fast == null) {
						return null;
					}
					if (fast == head) {
						return head;
					}
				}
				slow = slow.next;
				if (fast == slow) {
					fast = head;
					while (fast != slow) {
						fast = fast.next;
						slow = slow.next;
					}
					return fast;
				}
			}
		}
	}

	public static void main(String[] args) {
		ListNode root1 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		root1.next = node1;
		node1.next = node2;
		node2.next = node1;
		System.out.println(new Solution().detectCycle(root1));

		ListNode root2 = new ListNode(0);
		System.out.println(new Solution().detectCycle(root2));

		ListNode root3 = new ListNode(1);
		root3.next = new ListNode(2);
		root3.next.next = new ListNode(3);
		root3.next.next.next = new ListNode(4);
		root3.next.next.next.next = new ListNode(5);
		root3.next.next.next.next.next = new ListNode(6);
		root3.next.next.next.next.next.next = root3.next.next;
		System.out.println(new Solution().detectCycle(root3));
	}

}
