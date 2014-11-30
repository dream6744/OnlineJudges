package pers.weix.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
	public static class Solution {
		public ListNode mergeKLists(List<ListNode> lists) {
			int count = 0;
			for (ListNode node : lists) {
				while (node != null) {
					++count;
					node = node.next;
				}
			}
			int[] heap = new int[count + 2];
			int tail = 1;
			for (ListNode node : lists) {
				while (node != null) {
					insert(heap, tail++, node.val);
					node = node.next;
				}
			}
			ListNode root = new ListNode(0);
			ListNode temp = root;
			for (int i = 0; i < count; ++i) {
				temp.next = new ListNode(exact(heap, tail--));
				temp = temp.next;
			}
			return root.next;
		}

		public void insert(int[] heap, int tail, int node) {
			if (tail >= heap.length - 1) {
				return;
			}
			heap[tail] = node;
			while (true) {
				if (tail <= 1) {
					break;
				}
				int parent = tail / 2;
				if (heap[tail] < heap[parent]) {
					swap(heap, parent, tail);
				}
				tail = parent;
			}
		}

		public int exact(int[] heap, int tail) {
			if (tail < 1) {
				return -1;
			}
			int temp = heap[1];
			heap[1] = heap[tail - 1];
			int parent = 1;
			while (true) {
				if (parent < tail) {
					break;
				}
				int child = parent * 2;
				if (child < tail) {
					break;
				}
				if (child + 1 < tail && heap[child + 1] < heap[child]) {
					++child;
				}
				if (heap[child] > heap[parent]) {
					swap(heap, parent, child);
				}
				parent = child;
			}
			return temp;
		}

		public void swap(int[] heap, int i, int j) {
			int temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}
	}

	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<ListNode>(2);
		lists.add(ListNode.create(new int[] { 1 }));
		lists.add(ListNode.create(new int[] { 2 }));
		System.out.println(new Solution().mergeKLists(lists));

		lists.clear();
		lists.add(ListNode.create(new int[] { 0, 2, 5 }));
		System.out.println(new Solution().mergeKLists(lists));
	}

}
