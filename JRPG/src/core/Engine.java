package core;

import java.io.IOException;

import core.graphics.GameCanvas;
import core.io.SaveGameState;
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
	
	// Default Constructor for Engine class, creates an files or variables required.
	public Engine() {
		
		// Encode the map data
		//MapData.encodeFile("raw_maps/map_data_pack_0.txt", 1);
		//MapData.decodeFile("maps/map_data_pack_1.dat");
		
		try {
			SaveGameState.save(Instances.player);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Attempt to load sprites
		try {
			Instances.sheetLoader.loadSpriteSheet("JRPG/resources/tilesheets/castleSheet.png", 32, 32, 16, 16);
			Instances.sheetLoader.loadSpriteSheet("JRPG/resources/tilesheets/mountainSheet.png", 32, 32, 16, 16);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Engine.run(), handles the current state of the game through rendering and checking the players current position.
	// along with other actions
	@Override
	public void run() {
		while (true) {
			
			// Repeat updates
			Instances.player.update();
			drawing.render(fps, totalFrames);
			
			// Increase our total number of frames and frames this tick
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
