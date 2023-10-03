/*
 * This is a 1.3 version (thanks to JFrame.EXIT_ON_CLOSE)
 * but could easily be converted to work in earlier releases.
 * There are many valid ways to implement the exercise.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingApp3 {
    JFrame f;
    JButton startButton, stopButton;
    JLabel label;

    public SwingApp3() {
        f = new JFrame("SwingApp3");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //1.3+
        createGUI(f);
        initListeners();
        f.pack();
        f.setVisible(true);
    }

    void initListeners() {
        ActionListener al = new MyActionListener();
        startButton.addActionListener(al);
        stopButton.addActionListener(al);
    }

    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startButton) {
                if (userOKs()) {
                    startButton.setEnabled(false);
                    stopButton.setEnabled(true);
                    label.setText("Press Stop.");
                } else {
                    label.setText("Start canceled.");
                }
            } else {
                // e.getSource() == stopButton
                stopButton.setEnabled(false);
                startButton.setEnabled(true);
                label.setText("Press Start.");
            }
        }

        boolean userOKs() {
            Object[] options = {"Go ahead", "Cancel"};
            int n = JOptionPane.showOptionDialog(
                      f, 
                      "Really start the job?\n"
                      + "It's going to take a long time.",
                      "Confirmation",
                      JOptionPane.YES_NO_OPTION,
                      JOptionPane.QUESTION_MESSAGE,
                      null,
                      options,
                      options[0]);
            if (n == JOptionPane.YES_OPTION) {
                return true;
            }
            return false;
        }
    }

    void createGUI(JFrame f) {
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);
        label = new JLabel("Press Start.", JLabel.CENTER);

        Container c = f.getContentPane();
        //Use the content pane's default BorderLayout layout manager.
        c.add(startButton, BorderLayout.WEST);
        c.add(stopButton, BorderLayout.EAST);
        c.add(label, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new SwingApp3();
    }
}
