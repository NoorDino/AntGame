package com.mycompany.a1;
import com.codename1.charts.models.Point;
import java.util.Random;


public abstract class GameObject {
	private int size;
	private Point location; //range 0.0 - 1000.0
	private int color; //objects of same type = same color
	


	GameObject(){
		Random random = new Random();
		Random rand = new Random();
		location = new Point();
		this.size= 10 + random.nextInt(40);
		this.location.setX(rand.nextFloat() * 1000);
		this.location.setY(rand.nextFloat() * 1000);
	}

	GameObject(int size, Point p){ //to be used for ant and flags 
		this.size = size;
		this.location = p;
	}
	
	
	
	public int getSize() {return size;}
	
	public Point getLocation() {return location;}
	public void changeLocation(Point p) {this.location = p;}//TODO not sure if needed
	
	public void setColor(int objColor) {this.color = objColor;}
	public int getColor() {return this.color;}
	
	public abstract String toString(); //TODO define on concrete class

}
