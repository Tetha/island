package com.boxgames.island.ui;

import java.util.Map;

import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.SimulationState;

public final class ProjectileDrawer extends AbstractStatePairDrawer<ProjectileState> {
	@Override
	protected DrawableState getState(double fractionOfState, ProjectileState earlyState, ProjectileState lateState) {
		return new IntermediateGraphicalProjectileState(fractionOfState, earlyState, lateState);
		
	}
	
	@Override
	protected Map<Integer, ProjectileState> getStates(SimulationState state) {
		return state.projectileStates;
	}
}
