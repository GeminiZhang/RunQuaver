import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Hole {
	BufferedImage image;
	int x; int y; // (x,y) is the left top center
	int width; 
	int distance;//the distance between two holes
	boolean passed;
	Random r = new Random();
	public Hole(int n) throws IOException { 
		distance=200;
		x=distance*n+250;
		y=500;
		image=ImageIO.read(getClass().getResource("hole.png"));
		width=image.getWidth();
		passed=false;
	}
	// move the hole to the left
		public void move(){
			x-=5;
			if(x<=-width){ // reset (x,y) when the columns go to the end
				x=250+distance+r.nextInt(300);
				passed=false;
			}
		}
		
		// draw the image
		public void draw(Graphics g){
			g.drawImage(image,x,y,null);
		}
	}

