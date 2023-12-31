/*
 * Beeper2.java is a version of the 1.4 Beeper.java example
 * that allows the user to select from 1 to 10 beeps and then
 * beeps that many times when the ClickMe button is pressed.
 * This solution uses a JSpinner to select the number of beeps.
 * Your solution could use a different widget, such as a combo
 * box or a group of radio buttons.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Beeper2 extends JPanel 
                     implements ActionListener {
    JButton button;
    SpinnerNumberModel beepsModel;
    javax.swing.Timer timer;
    final static String BUTTON_CMD = "Button";
    int beepsRemaining;

    public Beeper2() {
        super(new BorderLayout());
	
        //Create and set up the spinner.
        String numBeepsString = "Number of Beeps: ";
        beepsModel = new SpinnerNumberModel(1, 1, 10, 1);
        JLabel numBeepsLabel = new JLabel(numBeepsString);
        add(numBeepsLabel, BorderLayout.PAGE_START);
        JSpinner spinner = new JSpinner(beepsModel);
        numBeepsLabel.setLabelFor(spinner);
        add(spinner, BorderLayout.CENTER);
        
        button = new JButton("Click Me");
        button.setPreferredSize(new Dimension(200, 80));
        add(button, BorderLayout.PAGE_END);
        button.setActionCommand(BUTTON_CMD);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (BUTTON_CMD.equals(e.getActionCommand())) {
            startBeeping(beepsModel.getNumber().intValue());
        } else { //called by the Timer
            Toolkit.getDefaultToolkit().beep();
            if (--beepsRemaining < 1) {
                timer.stop();
            }
        }
    }
            
    private void startBeeping(int numBeeps) {
        Toolkit.getDefaultToolkit().beep();
        
        if (numBeeps > 1) {
            if (timer == null) {
                timer = new Timer(500, this);
            }
            beepsRemaining = numBeeps - 1;
            timer.start();
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Beeper2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Beeper2();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
