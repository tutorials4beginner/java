import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class LineDemo2D extends JApplet {

	public void init() {
		setBackground(Color.white);
		setForeground(Color.white);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		
		g2.setPaint(Color.gray);
		int x1 = 50;
		int x2 = 70;
		int x3 = 60;
		// calculate this
		int dummy = (x3 ^ 2) / 2;

		int zero = 100;
		g2.setColor(Color.blue);
		g2.drawLine(100, 100, 100, 10);
		g2.drawLine(100, 100, 190, 100);
		g2.drawLine(100, 100, 50, 150);

		g2.setColor(Color.yellow);
		g2.drawLine(zero + x1, zero, zero, zero - x2);
		g2.drawLine(zero + x1, zero, zero - (x3 / 2), zero + (x3 / 2));
		g2.drawLine(zero, zero - x2, zero - (x3 / 2), zero + (x3 / 2));
	}

	public static void main(String s[]) {
		
		
		JFrame f = new JFrame("ShapesDemo2D");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		JApplet applet = new LineDemo2D();
		f.getContentPane().add("Center", applet);
		applet.init();
		f.pack();
		f.setSize(new Dimension(300, 300));
		f.show();
	}
}
