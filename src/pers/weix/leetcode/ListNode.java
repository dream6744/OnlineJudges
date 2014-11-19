package pers.weix.leetcode;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode create(int[] nums) {
		ListNode root = null;
		for (int i = nums.length - 1; i >= 0; --i) {
			ListNode temp = new ListNode(nums[i]);
			temp.next = root;
			root = temp;
		}
		return root;
	}

	public String toString() {
		String str = val + "";
		ListNode temp = next;
		while (temp != null) {
			str += ", " + temp.val;
			temp = temp.next;
		}
		return str;
	}
}
