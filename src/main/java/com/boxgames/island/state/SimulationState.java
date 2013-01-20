package com.boxgames.island.state;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimulationState {
    /** projectile state id -> state */
    public final Map<Integer, ProjectileState> projectileStates;

    /** tower state id -> state */
    public final Map<Integer, TowerState> towerStates;

    public SimulationState(Map<Integer, ProjectileState> projectileStates,
            Map<Integer, TowerState> towerStates) {
        assert projectileStates != null;
        assert towerStates != null;
        this.projectileStates = Collections.unmodifiableMap(new HashMap<>(projectileStates));
        this.towerStates = Collections.unmodifiableMap(new HashMap<>(towerStates));
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        boolean first = true;
        for (final Entry<Integer, ProjectileState> idState : projectileStates.entrySet()) {
            if (!first) result.append(",");
            first = false;

            result.append(idState.getKey()).append("=>").append(idState.getValue());
        }
        return result.toString();
    }
}
