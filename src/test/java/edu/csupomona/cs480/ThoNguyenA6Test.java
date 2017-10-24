package edu.csupomona.cs480;

import org.junit.Test;
import edu.csupomona.cs480.ThoNguyenA6;
import org.junit.Assert;

public class ThoNguyenA6Test {
	
	@Test
	public void testReturnFib() {
		ThoNguyenA6 a5 = new ThoNguyenA6();
		
		int maxFib = 10;
		int maxFib2 = 15;
		int[] fib = {0,1,1,2,3,5,8,13,21,34};
		int[] fib2 = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377};
		
		Assert.assertArrayEquals(fib, a5.returnFib(maxFib));
		Assert.assertArrayEquals(fib2, a5.returnFib(maxFib2));
	}
}
