package core.graphics.sprites;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private Sprite[] sprites;
	private BufferedImage bigImage;
	
	private int width;
	private int height;
	
	public SpriteSheet(Sprite[] sprites, BufferedImage bigImage, int width, int height) {
		this.sprites = sprites;
		this.bigImage = bigImage;
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Sprite[] getSprites() {
		return sprites;
	}
	
	public BufferedImage getImage() {
		return bigImage;
	}
}
