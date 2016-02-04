package core;

import java.io.IOException;

import core.graphics.GameCanvas;
import core.world.Instances;
import core.world.map.MapData;

public class Engine implements Runnable {

	GameCanvas drawing = new GameCanvas();
	
	public long totalFrames = 0;
	public int framesThisInterval = 0;
	public long intervalStartTime = 0;
	public int fps = 0;
	public static final int TPS = 60;
	
	long previous = System.currentTimeMillis();
	long lag = 0;
	
	public Engine() {
		
		// Encode the map data
		//MapData.encodeFile("raw_maps/map_data_pack_0.txt", 1);
		//MapData.decodeFile("maps/map_data_pack_1.dat");
		
		// Attempt to load sprites
		try {
			Instances.sheetLoader.loadSpriteSheet("JRPG/resources/castleSheet.png", 32, 32, 16, 16);
			Instances.sheetLoader.loadSpriteSheet("JRPG/resources/mountainSheet.png", 32, 32, 16, 16);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			// Repeat updates
			Instances.player.update();
			drawing.render(fps, totalFrames);
			
			totalFrames++;;
			framesThisInterval++;
			
			long timeDiff = (System.currentTimeMillis() - intervalStartTime);
			if (timeDiff >= 250) {
				fps = (int) (framesThisInterval / (timeDiff / 1000.0));
				framesThisInterval = 0;
				intervalStartTime = System.currentTimeMillis();
			}
			
			try {Thread.sleep(System.currentTimeMillis() % (1000 / TPS) * -1 + (1000 / TPS));} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

}
