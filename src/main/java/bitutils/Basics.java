package bitutils;

public class Basics {
	public static int turnOffRightMost1Bit(final int input) {
		return input & (input - 1);
	}

	public static int turnOnRightMost0Bit(final int input) {
		return input | (input + 1);
	}

	public static int turnOffTrailing1s(final int input) {
		return input & (input + 1);
	}

	public static int turnOnTrailing0s(final int input) {
		return input | (input - 1);
	}
}