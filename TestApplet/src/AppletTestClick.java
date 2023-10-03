import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*

*/
public class AppletTestClick extends Applet implements ActionListener {
	String msg = "Hi....";
	Button b1 = new Button("click me");
	Button b2 = new Button("click");

	public void paint(Graphics g) {
		g.drawLine(10, 10, 200, 200);
		g.drawString(msg, 100, 50);
		g.setColor(Color.red);
		g.drawLine(100, 200, 300, 400);
	}


	public void start() {
		System.out.println("i am start.");
	}

	public void init() {
		System.out.println("i am init.");
		b1.addActionListener(this);
		add(b1);
		b2.addActionListener(this);
		add(b2);
		b2.setVisible(false);
	}

	public void stop() {
		System.out.println("i am stop.");
	}

	public void destroy() {
		System.out.println("i am destroy.");
	}


	public void actionPerformed(ActionEvent paramActionEvent) {
		msg = "you have clicked me.";
		b2.setVisible(true);
		
		repaint();
	}
	
	public AppletTestClick() {
		System.out.println("i am constructor.");
	}

}
