package bitutils;

public class Basics {
	public static int turnOffRightMost1Bit(final int input) {
		return input & (input - 1);
	}
}