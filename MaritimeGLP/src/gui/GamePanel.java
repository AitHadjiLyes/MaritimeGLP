package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS
		private final int orignalTileSize = 32; // which means each tile has 16px
		private final int scale = 1; // to be able to modify the scaling of the game easily
		private final int tileSize = orignalTileSize * scale ;
		private final int maxScreenCol = 40;
		private final int maxScreenRow = 30;
		private final int screenWidhth = maxScreenCol * tileSize;
		private final int screenHeight = maxScreenRow * tileSize;
		private Thread gameThread;
		private int fps = 60;
		
		public GamePanel() {
			this.setPreferredSize(new Dimension(screenWidhth,screenHeight));
			this.setBackground(Color.blue);
			this.setDoubleBuffered(true);
			this.setFocusable(true);
		}
		public void startGameThread() {
			gameThread = new Thread(this);
			gameThread.start();
		}
		
		
		public void update() throws IOException {
		}

		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			Graphics2D g2 = (Graphics2D)g;

			
			
			
		    
		    
		       
		        g2.dispose();
		    }
			
		
		
	@Override
	public void run() {
		double drawInterval = 1000000000/fps;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		
		
		try {
			double remainingTime = nextDrawTime - System.nanoTime();
			remainingTime = remainingTime/1000000;
			
			if(remainingTime < 0) {
				remainingTime = 0;
			}
			
			Thread.sleep((long)remainingTime);
			
			nextDrawTime += drawInterval;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
