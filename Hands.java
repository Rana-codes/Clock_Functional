package clock_Functional;

//File: Hands
//Name: Harsh Rana

/**
* A clock has three hands and all three hands different properties making them
* complex enough to be created into a seperate object.
*/
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;

public class Hands {
	// pi is declared as a constant so that it doesn't change and is easier to use.
	final double pi = Math.PI;
	
	//Instance variables
	private double radius, xcenter, ycenter;
	
	// constructor
	/**
	 * The following information is required to make hands of the clock.
	 * @param rad - Radius of the clock
	 * @param xcen - x co-ordinate of the center of the clock
	 * @param ycen - y co-ordinate of the center of the clock
	 */
	public Hands(double rad, double xcen, double ycen) {
		radius = rad;
		xcenter = xcen;
		ycenter = ycen;
	}
	
	/**
	 * Required information is taken from the instance variables,
	 * hands of the clock are created and programmed to function appropriately.
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		
		//The local time is received so that whenever the clock is run, it shows the exact time.
		LocalDateTime now = LocalDateTime.now(); 
		// %12 because hours return time in 24 hr format.
		int hours = now.getHour()%12; 
		int minute = now.getMinute();
		int seconds = now.getSecond();
		
		double hourAngle = (((pi/6)*hours)+((pi/360)*minute))-pi/2;
		double minuteAngles = ((pi/30)*minute)-pi/2;
		double secondAngles = ((pi/30)*seconds)-pi/2;
				
				 
		// All the hands start at origin		
		Point2D.Double handsStartAt = new Point2D.Double(xcenter,ycenter);
		// These points are to set the length of the hands	
		Point2D.Double hourHandEnd = new Point2D.Double((xcenter + (3*radius/5)*Math.cos(hourAngle)),(ycenter + (3*radius/5)*Math.sin(hourAngle)));
		Point2D.Double minuteHandEnd = new Point2D.Double((xcenter + (3.9*radius/5)*Math.cos(minuteAngles)),(ycenter + (3.9*radius/5)*Math.sin(minuteAngles)));
		Point2D.Double secondHandEnd = new Point2D.Double((xcenter + (4.3*radius/5)*Math.cos(secondAngles)),(ycenter + (4.3*radius/5)*Math.sin(secondAngles)));
			
		Line2D.Double hourHand = new Line2D.Double(handsStartAt, hourHandEnd);
		Line2D.Double minuteHand = new Line2D.Double(handsStartAt, minuteHandEnd);
		
		// Stylea are set for differentiation and the hands are drawn
		g2.setStroke(new BasicStroke(8));
		g2.draw(hourHand);
		g2.setStroke(new BasicStroke(4));
		g2.draw(minuteHand);
			
		g2.setColor(Color.RED);
		Line2D.Double secondHand = new Line2D.Double(handsStartAt, secondHandEnd);
			g2.setStroke(new BasicStroke(2));
		g2.draw(secondHand);
				
		// When all hands combine in the middle, it looks very messy, therefore a red circle is drawn to cover it up.
		Ellipse2D.Double centerDot = new Ellipse2D.Double(xcenter-(radius/40), ycenter-(radius/40), radius/20, radius/20);
		g2.fill(centerDot);
			
	}
	
}
