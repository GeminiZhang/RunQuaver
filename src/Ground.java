import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	BufferedImage image;
	int x; int y; // (x,y) is the top left corner
	public Ground() throws IOException {
		y = 500;
		image = ImageIO.read(getClass().getResource("ground.png"));
		x = 0;
	}
	// move the ground to the left
		public void move(){
			x-=5;
			if(x<=-(100)){ // when it goes to the end, start over 
				x=0;
			}
		}
		// paint the ground
		public void paint(Graphics g) {
			g.drawImage(image, x, y, null);		
		}
	}
