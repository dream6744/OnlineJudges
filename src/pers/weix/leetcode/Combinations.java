package pers.weix.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

	public static class Solution {
		private static final List<List<Integer>> NULL = Collections.emptyList();

		public List<List<Integer>> combine(int n, int k) {
			if (n < 0 || k < 0 || n < k) {
				return NULL;
			}
			int[] counts = new int[n];
			for (int i = 0; i < k; ++i) {
				counts[i] = 1;
			}
			List<List<Integer>> res = new LinkedList<List<Integer>>();
			do {
				List<Integer> tmp = new ArrayList<Integer>(k);
				for (int i = 0; i < counts.length; ++i) {
					if (counts[i] == 1) {
						tmp.add(i+1);
					}
				}
				res.add(tmp);
			} while (compute(counts));
			return res;
		}

		public boolean compute(int[] counts) {
			for (int i = 0; i < counts.length - 1; ++i) {
				if (counts[i] == 1 && counts[i + 1] == 0) {
					counts[i] = 0;
					counts[i + 1] = 1;
					int z = 0;
					for (int j = 0; j < i; ++j) {
						if (counts[j] == 1) {
							counts[j] = 0;
							counts[z++] = 1;
						}
					}
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().combine(4, 2));
	}

}
