package com.boxgames.island.ui;

import java.awt.Graphics;

public abstract class IntermediateGraphicalState {
	
	protected final double fractionOfStateProgressed;
	
	public abstract void drawTo(Graphics g);
	
	public IntermediateGraphicalState(double fractionOfStateProgressed) {
		this.fractionOfStateProgressed = fractionOfStateProgressed;
	}
	
	protected int roundedLinearInterpolation(int start, int end) {
		return (int) Math.round(preciseLinearInterpolation(start, end));
	}
	
	private double preciseLinearInterpolation(int start, int end) {
		return start + (end - start) * fractionOfStateProgressed;
	}
	
}