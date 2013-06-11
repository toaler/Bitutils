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
	public void turnOnRightMost0Bit() {
		int input  = 0b10100111;

		input = Basics.turnOnRightMost0Bit(input);
		assertEquals(0b10101111, input);
		
		input = Basics.turnOnRightMost0Bit(input);
		assertEquals(0b10111111, input);
		
		input = Basics.turnOnRightMost0Bit(input);
		assertEquals(0b11111111, input);
	}
	
	@Test
	public void turnOffTrailing1s() {
		int input = 0b10100111;
		
		input = Basics.turnOffTrailing1s(input);
		assertEquals(0b10100000, input);
	}
	
	@Test
	public void turnOnTrailing0s() {
		int input = 0b10101000;
		
		input = Basics.turnOnTrailing0s(input);
		assertEquals(0b10101111, input);
	}
}
