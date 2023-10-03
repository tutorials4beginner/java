/* 
 * Java(TM) SE 6 version.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Receiver extends JApplet 
                      implements ActionListener {
    private final String waitingMessage = 
            "Waiting for a message...           ";
    private JLabel label;

    public void init() {
        //Set up the UI.
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

    private void createGUI() {
        JPanel contentPane = new JPanel(); //use default FlowLayout
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.black),
                                    BorderFactory.createEmptyBorder(5,20,5,10)));
        setContentPane(contentPane);
        
        JButton button = new JButton("Clear");
	button.addActionListener(this);
        
        label = new JLabel(waitingMessage, JLabel.TRAILING);
        
        add(label);
        add(button);
        add(new JLabel("(My name is " + getParameter("name") 
                       + ".)", 
                       JLabel.LEADING)); 
    }

    public void actionPerformed(ActionEvent event) {
        label.setText(waitingMessage);
    }

    public void processRequestFrom(String senderName) {
        label.setText("Received message from " 
                      + senderName + "!");
    }

    public String getAppletInfo() {
        return "Receiver (named " + getParameter("name") + 
               ") by Kathy Walrath";
    }
}
