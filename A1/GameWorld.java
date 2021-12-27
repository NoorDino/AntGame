package com.mycompany.a1;
import java.util.ArrayList;
import java.util.Random;

import com.codename1.charts.models.Point;

public class GameWorld {
	
	private int clockTicks = 0;
	private int lives = 3;
	private int lastFlag = 4;
	Ant ant;
	ArrayList<GameObject> myGameObjects;
	
	public void init() {
		
		myGameObjects = new ArrayList<GameObject>();
		populateGame();
		//code here to create the       
		//initial game objects/setup
		
	}
	
		// additional methods here to    
	    // manipulate world objects and
	    // related game state data
	public void populateGame() {
		Spider spider1 = new Spider();
		Spider spider2 = new Spider();
		
		FoodStation station1 = new FoodStation();
		FoodStation station2 = new FoodStation();
		
		Point start = new Point(200,200);
		Flag flag1 = new Flag(10, start);
		Point p = new Point(200,800);
		Flag flag2 = new Flag(10, p);
		p = new Point(700,800);
		Flag flag3 = new Flag(10, p);
		p = new Point(900,400);
		Flag flag4 = new Flag(10, p);
		
		ant = new Ant(5,start);
		
		myGameObjects.add(flag1);
		myGameObjects.add(flag2);
		myGameObjects.add(flag3);
		myGameObjects.add(flag4);
		myGameObjects.add(ant);
		myGameObjects.add(spider1);
		myGameObjects.add(spider2);
		myGameObjects.add(station1);
		myGameObjects.add(station2);	
	}
	
	public void showMap() {
		System.out.println("Showing Map");
		for(GameObject obj : myGameObjects) {
			System.out.println(obj);
		}
	}
	public void gameState() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Game State");
		System.out.println("Lives Remaining: " + lives);
		System.out.println("Time: " + clockTicks);
		System.out.println("Highest Flag Reached: " + ant.getLastFlag());
		System.out.println("Current Food Level: " + ant.getFoodLevel());
		System.out.println("Health Level: " + ant.getHealthLevel());
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	//---------------------------------------------------------------
	//----Map and game state above --- rest of the commands below ---
	//---------------------------------------------------------------
	
	public void accelerate() {
		ant.accelerate();
		System.out.println("Ant is accelerating!");
	}
	public void brake() {
		ant.brake();
		System.out.println("Ant is braking!");

	}
	public void headLeft() {
		ant.turnLeft();
		System.out.println("Turning left!");
	}
	public void headRight() {
		ant.turnRight();
		System.out.println("Turning right!");
	}
	public void collideFlag(int num) {
		if((ant.getLastFlag()+1) == num) {
			ant.updateLastFlag();
			System.out.println("Flag " + num + " has been collided with!");
		}
		if(ant.getLastFlag() == lastFlag) {  //check if the last flag was reached, you win if it is
			System.out.println("Game Over, you won!! Total Time: " + clockTicks);
			exit();
		}
	}
	public void collideFoodStation() {
		for(GameObject obj : myGameObjects) {
			if(obj instanceof FoodStation) {
				if(((FoodStation) obj).getCapacity() != 0) {
					ant.updateFoodLevel(((FoodStation) obj).getCapacity());
					System.out.println("Ant collided with food station. Food level up by: " + ((FoodStation) obj).getCapacity());
					((FoodStation) obj).deplete();
					myGameObjects.add(new FoodStation());
					return;
				}
			}
		}

	}
	public void caughtBySpider() {
		for(GameObject obj : myGameObjects) {
			if(obj instanceof Spider) {
				ant.collideWithSpider();
				System.out.println("Ouch! Bit by a spider!");
				return;
			}
		}
		lifeLost(); //check if the any has lost a life, call init if yes
	}
	public void tick() {
		for(GameObject obj : myGameObjects) {
			if(obj instanceof Spider) {
			    ((Spider) obj).crawl();
			}
			if(obj instanceof Ant) {
			    ((Ant) obj).move();
			    ((Ant) obj).consume();
			}
		}
		lifeLost(); //check if the any has lost a life, call init if yes
		System.out.println("Clock Ticked, Locations updated...");
		clockTicks++;//clock tick incremented
	}
	public void exitPrompt() {
		System.out.println("Do you want to exit? Press Y/N then press enter");
	}
	public void exit() {
		System.exit(0);
	}
	public void exitCancelled() {
		System.out.println("Cancel not confirmed...continue");
	}
	public void lifeLost() {
		if(lives <= 0) {
			System.out.println("Game over, you failed!!");
			exit();
		}
		for(GameObject obj : myGameObjects) {
			if(obj instanceof Ant) {
				if(((Ant) obj).getHealthLevel() == 0 || ((Ant) obj).getMaxSpeed() == 0 || ((Ant) obj).getFoodLevel() == 0) {
					System.out.println("You lost a life. Game world is reinitailizing...");
					lives--;
					init();
				}
			}
		}
	}
	
	
}
