import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JPanel;

public class World extends JPanel{
	BufferedImage background;
	BufferedImage gameOver;
	BufferedImage start;
	boolean isGameStarted;
	boolean isGameOver;
	int score;
	Bunny bunny;
	Ground ground;
	Hole hole1;
	Hole hole2;
	
	public World() throws IOException {
		background=ImageIO.read(getClass().getResource("bg.png"));
		gameOver=ImageIO.read(getClass().getResource("gameover.png"));
		start=ImageIO.read(getClass().getResource("start.png"));
		initialize();
	}
	public void initialize(){
		try {
			isGameStarted=false;
			isGameOver=false;
			score=0;
			bunny=new Bunny();
			ground=new Ground(); 
			hole1=new Hole(1);
			hole2=new Hole(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// run the game 
	public void run() throws Exception{	

		// Audio input
		AudioFormat format=new AudioFormat(44100f, 16, 1, true, false);
		final int bufferSize=2048;

		TargetDataLine line;
		try {
			line = AudioSystem.getTargetDataLine(format);
			line.open(format,bufferSize);
		} catch(LineUnavailableException e) {
			e.printStackTrace();
			return;
		}

		byte[] buffer=new byte[bufferSize];
		float[] data=new float[bufferSize/2];
		line.start(); 

		// loop
		while(true){
			if(isGameOver||!isGameStarted){
				int numBytes=line.read(buffer,0,buffer.length);
				if(numBytes>=0){
					for(int i=0,s=0;i<numBytes;) {
						// Convert two bytes to one
						int d = 0;
						d|=buffer[i++]&0xFF; 
						d|=buffer[i++]<<8;  
						data[s++]=d/32768f;// normalize to range of +/-1.0
					}
					float peak = 0f;
					for(float d:data) {
						float p=Math.abs(d);
						if(p>peak) {
							peak=p;
						}
					}
					if(peak>0.5){
						initialize();
						isGameStarted = true;
					}
				}
			}
			if(isGameStarted&&!isGameOver){
				bunny.move();
				int numBytes=line.read(buffer,0,buffer.length);
				if(numBytes>=0){
					for(int i=0,s=0;i<numBytes;) {
						// Convert two bytes to one
						int d = 0;
						d|=buffer[i++]&0xFF; 
						d|=buffer[i++]<<8;  
						data[s++]=d/32768f;// normalize to range of +/-1.0
					}
					float peak = 0f;
					for(float d:data) {
						float p=Math.abs(d);
						if(p>peak) {
							peak=p;
						}
					}

					if( peak > 0.8){ // if sound is loud, jump (notes: max is 1.0, maybe change it to 0.8 or 0.9)
						ground.move();
						hole1.move();
						hole2.move();
						bunny.jump();
					}
					else if( peak > 0.1){ // if it is not loud, just move forward
						ground.move();
						hole1.move();
						hole2.move();
					}
				}
			}
		}
	}
	public static void main(String[] args){
		
	}
}
