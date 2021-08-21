package clock_Functional;

//File: Clock
//Name: Harsh Rana

/**
* A clock can end up being much more complex than we think it is, therefore we made it into an 
* object that further contains more sub objects. 
* This class basically just assembles the parts to form the clock.
*/

import java.awt.Graphics2D;

public class Clock {
	
	// pi is declared as a constant so that it doesn't change and is easier to use.
	final double pi = Math.PI;
	
	// instance variables
	private double radius, xcenter, ycenter;
	private ClockFrame base;
	private Hands hands;
	
	// constructor
	/**
	 * Provided information is received and stored as the properties of clock
	 * @param rad - Radius of the clock
	 * @param xcen - x co-ordinate of the center of the clock
	 * @param ycen - y co-ordinate of the center of the clock
	 */
	public Clock(double rad, double xcen, double ycen) {
		radius = rad;
		xcenter = xcen;
		ycenter = ycen;
	}
	
	/**
	 * Uses different classes to crate and draw a clock on the component.
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		
		base = new ClockFrame(radius, xcenter, ycenter);
		base.draw(g2);
		
		hands = new Hands(radius, xcenter, ycenter);
		hands.draw(g2);	
		
	}
	
	/**
	 * Finds the center of your clock.
	 * @return - The coordinates of center as a string
	 */
	public String getCenter() {
		return "Center [x,y] = "+Double.toString(xcenter)+Double.toString(ycenter);
	}
	
	/**
	 * Finds the radius of your clock.
	 * @return - The radius as a string
	 */
	public String getRadius() {
		return "Radius of the clock = "+Double.toString(radius);
	}

	
}
