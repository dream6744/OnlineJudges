package pers.weix.leetcode;

/**
 * Created by weixing on 3/13/2015.
 */
public class PalindromeNumber {
    public static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            long y = 1;
            for (; y * 10 <= x; y *= 10) ;
            for (; y > 1; y /= 100) {
                System.out.println(x);
                System.out.println(y);
                if (x / y != x % 10)
                    return false;
                x %= y;
                x /= 10;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1874994781));
    }
}
