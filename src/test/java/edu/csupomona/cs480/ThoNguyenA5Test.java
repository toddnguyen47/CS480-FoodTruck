package edu.csupomona.cs480;

import org.junit.Test;
import edu.csupomona.cs480.ThoNguyenA5;
import org.junit.Assert;

public class ThoNguyenA5Test {
	
	@Test
	public void testReturnFib() {
		int maxFib = 10;
		ThoNguyenA5 a5 = new ThoNguyenA5();
		int[] fib = {0,1,1,2,3,5,8,13,21,34};
		int[] returnFib = a5.returnFib(maxFib);
		
		Assert.assertArrayEquals(fib, returnFib);
	}
}
