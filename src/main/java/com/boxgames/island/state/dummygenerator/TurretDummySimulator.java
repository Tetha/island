package com.boxgames.island.state.dummygenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.boxgames.island.balancing.EngineConst;
import com.boxgames.island.balancing.LevelConst;
import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.RobotState;
import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.SimulationState;
import com.boxgames.island.state.SimulationTowerState;
import com.boxgames.island.state.TowerState;

public class TurretDummySimulator implements DummySimulationGenerator {
	private static final int SIMULATION_LENGTH_SECONDS = 30;
	private static final int X = LevelConst.LEVEL_WIDTH_IN_TILES / 2;
	private static final int Y = LevelConst.LEVEL_HEIGHT_IN_TILES / 2;
	
	@Override
	public SimulationResult generateDummySimulation() {
		final int simulationLength = SIMULATION_LENGTH_SECONDS * EngineConst.SIMULATION_TICKS_PER_SECOND;
		final int orientationPerStep = 36000 / simulationLength;
		final List<SimulationState> result = new LinkedList<>();
		for (int i = 0; i < simulationLength; i++) {
			TowerState thisState = new SimulationTowerState(X, Y, orientationPerStep * i, 0);
			result.add(new SimulationState(Collections.<Integer, ProjectileState> emptyMap(), Collections.singletonMap(0, thisState),
			                               Collections.<Integer, RobotState> emptyMap()));
		}
		return new SimulationResult(result);
	}
	
}
