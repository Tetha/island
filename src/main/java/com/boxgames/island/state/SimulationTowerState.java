package com.boxgames.island.state;

import com.boxgames.island.math.AngleMath;

public class SimulationTowerState implements TowerState {
	private final int xInTiles;
	private final int yInTiles;
	
	/** @see AngleMath */
	private final int orientation;
	private final int msToNextShot;
	
	public SimulationTowerState(int x, int y, int orientation, int msToNextShot) {
		this.xInTiles = x;
		this.yInTiles = y;
		this.orientation = orientation;
		this.msToNextShot = msToNextShot;
	}
	
	@Override
	public int getxInTiles() {
		return xInTiles;
	}
	
	@Override
	public int getyInTiles() {
		return yInTiles;
	}
	
	@Override
	public int getOrientation() {
		return orientation;
	}
	
	@Override
	public int getMsToNextShot() {
		return msToNextShot;
	}
}
