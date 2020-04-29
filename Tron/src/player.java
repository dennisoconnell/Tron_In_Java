
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class player {
	int xDefault;
	int yDefault;
	int xPos;
	int yPos;
	ArrayList<Integer> xTails = new ArrayList<Integer>(0);
	ArrayList<Integer> yTails = new ArrayList<Integer>(0);
	int sides= 10;
	Color color; 
	int velocity = 11;
	boolean horizontal = true;
	boolean vertical = true;
	int counter;
	public player(Color colorTemp, int x, int y) {
		color = colorTemp;
		xPos = x;
		yPos = y;
	}
	public boolean collide (player p, ArrayList<Integer> x, ArrayList<Integer> y){		
		for (int i = 0; i < x.size(); i++) {
			int xCor = x.get(i);
			int yCor = y.get(i);
			int tempX;
			int tempY;
			tempX = xPos + sides / 2;
			tempY = yPos + sides / 2;
			boolean xCollide = tempX > xCor && tempX < xCor + sides;
		    boolean yCollide = tempY > yCor && tempY < yCor + sides;
		    if (xCollide && yCollide) {
		    	System.out.println(i);
		    	
		    	return true;
		    }
		}
		return false;
	}
	public void display(Graphics g){
		g.setColor(color);
		g.fillRect(xPos,yPos, sides, sides);
		for(int i = 0; i < xTails.size(); i++){
			g.fillRect(xTails.get(i),yTails.get(i), sides, sides);
		}
		
	}
	public void move(){
		if (horizontal && vertical){
			xPos += velocity;
		} else if (horizontal && !vertical){
			xPos -= velocity;
		} else if (!horizontal && vertical){
			yPos += velocity;
		} else{
			yPos -= velocity;
		}
		if (counter > 0) counter += -1;
		xTails.add(xPos);
		yTails.add(yPos);
	}
	
	public void reset(){
		yPos = yDefault;
		xPos = xDefault;
		xTails = new ArrayList<Integer>(0);
		yTails = new ArrayList<Integer>(0);
	}
}
