package sprite;

import model.Update;

public class Sprite implements Update, Drawable{
	private double xPos, yPos, xPosVel, yPosVel, xAcc, yAcc;
	private char[][] charSet;
	
	public Sprite(char[][] cs){
		charSet = cs;
	}
	
	public Sprite(String s){
		char[][] c = {s.toCharArray()};
		charSet = c;
	}
	
	public void update(double delta){
		xPosVel += xAcc * delta;
		yPosVel += yAcc * delta;
		xPos += xPosVel * delta;
		yPos += yPosVel * delta;
	}
	
	public double getX(){
		return xPos;
	}
	public double getY(){
		return yPos;
	}
	
	public void setxAcc(double d){
		xAcc = d;
	}
	public void setyAcc(double d){
		yAcc = d;
	}
	
	public void setX(double d){
		xPos = d;
	}
	public void setY(double d){
		yPos = d;
	}
	
	public void setChar(char[][] c){
		charSet = c;
	}
	
	public void setString(String s){
		char[][] c = {s.toCharArray()};
		charSet = c;
	}
	
	public char[][] getCharSet() {
		return charSet;
	}
	
	public int getIndex() {
		return 0;
	}
}
