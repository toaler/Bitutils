package bitutils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicsTest {
	@Test
	public void turnOffRightMost1Bit() {
		int input  = 0b01011000;

		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b01010000, input);
		
		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b01000000, input);
		
		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b00000000, input);
		
		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b00000000, input);
	}
	
	@Test
	public void turnOnRightMost1Bit() {
		int input  = 0b10100111;

		input = Basics.turnOnRightMost1Bit(input);
		assertEquals(0b10101111, input);
		
		input = Basics.turnOnRightMost1Bit(input);
		assertEquals(0b10111111, input);
		
		input = Basics.turnOnRightMost1Bit(input);
		assertEquals(0b11111111, input);
	}
}
