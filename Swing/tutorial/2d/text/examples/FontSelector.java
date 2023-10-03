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
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
 * This applet displays a String with the user's selected 
 * fontname, style and size attributes.
*/

public class FontSelector extends JApplet
    implements ChangeListener, ItemListener {

    TextTestPanel textTestPanel;
    JComboBox fonts, styles;
    JSpinner sizes;
    String fontChoice = "Dialog";
    int styleChoice = 0;
    int sizeChoice = 12;

    public void init() {

        try {
            String cn = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(cn);
        } catch (Exception cnf) {
        }

        JPanel fontSelectorPanel = new JPanel();

        fontSelectorPanel.add(new JLabel("Font family:"));

        GraphicsEnvironment gEnv =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        fonts = new JComboBox(gEnv.getAvailableFontFamilyNames());
        fonts.setSelectedItem(fontChoice);
        fonts.setMaximumRowCount(5);
        fonts.addItemListener(this);
        fontSelectorPanel.add(fonts);

        fontSelectorPanel.add(new JLabel("Style:"));

        String[] styleNames = {"Plain", "Bold", "Italic", "Bold Italic"};
        styles = new JComboBox(styleNames);
        styles.addItemListener(this);
        fontSelectorPanel.add(styles);

        fontSelectorPanel.add(new JLabel("Size:"));

        sizes = new JSpinner(new SpinnerNumberModel(12, 6, 24, 1));
        sizes.addChangeListener(this);
        fontSelectorPanel.add(sizes);

        textTestPanel = new TextTestPanel();
        textTestPanel.setFont(new Font(fontChoice, styleChoice, sizeChoice));
        textTestPanel.setBackground(Color.white);

        add(BorderLayout.NORTH, fontSelectorPanel);
        add(BorderLayout.CENTER, textTestPanel);
    }

    /*
     * Detect a state change in any of the settings and create a new
     * Font with the corresponding settings. Set it on the test component.
     */
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() != ItemEvent.SELECTED) {
            return;
        }
        if (e.getSource() == fonts) {
            fontChoice = (String)fonts.getSelectedItem();
        } else {
            styleChoice = styles.getSelectedIndex();
        }
        textTestPanel.setFont(new Font(fontChoice, styleChoice, sizeChoice));
    }

    public void stateChanged(ChangeEvent e) {
        try {
            String size = sizes.getModel().getValue().toString();
            sizeChoice = Integer.parseInt(size);
            textTestPanel.setFont(new Font(fontChoice,styleChoice,sizeChoice));
        } catch (NumberFormatException nfe) {
        }
    }

    public static void main(String s[]) {

        JFrame f = new JFrame("FontSelector");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JApplet fontSelector = new FontSelector();
        f.add(fontSelector, BorderLayout.CENTER);
        fontSelector.init();
        f.pack();
        f.setVisible(true);
    }

}


class TextTestPanel extends JComponent {

    public Dimension getPreferredSize() {
        return new Dimension(500,200);
    }

    public void setFont(Font font) {
        super.setFont(font);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.setFont(getFont());
        FontMetrics metrics = g.getFontMetrics();
        String text = "The quick brown fox jumped over the lazy dog";
        int x = getWidth()/2 - metrics.stringWidth(text)/2;
        int y = getHeight() - 80;
        g.drawString(text, x, y);
    }
}
