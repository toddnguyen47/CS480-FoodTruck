package edu.csupomona.cs480;

public class AdrianCA6 {

	/**
	 * Returns a reversal of the inputed string.
	 * @param string String to be reversed
	 * @return Reversal of input string
	 */
	public String reverseString(String string) {
		byte[] byteArr = string.getBytes();
		byte[] res = new byte [string.length()];
		for(int i=0;i<string.length();i++) {
			res[i]=byteArr[byteArr.length-i-1];
		}
		return new String(res);
	}
}
