import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	public static void main(String[] args) {
		SlotMachine sm = new SlotMachine();
		sm.makeUI();
	}

	void makeUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.setText("Spin!");
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel);
		frame.pack();
		
	}
	int drawRandom() {
		int slot = new Random().nextInt(3);
		System.out.println(slot);
		if (slot == 0) {
		JLabel cherry = createLabelImage("cherry.png");
		panel.add(cherry);
		}
		if (slot == 1) {
		JLabel orange = createLabelImage("orange.png");
		panel.add(orange);
		}
		if (slot == 2) {
		JLabel lemon = createLabelImage("lemon.png");
		panel.add(lemon);
		}
		return slot;
		
	}
	private JLabel createLabelImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}


	public void actionPerformed(ActionEvent e) {
		panel.removeAll();
		int s1 = drawRandom();
		int s2 = drawRandom();
		int s3 = drawRandom();
		System.out.println("s1 is " + s1 + ", s2 is " + s2 + ", and s3 is " + s3);
		if (s1 == s2 && s1 == s3) {
			AudioClip sound = JApplet.newAudioClip(getClass().getResource("success.wav"));
			sound.play();
			JOptionPane.showMessageDialog(null, "YOU WIN!");
		}
		button.setText("Spin!");
		button.addActionListener(this);
		panel.add(button);
		frame.pack();
		
	}
}
