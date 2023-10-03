/* 
 * Java(TM) SE 6 version.
 */

import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sender extends JApplet 
                    implements ActionListener {
    private String myName;
    private JTextField nameField;
    private JTextArea status;

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

    private void createGUI() {
        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.BLACK),
                                    BorderFactory.createEmptyBorder(10,10,5,5)));
        setContentPane(contentPane);
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(0,0,5,5);

        JLabel receiverLabel = new JLabel("Receiver name:", 
                                          JLabel.TRAILING);
        add(receiverLabel, c);

        nameField = new JTextField(getParameter("RECEIVERNAME"),
                                                10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        add(nameField, c);
        nameField.addActionListener(this);

        JButton button = new JButton("Send message");
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        c.anchor = GridBagConstraints.LINE_START; //stick to the 
                                                  //text field
        c.fill = GridBagConstraints.NONE; //keep the button 
                                          //small
        c.weightx = 0.0;
        add(button, c);
        button.addActionListener(this);

        status = new JTextArea(5, 60);
        status.setEditable(false);
        c.anchor = GridBagConstraints.CENTER; //reset to the default
        c.fill = GridBagConstraints.BOTH; //make this big
        c.weighty = 1.0;
        add(new JScrollPane(status), c);

        myName = getParameter("NAME");
        JLabel senderLabel = new JLabel("(My name is " + myName + ".)",
                                        JLabel.CENTER);
        c.weightx = 0.0;
        c.weighty = 0.0;
        add(senderLabel, c);
    }

    public void actionPerformed(ActionEvent event) {
        Applet receiver = null;
        String receiverName = nameField.getText(); //Get name to 
                                                   //search for.
        receiver = getAppletContext().getApplet(receiverName);
        if (receiver != null) {
            //Use the instanceof operator to make sure the applet
            //we found is a Receiver object.
            if (!(receiver instanceof Receiver)) {
                status.append("Found applet named "
                              + receiverName + ", "
                              + "but it's not a Receiver object.\n");
            } else {
                status.append("Found applet named "
                              + receiverName + "\n"
                              + "  Sending message to it.\n");
                //Cast the receiver to be a Receiver object
                //(instead of just an Applet object) so that the
                //compiler will let us call a Receiver method.
                ((Receiver)receiver).processRequestFrom(myName);
            }
        } else {
            if (receiverName == null || receiverName.length() == 0) {
                receiverName = "<no name>";
            }
            status.append("Couldn't find any applet named "
                          + receiverName + ".\n");
        }
    }

    public String getAppletInfo() {
        return "Sender by Kathy Walrath";
    }
}
