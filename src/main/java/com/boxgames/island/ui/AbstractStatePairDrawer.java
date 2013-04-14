package com.boxgames.island.ui;

import java.awt.Graphics;
import java.util.Map;

import com.boxgames.island.state.SimulationState;
import com.boxgames.island.ui.SimulationDisplay.SimulationStatePair;

public abstract class AbstractStatePairDrawer<S> {
	public void draw(Graphics g, final SimulationStatePair currentStatePair, final double fractionOfState) {
		for (final Map.Entry<Integer, S> state : getEarlierStates(currentStatePair).entrySet()) {
			final Integer stateId = state.getKey();
			final S earlyState = state.getValue();
			final S lateState = getLaterStates(currentStatePair).get(stateId);
			
			if (lateState == null) {
				continue;
			}
			
			getState(fractionOfState, earlyState, lateState).drawTo(g);
		}
	}
	
	private Map<Integer, S> getEarlierStates(SimulationStatePair statePair) {
		return getStates(statePair.getEarlierState());
	}
	
	private Map<Integer, S> getLaterStates(SimulationStatePair statePair) {
		return getStates(statePair.getLaterState());
	}
	
	protected abstract DrawableState getState(double fractionOfState, S earlyState, S lateState);
	
	protected abstract Map<Integer, S> getStates(SimulationState state);
}
