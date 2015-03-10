package pers.weix.leetcode;

/**
 * Created by weixing on 3/10/2015.
 */
public class NumberOf1Bits {
    public static class Solution {
        public int hammingWeight(int n) {
            int count = 0;
            for (int i = 0; i < 32; ++i) {
                count += (n & 1);
                n >>>= 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
        System.out.println(new Solution().hammingWeight((int) 2147483648L));
    }
}
