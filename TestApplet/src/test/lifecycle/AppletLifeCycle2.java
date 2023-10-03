package test.lifecycle;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
 <applet code="ap2" width="500" height="400">
 </applet>
 */

public class AppletLifeCycle2 extends Applet implements ActionListener {

	Button b1, b2;
	TextField t1, t2, t3;
	Font f;

	public void init() {
		setBackground(Color.red);
		setForeground(Color.black);
		f = new Font("Times New Roman", Font.BOLD, 18);
		b1 = new Button("add");
		b2 = new Button("reset");
		t1 = new TextField(30);
		t2 = new TextField(30);
		t3 = new TextField(30);

		add(t1);
		add(t2);
		add(t3);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == b1) {
			String b1 = t1.getText();
			String b2 = t2.getText();
			int x1 = Integer.parseInt(b1);
			int x2 = Integer.parseInt(b2);
			int v = x1 + x2;
			String d1 = String.valueOf(v);
			t3.setText(d1);
		} else {
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
	}
}
