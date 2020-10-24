package handout7;

import acm.graphics.*;
import acm.program.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonClass extends GraphicsProgram {

	public void init() {
		
		ButtonLayout();
		addActionListeners();
		addMouseListeners();
	}

	private void ButtonLayout() {
		textField = new JTextField(MAX_NAME);
		textField.addActionListener(this);
		Add = new JButton("Add");
		Remove = new JButton("Remove");
		Clear = new JButton("Clear");
		add(new JLabel("Name"), SOUTH);
		add(textField, SOUTH);
		add(Add, SOUTH);
		add(Remove, SOUTH);
		add(Clear, SOUTH);
	}

	private void addBox(String name) {
		GCompound box = new GCompound();
		GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel label = new GLabel(name);
		box.add(outline, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
		box.add(label, -label.getWidth() / 2, label.getAscent() / 2);
		add(box, getWidth() / 2, getHeight() / 2);
		MultiBOX.put(name, box);
	}

	private void removeBox(String name) {
		GObject obj = MultiBOX.get(name);
		if (obj != null) {
			remove(obj);
		}
	}

	private void removeContents() {
		Iterator<String> iterator = MultiBOX.keySet().iterator();
		while (iterator.hasNext()) {
			removeBox(iterator.next());
		}
		MultiBOX.clear();
	}

	public void actionPerformed(ActionEvent A) {
		Object source = A.getSource();
		if (source == Add || source == textField) {
			addBox(textField.getText());
		} else if (source == Remove) {
			removeBox(textField.getText());
		} else if (source == Clear) {
			removeContents();
		}
	}

	public void mousePressed(MouseEvent M) {
		last = new GPoint(M.getPoint());
		currentObject = getElementAt(last);
	}

	public void mouseDragged(MouseEvent M) {
		if (currentObject != null) {
			currentObject.move(M.getX() - last.getX(), M.getY() - last.getY());
			last = new GPoint(M.getPoint());
		}
	}

	public void mouseClicked(MouseEvent M) {
		if (currentObject != null)
			currentObject.sendToFront();
	}

	private static final int MAX_NAME = 25;
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;

	
	private JTextField textField;
	private JButton Add;
	private JButton Remove;
	private JButton Clear;
	private GObject currentObject;
	private GPoint last;
	HashMap<String,GObject> MultiBOX = new HashMap<String,GObject>();
}