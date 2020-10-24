package handout7;

import acm.program.*; 
import acm.graphics.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class Usinginteractions extends GraphicsProgram {

	public void init() {
		Font myFont = new Font("Courier", Font.ITALIC, 24);

		add(new JLabel("Name:  "), SOUTH);
		add(textField = new JTextField(20), SOUTH);
		textField.addActionListener(this);
		textField.setFont(myFont);

		Add = new JButton("Add");
		add(Add, SOUTH);
		add(Remove = new JButton("Remove"), SOUTH);
		add(Clear = new JButton("Clear"), SOUTH);

		addActionListeners();
		addMouseListeners();
	}

	public void actionPerformed(ActionEvent A) {
		String cmd = A.getActionCommand();
		if (cmd.equals("Add")) {
				println("You typed: " + textField.getText());
				addBox();
	} else if (true) {
		
	}
		
	
		}
	
	
	private GCompound addBox() {
		final double BOX_WIDTH = 120;
		final double BOX_HEIGHT = 50;
		GRect BOX1 = new GRect(40, 1000, BOX_WIDTH, BOX_HEIGHT);
		GLabel BOXTitle = new GLabel(textField.getText());
		BOX1.setFilled(false);
		MultiBOX.put(textField.getText(), BOXA);
		GCompound BOXA = new GCompound();
		BOXA.add(BOX1, BOX_WIDTH / 2, BOX_HEIGHT / 2);
		BOXA.add(BOXTitle, -BOXTitle.getWidth() / 2, BOXTitle.getAscent() / 2);
		BOXA.add(BOXTitle);
		add(BOXA, getWidth() / 2, getHeight() / 2);
		return BOXA;
	}

	private JTextField textField;
	private JButton Add;
	private JButton Remove;
	private JButton Clear;
	private GRect BOX1;
	private GCompound BOXA;

	HashMap<String, GObject> MultiBOX = new HashMap<String, GObject>();
}