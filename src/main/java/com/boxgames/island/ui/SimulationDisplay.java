package com.boxgames.island.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import javax.swing.JPanel;

import com.boxgames.island.balancing.EngineConst;
import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.ProjectileStateValue;
import com.boxgames.island.state.RobotState;
import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.SimulationState;
import com.boxgames.island.state.TowerState;

@SuppressWarnings("serial")
public class SimulationDisplay extends JPanel {
	private final SimulationResult displayedSimulationResult;
	private int simulationStartMS;
	private boolean simulationRunning;
	
	public SimulationDisplay(SimulationResult displayedResult) {
		this.displayedSimulationResult = displayedResult;
	}
	
	public void startSimulation() {
		simulationRunning = true;
		simulationStartMS = (int) System.currentTimeMillis();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		final long currentTimeMS = System.currentTimeMillis();
		final SimulationStatePair currentStatePair = getSimulationStatePair(currentTimeMS);
		final double fractionOfState = getFractionOfCurrentState(currentTimeMS);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		drawProjectiles(g, currentStatePair, fractionOfState);
		drawTowers(g, currentStatePair, fractionOfState);
		drawRobots(g, currentStatePair, fractionOfState);
	}
	
	private static void drawProjectiles(Graphics g, final SimulationStatePair currentStatePair, final double fractionOfState) {
		for (final Map.Entry<Integer, ProjectileStateValue> state : currentStatePair.earlierState.projectileStates.entrySet()) {
			final Integer stateId = state.getKey();
			final ProjectileState earlyState = state.getValue();
			final ProjectileState lateState = currentStatePair.laterState.projectileStates.get(stateId);
			
			if (lateState == null) {
				continue;
			}
			
			new IntermediateGraphicalProjectileState(fractionOfState, earlyState, lateState).drawTo(g);
		}
	}
	
	private static void drawTowers(Graphics g, final SimulationStatePair currentStatePair, final double fractionOfState) {
		for (final Map.Entry<Integer, TowerState> state : currentStatePair.earlierState.towerStates.entrySet()) {
			final Integer stateId = state.getKey();
			final TowerState earlyState = state.getValue();
			final TowerState lateState = currentStatePair.laterState.towerStates.get(stateId);
			
			if (lateState == null) {
				continue;
			}
			
			new IntermediateGraphicalTowerState(fractionOfState, earlyState, lateState).drawTo(g);
		}
	}
	
	private static void drawRobots(Graphics g, final SimulationStatePair currentStatePair, final double fractionOfState) {
		for (final Map.Entry<Integer, RobotState> idStatePair : currentStatePair.earlierState.robotStates.entrySet()) {
			Integer stateId = idStatePair.getKey();
			RobotState earlyState = idStatePair.getValue();
			RobotState latestate = currentStatePair.laterState.robotStates.get(stateId);
			
		}
	}
	
	private double getFractionOfCurrentState(long currentTimeMS) {
		return ((1000.0) / EngineConst.SIMULATION_TICKS_PER_SECOND) / (currentTimeMS - simulationStartMS);
	}
	
	private SimulationStatePair getSimulationStatePair(long currentTimeMS) {
		if (!simulationRunning) {
			return new SimulationStatePair(displayedSimulationResult.firstState(), displayedSimulationResult.firstState());
		}
		
		final int currentSimulationStateIndex = getSimulationStateIndex(currentTimeMS);
		if (displayedSimulationResult.numberOfStates() <= currentSimulationStateIndex + 1) {
			return new SimulationStatePair(displayedSimulationResult.lastState(), displayedSimulationResult.lastState());
		}
		return new SimulationStatePair(displayedSimulationResult.getState(currentSimulationStateIndex),
		                               displayedSimulationResult.getState(currentSimulationStateIndex + 1));
	}
	
	private int getSimulationStateIndex(long currentTimeMS) {
		return (int) (currentTimeMS - simulationStartMS) / EngineConst.SIMULATION_TICKS_PER_SECOND;
	}
	
	private static class SimulationStatePair {
		private final SimulationState earlierState;
		private final SimulationState laterState;
		
		public SimulationStatePair(SimulationState earlierState, SimulationState laterState) {
			this.earlierState = earlierState;
			this.laterState = laterState;
		}
	}
}
