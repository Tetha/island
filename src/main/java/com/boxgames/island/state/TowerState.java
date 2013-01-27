package com.boxgames.island.state;

public class TowerState {
    public final int x;
    public final int y;

    /** degrees * 100 */
    public final int orientation;
    public final int msToNextShot;

    public TowerState(int x, int y, int orientation, int msToNextShot) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.msToNextShot = msToNextShot;
    }
}
