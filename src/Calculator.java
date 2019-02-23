import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	JButton addButton = new JButton();
	JButton subButton = new JButton();
	JButton mulButton = new JButton();
	JButton divButton = new JButton();
	JTextField answer1 = new JTextField(8);
	JTextField answer2 = new JTextField(8);

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.makeUI();
	}

	void makeUI() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		answer1.setSize(8, 4);
		answer1.setLocation(100, 50);
		answer2.setSize(8, 4);
		panel.add(answer1);
		panel.add(answer2);
		addButton.setText("Add");
		addButton.addActionListener(this);
		panel.add(addButton);
		subButton.setText("Subtract");
		subButton.addActionListener(this);
		panel.add(subButton);
		mulButton.setText("Multiply");
		mulButton.addActionListener(this);
		panel.add(mulButton);
		divButton.setText("Divide");
		divButton.addActionListener(this);
		panel.add(divButton);
		frame.add(panel);
		frame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.equals(addButton)) {
			String a = answer1.getText();
			String b = answer2.getText();
			int ai = Integer.parseInt(a);
			int bi = Integer.parseInt(b);
			int c = ai + bi;
			JOptionPane.showMessageDialog(null, c);

		}
		if (buttonPressed.equals(subButton)) {
			String a = answer1.getText();
			String b = answer2.getText();
			int ai = Integer.parseInt(a);
			int bi = Integer.parseInt(b);
			int c = ai - bi;
			JOptionPane.showMessageDialog(null, c);
		}
		
		if (buttonPressed.equals(mulButton)) {
			String a = answer1.getText();
			String b = answer2.getText();
			int ai = Integer.parseInt(a);
			int bi = Integer.parseInt(b);
			int c = ai * bi;
			JOptionPane.showMessageDialog(null, c);
		}

		if (buttonPressed.equals(divButton)) {
			String a = answer1.getText();
			String b = answer2.getText();
			int ai = Integer.parseInt(a);
			int bi = Integer.parseInt(b);
			int c = ai/bi;
			JOptionPane.showMessageDialog(null, c);
		}
	}

	public void add(String input) {

	}
}
