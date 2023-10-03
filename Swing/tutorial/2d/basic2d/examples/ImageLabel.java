/*
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */


import java.io.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;

public class ImageLabel extends Component {

    public static void main(String args[]) {

        JFrame frame = new JFrame("Image Label");
        BufferedImage img = null;
        try {
            String imageFileName = "painting.gif";
            img = ImageIO.read(new File(imageFileName));
        } catch (IOException e) {
        }      
        frame.add("Center", new ImageLabel(img, "Java 2D Graphics!"));
        frame.pack();
        frame.setVisible(true);
    }

    BufferedImage img;
    String text;
    Font font;
    
    public ImageLabel(BufferedImage img, String text) {
        this.img = img;
        this.text = text;
        font = new Font("Serif", Font.PLAIN, 36);
    }
    
    /* We want to size the component around the text.  */
    public Dimension getPreferredSize() {
        FontMetrics metrics = img.getGraphics().getFontMetrics(font);
        int width = metrics.stringWidth(text)*2;
        int height = metrics.getHeight()*2;
        return new Dimension(width, height);
    }

    public void paint(Graphics g) {
        
        /* Draw the image stretched to exactly cover the size of the
         * drawing area.
         */
        Dimension size = getSize();
        g.drawImage(img, 
                    0, 0, size.width, size.height,
                    0, 0, img.getWidth(null), img.getHeight(null),
                    null);                    

        /* Fill a rounded rectangle centered in the drawing area.
         * Calculate the size of the rectangle from the size of the text
         */
        g.setFont(font);
        FontRenderContext frc = ((Graphics2D)g).getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(text, frc);

        int wText = (int)bounds.getWidth();
        int hText = (int)bounds.getHeight();

        int rX = (size.width-wText)/2;
        int rY = (size.height-hText)/2;
        g.setColor(Color.yellow);
        g.fillRoundRect(rX, rY, wText, hText, hText/2, hText/2);

        /* Draw text positioned in the rectangle.
         * Since the rectangle is sized based on the bounds of
         * the String we can position it using those bounds.
         */
        int xText = rX-(int)bounds.getX();
        int yText = rY-(int)bounds.getY();
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString(text, xText, yText);
    }
}
