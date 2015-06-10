/*
 * The little trick is to return the left common parts of two numbers. 
 * When not equal, move right for 1 bit, util equal, return the common parts.
 * 
 * AND operation extract the left most consecutive common part of m and n. 
 * (Just consider two numbers). 
 * So keep right shift util they are equal, which means it reaches the left 
 * most consecutive common part.
 */

package bit;

public class BitwiseAndOfRange {
	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			count++;
		}
		return m <<= count;
	}
}