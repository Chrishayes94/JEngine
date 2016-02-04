package core.graphics.spritess;

import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;
	private int zOffset = 0;
	
	public Sprite(BufferedImage image) {
		this.image = image;
	}
	
	public void setZOffset(int value) {
		this.zOffset = value;
	}
	
	public BufferedImage getSprite() {
		return image;
	}
	
	public int getZOffset() {
		return zOffset;
	}
}
