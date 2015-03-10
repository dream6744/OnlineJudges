package pers.weix.leetcode;

/**
 * Created by weixing on 3/10/2015.
 */
public class RotateArray {
    public static class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length);
            reverse(nums, 0, k);
            reverse(nums, k, nums.length - k);
        }

        public void reverse(int[] nums, int beg, int len) {
            for (int i = 0; i < len / 2; ++i) {
                int j = len - i - 1;
                swap(nums, i + beg, j + beg);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
