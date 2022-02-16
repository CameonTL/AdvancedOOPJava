package finalExam;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ConvertFrame extends JFrame {

	private JTextField input;
	private JRadioButton far;
	private JRadioButton cel;
	private JRadioButton kel;
	private JRadioButton toFar;
	private JRadioButton toCel;
	private JRadioButton toKel;
	private JLabel lblOutput;
	private JButton convert;
	
	public ConvertFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
        setTitle("Tempurature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }
	
	private void initComponents() {
		input = new JTextField();
		
		far = new JRadioButton();
		cel = new JRadioButton();
		kel = new JRadioButton();
		toFar = new JRadioButton();
		toCel = new JRadioButton();
		toKel = new JRadioButton();
		
		lblOutput = new JLabel();

		far.setText("Farenheit");
		cel.setText("Celsius");
		kel.setText("Kelvin");
		toFar.setText("Farenheit");
		toCel.setText("Celsius");
		toKel.setText("Kelvin");
		
		ButtonGroup fromTemp = new ButtonGroup();
		fromTemp.add(far);
		fromTemp.add(cel);
		fromTemp.add(kel);
		ButtonGroup toTemp = new ButtonGroup();
		toTemp.add(toFar);
		toTemp.add(toCel);
		toTemp.add(toKel);
		
		Dimension dim = new Dimension(75, 20);
		Dimension dim2 = new Dimension(50, 20);
		input.setPreferredSize(dim);
		input.setMinimumSize(dim);
		lblOutput.setMaximumSize(dim2);
		
		convert = new JButton("Convert");
		convert.addActionListener((ActionEvent) -> {
			convertClicked();
		});
		
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridBagLayout());
		dataPanel.add(new JLabel("Welcome to the Tempurature Converter"),
				getConstraints(0, 0, GridBagConstraints.LINE_START));
		dataPanel.add(new JLabel("Enter tempurature to convert"),
				getConstraints(0, 1, GridBagConstraints.LINE_START));
		dataPanel.add(input,
				getConstraints(1, 1, GridBagConstraints.LINE_START));
		dataPanel.add(new JLabel("Select which unit it is:"),
				getConstraints(0, 2, GridBagConstraints.LINE_START));
		dataPanel.add(far,
				getConstraints(1, 2, GridBagConstraints.LINE_START));
		dataPanel.add(cel,
				getConstraints(2, 2, GridBagConstraints.LINE_START));
		dataPanel.add(kel,
				getConstraints(3, 2, GridBagConstraints.LINE_START));
		dataPanel.add(new JLabel("And units to convert to:"),
				getConstraints(0, 3, GridBagConstraints.LINE_START));
		dataPanel.add(toFar,
				getConstraints(1, 3, GridBagConstraints.LINE_START));
		dataPanel.add(toCel,
				getConstraints(2, 3, GridBagConstraints.LINE_START));
		dataPanel.add(toKel,
				getConstraints(3, 3, GridBagConstraints.LINE_START));
		dataPanel.add(new JLabel("Result:"),
				getConstraints(0, 4, GridBagConstraints.LINE_START));
		dataPanel.add(lblOutput, getConstraints(1, 4, GridBagConstraints.LINE_START));
		add(dataPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(convert);
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
	
	private void convertClicked() {
		double output;
		double num;
		try {
			num = Double.parseDouble(input.getText());
			if (far.isSelected() && toCel.isSelected()) {
				output = ConvertCode.getFarCel(num);
				lblOutput.setText(Double.toString(output));
			} else if (far.isSelected() && toKel.isSelected()) {
				output = ConvertCode.getFarKel(num);
				lblOutput.setText(Double.toString(output));
			} else if (far.isSelected() && toFar.isSelected()) {
				output = num;
				lblOutput.setText(Double.toString(output));
			} else if (cel.isSelected() && toFar.isSelected()) {
				output = ConvertCode.getCelFar(num);
				lblOutput.setText(Double.toString(output));
			} else if (cel.isSelected() && toCel.isSelected()) {
				output = num;
				lblOutput.setText(Double.toString(output));
			} else if (cel.isSelected() && toKel.isSelected()) {
				output = ConvertCode.getCelKel(num);
				lblOutput.setText(Double.toString(output));
			} else if (kel.isSelected() && toFar.isSelected()) {
				output = ConvertCode.getKelFar(num);
				lblOutput.setText(Double.toString(output));
			} else if (kel.isSelected() && toCel.isSelected()) {
				output = ConvertCode.getKelCel(num);
				lblOutput.setText(Double.toString(output));
			} else if (kel.isSelected() && toKel.isSelected()) {
				output = num;
				lblOutput.setText(Double.toString(output));
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
					"Invalid number. Try again.",
					"Invalid Number", JOptionPane.ERROR_MESSAGE);
		}
	}
}
