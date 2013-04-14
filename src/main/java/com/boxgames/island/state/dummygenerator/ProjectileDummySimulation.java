package com.boxgames.island.state.dummygenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.boxgames.island.balancing.EngineConst;
import com.boxgames.island.balancing.LevelConst;
import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.ProjectileStateValue;
import com.boxgames.island.state.ProjectileStateValue.ProjectileType;
import com.boxgames.island.state.RobotState;
import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.SimulationState;
import com.boxgames.island.state.TowerState;

public class ProjectileDummySimulation implements DummySimulationGenerator {
	private static final int SIMULATION_LENGTH_SECONDS = 30;
	
	@Override
	public SimulationResult generateDummySimulation() {
		final int minX = (int) (0.25 * LevelConst.LEVEL_WIDTH_IN_PIXELS);
		final int maxX = (int) (0.75 * LevelConst.LEVEL_WIDTH_IN_PIXELS);
		final int constantY = (int) (0.5 * LevelConst.LEVEL_HEIGHT_IN_PIXELS);
		
		final int simulationLength = SIMULATION_LENGTH_SECONDS * EngineConst.SIMULATION_TICKS_PER_SECOND;
		final int dX = (minX - maxX) / simulationLength;
		
		final List<SimulationState> states = new LinkedList<>();
		for (int i = 0; i < simulationLength; i++) {
			final double timeFraction = (double) i / simulationLength;
			final int oX = (int) ((maxX - minX) * timeFraction);
			final int x = minX + oX;
			
			final ProjectileState state = new ProjectileStateValue(x, constantY, dX, 0, ProjectileType.LASER);
			final SimulationState thisState = new SimulationState(Collections.singletonMap(0, state),
			                                                      Collections.<Integer, TowerState> emptyMap(),
			                                                      Collections.<Integer, RobotState> emptyMap());
			states.add(thisState);
		}
		return new SimulationResult(states);
	}
	
}
