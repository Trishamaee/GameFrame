import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

	//key interphase?
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("Pos: " + drawing.x + "," + drawing.y);
			drawing.moveRight();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			System.out.println("Pos: " + drawing.x + "," + drawing.y);
			drawing.moveDown();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			System.out.println("Pos: " + drawing.x + "," + drawing.y);
			drawing.moveLeft();
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			System.out.println("Pos: " + drawing.x + "," + drawing.y);
			drawing.moveUp();
		}
		drawing.reloadImage();
	}

	public void keyReleased(KeyEvent e){
		

	}

	public void keyTyped(KeyEvent e){

	}

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(600, 600);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("Ugh");
	}
}