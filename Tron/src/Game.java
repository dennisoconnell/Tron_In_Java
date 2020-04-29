

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game extends Applet implements Runnable,KeyListener {
	
	Thread runner;
	player playerOne = new player(Color.green,0,25);
	player playerTwo = new player(Color.pink,0,500);
	int size = 800;
	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.black);
		
		g.fillRect(0, 0, size, size);
		playerOne.display(g);
		
		playerOne.move();
		g.drawLine(playerOne.xPos,playerOne.yPos,playerTwo.xPos,playerTwo.yPos);
		playerTwo.display(g);
		playerTwo.move();
		if (playerOne.collide(playerOne, playerOne.xTails, playerOne.yTails)){
			System.out.println("Player one has collided with itself");
		}
		playerOne.velocity = 11;
		playerTwo.velocity = 11;
	}
	public void init () {
		setSize(size,size);
		addKeyListener(this);
	}
	public void stop() {
		if (runner != null) runner = null;
	}
	
	public void run() {
		
		while (true){
			
			repaint();
			
			
			try {
				Thread.sleep(30);
			}
			catch (Exception e) {
				
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		char key = arg0.getKeyChar();
		//right is 15
		//left is 23
		// down is 12
		//up is 234
		
		if (key == 'd' &&  !(!playerOne.vertical && playerOne.horizontal)) {
			playerOne.vertical = true;
			playerOne.horizontal = true;
		}  else if (key == 'a' &&  !(playerOne.vertical && playerOne.horizontal)){
			playerOne.vertical = false;
			playerOne.horizontal = true;
		}  else if (key == 's' && !(!playerOne.vertical && !playerOne.horizontal)){
			playerOne.vertical = true;
			playerOne.horizontal = false;
		}  else if (key == 'w' && !(playerOne.vertical && !playerOne.horizontal)){
			playerOne.vertical = false;
			playerOne.horizontal = false;
		}  else if (key == 'f' && playerOne.counter == 0){
			//playerOne.color = Color.blue;
			playerOne.velocity = 45;
			playerOne.counter += 20;
		}
		
		if (key == 'k' && !(!playerTwo.vertical && playerTwo.horizontal)) {
			playerTwo.vertical = true;
			playerTwo.horizontal = true;
		}  else if (key == 'h' && !(playerTwo.vertical && playerTwo.horizontal)){
			playerTwo.vertical = false;
			playerTwo.horizontal = true;
		}  else if (key == 'j' && !(!playerTwo.vertical && !playerTwo.horizontal)){
			playerTwo.vertical = true;
			playerTwo.horizontal = false;
		}  else if (key == 'u' && !(playerTwo.vertical && !playerTwo.horizontal)){
			playerTwo.vertical = false;
			playerTwo.horizontal = false;
		}  else if (key == 'l' && playerTwo.counter == 0){
			//playerOne.color = Color.blue;
			playerTwo.velocity = 45;
			playerTwo.counter += 20;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
