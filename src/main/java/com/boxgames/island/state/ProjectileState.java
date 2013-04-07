package com.boxgames.island.state;

import com.boxgames.island.state.ProjectileStateValue.ProjectileType;

public interface ProjectileState {
	
	public abstract int getX();
	
	public abstract int getY();
	
	public abstract int getDx();
	
	public abstract int getDy();
	
	public abstract ProjectileType getType();
	
}