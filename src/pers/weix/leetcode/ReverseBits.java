package pers.weix.leetcode;

/**
 * Created by weixing on 3/9/2015.
 */
public class ReverseBits {
    public static class Solution {
        public static int[] ones = new int[32];

        static {
            for (int i = 0; i < 32; ++i) {
                ones[i] = 1 << i;
            }
        }
        public int reverseBits(int n) {
            int m = 0;
            for (int i = 0; i < 16; ++i) {
                m |= ((n & ones[i]) << (31 - 2 * i));
            }
            for (int i = 16; i < 32; ++i) {
                m |= ((n & ones[i]) >>> (2 * i - 31));
            }
            return m;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
        System.out.println(new Solution().reverseBits((int)2147483648L));
    }
}
