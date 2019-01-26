import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	char currentLetter;

	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}

	public static void main(String[] args) {
		TypingTutor typingtutor = new TypingTutor();
		typingtutor.makeUI();
	}
	void makeUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("type or be ashamed");
		frame.setVisible(true);
		frame.setSize(400, 200);
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.add(label);
		frame.addKeyListener(this);
		frame.pack();

	}

	public void keyPressed(KeyEvent e) {
		char keyChar = e.getKeyChar();
		System.out.println("you typed: " + keyChar);
		if (keyChar == currentLetter) {
			System.out.println("Correct!");
			frame.setBackground(Color.green);
		}
		else {
			frame.setBackground(Color.red);
			System.out.println("Incorrect!");
		}
	}

	public void keyReleased(KeyEvent e) {
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");
	}

	public void keyTyped(KeyEvent e) {
		
	}
}
