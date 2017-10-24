package edu.csupomona.cs480;

public class ThoNguyenA6 {
	private int fib[];
	
	/**
	 * Return a Fibonacci sequence. Will start with 0 and 1.
	 * @param numberOfDigits - The number of integers in the fibonacci sequence.
	 * @return An Fibonacci integer array with numberOfDigits digits.
	 */
	public int[] returnFib(int numberOfDigits) {
		fib = new int[numberOfDigits];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < numberOfDigits; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib;
	}
}
