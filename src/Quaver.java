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
		
	}
}
