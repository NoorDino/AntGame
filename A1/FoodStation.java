package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class FoodStation extends Fixed{
	private int capacity;
	FoodStation(){
		super();
		setColor(ColorUtil.GREEN);
		Random rand = new Random();
		capacity = rand.nextInt(5) + 15; // random integer between 5 & 10
	}
	
	public int getCapacity() {return this.capacity;}
	public void deplete() {
		this.capacity = 0; //food station has been collided with by ant
		setColor(ColorUtil.rgb(0, 150, 0));
	}

	@Override
	public void changeLocation(Point p) {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		float x = (float)(Math.round(getLocation().getX() * 10.0)/10.0);
		float y = (float)(Math.round(getLocation().getY() * 10.0)/10.0);
		return ("FoodStation: loc=" + x + "," + y + " color =[" + ColorUtil.red(getColor())+ ","+ColorUtil.green(getColor())
		+","+ColorUtil.blue(getColor())+"]" + " size="+ getSize() + " Capacity=" + capacity);
	}
}
