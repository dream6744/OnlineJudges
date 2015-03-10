package pers.weix.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by weixing on 2/2/2015.
 */
public class LargestNumber {
    public static class Solution {
        public String largestNumber(int[] num) {
            Integer[] nums = new Integer[num.length];
            for (int i = 0; i < num.length; ++i) {
                nums[i] = num[i];
            }
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer i, Integer j) {
                    String ij = String.valueOf(i) + String.valueOf(j);
                    String ji = String.valueOf(j) + String.valueOf(i);
                    return -ij.compareTo(ji);
                }
            });
            String res = "";
            for (Integer i : nums) {
                res += i;
            }
            int nonZeroIndex = -1;
            for (int i = 0; i < res.length(); ++i) {
                if (res.charAt(i) != '0') {
                    nonZeroIndex = i;
                    break;
                }
            }
            if (nonZeroIndex == -1) {
                return "0";
            } else {
                return res.substring(nonZeroIndex);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Solution().largestNumber(new int[]{0, 0}));
        System.out.println(new Solution().largestNumber(new int[]{1}));
    }
}
