package pers.weix.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public static class Solution {
		public int threeSumClosest(int[] num, int target) {
			Arrays.sort(num);
			return 0;
		}
	}

	public static void main(String[] args) {
		int[] num = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(new Solution().threeSumClosest(num, target));
	}

}
