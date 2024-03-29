package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements ISteerable{
	private int foodLevel;
	private int maxSpeed;
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlag;
	private int maxHealthLevel;	
	
	Ant(int size, Point p){
		super(size, p);
		this.healthLevel = 10;
		this.maxHealthLevel = 10;
		this.foodLevel = 100;
		this.foodConsumptionRate = 5;
		this.lastFlag = 1;
		this.maxSpeed = this.healthLevel;
		setSpeed(5);
		setHeading(0);
		setColor(ColorUtil.rgb(130, 0, 0));
	}

	
	public int getMaxSpeed() {return maxSpeed;}
	public int getFoodRate() {return foodConsumptionRate;}
	public int getFoodLevel() {return foodLevel;}
	public void updateFoodLevel(int level) {this.foodLevel += level;}
	public void updateLastFlag() {if(lastFlag < 9) {lastFlag++;}}
	public int getLastFlag() {return lastFlag;}
	public int getHealthLevel() {return healthLevel;}

	@Override
	public String toString() {
		float x = (float)(Math.round(getLocation().getX() * 10.0)/10.0);
		float y = (float)(Math.round(getLocation().getY() * 10.0)/10.0);
		return ("Ant: loc=" + x + "," + y + " color =[" + ColorUtil.red(getColor())+ ","+ColorUtil.green(getColor())
		+","+ColorUtil.blue(getColor())+"]" + " heading=" + getHeading() + " speed=" + getSpeed() +" size="+ getSize() + 
		" maxSpeed=" + getMaxSpeed() + " foodConsumptionRate=" + getFoodRate());
	}

	@Override
	public void turnLeft() {
		setHeading(getHeading() - 5);
		if(this.getHeading() < 0) {
		   this.setHeading(360 + this.getHeading());
		}
	}
	@Override
	public void turnRight() {
		setHeading(getHeading() + 5);
		if(this.getHeading() > 360) {
			   this.setHeading(this.getHeading() - 360);
			}
	}
	
	public void accelerate() {
		maxSpeed = maxSpeed * (healthLevel/10);
		if((getSpeed() + 2) <= this.maxSpeed) {
			setSpeed(getSpeed() + 2);
		}else {
			setSpeed(maxSpeed);
		}
		checkStarving();
	}
	public void brake() {
		if(this.getSpeed() > 0) {
			setSpeed(getSpeed() -1);
		}
	}
	
	public void checkStarving() {
		if(foodLevel <= 0) {
			setSpeed(0);
		}
	}
	public void updateSpeed() {
		float updateSpeed = maxSpeed * (healthLevel/10);
		//maxSpeed = maxSpeed * (healthLevel/10);
		if (getSpeed() > maxSpeed) {
			setSpeed(maxSpeed);
			checkStarving();
		}
	}
	public void consume() {
		foodLevel = foodLevel - foodConsumptionRate;
	}
	public void collideWithSpider() {
		healthLevel--;
		int redShade = ColorUtil.red(getColor()) + 10;
		int updatedColor = ColorUtil.rgb(redShade, 0, 0);
		setColor(updatedColor);
		updateSpeed();
		
	}
	

	
}
