import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton joke = new JButton();
	JButton punchline = new JButton();
	public static void main (String [] args) {
		new ChuckleClicker().makeButtons();
	}
	
	void makeButtons() {
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		joke.setText("joke");
		joke.addActionListener(this);
		panel.add(joke);
		punchline.setText("punchline");
		punchline.addActionListener(this);
		panel.add(punchline);
		frame.pack();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joke) {
			JOptionPane.showMessageDialog(null, "What does a nosy pepper do?");
		}
		if(e.getSource() == punchline) {
			JOptionPane.showMessageDialog(null, "Get jalapeño business.");
		}
	}
}
