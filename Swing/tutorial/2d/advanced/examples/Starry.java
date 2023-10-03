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


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.font.*;

import java.net.URL;

public class Starry extends JApplet {
    static String starryFile = "images/Starry.gif";

    public void init() {
	Image starry = getImage(getURL(starryFile));
	StarPanel starPanel = new StarPanel(starry);
	getContentPane().add(starPanel, BorderLayout.CENTER);
    }

    protected URL getURL(String filename) {
        URL codeBase = this.getCodeBase();
        URL url = null;

        try {
            url = new URL(codeBase, filename);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Couldn't create image: "
                             + "badly specified URL");
            return null;
        }

        return url;
    }

    public static void main(String[] args) {
        Image starImage = Toolkit.getDefaultToolkit().getImage(
                                        Starry.starryFile);

        StarPanel starPanel = new StarPanel(starImage);

        JFrame f = new JFrame("Starry");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        f.getContentPane().add(starPanel, BorderLayout.CENTER);
        f.setSize(new Dimension(550, 200));
        f.setVisible(true);
    }
}

class StarPanel extends JPanel {

    Image img;
    int w, h;

    public StarPanel(Image img) {
	this.img = img;
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
        setBackground(Color.white);
        w = getSize().width;
        h = getSize().height;
        Graphics2D g2;
        g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);

        FontRenderContext frc = g2.getFontRenderContext();
	Font f = new Font("Helvetica", 1, w/10);
	String s = new String("The Starry Night");
        TextLayout textTl = new TextLayout(s, f, frc);
        AffineTransform transform = new AffineTransform();
	Shape outline = textTl.getOutline(null);
        Rectangle r = outline.getBounds();
        transform = g2.getTransform();
        transform.translate(w/2-(r.width/2), h/2+(r.height/2));
        g2.transform(transform);
	g2.setColor(Color.blue);
	g2.draw(outline);
        g2.setClip(outline);
        g2.drawImage(img, r.x, r.y, r.width, r.height, this);

    }
}
