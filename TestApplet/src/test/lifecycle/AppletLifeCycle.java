package test.lifecycle;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 <applet code="ap1" width="500" height="400">
 </applet>
 */

public class AppletLifeCycle extends Applet implements ActionListener {

	int count = 0;
	String output = "";
	// String z = "";
	Font f;
	Button b1;

	static {
		System.out.println("i am static block...");
	}

	{
		System.out.println("i am instance block...");
	}

	public AppletLifeCycle() {
		System.out.println("i am cons...");
	}

	public void init() {
		setBackground(Color.red);
		setForeground(Color.yellow);
		b1 = new Button("Click me");

		add(b1);
		b1.addActionListener(this);

		f = new Font("Times New Roman", Font.BOLD, 18);
		// z = "amitava";
	}

	public void start() {
		System.out.println("I am start...");
		// z += "teaches...";
	}

	public void repaint(Graphics g) {
		super.repaint();
		// z += "JAVA";
		g.setFont(f);
		// g.drawString(z, 60, 120);
		g.drawString(output, 20, 30);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		// z += "JAVA";
		g.setFont(f);
		// g.drawString(z, 60, 120);
		g.drawString(output, 20, 30);
	}

	public void stop() {
		System.out.println("stopped....");
	}

	public void destroy() {
		System.out.println("bye bye....");
	}

	public static void main(String t[]) {
		System.out.println("i am main...");
		// AppletLifiCycle x=new AppletLifiCycle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("--Action --");
		count++;
		output = "Hit count ---" + count;
		repaint();
	}
}