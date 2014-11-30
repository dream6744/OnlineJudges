package pers.weix.leetcode;

public class ReverseInteger {

	public static class Solution {
		public int reverse(int x) {
			boolean is = true;
			long l1 = x;
			if (x < 0) {
				is = false;
				l1 = 0L - x;
			}
			String xStr = String.valueOf(l1);
			char[] yChs = new char[xStr.length()];
			for (int i = xStr.length() - 1, j = 0; i >= 0; --i, ++j) {
				yChs[j] = xStr.charAt(i);
			}
			long l = Long.valueOf(new String(yChs));
			if (l > Integer.MAX_VALUE) {
				l = 0L;
			}
			return is ? (int) l : 0 - (int) l;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverse(123));
		System.out.println(new Solution().reverse(-123));
		System.out.println(new Solution().reverse(10));
		System.out.println(new Solution().reverse(1000000003));
		System.out.println(new Solution().reverse(-2147483648));
		System.out.println(-11 % 10);
	}

}
