package pers.weix.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
	public static class Solution {
		public int lengthOfLongestSubstring(String s) {
			int[] positions = new int[Byte.MAX_VALUE];
			int[] longests = new int[Byte.MAX_VALUE];
			for (int i = 0; i < positions.length; ++i) {
				positions[i] = -1;
			}
			int longest = 0;
			byte[] bytes = {};
			if (s != null) {
				bytes = s.getBytes();
			}
			for (int i = 0; i < bytes.length; ++i) {
				int length = i - positions[bytes[i]];
				if (length > longest) {
					longest = length;
				}
				positions[bytes[i]] = i;
			}
			return longest;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
		System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
	}
}
