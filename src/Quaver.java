import java.awt.image.BufferedImage;

public class Quaver {
	int x;	int y; 			// x, y coordinate, the center of Quaver
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
	
	
}
