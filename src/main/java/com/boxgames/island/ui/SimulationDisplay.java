package com.boxgames.island.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.boxgames.island.balancing.EngineConst;
import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.SimulationState;
import com.boxgames.island.ui.projectile.ProjectileDrawer;
import com.boxgames.island.ui.robot.RobotDrawer;
import com.boxgames.island.ui.towers.TowerDrawer;

@SuppressWarnings("serial")
public class SimulationDisplay extends JPanel {
	private static final Logger LOG = Logger.getLogger(SimulationDisplay.class);
	private final List<AbstractStatePairDrawer<?>> drawers = Arrays.<AbstractStatePairDrawer<?>> asList(new ProjectileDrawer(),
	                                                                                                    new TowerDrawer(),
	                                                                                                    new RobotDrawer());
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
		
		for (AbstractStatePairDrawer<?> drawer : drawers) {
			drawer.draw(g, currentStatePair, fractionOfState);
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
		LOG.debug("CurrentSimulationStateIndex = " + currentSimulationStateIndex);
		if (displayedSimulationResult.numberOfStates() <= currentSimulationStateIndex + 1) {
			return new SimulationStatePair(displayedSimulationResult.lastState(), displayedSimulationResult.lastState());
		}
		return new SimulationStatePair(displayedSimulationResult.getState(currentSimulationStateIndex),
		                               displayedSimulationResult.getState(currentSimulationStateIndex + 1));
	}
	
	private int getSimulationStateIndex(long currentTimeMS) {
		return (int) (currentTimeMS - simulationStartMS) / EngineConst.SIMULATION_TICKS_PER_SECOND;
	}
	
	public static class SimulationStatePair {
		private final SimulationState earlierState;
		private final SimulationState laterState;
		
		public SimulationStatePair(SimulationState earlierState, SimulationState laterState) {
			this.earlierState = earlierState;
			this.laterState = laterState;
		}
		
		public SimulationState getLaterState() {
			return laterState;
		}
		
		public SimulationState getEarlierState() {
			return earlierState;
		}
	}
}
