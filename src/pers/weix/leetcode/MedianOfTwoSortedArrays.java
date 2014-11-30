package pers.weix.leetcode;

public class MedianOfTwoSortedArrays {
	public static class Solution {
		public double findMedianSortedArrays(int A[], int B[]) {
			int[] C = new int[A.length + B.length];
			int aStep = 1;
			int aInit = 0;
			int aStop = A.length;
			int bStep = 1;
			int bInit = 0;
			int bStop = B.length;
			if (A.length > 1 && A[0] > A[1]) {
				aStep = -1;
				aInit = A.length - 1;
				aStop = -1;
			}
			if (B.length > 1 && B[0] > B[1]) {
				bStep = -1;
				bInit = A.length - 1;
				bStop = -1;
			}
			for (int i = 0; i < C.length; ++i) {
				if (aInit == aStop) {
					C[i] = B[bInit];
					bInit += bStep;
				} else if (bInit == bStop) {
					C[i] = A[aInit];
					aInit += aStep;
				} else {
					if (A[aInit] < B[bInit]) {
						C[i] = A[aInit];
						aInit += aStep;
					} else {
						C[i] = B[bInit];
						bInit += bStep;
					}
				}
			}
			if (C.length % 2 == 1) {
				return C[C.length / 2];
			} else {
				return (C[C.length / 2 - 1] + C[C.length / 2]) / 2.0;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = { 1 };
		System.out.println(new Solution().findMedianSortedArrays(a, b));
	}
}
