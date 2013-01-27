package com.boxgames.island.test.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boxgames.island.math.AngleMath;

public class ClockwiseRotationTest {
    @Test
    public void turnInDegreesTest() {
        assertEquals(9000, AngleMath.clockwiseTurnInDegrees(AngleMath.UP, AngleMath.RIGHT));
        assertEquals(9000, AngleMath.clockwiseTurnInDegrees(AngleMath.RIGHT, AngleMath.DOWN));
        assertEquals(9000, AngleMath.clockwiseTurnInDegrees(AngleMath.DOWN, AngleMath.LEFT));
        assertEquals(9000, AngleMath.clockwiseTurnInDegrees(AngleMath.LEFT, AngleMath.UP));


        assertEquals(100, AngleMath.clockwiseTurnInDegrees(35900, 0));
        assertEquals(35900, AngleMath.clockwiseTurnInDegrees(0, 35900));

        assertEquals(18000, AngleMath.clockwiseTurnInDegrees(AngleMath.LEFT, AngleMath.RIGHT));
        assertEquals(18000, AngleMath.clockwiseTurnInDegrees(AngleMath.RIGHT, AngleMath.LEFT));
    }

    @Test(expected=IllegalArgumentException.class)
    public void startOutofLowerRange() {
        AngleMath.clockwiseTurnInDegrees(-1, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void startOutofUpperRange() {
        AngleMath.clockwiseTurnInDegrees(36000, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void endOutOfLowerRange() {
        AngleMath.clockwiseTurnInDegrees(0, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void endOutOfUpperRange() {
        AngleMath.clockwiseTurnInDegrees(0, 36000);
    }

}
