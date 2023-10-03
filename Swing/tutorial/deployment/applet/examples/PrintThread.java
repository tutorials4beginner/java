/*
 * Java(TM) SE 6 version.
 */

import javax.swing.*;
import java.awt.*;

public class PrintThread extends JApplet {

    JTextArea display;

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

        addItem("init: " + threadInfo(Thread.currentThread()),
                false); //not on event-dispatching thread
    }
    
    private void createGUI() {
        //Create the text area and make it uneditable.
    	display = new JTextArea(1, 80);
        display.setEditable(false);

	//Set the layout manager so that the text area 
	//will be as wide as possible.
        setLayout(new GridLayout(1,0));

	//Add the text area (in a scroll pane) to the applet.
        add(new JScrollPane(display));
        
        addItem("createGUI: " + threadInfo(Thread.currentThread()),
                true); //on event-dispatching thread
    }

    public void start() {
        addItem("start: " + threadInfo(Thread.currentThread()),
                false); //not on event-dispatching thread
    }

    public void stop() {
        addItem("stop: " + threadInfo(Thread.currentThread()),
                false); //not on event-dispatching thread
    }

    public void destroy() {
        addItem("destroy: " + threadInfo(Thread.currentThread()),
                false); //not on event-dispatching thread
        
        //Execute a job on the event-dispatching thread:
        //destroying this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    getContentPane().removeAll();
                    addItem("doing removeAll: "
                            + threadInfo(Thread.currentThread()),
                            true); //on event-dispatching thread
                }
            });
        } catch (Exception e) { }
    }

    String threadInfo(Thread t) {
        return "thread=" + t.getName() + ", "
               + "thread group=" + t.getThreadGroup().getName();
    }
   
    void addItem(String newWord, boolean onEDT) {
        final String s = newWord + "\n";
        
        System.out.println(newWord);
        
        if (onEDT) {
            display.append(s);
        } else {
            //Execute a job on the event-dispatching thread:
            //updating this applet's GUI.
            try {
                SwingUtilities.invokeAndWait(new Runnable() {
                    public void run() {
                        display.append(s);
                    }
                });
            } catch (Exception e) { }
        }
    }
}

