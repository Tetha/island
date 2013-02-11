package com.boxgames.island.state;

public class TowerState {
    public final int xInTiles;
    public final int yInTiles;

    /** @see AngleMath */
    public final int orientation;
    public final int msToNextShot;

    public TowerState(int x, int y, int orientation, int msToNextShot) {
        this.xInTiles = x;
        this.yInTiles = y;
        this.orientation = orientation;
        this.msToNextShot = msToNextShot;
    }
}
