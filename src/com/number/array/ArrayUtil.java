package com.number.array;

public class ArrayUtil {

	/**
	 * calculate the max sum of sub array
	 * use double for cycle
	 * @param array {-2, 5, 3, -6, 4, -8, 6}
	 * @return
	 */
	public static int maxSubArraySum(int[] array) {
		if (null == array || array.length == 0) {
			return Integer.MIN_VALUE;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum += array[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
	
	/**
	 * calculate the max sum of sub array
	 * use dynamic 
	 * @param array
	 * @return
	 */
	public static int dynamicMaxSubArraySum(int[] array) {
		if (null == array || array.length == 0) {
			return Integer.MIN_VALUE;
		}
		int[] start = new int[array.length];
		start[0] = array[0];
		int[] all = new int[array.length];
		all[0] = array[0];
		int i = 1;
		for (; i < array.length; i++) {
			start[i] = Math.max(array[i], array[i] + start[i - 1]);
			all[i] = Math.max(start[i], all[i - 1]);
		}
		return all[i];
	}
}
