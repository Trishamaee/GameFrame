import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");

	//CIRCLE'S POSITION
	public int x = 50;
	public int y = 285;

	//animation states
	public int states = 0;

	// randomizer
	public Random randomizer;

	// enemy
	public int enemyCount;
	Monster[] monsters = new Monster[10];

	public Draw(){
		randomizer = new Random();
		spawnEnemy();

		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("Bg.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void spawnEnemy(){
		if(enemyCount < 10){
			monsters[enemyCount] = new Monster(randomizer.nextInt(500), randomizer.nextInt(500), this);
			enemyCount++;
		}
	}

	public void reloadImage(){

		states++;

		if(states == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(states == 1){
			resource = getClass().getResource("run1.png");
			
		} 
		else if(states == 2){
			resource = getClass().getResource("run2.png");
			
		}
		else if(states == 3){
			resource = getClass().getResource("run3.png");
			
		}
		else if(states == 4){
			resource = getClass().getResource("run4.png");
			
		}
		else if(states == 5){
			resource = getClass().getResource("run5.png");
			states = 0;
		}

		try{
			image = ImageIO.read(resource);

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void attackAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run1.png");
						}
						else{
							resource = getClass().getResource("attack"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		thread1.start();

	}

	public void jumpAnimation(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run1.png");
							y = y - 15;
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
							
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();

	}

	public void crouchAnimation(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run1.png");
						}
						else{
							resource = getClass().getResource("crouch"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(80);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();

	}

	public void bowAnimation(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("run1.png");
						}
						else{
							resource = getClass().getResource("bow"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(80);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();

	}

	public void punchAnimation(){
		Thread thread5 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 14; ctr++){
					try{
						if(ctr==13){
							resource = getClass().getResource("run1.png");
						}
						else{
							resource = getClass().getResource("punch"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(80);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread5.start();

	}

	public void kickAnimation(){
		Thread thread6 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("run1.png");
						}
						else{
							resource = getClass().getResource("kick"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(80);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread6.start();

	}

	public void fallAnimation(){
		Thread thread7 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("walk0.png");
							y = y + 15;
						}
						else{
							resource = getClass().getResource("fall"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread7.start();

	}

	public void smrsltAnimation(){
		Thread thread8 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run1.png");
							y = y + 20;
						}
						else{
							resource = getClass().getResource("smrslt"+ctr+".png");
							y = y - 5;
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread8.start();

	}

	public void dropkickAnimation(){
		Thread thread9 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5; ctr++){
					try{
						if(ctr==4){
							resource = getClass().getResource("run1.png");
							y = y + 20;
						}
						else{
							resource = getClass().getResource("dropkick"+ctr+".png");
							y = y - 5;
							x = x + 15;
							
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread9.start();

	}

	public void attack(){
		attackAnimation();
	}

	public void moveRight(){
		x = x + 5;
		repaint();
	}

	public void moveLeft(){
		x = x - 5;
		repaint();
	}

	public void moveUp(){
		/*y = y - 5;
		repaint();*/
		jumpAnimation();
	}

	public void moveDown(){
		/*y = y + 5;
		repaint();*/
		fallAnimation();
	}

	public void crouch(){
		crouchAnimation();
	}

	public void bow(){
		bowAnimation();
	}

	public void punch(){
		punchAnimation();
	}

	public void kick(){
		kickAnimation();
	}

	public void smrslt(){
		smrsltAnimation();
	}

	public void dropkick(){
		dropkickAnimation();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image,x,y,this);

		for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				// character grid for monsters
				// g.setColor(Color.BLUE);
				// g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
				g.setColor(Color.GREEN);
				g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
			}	
		}

	}
}