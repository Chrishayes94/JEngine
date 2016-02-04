package core.player;

import core.graphics.GameCanvas;

public class Player {

	
	// Player properties
	private int x = GameCanvas.WIDTH / 2, y = GameCanvas.HEIGHT / 2;
	private boolean left, right, up, down;
	private double speedBoost = 1.00;
	
	private int sizeX = 30, sizeY = 30;
	
	// Constant static types
	public static enum KEY_MOVEMENTS {LEFT, RIGHT, UP, DOWN, SHIFT};
	
	public void update() {
		move();
	}
	
	public void move() {
		
		if (left && this.x > 2) x -= 1 * speedBoost;
		if (right && this.x < GameCanvas.WIDTH - (sizeX + 2)) x += 1 * speedBoost;
		if (up && this.y > 2) y -= 1 * speedBoost;
		if (down && this.y < GameCanvas.HEIGHT - (sizeY + 2)) y += 1 * speedBoost;
		
	}
	
	public void setMovement(KEY_MOVEMENTS type, boolean state) {
		switch (type) {
			case LEFT:
				left = state;
				break;
			case RIGHT:
				right = state;
				break;
			case UP:
				up = state;
				break;
			case DOWN:
				down = state;
				break;
			case SHIFT:
				if (state) speedBoost = 1.06;
				else speedBoost = 1.0;
		}
	}
	
	public boolean getMovementState(KEY_MOVEMENTS type) {
		switch (type) {
			case LEFT:
				return left;
			case RIGHT:
				return right;
			case UP:
				return up;
			case DOWN:
				return down;
			case SHIFT:
				if (speedBoost > 1) return true;
				else return false;
		}
		return false;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
}
