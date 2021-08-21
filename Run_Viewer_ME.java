package clock_Functional;

//File: ClockComponent
//Name: Harsh Rana

/**
* Clock Viewer provides the interface for the user to be able to see the clock.
*/
import javax.swing.JFrame;

public class Run_Viewer_ME {
	
	public static void main(String[] args)
	   {
		JFrame frame = new JFrame();

	    final int FRAME_WIDTH = 400;
	    final int FRAME_HEIGHT = 400;
	    
	    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	    frame.setTitle("CLOCK");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		// The component is created and added to the frame.
		ClockComponent component = new ClockComponent(); 
		frame.add(component);
		 

	    frame.setVisible(true);
	   }

}
