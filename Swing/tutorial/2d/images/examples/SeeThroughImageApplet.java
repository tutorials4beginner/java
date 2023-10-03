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
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;

class SeeThroughComponent extends Component {

    private BufferedImage bi;
    float[] scales = { 1f, 1f, 1f, 0.5f };
    float[] offsets = new float[4];
    RescaleOp rop;
    
    public SeeThroughComponent(URL imageSrc) {
        try {
            BufferedImage img = ImageIO.read(imageSrc);
            int w = img.getWidth(null);
            int h = img.getHeight(null);
            bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.getGraphics();
            g.drawImage(img, 0, 0, null);

        } catch (IOException e) {
            System.out.println("Image could not be read");
            System.exit(1);
        }
        setOpacity(0.5f);
    }

    public Dimension getPreferredSize() {
        return new Dimension(bi.getWidth(null), bi.getHeight(null));
    }

    public void setOpacity(float opacity) {
        scales[3] = opacity;
        rop = new RescaleOp(scales, offsets, null);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0,0, getWidth(), getHeight());
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Dialog", Font.BOLD, 24));
        g2d.drawString("Java 2D is great!", 10, 80);
        g2d.drawImage(bi, rop, 0, 0);
    }
}

public class SeeThroughImageApplet extends JApplet {

    static String imageFileName = "duke_skateboard.jpg";
    private URL imageSrc;

    public SeeThroughImageApplet () {
    }

    public SeeThroughImageApplet (URL imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void init() {
        try {
            imageSrc = new URL(getCodeBase(), imageFileName);
        } catch (MalformedURLException e) {
        }
        buildUI();
    }
     
    public void buildUI() {
        final SeeThroughComponent st = new SeeThroughComponent(imageSrc);
        add("Center", st);
        JSlider opacitySlider = new JSlider(0, 100);
        opacitySlider.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    JSlider b = (JSlider)e.getSource();
                    JSlider slider = (JSlider)e.getSource();
                    st.setOpacity(slider.getValue()/100f);
                    st.repaint();
                };
            });
        Dimension size = st.getPreferredSize();
        Dimension sliderSize = opacitySlider.getPreferredSize();
        resize(size.width, size.height+sliderSize.height);
        add("South", opacitySlider);
    }

    public static void main(String s[]) {
        JFrame f = new JFrame("See Through Image");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        URL imageSrc = null;
        try {
             imageSrc = ((new File(imageFileName)).toURI()).toURL();
        } catch (MalformedURLException e) {
        }
        SeeThroughImageApplet sta = new SeeThroughImageApplet(imageSrc);
        sta.buildUI();
        f.add("Center", sta);
        f.pack();
        f.setVisible(true);
    }
}
