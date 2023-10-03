import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.plaf.FileChooserUI;

/*
 <applet code="AppletTest" width=200 height=150>
 </applet>

 */

public class AppletTest extends Applet implements ActionListener {
	String fontName;
	int i = 0;
	String msg = " ::::: ";
	Button b2 = new Button("click11");

	public void init() {
		System.out.println("I am init.");
		setBackground(Color.CYAN);
		setForeground(Color.BLUE);

		Button b1 = new Button("click");
		b1.addActionListener(this);
		add(b1);
		
		add(b2);
		b2.setVisible(false);
	}

	public void start() {
		System.out.println("I am start.");
		fontName = getFont().toString();
	}

	public void stop() {
		System.out.println("I am stop.");
	}

	public void destroy() {
		System.out.println("I am destroy.");
	}

	public void paint(Graphics g) {
		g.drawString("Hi welcome.", 10, 20);
		showStatus("I am status.");
		g.drawString(fontName, 10, 40);
		g.drawString(getDocumentBase().toString(), 10, 60);
		g.drawString(getCodeBase().toString(), 10, 80);
		g.drawString(msg, 10, 120);
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		msg += "Hello........";
		i = new Random().nextInt(5);
		int j = (i % 5);
		if (j == 0) {
			setBackground(Color.RED);
		} else if (j == 1) {
			setBackground(Color.YELLOW);
		} else if (j == 2) {
			setBackground(Color.BLACK);
		} else if (j == 3) {
			setBackground(Color.GRAY);
		} else if (j == 4) {
			setBackground(Color.WHITE);
		}
		b2.setVisible(true);
		repaint();
	}
}
