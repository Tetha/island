package com.boxgames.island.state;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SimulationState {
    public final List<ProjectileState> projectileStates;

    public SimulationState(List<ProjectileState> projectileStates) {
        assert projectileStates != null;
        this.projectileStates = Collections.unmodifiableList(new LinkedList<ProjectileState>(projectileStates));
    }
}
