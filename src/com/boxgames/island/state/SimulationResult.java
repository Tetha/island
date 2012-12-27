package com.boxgames.island.state;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SimulationResult {
    public final List<SimulationState> states;

    public SimulationResult(List<SimulationState> states) {
        assert states != null;
        assert !states.isEmpty();
        this.states = Collections.unmodifiableList(new LinkedList<SimulationState>(states));
    }

    public int numberOfStates() {
        return states.size();
    }

    public SimulationState getState(int index) {
        return states.get(index);
    }

    public SimulationState lastState() {
        return states.get(states.size()-1);
    }

    public SimulationState firstState() {
        return states.get(0);
    }
}
