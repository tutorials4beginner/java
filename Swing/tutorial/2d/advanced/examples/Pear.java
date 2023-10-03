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


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

/*
 * This applet renders a pear, using Constructive Area Geometry (CSG) methods,
 * add, intersect, and subtract.
*/

public class Pear extends Applet {

    Ellipse2D.Double circle, oval, leaf, stem;
    Area circ, ov, leaf1, leaf2, st1, st2;

    public void init() {
        circle = new Ellipse2D.Double();
        oval = new Ellipse2D.Double();
        leaf = new Ellipse2D.Double();
        stem = new Ellipse2D.Double();
        circ = new Area(circle);
        ov = new Area(oval);
        leaf1 = new Area(leaf);
        leaf2 = new Area(leaf);
        st1 = new Area(stem);
        st2 = new Area(stem);

        setBackground(Color.white);
   }
   
    public void paint (Graphics g) {
        
        
        Graphics2D g2 = (Graphics2D) g;
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        double ew = w/2;
        double eh = h/2;
        
        

        g2.setColor(Color.green);

        // Creates the first leaf by filling the intersection of two Area objects created from an ellipse.
        leaf.setFrame(ew-16, eh-29, 15.0, 15.0);
        leaf1 = new Area(leaf);
        leaf.setFrame(ew-14, eh-47, 30.0, 30.0);
        leaf2 = new Area(leaf); 
        leaf1.intersect(leaf2);   
        g2.fill(leaf1);   

        // Creates the second leaf.
        leaf.setFrame(ew+1, eh-29, 15.0, 15.0);
        leaf1 = new Area(leaf);
        leaf2.intersect(leaf1);
        g2.fill(leaf2);

        g2.setColor(Color.black);

        // Creates the stem by filling the Area resulting from the subtraction of two Area objects created from an ellipse.
        stem.setFrame(ew, eh-42, 40.0, 40.0);
        st1 = new Area(stem);
        stem.setFrame(ew+3, eh-47, 50.0, 50.0);
        st2 = new Area(stem);
        st1.subtract(st2);
        g2.fill(st1);

        g2.setColor(Color.yellow);

        // Creates the pear itself by filling the Area resulting from the union of two Area objects created by two different ellipses.
        circle.setFrame(ew-25, eh, 50.0, 50.0);
        oval.setFrame(ew-19, eh-20, 40.0, 70.0);
        circ = new Area(circle);
        ov = new Area(oval);
        circ.add(ov);
        g2.fill(circ);

        
        
    }

    public static void main(String s[]) {
        JFrame f = new JFrame ("Pear");
        Applet applet = new Pear();
         
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(150,200));
        f.setVisible(true);
    }

}






