package pers.weix.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
	public static class Solution {
		public List<Integer> getRow(int rowIndex) {
			if (rowIndex < 0) {
				return new ArrayList<Integer>();
			}
			List<Integer> nums = new ArrayList<Integer>(rowIndex + 1);
			int[] tmp = new int[rowIndex + 1];
			for (int i = 0; i < tmp.length; ++i) {
				tmp[i] = 1;
			}
			do {
				nums.add(tmp[tmp.length - 1]);
				tmp = addNext(tmp);
			} while(tmp != null);
			return nums;
		}

		public int[] addNext(int[] left) {
			if (left.length <= 1) {
				return null;
			}
			int[] right = new int[left.length - 1];
			right[0] = 1;
			for (int i = 1; i < right.length; ++i) {
				right[i] = right[i - 1] + left[i];
			}
			return right;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().getRow(0));
		System.out.println(new Solution().getRow(1));
		System.out.println(new Solution().getRow(2));
		System.out.println(new Solution().getRow(3));
	}

}
