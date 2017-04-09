import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	BufferedImage image;
	int x; int y; // (x,y) is the top left corner
	int width;
	int height;
	public Ground() throws IOException {
		y = 500;
		image = ImageIO.read(getClass().getResource("ground.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 0;
	}
	// move the ground to the left
		public void move(){
			x-=5;
			if(x<=-(111)){ // when it goes to the end, start over 
				x=0;
			}
		}
}
