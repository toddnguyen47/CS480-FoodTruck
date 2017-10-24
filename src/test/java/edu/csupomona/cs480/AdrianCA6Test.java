package edu.csupomona.cs480;

import org.junit.Test;
import edu.csupomona.cs480.ThoNguyenA6;
import org.junit.Assert;


public class AdrianCA6Test {

	public void testStringRev() {
		AdrianCA6 test = new AdrianCA6();
		
		Assert.assertEquals("abcdefgh",test.reverseString("hgfedcba"));
		Assert.assertEquals("abcdefghijklmnopqrstuvwxyz",test.reverseString("zyxwvutsrqponmlkjihgfedcba"));
		Assert.assertEquals("AdrianCuellar",test.reverseString("ralleuCnairdA"));
	}
}
