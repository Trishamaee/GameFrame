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
		else if(e.getKeyCode() == KeyEvent.VK_X){
			System.out.println("Duck");
			drawing.crouch();
		}
		else if(e.getKeyCode() == KeyEvent.VK_W){
			System.out.println("PAK!");
			drawing.punch();
		}
		else if(e.getKeyCode() == KeyEvent.VK_E){
			System.out.println("SITDOWN!");
			drawing.kick();
		}
		else if(e.getKeyCode() == KeyEvent.VK_C){
			System.out.println("!");
			drawing.smrslt();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q){
			System.out.println("Attack with a Bow");
			drawing.bow();
		}
		else if(e.getKeyCode() == KeyEvent.VK_R){
			System.out.println("Ughhhhh");
			drawing.dropkick();
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
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("attack");
			drawing.attack();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.spawnEnemy();
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
		gameFrame.setSize(640, 400);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("Ugh");
	}
}