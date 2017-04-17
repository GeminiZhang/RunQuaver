import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class World extends JPanel{
	BufferedImage background;
	BufferedImage gameOver;
	BufferedImage start;
	public World() throws IOException {
		background=ImageIO.read(getClass().getResource("bg.png"));
		gameOver=ImageIO.read(getClass().getResource("gameover.png"));
		start=ImageIO.read(getClass().getResource("start.png"));
		initialize();
	}
	public void initialize(){
		
	}
	public static void main(String[] args){
		
	}
}
