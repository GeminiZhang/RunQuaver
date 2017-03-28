import java.awt.image.BufferedImage;
import java.util.Random;

public class Holes {
	BufferedImage image;
	int x; int y; // (x,y) is the center of two columns
	int width; 
	int height;
	int gap = 144; // the gap between the column on the top and the column on the buttom
	Random r = new Random();
	int distance = 245; // the horizontal distance between two columns
}
