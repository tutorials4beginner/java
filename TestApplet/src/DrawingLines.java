import java.applet.*;
import java.awt.*;

public class DrawingLines extends Applet {
	int height = 0;
	int width = 0;
	public void init() {
		System.out.println("Hi, I am init");
		//width = getSize().width;
		//height = getSize().height;
		//setBackground( Color.black );
	}
	
	public void start() {
		System.out.println("Hi, I am start");
	}

	public void stop() {
		System.out.println("Hi, I am stop");
	}

	public void destroy() {
		System.out.println("Hi, I am destroy");
	}

	public void paint( Graphics g ) {
		width = getSize().width;
		height = getSize().height;
		System.out.println("Hi, I am paint");
		g.drawLine(50, 50, width - 50, height - 50);
		g.setColor( Color.green );
		for ( int i = 0; i < 10; ++i ) {
			g.drawLine( width/2, height/2, i * width / 10, 0 );
		}
	}
}