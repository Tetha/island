package com.boxgames.island.state;

public class ProjectileStateValue implements ProjectileState {
	public enum ProjectileType {
		LASER;
	}
	
	private final int x;
	private final int y;
	
	private final int dx;
	private final int dy;
	
	private final ProjectileType type;
	
	public ProjectileStateValue(int x, int y, int dx, int dy, ProjectileType type) {
		assert type != null;
		
		this.x = x;
		this.y = y;
		
		this.dx = dx;
		this.dy = dy;
		
		this.type = type;
	}
	
	@Override
	public String toString() {
		return String.format("ProjectileState(x=%d,y=%d,dx=%d,dy=%d,type=%s)", x, y, dx, dy, type);
	}
	
	/* (non-Javadoc)
	 * @see com.boxgames.island.state.ProjectileState#getX()
	 */
	@Override
    public int getX() {
		return x;
	}
	
	/* (non-Javadoc)
	 * @see com.boxgames.island.state.ProjectileState#getY()
	 */
	@Override
    public int getY() {
		return y;
	}
	
	/* (non-Javadoc)
	 * @see com.boxgames.island.state.ProjectileState#getDx()
	 */
	@Override
    public int getDx() {
		return dx;
	}
	
	/* (non-Javadoc)
	 * @see com.boxgames.island.state.ProjectileState#getDy()
	 */
	@Override
    public int getDy() {
		return dy;
	}
	
	/* (non-Javadoc)
	 * @see com.boxgames.island.state.ProjectileState#getType()
	 */
	@Override
    public ProjectileType getType() {
		return type;
	}
}
