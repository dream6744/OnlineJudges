package pers.weix.leetcode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null
					|| preorder.length != inorder.length
					|| preorder.length == 0) {
				return null;
			}
			return buildTree(preorder, inorder, 0, preorder.length - 1, 0,
					preorder.length - 1);
		}

		public TreeNode buildTree(int[] preorder, int[] inorder, int i1,
				int j1, int i2, int j2) {
			if (i1 >= preorder.length) {
				return null;
			}
			if (i1 > j1) {
				return null;
			}
			TreeNode root = new TreeNode(preorder[i1]);
			if (i1 != j1) {
				int k = i2;
				for (; k < j2; ++k) {
					if (inorder[k] == preorder[i1]) {
						break;
					}
				}
				root.left = buildTree(preorder, inorder, i1 + 1, i1 + k - i2,
						i2, k - 1);
				root.right = buildTree(preorder, inorder, i1 + k - i2 + 1, j1,
						k + 1, j2);
			}
			return root;
		}
	}

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 5, 3, 6 };
		int[] inorder = { 4, 2, 5, 1, 3, 6 };
		TreeNode root = new Solution().buildTree(preorder, inorder);
		printTreeNode(root);
	}

	public static void printTreeNode(TreeNode node) {
		if (node == null) {
			System.out.println("null");
			return;
		}
		System.out.println(node.val);
		printTreeNode(node.left);
		printTreeNode(node.right);
	}
}
