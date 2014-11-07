package pers.weix.leetcode;

public class SumRootToLeafNumbers {
	/**
	 * Definition for binary tree
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class Solution {
		public int sumNumbers(TreeNode root) {
			return sumNumbers(root, 0);
		}

		public int sumNumbers(TreeNode root, int value) {
			int sum = 0;
			if (root == null) {
				return 0;
			}
			value = value * 10 + root.val;
			if (root.left == null && root.right == null) {
				return value;
			}
			if (root.left != null) {
				sum += sumNumbers(root.left, value);
			}
			if (root.right != null) {
				sum += sumNumbers(root.right, value);
			}

			return sum;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new Solution().sumNumbers(root));
	}

}
