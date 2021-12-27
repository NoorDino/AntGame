package com.mycompany.a1;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Flag extends Fixed{
	private int sequenceNumber;
	
	Flag(int size, Point p){
		super(size, p);
		setColor(ColorUtil.BLUE);
	}
	
	public void setSeqNum(int num) {
		sequenceNumber = num;
	}
	
	public int getSeqNum() {return sequenceNumber;}
	
	@Override
	public void changeLocation(Point p) {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		float x = (float)(Math.round(getLocation().getX() * 10.0)/10.0);
		float y = (float)(Math.round(getLocation().getY() * 10.0)/10.0);
		return ("Flag: loc=" + x + "," + y + " color =[" + ColorUtil.red(getColor())+ ","+ColorUtil.green(getColor())
		+","+ColorUtil.blue(getColor())+"]" + " size="+ getSize() + " seqNum=" + sequenceNumber);
	}

}
