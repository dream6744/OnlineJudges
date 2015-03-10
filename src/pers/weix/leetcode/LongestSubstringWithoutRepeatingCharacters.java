package pers.weix.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            String[] noRepeats = new String[s.length()];
            noRepeats[0] = s.substring(0, 1);
            for (int i = 1; i < s.length(); ++i) {
                int lastIndex = noRepeats[i - 1].lastIndexOf(s.charAt(i));
                if (lastIndex == -1) {
                    noRepeats[i] = s.substring(i - noRepeats[i - 1].length(), i + 1);
                } else {
                    noRepeats[i] = s.substring(i - noRepeats[i - 1].length() + lastIndex + 1, i + 1);
                }
            }
            int longest = 0;
            for (int i = 0; i < noRepeats.length; ++i) {
                if (noRepeats[i].length() > longest) {
                    longest = noRepeats[i].length();
                }
            }
            return longest;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(""));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
    }
}
