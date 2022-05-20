import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel implements Runnable {
	

	private java.util.List<Ball> balls;
	Thread threadObjPtr  = null;
	Dimension dimension = null;

	@Override
	public void run() {
		balls = new ArrayList<>();
		// Generation of the  balls 
		for (int i = 0; i < 20; i++) {
			Ball ball = new Ball(
					(int) Math.floor(Math.random() * dimension.width),
					(int) Math.floor(Math.random() * dimension.height),
					(int) Math.floor(Math.random() * 20) + 10,
					// Random RGB colors
					new Color(
							(int) Math.floor((Math.random() * 256)),
							(int) Math.floor((Math.random() * 256)),
							(int) Math.floor((Math.random() * 256))
							),
					// Random velocities from -5 to 5 
					(int) Math.floor((Math.random() * 10) - 5),
					(int) Math.floor((Math.random() * 10) - 5)
					);

			balls.add(ball);
		}
		this.setSize(dimension.width, dimension.height);
		this.setVisible(true);
		while(threadObjPtr != null) {
			
			for (Ball b: balls) {
				b.move(dimension);
			}

			// Giving  Swing for every 10 milliseconds 
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}

	}

	//run thread
	void start() {
		if(threadObjPtr == null) {
			threadObjPtr = new Thread(this);
			if(dimension == null) {
				dimension = new Dimension(this.getWidth(), this.getHeight());
			}
			threadObjPtr.start();
		}
	}

	//terminate thread
	void stop() {
		threadObjPtr = null;
		dimension = null;
	}
	
	//paint panel
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		if(dimension != null) {
			for (Ball b: balls) {
				b.draw(graphics);
			}
		}
	}

}
