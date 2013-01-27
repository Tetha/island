package com.boxgames.island.test.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boxgames.island.math.AngleMath;

public class RadianConversion {
	@Test(expected=IllegalArgumentException.class)
	public void lowerBoundary() {
		AngleMath.degreesToRadian(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void upperBoundary() {
		AngleMath.degreesToRadian(36000);
	}
	
	@Test
	public void checkConversion() {
		assertEquals(0.0, AngleMath.degreesToRadian(AngleMath.RIGHT), 0.1);
		assertEquals(Math.PI/2, AngleMath.degreesToRadian(AngleMath.UP), 0.1);
		assertEquals(Math.PI, AngleMath.degreesToRadian(AngleMath.LEFT), 0.1);
		assertEquals(3*Math.PI/2, AngleMath.degreesToRadian(AngleMath.DOWN), 0.1);
	}
}
