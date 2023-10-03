import java.awt.geom.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.print.*;

public class ShapesPrint extends JPanel implements Printable, ActionListener {

    
    final static Color bg = Color.white;
    final static Color fg = Color.black;
    final static Color red = Color.red; 
    final static Color white = Color.white;

    final static BasicStroke stroke = new BasicStroke(2.0f);
    final static BasicStroke wideStroke = new BasicStroke(8.0f);
    
    final static float dash1[] = {10.0f};
    final static BasicStroke dashed = new BasicStroke(1.0f,
                                                      BasicStroke.CAP_BUTT,
                                                      BasicStroke.JOIN_MITER,
                                                      10.0f, dash1, 0.0f);
    final static JButton button = new JButton("Print");

    public ShapesPrint() {
	setBackground(bg);
        button.addActionListener(this);
    }


   public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {   
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        if (printJob.printDialog()) {
            try {
                printJob.print();  
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
	}
}
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	drawShapes(g2);
}
public void drawShapes(Graphics2D g2){
        Dimension d = getSize();
        int gridWidth = 400 / 6;
        int gridHeight = 300 / 2;
         
        int rowspacing = 5;
        int columnspacing = 7;
        int rectWidth = gridWidth - columnspacing;
        int rectHeight = gridHeight - rowspacing;

        Color fg3D = Color.lightGray;
    
        g2.setPaint(fg3D);
        g2.drawRect(80, 80, 400 - 1, 310);
        g2.setPaint(fg);
         
        int x = 85;
        int y = 87;

        
        // draw Line2D.Double
        g2.draw(new Line2D.Double(x, y+rectHeight-1, x + rectWidth, y));
        x += gridWidth;
        
        // draw Rectangle2D.Double
        g2.setStroke(stroke);
        g2.draw(new Rectangle2D.Double(x, y, rectWidth, rectHeight));
        x += gridWidth;
        
        // draw  RoundRectangle2D.Double
        g2.setStroke(dashed);
        g2.draw(new RoundRectangle2D.Double(x, y, rectWidth,
                                            rectHeight, 10, 10));
        x += gridWidth;
       
        // draw Arc2D.Double
        g2.setStroke(wideStroke);
        g2.draw(new Arc2D.Double(x, y, rectWidth, rectHeight, 90,
                                 135, Arc2D.OPEN));
        x += gridWidth;
                                            
        // draw Ellipse2D.Double
        g2.setStroke(stroke);

        g2.draw(new Ellipse2D.Double(x, y, rectWidth, rectHeight));
        x += gridWidth;
        
        // draw GeneralPath (polygon)
        int x1Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y1Points[] = {y, y+rectHeight, y+rectHeight, y};
        GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                                              x1Points.length);
        polygon.moveTo(x1Points[0], y1Points[0]);
        for ( int index = 1; index < x1Points.length; index++ ) {  
            polygon.lineTo(x1Points[index], y1Points[index]);
        };
        polygon.closePath();
        
        g2.draw(polygon);
        
        // NEW ROW
        x = 85;
       y += gridHeight;
          
        // draw GeneralPath (polyline)
        
        int x2Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y2Points[] = {y, y+rectHeight, y+rectHeight, y};
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                                               x2Points.length);
        polyline.moveTo (x2Points[0], y2Points[0]);
       for ( int index = 1; index < x2Points.length; index++ ) {
            polyline.lineTo(x2Points[index], y2Points[index]);
        };
        
        g2.draw(polyline);
        x += gridWidth;
        
        // fill Rectangle2D.Double (red)
        g2.setPaint(red);
        g2.fill(new Rectangle2D.Double(x, y, rectWidth, rectHeight));
        g2.setPaint(fg);
        x += gridWidth;
        
        // fill RoundRectangle2D.Double
        GradientPaint redtowhite = new GradientPaint(x,y,red,x+rectWidth, y,white);
        g2.setPaint(redtowhite);
        g2.fill(new RoundRectangle2D.Double(x, y, rectWidth,
                                            rectHeight, 10, 10));
        g2.setPaint(fg);
        x += gridWidth;
        
        // fill Arc2D
        g2.setPaint(red);
        g2.fill(new Arc2D.Double(x, y, rectWidth, rectHeight, 90,
                                 135, Arc2D.OPEN));
        g2.setPaint(fg);
        x += gridWidth; 
        
        // fill Ellipse2D.Double
        redtowhite = new GradientPaint(x,y,red,x+rectWidth, y,white);
        g2.setPaint(redtowhite);
        g2.fill (new Ellipse2D.Double(x, y, rectWidth, rectHeight));
        g2.setPaint(fg);
        x += gridWidth; 
        // fill and stroke GeneralPath
        int x3Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y3Points[] = {y, y+rectHeight, y+rectHeight, y};
        GeneralPath filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
                                                    x3Points.length);
        filledPolygon.moveTo(x3Points[0], y3Points[0]);
        for ( int index = 1; index < x3Points.length; index++ ) {
            filledPolygon.lineTo(x3Points[index], y3Points[index]);
        };
        filledPolygon.closePath();
        g2.setPaint(red);
        g2.fill(filledPolygon);
        g2.setPaint(fg);
        g2.draw(filledPolygon);
    }


    public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
        if (pi >= 1) {
            return Printable.NO_SUCH_PAGE;
	}
	drawShapes((Graphics2D) g);
        return Printable.PAGE_EXISTS;
    }
  
   public static void main(String s[]){
	WindowListener l = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {System.exit(0);}
		public void windowClosed(WindowEvent e) {System.exit(0);}
	};
	JFrame f = new JFrame();
	f.addWindowListener(l);
	JPanel panel = new JPanel();
	panel.add(button);
	f.getContentPane().add(BorderLayout.SOUTH, panel);
	f.getContentPane().add(BorderLayout.CENTER, new ShapesPrint());
	f.setSize(580, 500);
	f.show();
    }

}
