package pers.weix.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
	public static class Solution {
		private static final Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		static {
			cache.put(1, 1);
			cache.put(2, 2);
			cache.put(3, 5);
		}

		public int numTrees(int n) {
			if (n <= 0) {
				return 0;
			}
			if (cache.containsKey(n)) {
				return cache.get(n);
			}
			int sum = 0;
			sum += 2 * numTrees(n - 1);
			for (int i = 1;; ++i) {
				if (n - i - 1 > 0) {
					sum += numTrees(i) * numTrees(n - i - 1);
				} else {
					break;
				}
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().numTrees(3));
		System.out.println(new Solution().numTrees(4));
	}

}
