package pers.weix.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	public static class Solution {
		public List<List<Integer>> subsets(int[] S) {
			if (S == null || S.length == 0) {
				return new ArrayList<List<Integer>>();
			}
			// non-descending
			Arrays.sort(S);
			List<List<Integer>> ret = new LinkedList<List<Integer>>();
			ret.add(new ArrayList<Integer>());
			for (int i = 1; i <= S.length; ++i) {
				int[] counts = new int[S.length];
				for (int j = 0; j < i; ++j) {
					counts[j] = 1;
				}
				do {
					List<Integer> set = new ArrayList<Integer>(i);
					for (int j = 0; j < S.length; ++j) {
						if (counts[j] == 1) {
							set.add(S[j]);
						}
					}
					ret.add(set);
				} while (compute(counts));
			}
			return ret;

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
		int[] S1 = { 1, 2, 3 };
		System.out.println(new Solution().subsets(S1));
		int[] S2  = {4, 1, 0};
		System.out.println(new Solution().subsets(S2));
	}
}
