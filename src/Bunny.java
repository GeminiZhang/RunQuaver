import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bunny {
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
	int size = 40;			// width/height of Bunny, center is (x,y)

	public Bunny() throws Exception {
		g = 3; 	  // acceleration of gravity
		t = 0.25; // unit time
		v0 = 20;  // initial velocity
		x = 132;  // initial x coordinate
		y = 275;  // initial y coordinate

		// load animation frames(images)
		images = new BufferedImage[8]; 
		for(int i=0; i<8; i++){
			images[i] = ImageIO.read(getClass().getResource("sprite_"+i+".png"));
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
	// check if it drops into the hole
	public boolean hit(Hole hole){
		if(x>hole.x+size/2 && x<hole.x+hole.width && y==480){
			return true;
		}
			return false;
		}
	public boolean pass(Hole hole){
		if(!hole.passed&&hole.x+hole.width<x){
			hole.passed=true;
			return true;
		}
		return false;
	}
	// draw the image
		public synchronized void draw(Graphics g){
			Graphics2D g2=(Graphics2D)g;
			g2.rotate(angle,x,y); // rotate 
			int a=this.x-image.getWidth()/2;
			int b=this.y-image.getHeight()/2;
			g.drawImage(image,a,b,null);
			g2.rotate(-angle,x,y);// rotate back
		}
}
