import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor {
	private char currentLetter;
	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}
	public static void main(String[] args) {
	
	}
	void hdfshklf() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("type or be ashamed");
		frame.setVisible(true);
		frame.setSize(400, 200);
		JLabel label = new JLabel();
		label.add(currentLetter);

	}
}
