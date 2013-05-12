package com.boxgames.island.ui.projectile;

import java.awt.Color;
import java.awt.Graphics;

import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.ProjectileStateValue.ProjectileType;
import com.boxgames.island.ui.IntermediateGraphicalState;

public class IntermediateGraphicalProjectileState extends IntermediateGraphicalState implements ProjectileState {
	
	private final ProjectileState earlyState;
	private final ProjectileState lateState;
	
	public IntermediateGraphicalProjectileState(double fractionOfStateProgressed, ProjectileState earlyState, ProjectileState lateState) {
		super(fractionOfStateProgressed);
		this.earlyState = earlyState;
		this.lateState = lateState;
	}
	
	@Override
	public void drawTo(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(getX() - 5, getY() - 5, 10, 10);
	}
	
	@Override
	public int getX() {
		return roundedLinearInterpolation(earlyState.getX(), lateState.getX());
	}
	
	@Override
	public int getY() {
		return roundedLinearInterpolation(earlyState.getY(), lateState.getY());
	}
	
	@Override
	public int getDx() {
		return roundedLinearInterpolation(earlyState.getDx(), lateState.getDx());
	}
	
	@Override
	public int getDy() {
		return roundedLinearInterpolation(earlyState.getDy(), lateState.getDy());
	}
	
	@Override
	public ProjectileType getType() {
		if (!earlyState.getType().equals(lateState.getType())) {
			throw new IllegalStateException("Cannot handle projectiles that transform in type");
		}
		return earlyState.getType();
	}
	
}
