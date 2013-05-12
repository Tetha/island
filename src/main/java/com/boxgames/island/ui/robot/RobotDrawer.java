package com.boxgames.island.ui.robot;

import java.util.Map;

import com.boxgames.island.state.RobotState;
import com.boxgames.island.state.SimulationState;
import com.boxgames.island.ui.AbstractStatePairDrawer;
import com.boxgames.island.ui.DrawableState;

public final class RobotDrawer extends AbstractStatePairDrawer<RobotState> {
	
	@Override
	protected DrawableState getState(double fractionOfState, RobotState earlyState, RobotState lateState) {
		return new IntermediateGraphicalRobotState(fractionOfState, earlyState, lateState);
	}
	
	@Override
	protected Map<Integer, RobotState> getStates(SimulationState state) {
		return state.robotStates;
	}
	
}
