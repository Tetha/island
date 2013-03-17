package com.boxgames.island.ui;

import com.boxgames.island.state.TowerState;

public class IntermediateGraphicalTowerState implements TowerState {
	private final TowerState earlyTowerState;
	private final TowerState lateTowerState;
	private final double fractionOfStateProgressed;
	
	public IntermediateGraphicalTowerState(double fractionOfStateProgressed, TowerState earlyTowerState, TowerState lateTowerState) {
		this.earlyTowerState = earlyTowerState;
		this.lateTowerState = lateTowerState;
		this.fractionOfStateProgressed = fractionOfStateProgressed;
	}
	
	@Override
	public int getxInTiles() {
		return roundedLinearInterpolation(earlyTowerState.getxInTiles(), lateTowerState.getxInTiles());
	}
	
	@Override
	public int getyInTiles() {
		return roundedLinearInterpolation(earlyTowerState.getyInTiles(), lateTowerState.getyInTiles());
	}
	
	@Override
	public int getOrientation() {
		return roundedLinearInterpolation(earlyTowerState.getOrientation(), lateTowerState.getOrientation());
	}
	
	@Override
	public int getMsToNextShot() {
		return roundedLinearInterpolation(earlyTowerState.getMsToNextShot(), lateTowerState.getMsToNextShot());
	}
	
	private int roundedLinearInterpolation(int start, int end) {
		return (int) Math.round(preciseLinearInterpolation(start, end));
	}
	
	private double preciseLinearInterpolation(int start, int end) {
		return start + (end - start) * fractionOfStateProgressed;
	}
}
