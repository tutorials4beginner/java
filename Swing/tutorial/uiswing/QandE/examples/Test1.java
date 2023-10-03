//v 1.3
import javax.swing.*;          
import java.awt.*;
import java.awt.event.*;

public class Test1 {
    private static String labelText = 
	"<html>The <em>last</em> word is <font size=+2>big</font>.</html>";
    private int numClicks = 0;

    public Component createComponents() {
        final JLabel label = new JLabel(labelText);

        /*
         * An easy way to put space between a top-level container
         * and its contents is to put the contents in a JPanel
         * that has an "empty" border.
         */
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(
                                        30, //top
                                        30, //left
                                        10, //bottom
                                        30) //right
                                        );
        pane.setLayout(new GridLayout(0, 1));
        pane.add(label);

        return pane;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}

        //Create the top-level container and add contents to it.
        JFrame frame = new JFrame("Test1");
        Test1 app = new Test1();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

