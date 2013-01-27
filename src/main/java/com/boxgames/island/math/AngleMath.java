package com.boxgames.island.math;


public class AngleMath {
	public static final int UP = 0;
	public static final int RIGHT = 9000;
	public static final int DOWN = 18000;
	public static final int LEFT = 27000;
	
	/**
	 * Calculates how many degrees must be rotated clockwise from start to end.
	 * @param startDegrees degrees * 100
	 * @param endDegrees degrees * 100
	 * @return degrees * 100
	 */
    public static int clockwiseTurnInDegrees(int startDegrees, int endDegrees) {
        if (!isNormalizedDegree(startDegrees)) throw new IllegalArgumentException();
        if (!isNormalizedDegree(endDegrees)) throw new IllegalArgumentException();

        int result =  endDegrees - startDegrees;
        if (!isNormalizedDegree(result)) {
            result += 36000;
        }
        assert isNormalizedDegree(result) : result + " not normalized";
        return result;
    }

    public static boolean isNormalizedDegree(int degree) {
        return 0 <= degree && degree < 36000;
    }

	/**
	 * Calculates how many degrees must be rotated clockwise from start to end.
	 * @param startDegrees degrees * 100
	 * @param endDegrees degrees * 100
	 * @return degrees * 100
	 */
	public static int counterClockwiseTurnInDegrees(int startDegrees, int endDegrees) {
		if (!isNormalizedDegree(startDegrees)) throw new IllegalArgumentException();
        if (!isNormalizedDegree(endDegrees)) throw new IllegalArgumentException();
		
        int result =  startDegrees - endDegrees;
        if (!isNormalizedDegree(result)) {
            result += 36000;
        }
        assert isNormalizedDegree(result) : result + " not normalized";
        return result;
	}

	public static double degreesToRadian(int degrees) {
		if (!isNormalizedDegree(degrees)) throw new IllegalArgumentException();
		int rotatedDegrees = 36000 -(degrees - 9000);
		if (!isNormalizedDegree(rotatedDegrees)) rotatedDegrees -= 36000;
		assert isNormalizedDegree(rotatedDegrees) : rotatedDegrees + " not normalized";
		return (rotatedDegrees / 18000.0)* Math.PI;
		
	}
}
