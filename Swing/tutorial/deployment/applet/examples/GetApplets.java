/* 
 * Java(TM) SE 6 version.
 */

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

public class GetApplets extends JApplet 
                        implements ActionListener {
    private JTextArea textArea;

    public void init() {
    //Execute a job on the event-dispatching thread:
    //creating this applet's GUI.
    try {
        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    } catch (Exception e) {
        System.err.println("createGUI didn't successfully complete");
    }
}

    private void createGUI() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.BLACK),
                                    BorderFactory.createEmptyBorder(10,10,10,10)));
        setContentPane(contentPane);
        
        JButton b = new JButton("Click to call getApplets()");
        b.addActionListener(this);
        add(b, BorderLayout.PAGE_START);

        textArea = new JTextArea(5, 40);
        textArea.setEditable(false);
        JScrollPane scroller = new JScrollPane(textArea);
        add(scroller, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent event) {
        printApplets();
    }

    public String getAppletInfo() {
        return "GetApplets by Kathy Walrath";
    }

    public void printApplets() {
        //Enumeration will contain all applets on this page
        //(including this one) that we can send messages to.
        Enumeration e = getAppletContext().getApplets();

        textArea.append("Results of getApplets():\n");

        while (e.hasMoreElements()) {
            Applet applet = (Applet)e.nextElement();
            String info = ((Applet)applet).getAppletInfo();
            if (info != null) {
                textArea.append("- " + info + "\n");
            } else {
                textArea.append("- " 
				+ applet.getClass().getName() 
                                + "\n");
            } 
        }
        textArea.append("________________________\n\n");
    }
}
