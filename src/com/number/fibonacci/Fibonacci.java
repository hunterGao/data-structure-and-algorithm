package com.number.fibonacci;

import java.math.BigInteger;

import Jama.Matrix;

public class Fibonacci {

	public static int fabonacciRecursion(int position) {
		if (position <= 0) {
			return 0;
		}
		if (position == 1) {
			return 1;
		}
		return fabonacciRecursion(position - 1) +
				fabonacciRecursion(position - 2);
	}
	
	public static int dynamicFabonacci(int position) {
		if (position <= 0) {
			return 0;
		}
		if (position == 1 || position == 2) {
			return 1;
		}
		int result = 0;
		int lastOne = 1;
		int lastTwo = 1;
		for (int i = 2; i < position; i++) {
			result = lastOne + lastTwo;
			lastTwo = lastOne;
			lastOne = result;
		}
		return result;
	}
	
	public static int dynamicArrayFabonacci(int position) {
		if (position <= 0) {
			return 0;
		}
		if (position == 1 || position == 2) {
			return 1;
		}
		
		int[] array = new int[position + 1];
		array[0] = 0;
		array[1] = 1;
		for (int i = 2; i <= position; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		return array[position];
	}
	
	public static double fabonacci(int position) {
		if (position <= 0) {
			return 0;
		}
		if (position == 1 || position == 2) {
			return 1;
		}
		Matrix base = new Matrix(new double[]{1, 1, 1, 0}, 2);
		Matrix an = matrixPow(base, position - 1);
		return an.getArray()[0][0];
	}
	
	private static Matrix matrixPow(Matrix m, int n) {
		if (m == null || n < 0) {
			return null;
		}
		Matrix result = Matrix.identity(m.getRowDimension(), m.getColumnDimension());
		Matrix temp = m;
		for (; n > 0; n >>= 1) {
			if ((n & 1) > 0) {
				result = result.times(temp);
			}
			temp.times(temp);
		} 
		return result;
	}
	
	public static BigInteger bigFabonacci(BigInteger lastOne, BigInteger lastTwo, int duration) {
		if (duration < 0 || lastOne.byteValue() < 0 || 
				lastTwo.byteValue() < 0 || lastTwo.compareTo(lastOne) != 1) {
			return null;
		}
		BigInteger result = new BigInteger("0");
		for (int i = 0; i < duration; i++) {
			result = lastOne.add(lastTwo);
			lastOne = lastTwo;
			lastTwo = result;
		}
		return result;
	}
	
	
}
