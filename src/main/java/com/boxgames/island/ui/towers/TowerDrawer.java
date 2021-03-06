package com.boxgames.island.ui.towers;

import java.util.Map;

import com.boxgames.island.state.SimulationState;
import com.boxgames.island.state.TowerState;
import com.boxgames.island.ui.AbstractStatePairDrawer;
import com.boxgames.island.ui.DrawableState;

public final class TowerDrawer extends AbstractStatePairDrawer<TowerState> {
	
	@Override
	protected DrawableState getState(double fractionOfState, TowerState earlyState, TowerState lateState) {
		return new IntermediateGraphicalTowerState(fractionOfState, earlyState, lateState);
	}
	
	@Override
	protected Map<Integer, TowerState> getStates(SimulationState state) {
		return state.towerStates;
	}
	
}
