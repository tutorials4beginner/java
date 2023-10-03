/*
 * Java(TM) SE 6 version.
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;

//No need to extend JApplet, since we don't add any components;
//we just paint.
public class SimpleClick extends Applet 
			 implements MouseListener {

    StringBuffer buffer;

    public void init() {
	addMouseListener(this);
	buffer = new StringBuffer();
        addItem("initializing... ");
    }

    public void start() {
        addItem("starting... ");
    }

    public void stop() {
        addItem("stopping... ");
    }

    public void destroy() {
        addItem("preparing for unloading...");
    }

    void addItem(String newWord) {
        System.out.println(newWord);
        buffer.append(newWord);
        repaint();
    }

    public void paint(Graphics g) {
	//Draw a Rectangle around the applet's display area.
        g.drawRect(0, 0, 
		   getWidth() - 1,
		   getHeight() - 1);

	//Draw the current string inside the rectangle.
        g.drawString(buffer.toString(), 5, 15);
    }

    //The following empty methods could be removed
    //by implementing a MouseAdapter (usually done
    //using an inner class).
    public void mouseEntered(MouseEvent event) {
    }
    public void mouseExited(MouseEvent event) {
    }
    public void mousePressed(MouseEvent event) {
    }
    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
	addItem("click!... ");
    }
}
