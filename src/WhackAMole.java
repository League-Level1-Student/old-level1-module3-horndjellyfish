import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Random rand = new Random();
	int value = rand.nextInt(23);
	JButton[] buttons = new JButton[24];

	public static void main(String[] args) {
		WhackAMole wam = new WhackAMole();
		wam.makeUI();
		
	}

	void makeUI() {
		frame.setVisible(true);
		frame.setTitle("Whack-a-Mole");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		drawButtons(value);
	}

	void drawButtons(int random) {

		for (int i = 0; i <= 23; i++) {
			buttons[i] = new JButton();
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		// buttons[value].setText("Mole!");
		frame.add(panel);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}

	private void pause(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttons[value])) {
			buttons[value].setText("Mole!");
			playSound("success.wav");
			pause(5);
			speak("You found the mole!");
		}

		else {
			speak("Wrong!");
			
		}
	}

}
