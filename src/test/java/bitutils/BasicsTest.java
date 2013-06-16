package bitutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BasicsTest {
	@Test
	public void turnOffRightmost1() {
		int input  = 0b01011000;

		input = Basics.turnOffRightmost1(input);
		assertEquals(0b01010000, input);
		
		input = Basics.turnOffRightmost1(input);
		assertEquals(0b01000000, input);
		
		input = Basics.turnOffRightmost1(input);
		assertEquals(0b00000000, input);
		
		input = Basics.turnOffRightmost1(input);
		assertEquals(0b00000000, input);
	}
	
	@Test
	public void turnOnRightmost0() {
		int input  = 0b10100111;

		input = Basics.turnOnRightmost0(input);
		assertEquals(0b10101111, input);
		
		input = Basics.turnOnRightmost0(input);
		assertEquals(0b10111111, input);
		
		input = Basics.turnOnRightmost0(input);
		assertEquals(0b11111111, input);
	}
	
	@Test
	public void turnOffTrailing1s() {
		assertEquals(0b10100000, Basics.turnOffTrailing1s(0b10100111));
	}
	
	@Test
	public void turnOnTrailing0s() {
		assertEquals(0b10101111, Basics.turnOnTrailing0s(0b10101000));
	}
	
	@Test
	public void markPositionOfRightmost0BitWith1() {
		assertEquals(0b00001000, Basics.markPositionOfRightmost0With1(0b10100111));
	}
	
	@Test
	public void markPositionOfRightmost1BitWith0() {
		assertEquals(0b11111111111111111111111111110111, Basics.markPositionOfRightmost1With0(0b10101000));
	}
	
	@Test
	public void createWordWith1sAtPositionsOfTrailing0s() {
		assertEquals(0b00000111, Basics.createWordWith1sAtPositionsOfTrailing0s(0b01011000));
	}
	
	@Test
	public void createWordWith0sAtPositionsOfTrailing1s() {
		assertEquals(0b11111111111111111111111111111000, Basics.createWordWith0sAtPositionsOfTrailing1s(0b10100111));
	}
	
	@Test
	public void markPositionOfRightmost1BitWith1() {
		assertEquals(0b00001000, Basics.markPositionOfRightmost1BitWith1(0b01011000));
	}
	
	@Test
	public void markPositionOfRightmost1BitWith1WithNo1s() {
		assertEquals(0b00000000, Basics.markPositionOfRightmost1BitWith1(0b00000000));
	}
	
	@Test
	public void markRightmost1WithContiguous1s() {
		assertEquals(0b00001111, Basics.markRightmost1WithContiguous1s(0b01011000));
	}
	
	@Test
	public void markRightmost0WithContiguous1s() {
		assertEquals(0b00001111, Basics.markRightmost0WithContiguous1s(0b01010111));
	}
	
	@Test
	public void clearRightmostContiguousStringOf1s() {
		assertEquals(0b01000000, Basics.clearRightmostContiguousStringOf1s(0b01011100));
	}
	
	@Test
	public void isBaseTwoAMultipleOfBaseTwo() {
		// These can be used to determine if a nonnegative integer is of the form 
		// 2j − 2k for some j ≥ k≥ 0: apply the formula followed by a 0-test on the result.
		assertEquals(true, Basics.isBaseTwoAMultipleOfBaseTwo(0b00001000, 0b00000010));
		
		assertEquals(false, Basics.isBaseTwoAMultipleOfBaseTwo(0b00001001, 0b00000010));
		
		assertEquals(false, Basics.isBaseTwoAMultipleOfBaseTwo(0b00001010, 0b00000101));
		
		try {
			Basics.isBaseTwoAMultipleOfBaseTwo(0b00000010, 0b00001000);
			fail("First argument cannot be greater than second.");
		}
		catch (IllegalArgumentException e) {
		}
		
		try {
			Basics.isBaseTwoAMultipleOfBaseTwo(0b11111111111111111111111111111111, 0b00001000);
			fail("First operand has to be greater than zero.");
		}
		catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	public void abs() {
		assertEquals(0b00000001, Basics.abs(0b11111111111111111111111111111111));
	}
	
	@Test
	public void nabs() {
		assertEquals(0b11111111111111111111111111111111, Basics.nabs(0b00000001));
	}
	
	@Test
	public void avgRoundDown() {
		assertEquals(2, Basics.floorAvg(2, 3));
	}
	
	@Test
	public void avgRoundUp() {
		assertEquals(3, Basics.ceilingAvg(2, 3));
	}
	
	@Test
	public void threeValueCompare() {
		assertEquals(-1, Basics.threeValueCompare(0, 1));
		assertEquals(0, Basics.threeValueCompare(0, 0));
		assertEquals(1, Basics.threeValueCompare(1, 0));
	}
	
	@Test
	public void comparisonPredicatesEquals() {
		assertEquals(0, Basics.eq(0, 1));
		assertEquals(0, Basics.eq(1, 0));
		assertEquals(1, Basics.eq(1, 1));
	}
	
	@Test
	public void comparisonPredicatesNotEquals() {
		assertEquals(0, Basics.ne(1, 1));
		assertEquals(1, Basics.ne(1, 0));

	}
	
	@Test
	public void comparisonPredicatesLessThan() {
		assertEquals(0, Basics.lt(0, 0));
		assertEquals(1, Basics.lt(-1, 0));
	}
	
	@Test
	public void comparisonPredicatesGreaterThan() {
		assertEquals(0, Basics.gt(0, 0));
		assertEquals(1, Basics.gt(1, 0));
	}
	
	@Test
	public void comparisonPredicatesLessThanOrEqual() {
		assertEquals(1, Basics.le(0, 0));
		assertEquals(0, Basics.le(1, 0));
	}

	@Test
	public void comparisonPredicatesGreaterThanOrEqual() {
		assertEquals(1, Basics.ge(0, 0));
		assertEquals(0, Basics.ge(-1, 0));
	}
	
	@Test
	public void doz() {
		assertEquals(3, Basics.doz(7, 4));
		assertEquals(0, Basics.doz(1, 2));
	}

}