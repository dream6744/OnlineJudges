package pers.weix.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static class Solution {
		public int[] twoSum(int[] numbers, int target) {
			int[] result = new int[2];
			int[] positions = quickSort(numbers);
			for (int i = 0; i < positions.length; ++i) {
				int val = numbers[positions[i]];
				int pos = binarySearch(numbers, positions, target - val);
				if (pos >= 0 && i != pos) {
					result[0] = positions[i] + 1;
					result[1] = positions[pos] + 1;
					break;
				}
			}
			if (result[0] > result[1]) {
				int temp = result[1];
				result[1] = result[0];
				result[0] = temp;
			}
			return result;
		}

		public int binarySearch(int[] numbers, int[] positions, int key) {
			int ret = -1;
			int beg = 0;
			int end = positions.length - 1;
			while (beg <= end) {
				int mid = (beg + end) / 2;
				int val = numbers[positions[mid]];
				if (val == key) {
					ret = mid;
					break;
				} else if (val < key) {
					beg = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			return ret;
		}

		public int[] quickSort(int[] numbers) {
			int[] positions = new int[numbers.length];
			for (int i = 0; i < positions.length; ++i) {
				positions[i] = i;
			}
			quickSort(numbers, positions, 0, numbers.length - 1);
			return positions;
		}

		public void quickSort(int[] numbers, int[] positions, int beg, int end) {
			if (beg >= end) {
				return;
			}
			int m = (int) (Math.random() * (end - beg)) + beg;
			swap(positions, beg, m);
			m = beg;
			for (int i = beg + 1; i <= end; ++i) {
				if (numbers[positions[i]] < numbers[positions[beg]]) {
					swap(positions, i, ++m);
				}
			}
			swap(positions, beg, m);
			quickSort(numbers, positions, beg, m - 1);
			quickSort(numbers, positions, m + 1, end);
		}

		public void swap(int[] array, int p1, int p2) {
			int tmp = array[p1];
			array[p1] = array[p2];
			array[p2] = tmp;
		}
	}

	public static class Solution1 {
		public int[] twoSum(int[] numbers, int target) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < numbers.length; i++) {
				int x = numbers[i];
				if (map.containsKey(target - x)) {
					return new int[] { map.get(target - x) + 1, i + 1 };
				}
				map.put(x, i);
			}
			throw new IllegalArgumentException("No two sum solution");
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 2, 7, 11, 15 };
		int[] result = new Solution().twoSum(numbers, 9);
		System.out.println(result[0] + " " + result[1]);

		int[] numbers1 = { 7, 2, 11, 15 };
		result = new Solution().twoSum(numbers1, 9);
		System.out.println(result[0] + " " + result[1]);

		int[] numbers2 = { 3, 2, 4 };
		result = new Solution().twoSum(numbers2, 6);
		System.out.println(result[0] + " " + result[1]);

		int[] numbers3 = { 230, 863, 916, 585, 981, 404, 316, 785, 88, 12, 70,
				435, 384, 778, 887, 755, 740, 337, 86, 92, 325, 422, 815, 650,
				920, 125, 277, 336, 221, 847, 168, 23, 677, 61, 400, 136, 874,
				363, 394, 199, 863, 997, 794, 587, 124, 321, 212, 957, 764,
				173, 314, 422, 927, 783, 930, 282, 306, 506, 44, 926, 691, 568,
				68, 730, 933, 737, 531, 180, 414, 751, 28, 546, 60, 371, 493,
				370, 527, 387, 43, 541, 13, 457, 328, 227, 652, 365, 430, 803,
				59, 858, 538, 427, 583, 368, 375, 173, 809, 896, 370, 789 };
		result = new Solution().twoSum(numbers3, 542);
		System.out.println(result[0] + " " + result[1]);
	}

}
