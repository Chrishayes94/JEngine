package core.handlers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.player.Player;
import core.world.Instances;

public class ButtonHandler extends KeyAdapter {

	public ButtonHandler() {
		System.out.println("Button handler initialised!");
	}
	
	public void keyPressed(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_W:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.UP, true);
				break;
			case KeyEvent.VK_S:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.DOWN, true);
				break;
			case KeyEvent.VK_A:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.LEFT, true);
				break;
			case KeyEvent.VK_D:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.RIGHT, true);
				break;
			case KeyEvent.VK_SHIFT:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.SHIFT, true);
		}
	}
	
	public void keyReleased(KeyEvent key) {
		switch (key.getKeyCode()) {
			case KeyEvent.VK_W:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.UP, false);
				break;
			case KeyEvent.VK_S:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.DOWN, false);
				break;
			case KeyEvent.VK_A:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.LEFT, false);
				break;
			case KeyEvent.VK_D:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.RIGHT, false);
				break;
			case KeyEvent.VK_SHIFT:
				Instances.player.setMovement(Player.KEY_MOVEMENTS.SHIFT, false);
				break;
		}
	}
	
	public void keyTyped(KeyEvent arg0) {
		
	}
}
