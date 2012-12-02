package com.boxgames.island.state;

public class ProjectileState {
    public enum ProjectileType { LASER; }

    public final int x;
    public final int y;

    public final int dx;
    public final int dy;

    public final ProjectileType type;

    public ProjectileState(int x, int y, int dx, int dy, ProjectileType type) {
        assert type != null;

        this.x = x;
        this.y = y;

        this.dx = dx;
        this.dy = dy;

        this.type = type;
    }
}
