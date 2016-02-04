package core.graphics.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SpriteSheetLoader {

	ArrayList<SpriteSheet> spriteSheets;
	
	public SpriteSheetLoader() {
		spriteSheets = new ArrayList<>();
	}
	
	public void loadSpriteSheet(String location, int width, int height, int rows, int cols) throws IOException {
		// Load the big overall sprite image
		BufferedImage bigImg = ImageIO.read(new File(location));
		
		Sprite[] sprites = new Sprite[rows * cols];
	
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sprites[(i * cols) + j] = new Sprite(bigImg.getSubimage(
						j * width,
						i * height,
						width,
						height
					));
			}
		}
		spriteSheets.add(new SpriteSheet(sprites, bigImg, width, height));
	}
	
	public void deleteSpriteSheet(int index) {
		spriteSheets.remove(index);
	}
	
	public SpriteSheet getSpriteSheet(int index) {
		return spriteSheets.get(index);
	}
}
