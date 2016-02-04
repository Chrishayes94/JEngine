package core.graphics.sprites;

import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;
	
	private int posX, posY;
	private int zOffset = 0;
	
	public Sprite(BufferedImage image) {
		this.image = image;
		posX = 0;
		posY = 0;
	}
	
	public void setZOffset(int value) {
		this.zOffset = value;
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public BufferedImage getSprite() {
		return image;
	}
	
	public int getZOffset() {
		return zOffset;
	}
}
