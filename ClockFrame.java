package clock_Functional;

//File: ClockFrame
//Name: Harsh Rana

/**
* As the clock frame contains various points for time to be clear.
* Another reason to seperate hands and points was for designing purposes.
*/
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class ClockFrame {
	
	// pi is declared as a constant so that it doesn't change and is easier to use.
	final double pi = Math.PI;
	
	// instance variables
	private double radius, xcenter, ycenter;
	
	/**
	 * The following information is required to make frame of the clock.
	 * @param rad - Radius of the clock
	 * @param xcen - x co-ordinate of the center of the clock
	 * @param ycen - y co-ordinate of the center of the clock
	 */
	public ClockFrame(double rad, double xcen, double ycen) {
		radius = rad;
		xcenter = xcen;
		ycenter = ycen;
	}
	
	
	public void draw(Graphics2D g2) {
		
		// clock's outermost rim
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(8));
		Ellipse2D.Double clockFrame = new Ellipse2D.Double(xcenter-radius, ycenter-radius, radius*2, radius*2);
		g2.draw(clockFrame);
		
		// time differentiating points points
		double angle = 0;
		
		g2.setColor(Color.BLACK);
		
		//To draw lines at major points like when the time is 1 to 12 o' clock.
		for(int i = 0; i<12; i++) {
			if(i%3 == 0) {
				g2.setStroke(new BasicStroke(4));
			}
			else{
				g2.setStroke(new BasicStroke(2));
			}
				
				Point2D.Double smallPoint1 = new Point2D.Double((xcenter + (radius-(radius/7.5))*Math.cos(angle)),(ycenter + (radius-(radius/7.5))*Math.sin(angle)));
				Point2D.Double smallPoint2 = new Point2D.Double((xcenter + (radius-(radius/10))*Math.cos(angle)),(ycenter + (radius-(radius/10))*Math.sin(angle)));
				
				Line2D.Double smallLine = new Line2D.Double(smallPoint1, smallPoint2);
				g2.draw(smallLine);
				angle += pi/6;
			
			
		}
		
		//To draw dots at all the minute/second points
		g2.setColor(Color.BLACK);
		angle = 0;
		for(int i=0; i<60; i++) {
			
			if(i % 5 == 0) {
				angle += pi/30;
			}
			else {
				Ellipse2D.Double dots = new Ellipse2D.Double((xcenter + (radius-(radius/9.5))*Math.cos(angle)),(ycenter + (radius-(radius/9.5))*Math.sin(angle)), 2, 2);
				g2.draw(dots);
				angle += pi/30;
			}
		}
		
			//The text on the clock
			
			g2.setStroke(new BasicStroke(1));
			g2.setColor(Color.BLACK);
			
			String text = "COMPLETE";
			Font font = new Font("Arial", Font.PLAIN, (int)(radius/14));
			g2.setFont(font);
			g2.drawString(text, (int)(xcenter-(radius/5)), (int)(ycenter-(radius/1.5)));
	}
}
