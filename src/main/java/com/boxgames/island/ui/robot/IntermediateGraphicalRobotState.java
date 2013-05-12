package com.boxgames.island.ui.robot;

import java.awt.Color;
import java.awt.Graphics;

import org.apache.log4j.Logger;

import com.boxgames.island.balancing.LevelConst;
import com.boxgames.island.state.RobotState;
import com.boxgames.island.ui.IntermediateGraphicalState;

public class IntermediateGraphicalRobotState extends IntermediateGraphicalState implements RobotState {
	private static final Logger LOG = Logger.getLogger(IntermediateGraphicalRobotState.class);
	private final RobotState earlyState;
	private final RobotState lateState;
	
	private static final int WIDTH = 20;
	
	public IntermediateGraphicalRobotState(double fractionOfStateProgressed, RobotState earlyState, RobotState lateState) {
		super(fractionOfStateProgressed);
		this.earlyState = earlyState;
		this.lateState = lateState;
		LOG.debug("Intermediate state between " + earlyState + " and " + lateState);
	}
	
	@Override
	public void drawTo(Graphics g) {
		g.setColor(Color.RED);
		LOG.debug("Drawing around " + getXInPixels() + "/" + getYInPixels());
		g.fillOval(getXInPixels() - WIDTH / 2, getYInPixels() - WIDTH / 2, WIDTH, WIDTH);
	}
	
	public int getXInPixels() {
		return getXInTiles() * LevelConst.TILE_WIDTH_IN_PIXELS;
	}
	
	public int getYInPixels() {
		return getYInTiles() * LevelConst.TILE_HEIGHT_IN_PIXELS;
	}
	
	@Override
	public int getXInTiles() {
		return roundedLinearInterpolation(earlyState.getXInTiles(), lateState.getXInTiles());
	}
	
	@Override
	public int getYInTiles() {
		return roundedLinearInterpolation(earlyState.getYInTiles(), lateState.getYInTiles());
	}
}
