package finalProject;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	int rand = NumberGame.getRandom();
	
	private JTextField input;
	private JButton check;
	private JButton reset;
	
	public GameFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
        setTitle("Future Value Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }
	
	private void initComponents() {
		input = new JTextField();
		
		Dimension dim = new Dimension(75, 20);
		input.setPreferredSize(dim);
		input.setMinimumSize(dim);
		
		check = new JButton("Check");
		reset = new JButton("Reset");
		
		check.addActionListener((ActionEvent) -> {
			checkClicked();
		});
		reset.addActionListener((ActionEvent) -> {
			resetClicked();
		});
		
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridBagLayout());
		dataPanel.add(new JLabel("Welcome to Guessing Game"),
				getConstraints(0, 0, GridBagConstraints.LINE_START));
		dataPanel.add(new JLabel("I have set a number between 1 - 1000"),
				getConstraints(0, 1, GridBagConstraints.LINE_START));
		dataPanel.add(new JLabel("Your guess:"),
				getConstraints(0, 2, GridBagConstraints.LINE_START));
		dataPanel.add(input,
				getConstraints(1, 2, GridBagConstraints.LINE_START));
		add(dataPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(check);
		buttonPanel.add(reset);
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	private GridBagConstraints getConstraints(int x, int y, int anchor) {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 0, 5);
		c.gridx = x;
		c.gridy = y;
		c.anchor = anchor;
		return c;
	}
	
	private void checkClicked() {
		int guess;
		try {
			guess = Integer.parseInt(input.getText());
			if (guess < rand) {
				JOptionPane.showMessageDialog(this, "Guess is too low");
			} else if (guess > rand) {
				JOptionPane.showMessageDialog(this, "Guess is too high");
			} else if (guess == rand) {
				JOptionPane.showMessageDialog(this, "Congratulations! That's correct!");
				input.setEditable(false);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
					"Invalid number. Try again.",
					"Invalid Number", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void resetClicked() {
		rand = NumberGame.getRandom();
		input.setEditable(true);
		input.setText("");
	}

}
