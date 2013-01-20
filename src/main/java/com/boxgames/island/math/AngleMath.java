package com.boxgames.island.math;


public class AngleMath {
    public static int rightwardsTurnInDegrees(int startDegrees, int endDegrees) {
        if (!isNormalizedDegree(startDegrees)) throw new IllegalArgumentException();
        if (!isNormalizedDegree(endDegrees)) throw new IllegalArgumentException();

        int result =  endDegrees - startDegrees;
        if (!isNormalizedDegree(result)) {
            result += 36000;
        }
        return result;
    }

    public static boolean isNormalizedDegree(int degree) {
        return 0 <= degree && degree <= 36000;
    }
}
