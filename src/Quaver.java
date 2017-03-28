import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Quaver {
	int x;	
	int y; 			// x, y coordinate, the center of Quaver
	double angle; 			// angle when flying 
	BufferedImage[] images; // animation frames(images)
	BufferedImage image; 	// current frame(image)
	int index = 0; 			// image index
	final double g; 		// acceleration of gravity
	final double t;			// unit time 
	final double v0;		// initial velocity 
	double velocity;		// current velocity
	double s;    			// distance
	int size = 40;			// width/height of Quaver, center is (x,y)
	
	public Quaver() throws Exception {
		g = 4; 	  // acceleration of gravity
		t = 0.25; // unit time
		v0 = 20;  // initial velocity
		x = 132;  // initial x coordinate
		y = 275;  // initial y coordinate
		
		// load animation frames(images)
		images = new BufferedImage[8]; 
		for(int i=0; i<8; i++){
			images[i] = ImageIO.read(getClass().getResource(i+".png"));
		}
		image = images[0]; // set current frame(image)
	}
	
	public void move(){
		double v0 = velocity; // get current velocity
		double v = v0 - g*t;  // calculate v after t unit time
		velocity = v; 		  // set current velocity to v
		s = v0*t - 0.5 * g * t * t; // calculate the vertical displacement
		y = y - (int)s; // calculate y coordinate 
		angle = -Math.atan(s/8); // calculate the flying angle
	}
	// switch to the next frame(image)
		public void animate(){
			index++;
			image = images[(index/8)%images.length];
		}
		
		
		public void jump(){
			velocity = v0; // reset current velocity to initial velocity
		}
		
		
		// paint the image
		public synchronized void paint(Graphics g){
			Graphics2D g2 = (Graphics2D)g;
			g2.rotate(angle, this.x, this.y); // rotate 
			int x = this.x-image.getWidth()/2;
			int y = this.y-image.getHeight()/2;
			g.drawImage(image, x, y, null);
			g2.rotate(-angle, this.x, this.y);// rotate back
		}
		public boolean pass(Holes hole1, Holes hole2) {
			return hole1.x==x || hole2.x==x;
		}

}
