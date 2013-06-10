package bitutils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicsTest {
	@Test
	public void manipulateRightMostBitsTurnOffRightMost1Bit() {
		int input  = 0b01011000;

		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b01010000, input);
		
		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b01000000, input);
		
		input = Basics.turnOffRightMost1Bit(input);
		assertEquals(0b00000000, input);
	}
}
