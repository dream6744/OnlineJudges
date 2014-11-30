package pers.weix.leetcode;

import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static class Solution {
		public List<Integer> findSubstring(String S, String[] L) {
			List<Integer> list = new LinkedList<Integer>();
			if (L == null || L.length == 0) {
				return list;
			}
			int len = L[0].length();
			int num = L.length;
			if (S == null || S.length() < len * num) {
				return list;
			}
			String[] index = new String[S.length()];
			for (int i = 0; i < S.length(); ++i) {
				for (String l : L) {
					if (S.startsWith(l, i)) {
						index[i] = l;
					}
				}
			}
			for (int i = 0; i < S.length(); ++i) {
				if (index[i] != null) {
					boolean[] bs = new boolean[num];
					for (int j = 0; j < num; ++j) {
						if (i + j * len >= S.length()) {
							break;
						}
						if (index[i + j * len] == null) {
							break;
						}
						if (!setTrue(index[i + j * len], L, bs)) {
							break;
						}
					}
					if (isAllTrue(bs)) {
						list.add(i);
					}
				}
			}
			return list;
		}

		public boolean setTrue(String s, String[] ss, boolean[] bs) {
			boolean successful = false;
			for (int i = 0; i < bs.length; ++i) {
				if (!bs[i] && ss[i].equals(s)) {
					successful = true;
					bs[i] = true;
					break;
				}
			}
			return successful;
		}

		public boolean isAllTrue(boolean[] bs) {
			for (boolean b : bs) {
				if (!b) {
					return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = { "foo", "bar" };
		System.out.println(new Solution().findSubstring(S, L));

		String S1 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] L1 = { "fooo", "barr", "wing", "ding", "wing" };
		System.out.println(new Solution().findSubstring(S1, L1));
	}

}
