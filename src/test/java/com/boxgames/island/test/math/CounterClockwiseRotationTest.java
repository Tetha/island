package com.boxgames.island.test.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boxgames.island.math.AngleMath;

public class CounterClockwiseRotationTest {
    @Test
    public void turnInDegreesTest() {
    	assertEquals(9000, AngleMath.counterClockwiseTurnInDegrees(AngleMath.UP, AngleMath.LEFT));
    	assertEquals(9000, AngleMath.counterClockwiseTurnInDegrees(AngleMath.LEFT, AngleMath.DOWN));
    	assertEquals(9000, AngleMath.counterClockwiseTurnInDegrees(AngleMath.DOWN, AngleMath.RIGHT));
    	assertEquals(9000, AngleMath.counterClockwiseTurnInDegrees(AngleMath.RIGHT, AngleMath.UP));
    	
    	assertEquals(35900, AngleMath.counterClockwiseTurnInDegrees(0, 100));
    	assertEquals(100, AngleMath.counterClockwiseTurnInDegrees(100, 0));
    }

    @Test(expected=IllegalArgumentException.class)
    public void startOutofLowerRange() {
        AngleMath.counterClockwiseTurnInDegrees(-1, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void startOutofUpperRange() {
        AngleMath.counterClockwiseTurnInDegrees(36000, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void endOutOfLowerRange() {
        AngleMath.counterClockwiseTurnInDegrees(0, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void endOutOfUpperRange() {
        AngleMath.counterClockwiseTurnInDegrees(0, 36000);
    }

}
