package pers.weix.leetcode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTrees2 {

	public static class Solution {
		public List<TreeNode> generateTrees(int n) {
			return generateTrees(n, 0);
		}

		public List<TreeNode> generateTrees(int n, int start) {
			List<TreeNode> list = new LinkedList<TreeNode>();
			if (n <= 0) {
				list.add(null);
			} else if (n == 1) {
				list.add(new TreeNode(1 + start));
			} else if (n == 2) {
				TreeNode node1 = new TreeNode(1 + start);
				node1.right = new TreeNode(2 + start);
				list.add(node1);
				TreeNode node2 = new TreeNode(2 + start);
				node2.left = new TreeNode(1 + start);
				list.add(node2);
			} else {
				for (TreeNode root : generateTrees(n - 1, start)) {
					TreeNode node = new TreeNode(n + start);
					node.left = root;
					list.add(node);
				}
				for (TreeNode root : generateTrees(n - 1, start)) {
					TreeNode node = new TreeNode(n + start);
					right(root).right = node;
					list.add(root);
				}
				for (int i = 1;; ++i) {
					if (n - i - 1 > 0) {
						for (TreeNode root2 : generateTrees(n - i - 1, i
								+ start)) {
							// if put follow statement up, will modify result
							for (TreeNode root1 : generateTrees(i, start)) {
								TreeNode node = new TreeNode(n + start);
								right(root1).right = node;
								node.left = root2;
								list.add(root1);
							}
						}
					} else {
						break;
					}
				}
			}
			return list;
		}

		public TreeNode right(TreeNode root) {
			if (root != null) {
				while (root.right != null) {
					root = root.right;
				}
			}
			return root;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().generateTrees(0));
		System.out.println(new Solution().generateTrees(1));
		System.out.println(new Solution().generateTrees(2));
		System.out.println(new Solution().generateTrees(3));
		System.out.println(new Solution().generateTrees(4));
	}

}
