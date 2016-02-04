package core.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.handlers.ButtonHandler;
import core.player.Player;
import core.world.Instances;

public class GameCanvas extends JFrame {

	private static final long serialVersionUID = -163334999967730040L;
	
	private Canvas canvas;
	private JPanel panel;
	
	private BufferStrategy bs;
	private Graphics2D g2D;
	
	public static int WIDTH = 1366;
	public static int HEIGHT = 800;
	
	public GameCanvas() {
		this.setTitle("Testing Engine");
		
		panel = (JPanel) this.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0,0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		setResizable(false);
		setVisible(true);
		
		
		panel.add(canvas);
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		
		canvas.requestFocus();
		canvas.setBackground(Color.black);
		canvas.addKeyListener(new ButtonHandler());
	}

	
	public void render(int fps, long totalFrames) {
		g2D = (Graphics2D) bs.getDrawGraphics();
		
		// Wipe the previous information
		g2D.clearRect(0, 0, WIDTH, HEIGHT);
		
		for (int x = 0; x < WIDTH; x += 32) {
			for (int y = 0; y < HEIGHT; y += 32) {
				g2D.drawImage(Instances.sheetLoader.getSpriteSheet(1).getSprites()[10].getSprite(), x, y, this);
			}
		}
		
		int x = 128;
		int y = 32;
		for (int i = 0; i < Instances.sheetLoader.getSpriteSheet(0).getSprites().length; i++) {
			g2D.drawImage(Instances.sheetLoader.getSpriteSheet(0).getSprites()[i].getSprite(), x, y, this);
			
			x += 32;
			if (x > 608) {
				x = 128;
				y += 32;
			}
		}
		x = 608;
		y = 32;
		for (int i = 0; i < Instances.sheetLoader.getSpriteSheet(1).getSprites().length; i++){
			g2D.drawImage(Instances.sheetLoader.getSpriteSheet(1).getSprites()[i].getSprite(), x, y, this);
			
			x += 32;
			if (x > 1152) {
				x = 672;
				y += 32;
			}
		}
		
		// Draw the rectangle
		g2D.setColor(Color.white);
		g2D.fillRect(Instances.player.getX(), Instances.player.getY(), Instances.player.getSizeX(), Instances.player.getSizeY());
		
		// Draw debug info
		g2D.setColor(Color.YELLOW);
		g2D.drawString("Total Frames: " + totalFrames, 10, 20);
		g2D.drawString("FPS: " + fps, 10, 40);
		g2D.drawString("Player.Location.X: " + Instances.player.getX(), 10, 60);
		g2D.drawString("Player.Location.Y: " + Instances.player.getY(), 10, 80);
		g2D.drawString("KEY.LEFT STATE: " + Instances.player.getMovementState(Player.KEY_MOVEMENTS.LEFT), 10, 100);
		g2D.drawString("KEY.RIGHT STATE: " + Instances.player.getMovementState(Player.KEY_MOVEMENTS.RIGHT), 10, 120);
		g2D.drawString("KEY.UP STATE: " + Instances.player.getMovementState(Player.KEY_MOVEMENTS.UP), 10, 140);
		g2D.drawString("KEY.DOWN STATE: " + Instances.player.getMovementState(Player.KEY_MOVEMENTS.DOWN), 10, 160);
		g2D.drawString("KEY.SHIFT STATE: " + Instances.player.getMovementState(Player.KEY_MOVEMENTS.SHIFT), 10, 180);
		
		
		g2D.dispose();
		bs.show();
	}
}
