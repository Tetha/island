package com.boxgames.island.state;

public class RobotStateValue implements RobotState {
	private final int xInTiles;
	private final int yInTiles;
	
	public RobotStateValue(int xInTiles, int yInTiles) {
		this.xInTiles = xInTiles;
		this.yInTiles = yInTiles;
	}
	
	@Override
	public int getXInTiles() {
		return xInTiles;
	}
	
	@Override
	public int getYInTiles() {
		return yInTiles;
	}
}
