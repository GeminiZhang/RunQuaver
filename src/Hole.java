import java.awt.image.BufferedImage;
import java.util.Random;

public class Hole {
	BufferedImage image;
	int x; int y; // (x,y) is the left top center
	int width; 
	int distance;//the distance between two holes
	boolean passed;
	Random r = new Random();
}
