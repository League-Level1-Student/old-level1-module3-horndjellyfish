/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {

	// Complete steps 1 - 7 before you test
	// 1. Declare a JFrame variable
		JFrame frame = new JFrame();
	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private boolean simonSays = false;
	Date timeAtStart;

	private void makeAlbum() {
		// 2. Add the four images that match keyboard keys like this: 
		images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "down.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "right.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "left.jpg");
		
		// 3. Use a JOptionPane to tell the user the rules: "Press the matching key when
		// 'Simon says' otherwise press a different key"
		JOptionPane.showMessageDialog(frame, "Press the matching key when 'Simon Says.' Otherwise press a different key.");
		// 4. Call the showImage method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		// 15. Make a points variable to track the score.
			int points = 0;
		// 16. If the keyCode matches the imageIndex and "Simon says"
			if (e.getKeyCode() == imageIndex && simonSays == true) {
				points = points + 1;
				speak("You are correct!");
			}
			// 17. Increase the value of score
		
			// 18. Use the speak method to tell the user they were correct
		
		// 19. If the keyCode doesn't match the imageIndex and "Simon didn't say..."
			else if (e.getKeyCode() != imageIndex && simonSays == false){
				points = points + 1;
				speak("You are correct!");
				}
			// 20.  Increase the value of score
		
			// 21. Use the speak method to tell the user they were correct
		
		// 22. Increment tries by 1
			tries = tries + 1;
		// 25. If tries is greater than 9 (or however many you want)...
			if (tries > 9) {
				JOptionPane.showMessageDialog(frame, "Your score is " + points);
				
			}
			// 26. Tell the user their score
		
			// 27. Exit the program

		// 23. Dispose of the frame
			frame.dispose();
		// 24. Call the showImage method to show a new image
			showImage();
	}

	private void showImage() {
		// 5. Initialize your frame to a new JFrame()
		JFrame frameb = new JFrame();
		// 6. Set the frame to visible
		frameb.setVisible(true);
		// 7. Uncomment the following line to add a random image to your frame
		frameb.add(getNextRandomImage());
		// 8. Set the name of your frame
		frameb.setTitle("Simon Says");
		// 9. Pack the frame
		frameb.pack();
		// 10. Set the defaultCloseOperation of your from to JFrame.EXIT_ON_CLOSE
		frameb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 11. Add a key listener to the frame
		frameb.addKeyListener(this);
		// 12. Create a new instance of Random
		Random random = new Random();
		// 13. Use the Random and the speak method to either say 
		// "Simon says press this key" or "Press this key"
		speak("Simon says");
		simonSays = true;
		// 14. Above, set the value of simonSays to true/false appropriately
		
		
	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new SimonSays().makeAlbum();
	}
}

/*
 * BONUS!
 * Add a timer :
 * ~~~ where the code starts running ~~~ 
 * timeAtStart = newDate();
 *
 * ~~~ where the code ends ~~~ 
 * Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */





