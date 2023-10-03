/**
  * Java(TM) SE 6 version
  *
  * @author  Marianne Mueller
  * @author  Kathy Walrath
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GetOpenProperties extends JApplet {
    private String[] propertyNames = {"file.separator",
                                      "line.separator",
                                      "path.separator",
                                      "java.class.version",
                                      "java.vendor",
                                      "java.vendor.url",
                                      "java.version",
                                      "os.name",
                                      "os.arch",
                                      "os.version"};
    private final int numProperties = propertyNames.length;
    private JLabel[] values;
    private javax.swing.Timer timer;
    private int currentPropNum = 0;

    public void init() {
        //Execute a job on the event-dispatching thread:
        //creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
    }
    
    public void start() {
        //Update the GUI every 1/4 second or so.
        timer = new javax.swing.Timer(250, new PropertyUpdater());
        timer.setCoalesce(false);
        timer.start();    
    }
    
    public void stop() {
        if (timer != null) {
            timer.stop();
        }
    }
    
    public void destroy() {
        //Execute a job on the event-dispatching thread:
        //destroying this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    remove(getContentPane());
                }
            });
        } catch (Exception e) { }        
    }

    private void createGUI() {      
        JPanel contentPane = new JPanel(new GridBagLayout());
        
        GridBagConstraints labelConstraints = 
                new GridBagConstraints();
        GridBagConstraints valueConstraints = 
                new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.WEST;
        labelConstraints.ipadx = 10;
        valueConstraints.fill = GridBagConstraints.HORIZONTAL;
        valueConstraints.gridwidth = GridBagConstraints.REMAINDER;
        valueConstraints.weightx = 1.0; //Extra space to values column.

        //Set up the Label arrays.
        JLabel[] names = new JLabel[numProperties];
        values = new JLabel[numProperties];
        String firstValue = "<not read yet>";
        
        //Fonts
        Font headingFont = new Font("SansSerif", Font.BOLD, 14);
        Font propertyFont = new Font("SansSerif", Font.BOLD, 12);
        Font valueFont = new Font("SansSerif", Font.PLAIN, 12);
 
        //Add headings.
        contentPane.add(createHeading("Property Name", headingFont), labelConstraints);
        contentPane.add(createHeading("Value", headingFont), valueConstraints);

        for (int i = 0; i < numProperties; i++) {
            names[i] = new JLabel(propertyNames[i]);
            names[i].setFont(propertyFont);
            contentPane.add(names[i], labelConstraints);

            values[i] = new JLabel(firstValue);
            values[i].setFont(valueFont);
            contentPane.add(values[i], valueConstraints);
            
            names[i].setLabelFor(values[i]);
        }
        
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.black),
                                    BorderFactory.createEmptyBorder(5,20,5,10)));
        setContentPane(contentPane);
    }
    
    private JLabel createHeading(String text, Font font) {
        JLabel l = new JLabel(text);
        l.setFont(font);
        l.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(0,0,5,0),
                        BorderFactory.createMatteBorder(0,0,1,0,Color.black)));
        return l;
    }
    
    private class PropertyUpdater implements ActionListener {
        private String value;
        public void actionPerformed(ActionEvent e) {
            if (currentPropNum < numProperties) {
                try {
                    value = System.getProperty(propertyNames[currentPropNum]);
                    if (value == null) {
                        value = "<null value!>";
                    }
                    values[currentPropNum].setText(value);
                } catch (SecurityException exc) {
                    values[currentPropNum].setText("Could not read: SECURITY EXCEPTION!");
                }
                currentPropNum++;
            } else {
                timer.stop();
            }
        }
    }
}

