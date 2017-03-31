import java.awt.image.BufferedImage;
import java.util.Random;

public class Hole {
	BufferedImage image;
	int x; int y; // (x,y) is the center of the hole
	int width; 
	int depth;
	Random r = new Random();
	int distance = 245;//the distance between two holes
}
