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
}
