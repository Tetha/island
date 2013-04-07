package com.boxgames.island.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.boxgames.island.balancing.LevelConst;
import com.boxgames.island.math.AngleMath;
import com.boxgames.island.state.TowerState;

public class IntermediateGraphicalTowerState extends IntermediateGraphicalState implements TowerState {
	private final TowerState earlyTowerState;
	private final TowerState lateTowerState;
	
	public IntermediateGraphicalTowerState(double fractionOfStateProgressed, TowerState earlyTowerState, TowerState lateTowerState) {
		super(fractionOfStateProgressed);
		this.earlyTowerState = earlyTowerState;
		this.lateTowerState = lateTowerState;
	}
	
	@Override
	public int getxInTiles() {
		return roundedLinearInterpolation(earlyTowerState.getxInTiles(), lateTowerState.getxInTiles());
	}
	
	@Override
	public int getyInTiles() {
		return roundedLinearInterpolation(earlyTowerState.getyInTiles(), lateTowerState.getyInTiles());
	}
	
	public int getxInPixels() {
		return getxInTiles() * LevelConst.TILE_WIDTH_IN_PIXELS;
	}
	
	public int getyInPixels() {
		return getyInTiles() * LevelConst.TILE_WIDTH_IN_PIXELS;
	}
	
	@Override
	public int getOrientation() {
		return roundedLinearInterpolation(earlyTowerState.getOrientation(), lateTowerState.getOrientation());
	}
	
	@Override
	public int getMsToNextShot() {
		return roundedLinearInterpolation(earlyTowerState.getMsToNextShot(), lateTowerState.getMsToNextShot());
	}
	
	@Override
	public void drawTo(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(getxInPixels() - 10, getyInPixels() - 10, 20, 20);
		
		Graphics2D barrelGraphics = (Graphics2D) g.create();
		barrelGraphics.setColor(Color.BLUE);
		barrelGraphics.translate(getxInPixels(), getyInPixels());
		barrelGraphics.rotate(-(AngleMath.degreesToRadian(getOrientation()) + Math.PI / 2));
		barrelGraphics.fillRect(-5, 0, 10, 30);
		barrelGraphics.dispose();
	}
}
