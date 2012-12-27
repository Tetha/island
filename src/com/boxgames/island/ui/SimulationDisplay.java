package com.boxgames.island.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import com.boxgames.island.balancing.EngineConst;
import com.boxgames.island.state.ProjectileState;
import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.SimulationState;

public class SimulationDisplay extends JPanel {
    private final SimulationResult displayedSimulationResult;
    private int simulationStartMS;
    private boolean simulationRunning;
    public SimulationDisplay(SimulationResult displayedResult) {
        this.displayedSimulationResult = displayedResult;
    }

    public void startSimulation() {
        simulationRunning = true;
        simulationStartMS = (int)System.currentTimeMillis();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        final long currentTimeMS = System.currentTimeMillis();
        final SimulationStatePair currentStatePair = getSimulationStatePair(currentTimeMS);
        final double fractionOfState = getFractionOfCurrentState(currentTimeMS);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, getWidth(), getHeight());

        final Set<Integer> drawnStates = new HashSet<Integer>();
        for (final Map.Entry<Integer, ProjectileState> state : currentStatePair.earlierState.projectileStates.entrySet()) {
            final Integer stateId = state.getKey();
            final ProjectileState earlyState = state.getValue();
            final ProjectileState lateState = currentStatePair.laterState.projectileStates.get(stateId);

            if (lateState == null) continue;

            final int dx = lateState.x - earlyState.x;
            final int dy = lateState.y - earlyState.y;

            final int x = (int) (earlyState.x + fractionOfState * dx);
            final int y = (int) (earlyState.y + fractionOfState * dy);
            g.setColor(Color.RED);
            g.drawOval(x-5, y-5, 10, 10);
        }
    }

    private double getFractionOfCurrentState(long currentTimeMS) {
        return ((1000.0) / EngineConst.SIMULATION_TICKS_PER_SECOND) / (currentTimeMS - simulationStartMS);
    }

    private SimulationStatePair getSimulationStatePair(long currentTimeMS) {
        if (!simulationRunning) {
            return new SimulationStatePair(displayedSimulationResult.firstState(),
                    displayedSimulationResult.firstState());
        }

        final int currentSimulationStateIndex = getSimulationStateIndex(currentTimeMS);
        if (displayedSimulationResult.numberOfStates() <= currentSimulationStateIndex+1) {
            return new SimulationStatePair(displayedSimulationResult.lastState(),
                    displayedSimulationResult.lastState());
        }
        return new SimulationStatePair(displayedSimulationResult.getState(currentSimulationStateIndex),
                displayedSimulationResult.getState(currentSimulationStateIndex+1));
    }

    private int getSimulationStateIndex(long currentTimeMS) {
        return (int)(currentTimeMS - simulationStartMS) / EngineConst.SIMULATION_TICKS_PER_SECOND;
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
