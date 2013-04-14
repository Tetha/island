package com.boxgames.island.ui;


public abstract class IntermediateGraphicalState implements DrawableState {
	
	protected final double fractionOfStateProgressed;
	
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