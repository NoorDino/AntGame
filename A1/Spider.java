package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Spider extends Moveable{
	Spider(){
		super();
		Random random = new Random();
		int x = random.nextInt(5) + 5; // random integer between 5 & 10
		setSpeed(x);
		int y = random.nextInt(359); //random integer between 0 & 359
		setHeading(y);
		setColor(ColorUtil.BLACK);
	}

	public void crawl() {
		move();
		Random random = new Random();
		int number = random.nextInt(10) - 5; //random integer between -5 & 5
		setHeading(getHeading() + number);
	}
	
	

	@Override
	public String toString() {
		float x = (float)(Math.round(getLocation().getX() * 10.0)/10.0);
		float y = (float)(Math.round(getLocation().getY() * 10.0)/10.0);
		return ("Spider: loc=" + x + "," + y + " color =[" + ColorUtil.red(getColor())+ ","+ColorUtil.green(getColor())
		+","+ColorUtil.blue(getColor())+"]" + " heading=" + getHeading() + " speed=" + getSpeed() +" size="+ getSize());
	}
}
