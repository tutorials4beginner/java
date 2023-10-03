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
import java.text.Normalizer;
import javax.swing.*;
import java.util.*;

public class NormSample extends Applet{
    static final long serialVersionUID = 6607883013849198961L;
    JComboBox normalizationTemplate;
    JComboBox formComboBox;
    JComponent paintingComponent;
    HashMap<String, Normalizer.Form> formValues = new HashMap<String, Normalizer.Form>();
    HashMap<String, String> templateValues = new HashMap<String, String>();
    
    public static void main(String[] args) {

//creating an applete for normalization 

        JFrame f = new JFrame("Normalizer's API");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NormSample applet = new NormSample();
        applet.init();
        f.add("Center", applet);
        f.pack();
        f.setVisible(true);
    }

    public void init(){

//preparing values for the normalization forms ComboBox

        formValues.put("NFC", Normalizer.Form.NFC);
        formValues.put("NFD", Normalizer.Form.NFD);
        formValues.put("NFKC", Normalizer.Form.NFKC);
        formValues.put("NFKD", Normalizer.Form.NFKD);

        formComboBox = new JComboBox();

        for (Iterator it = formValues.keySet().iterator(); it.hasNext();){
            formComboBox.addItem((String)it.next());
        }

//preparing samples for normalization

        //text with the acute accent symbol 
        templateValues.put("acute accent", "touch" + "\u00e9");
     
        //text with ligature
        templateValues.put("ligature", "a" + "\ufb03" + "ance");

        //text with the cedilla
        templateValues.put("cedilla", "fa" + "\u00e7" + "ade");

        //text with half-width katakana
        templateValues.put("half-width katakana", "\uff81\uff6e\uff7a\uff9a\uff70\uff84");

        normalizationTemplate = new JComboBox();

        for (Iterator it = templateValues.keySet().iterator(); it.hasNext();){
            normalizationTemplate.addItem((String)it.next());
        }

//defining a component to output normalization results

        paintingComponent = new JComponent(){
            static final long serialVersionUID = -3725620407788489160L;
            
            public Dimension getSize(){
                    return new Dimension(550, 200);
                }
                public Dimension getPreferredSize(){
                    return new Dimension(550, 200);
                }
                public Dimension getMinimumSize(){
                    return new Dimension(550, 200);
                }
                public void paint (Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    

                    g2.setFont(new Font("Serif", Font.PLAIN, 20));                     
                    g2.setColor(Color.BLACK);
                    g2.drawString("Original string:", 100, 80);
                    g2.drawString("Normalized string:", 100, 120);
                    g2.setFont(new Font("Serif", Font.BOLD, 24));


//output of the original sample selected from the ComboBox 
 
                    String original_string = templateValues.get(normalizationTemplate.getSelectedItem());
                    g2.drawString(original_string, 320, 80);

//normalization and output of the normalized string

                    String normalized_string;
                    java.text.Normalizer.Form currentForm = formValues.get(formComboBox.getSelectedItem());
                    normalized_string = Normalizer.normalize(original_string, currentForm);
                    g2.drawString(normalized_string, 320, 120);
                }
            };
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(paintingComponent);
        JPanel controls = new JPanel();
        
        controls.setLayout(new BoxLayout(controls, BoxLayout.X_AXIS));
        controls.add(new Label("Normalization Form: "));
        controls.add(formComboBox);
        controls.add(new Label("Normalization Template:"));
        controls.add(normalizationTemplate);
        add(controls);
        formComboBox.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    paintingComponent.repaint();
                }
            });

        normalizationTemplate.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    paintingComponent.repaint();
                }
            });
    }
}
