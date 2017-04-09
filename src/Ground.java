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
		image = ImageIO.read(getClass().getResource("image0.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 0;
	}
}
