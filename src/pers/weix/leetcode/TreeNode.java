package pers.weix.leetcode;

/**
 * Definition for binary tree
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		int[] values = new int[1024];
		values[0] = val;
		set(0, values);
		int right = 0;
		for (right = values.length - 1; right >= 0; --right) {
			if (values[right] != 0) {
				break;
			}
		}
		String str = "{";
		for (int i = 0; i < right; ++i) {
			if (values[i] != 0) {
				str += values[i] + ",";
			} else {
				str += "#,";
			}
		}
		if (right >= 0) {
			str += values[right] + "}";
		} else {
			str += "}";
		}
		return str;
	}

	private void set(int parent, int[] values) {
		if (left != null) {
			values[parent * 2 + 1] = left.val;
			left.set(parent * 2 + 1, values);
		}
		if (right != null) {
			values[parent * 2 + 2] = right.val;
			right.set(parent * 2 + 2, values);
		}
	}

}
