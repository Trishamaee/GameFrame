import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Draw extends JComponent{

	private BufferedImage image;
	private URL resource = getClass().getResource("run0.png");

	//CIRCLE'S POSITION
	public int x = 50;
	public int y = 50;

	//animation states
	public int states = 0;

	public Draw(){
		try{
			image = ImageIO.read(resource);

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		if(states == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(states == 1){
			resource = getClass().getResource("run1.png");
			states = 0;
		} 
		else if(states == 2){
			resource = getClass().getResource("run2.png");
			states = 0;
		}
		else if(states == 3){
			resource = getClass().getResource("run3.png");
			states = 0;
		}
		else if(states == 4){
			resource = getClass().getResource("run4.png");
			states = 0;
		}

		try{
			image = ImageIO.read(resource);

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void moveRight(){
		x = x + 5;
		states++;
		reloadImage();
		repaint();
	}

	public void moveLeft(){
		x = x - 5;
		states++;
		reloadImage();
		repaint();
	}

	public void moveUp(){
		y = y - 5;
		states++;
		reloadImage();
		repaint();
	}

	public void moveDown(){
		y = y + 5;
		states++;
		reloadImage();
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 50, 50);
		g.drawImage(image,x,y,this);

	}
}