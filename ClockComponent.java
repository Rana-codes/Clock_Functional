package clock_Functional;

//File: ClockComponent
//Name: Harsh Rana

/**
* Clock component acts as the canvas on which the clock can be drawn.
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;


public class ClockComponent extends JComponent {
	
	private Timer t;
	private Clock myClock;
	private Graphics2D g2;
	private double radius;
	
	public void paintComponent(Graphics g) {  
		
		g2 = (Graphics2D) g;
		
		//It is made sure that the clock is always drawn at the center of the component.
		radius = 0;
		if (getWidth() <= getHeight()) {
			radius = (getWidth()-20)/2;
		}
		
		else {
			radius = (getHeight()-20)/2;
		}
		
		// Clock is created and drawn.
		myClock = new Clock(radius, getWidth()/2, getHeight()/2);
		myClock.draw(g2);
		
		startTimer();
	}
	
	// Redraws the clock so that the the time is updated every second.
	private void startTimer(){
		
		class TimerListen implements ActionListener{
        	
			public void actionPerformed(ActionEvent event){
				myClock = new Clock(radius, getWidth()/2, getHeight()/2);
				repaint();
            }
		}
        
        t = new Timer(1000, new TimerListen());
        t.start(); 
    }
}
