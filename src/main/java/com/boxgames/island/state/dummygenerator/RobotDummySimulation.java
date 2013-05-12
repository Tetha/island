package com.boxgames.island.state.dummygenerator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.boxgames.island.balancing.EngineConst;
import com.boxgames.island.balancing.LevelConst;
import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.RobotState;
import com.boxgames.island.state.RobotStateValue;
import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.SimulationState;
import com.boxgames.island.state.TowerState;

public final class RobotDummySimulation implements DummySimulationGenerator {
	private static final Logger LOG = Logger.getLogger(RobotDummySimulation.class);
	private final int SIMULATION_LENGTH_SECONDS = 60;
	
	private static final double[][] WAYPOINT_TILES = { { 0.25, 0.25 }, { 0.75, 0.25 }, { 0.75, 0.75 }, { 0.75, 0.25 }, { 0.25, 0.25 } };
	
	@Override
	public SimulationResult generateDummySimulation() {
		int ticksInSimulation = SIMULATION_LENGTH_SECONDS * EngineConst.SIMULATION_TICKS_PER_SECOND;
		List<SimulationState> result = new LinkedList<>();
		for (int pairStart = 0; pairStart + 1 < WAYPOINT_TILES.length; pairStart++) {
			addPath(result, ticksInSimulation / 4, WAYPOINT_TILES[pairStart], WAYPOINT_TILES[pairStart + 1]);
		}
		LOG.debug("Simulated " + result.size() + " steps");
		return new SimulationResult(result);
	}
	
	private void addPath(List<SimulationState> result, int ticksForPath, double[] pathStart, double[] pathEnd) {
		double startX = (pathStart[0] * LevelConst.LEVEL_WIDTH_IN_TILES);
		double startY = (pathStart[1] * LevelConst.LEVEL_HEIGHT_IN_TILES);
		double endX = (pathEnd[0] * LevelConst.LEVEL_WIDTH_IN_TILES);
		double endY = (pathEnd[1] * LevelConst.LEVEL_HEIGHT_IN_TILES);
		
		LOG.debug("Path starts at " + startX + "/" + startY);
		LOG.debug("Path ends at " + endX + "/" + endY);
		
		for (int tick = 0; tick < ticksForPath; tick++) {
			int tickX = (int) Math.round(startX + (endX - startX) * tick / ticksForPath);
			int tickY = (int) Math.round(startY + (endY - startY) * tick / ticksForPath);
			LOG.debug("Placing Robot at " + tickX + "/" + tickY);
			result.add(new SimulationState(Collections.<Integer, ProjectileState> emptyMap(), Collections.<Integer, TowerState> emptyMap(),
			                               Collections.<Integer, RobotState> singletonMap(0, new RobotStateValue(tickX, tickY))));
		}
	}
}
