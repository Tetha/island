package com.boxgames.island.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RightwardsRotationTest {
    @Test
    public void turnInDegreesTest() {
        assertEquals(9000, AngleMath.rightwardsTurnInDegrees(0, 9000));
        assertEquals(9000, AngleMath.rightwardsTurnInDegrees(9000, 18000));
        assertEquals(9000, AngleMath.rightwardsTurnInDegrees(18000, 27000));
        assertEquals(9000, AngleMath.rightwardsTurnInDegrees(27000, 0));


        assertEquals(100, AngleMath.rightwardsTurnInDegrees(35900, 0));
        assertEquals(35900, AngleMath.rightwardsTurnInDegrees(0, 35900));

        assertEquals(18000, AngleMath.rightwardsTurnInDegrees(27000, 9000));
        assertEquals(18000, AngleMath.rightwardsTurnInDegrees(9000, 27000));
    }

    @Test(expected=IllegalArgumentException.class)
    public void startOutofLowerRange() {
        AngleMath.rightwardsTurnInDegrees(-1, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void startOutofUpperRange() {
        AngleMath.rightwardsTurnInDegrees(36001, 0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void endOutOfLowerRange() {
        AngleMath.rightwardsTurnInDegrees(0, -1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void endOutOfUpperRange() {
        AngleMath.rightwardsTurnInDegrees(0, 36001);
    }

}
