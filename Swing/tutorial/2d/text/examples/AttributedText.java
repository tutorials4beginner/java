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
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;

import java.awt.font.TextAttribute;

/**
 * This class demonstrates how to use Text Attributes to style text.
 */
public class AttributedText extends Applet {
          
    public void paint(Graphics g) {

        Font font = new Font(Font.SERIF, Font.PLAIN, 24);
        g.setFont(font); 
        String text = "Too WAVY";
        g.drawString(text, 45, 30);

        Hashtable<TextAttribute, Object> map =
            new Hashtable<TextAttribute, Object>();

        /* Kerning makes the text spacing more natural */
        map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        font = font.deriveFont(map);
        g.setFont(font); 
        g.drawString(text, 45, 60);

        /* Underlining is easy */
        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        font = font.deriveFont(map);
        g.setFont(font); 
        g.drawString(text, 45, 90);

        /* Strikethrouh is easy */
        map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        font = font.deriveFont(map);
        g.setFont(font); 
        g.drawString(text, 45, 120);

        /* This colour applies just to the font, not other rendering */
        map.put(TextAttribute.FOREGROUND, Color.BLUE);
        font = font.deriveFont(map);
        g.setFont(font);
        g.drawString(text, 45, 150);
    }

    public static void main(String[] args) {

        Frame f = new Frame("Attributed Text Sample");
            
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        f.add("Center",  new AttributedText());
        f.setSize(new Dimension(250, 200));
        f.setVisible(true);
    }
}

