package pers.weix.leetcode;

public class LongestCommonPrefix {

	public static class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0) {
				return "";
			}
			for (int i = strs.length - 1; i > 0; --i) {
				String tmp = longestCommonPrefix(strs[i], strs[i - 1]);
				if (tmp.length() == 0) {
					return tmp;
				} else {
					strs[i - 1] = tmp;
				}
			}
			return strs[0];
		}

		public String longestCommonPrefix(String str1, String str2) {
			int len1 = str1.length();
			int len2 = str2.length();

			int i = 0;
			for (; i < len1 && i < len2; ++i) {
				if (str1.charAt(i) != str2.charAt(i)) {
					break;
				}
			}
			if (i == 0) {
				return "";
			} else {
				return str1.substring(0, i);
			}
		}
	}

	public static void main(String[] args) {
		String[] strs = { "abc", "ab", "a", "b" };
		System.out.println(new Solution().longestCommonPrefix(strs));
	}

}
