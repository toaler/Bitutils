package bitutils;

public class Basics {
	public static int turnOffRightmost1(final int input) {
		return input & (input - 1);
	}

	public static int turnOnRightmost0(final int input) {
		return input | (input + 1);
	}

	public static int turnOffTrailing1s(final int input) {
		return input & (input + 1);
	}

	public static int turnOnTrailing0s(final int input) {
		return input | (input - 1);
	}

	public static int markPositionOfRightmost0With1(final int input) {
		return ~input & (input + 1);
	}

	public static int markPositionOfRightmost1With0(final int input) {
		return ~input | (input - 1);
	}

	public static int createWordWith1sAtPositionsOfTrailing0s(final int input) {
		return ~input & (input - 1);
	}

	public static int createWordWith0sAtPositionsOfTrailing1s(final int input) {
		return ~input | (input + 1);
	}

	public static int markPositionOfRightmost1BitWith1(final int input) {
		return input & (input * -1);
	}

	public static int markRightmost1WithContiguous1s(final int input) {
		return input ^ (input - 1);
	}

	public static int markRightmost0WithContiguous1s(final int input) {
		return input ^ (input + 1);
	}

	public static int clearRightmostContiguousStringOf1s(final int input) {
		return (markPositionOfRightmost1BitWith1(input) + input) & input;
	}

	public static boolean isBaseTwoAMultipleOfBaseTwo(final int baseTwoB, final int baseTwoA) {
		if (baseTwoB < baseTwoA)
			throw new IllegalArgumentException();
		
		if (baseTwoA < 0)
			throw new IllegalArgumentException();
		
		if ((clearRightmostContiguousStringOf1s(baseTwoB) | clearRightmostContiguousStringOf1s(baseTwoA)) == 0){
			return true;
		}
		
		return false;
	}

	public static int abs(final int input) {
		int y = input >> 31;
		return (input ^ y) - y;
	}

	public static int nabs(final int input) {
		int y = input >> 31;
		return y - (input ^ y);
	}

	
	/**
	 * Computes rounded down average of two unsigned integers without overflow.
	 */
	public static int floorAvg(final int x, final int y) {
		return ((x & y) + ((x ^ y) >>> 1));
	}

	/**
	 * Computes rounded up average of two unsigned integers without overflow.
	 */
	public static int ceilingAvg(final int x, final int y) {
		return ((x | y) - ((x ^ y) >>> 1));
	}

	public static int threeValueCompare(final int x, final int y) {
		return (lt(y, x) - lt(x, y));
	}

	public static int eq(final int x, final int y) {
		return (abs(x - y) - 1) >>> 31;
	}

	public static int ne(final int x, final int y) {
		return nabs(x - y) >>> 31;
	}

	public static int lt(final int x, final int y) {
		return ((x - y) ^ ((x ^ y) & ((x - y) ^ x))) >>> 31;
	}
	
	public static int gt(final int x, final int y) {
		return lt(y, x);
	}
	
	public static int le(final int x, final int y) {
		return ((x | ~y) & ((x ^ y) | (~(y - x)))) >>> 31;
	}

	public static int ge(final int x, final int y) {
		return le(y, x);
	}

	public static int doz(final int x, final int y) {
		if (x >= y ) {
			return x - y;
		}
		return 0;
	}
} 