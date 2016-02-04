package core.world.map;

import core.world.Utils;

public class Map {

	private int width;
	private int height;
	
	private String[][] map;
	
	public Map(String fileLocation, int width, int height) {
		this.width = width;
		this.height = height;
		this.map = Utils.readMapData(fileLocation);
	}
	
	public String[][] getMap() {
		return map;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
