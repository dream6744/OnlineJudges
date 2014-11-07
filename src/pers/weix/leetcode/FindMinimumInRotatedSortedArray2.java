package pers.weix.leetcode;

public class FindMinimumInRotatedSortedArray2 {

	public static class Solution {
		public int findMin(int[] num) {
			int beg = 0;
			int end = num.length - 1;

			int mid = (beg + end) / 2;
			while (beg >= end) {
				
			}
			return mid;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] num = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(solution.findMin(num));
	}

}
