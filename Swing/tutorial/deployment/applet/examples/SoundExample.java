/* 
 * Java SE 6 version.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.*;

public class SoundExample extends JApplet 
			  implements ActionListener {
    private SoundList soundList;
    private String onceFile = "bark.au";
    private String loopFile = "train.au";
    private AudioClip onceClip;
    private AudioClip loopClip;
    private static String PLAY_ONCE_CMD = "playOnce";
    private static String START_LOOP_CMD = "startLoop";
    private static String STOP_LOOP_CMD = "stopLoop";
    private static String RELOAD_CMD = "reload";

    private JButton playOnce;
    private JButton startLoop;
    private JButton stopLoop;
    private JButton reload;

    private boolean looping = false;

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
        JPanel contentPane = new JPanel(new FlowLayout());
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                                    BorderFactory.createLineBorder(Color.BLACK),
                                    BorderFactory.createEmptyBorder(10,10,10,10)));
        setContentPane(contentPane);
        
        playOnce = new JButton("Bark!");
        playOnce.setActionCommand(PLAY_ONCE_CMD);
	playOnce.addActionListener(this);
        add(playOnce);

        startLoop = new JButton("Start sound loop");
        startLoop.setActionCommand(START_LOOP_CMD);
        stopLoop = new JButton("Stop sound loop");
        stopLoop.setActionCommand(STOP_LOOP_CMD);
        stopLoop.setEnabled(false);
	startLoop.addActionListener(this);
        add(startLoop);
	stopLoop.addActionListener(this);
        add(stopLoop);

        reload = new JButton("Reload sounds");
        reload.setActionCommand(RELOAD_CMD);
	reload.addActionListener(this);
        add(reload);

        startLoadingSounds();
    }

    void startLoadingSounds() {
        //Start asynchronous sound loading.
        soundList = new SoundList(this, getCodeBase());
        soundList.startLoading(loopFile);
        soundList.startLoading(onceFile);
   }

    public void stop() {
        if (onceClip != null) {
            onceClip.stop();        //Cut short the one-time sound.
        }
        if (looping && loopClip != null) {
            loopClip.stop();    //Stop the sound loop.
        }
    }    

    public void start() {
        if (looping && loopClip!= null) {
            loopClip.loop();    //Restart the sound loop.
        }
    }    

    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        
        //PLAY JButton
        if (PLAY_ONCE_CMD.equals(cmd)) {
            if (onceClip == null) {
                //Try to get the AudioClip.
                onceClip = soundList.getClip(onceFile);
            }

            if (onceClip != null) {  //If the sound is loaded:
                onceClip.play();     //Play it once.
                showStatus("Playing sound " + onceFile + ".");
            } else {
                showStatus("Sound " + onceFile + " not loaded yet.");
            }
	    return;
        }

        //START LOOP JButton
        if (START_LOOP_CMD.equals(cmd)) {
            if (loopClip == null) {
                //Try to get the AudioClip.
                loopClip = soundList.getClip(loopFile);
            }

            if (loopClip != null) {  //If the sound is loaded:
                looping = true;
                loopClip.loop();     //Start the sound loop.
                stopLoop.setEnabled(true);   //Enable stop JButton.
                startLoop.setEnabled(false); //Disable start JButton.
                showStatus("Playing sound " + loopFile + " continuously.");
            } else {
                showStatus("Sound " + loopFile + " not loaded yet.");
            }
            return;
        }

        //STOP LOOP JButton
        if (STOP_LOOP_CMD.equals(cmd)) {
            if (looping) {
                looping = false;
                loopClip.stop();    //Stop the sound loop.
                startLoop.setEnabled(true); //Enable start JButton.
                stopLoop.setEnabled(false); //Disable stop JButton.
            }
            showStatus("Stopped playing sound " + loopFile + ".");
            return;
        }

        //RELOAD JButton
        if (RELOAD_CMD.equals(cmd)) {
            if (looping) {          //Stop the sound loop.
                looping = false;
                loopClip.stop();
                startLoop.setEnabled(true); //Enable start JButton.
                stopLoop.setEnabled(false); //Disable stop JButton.
            }
            loopClip = null;        //Reset AudioClip to null.
            onceClip = null;        //Reset AudioClip to null.
            startLoadingSounds();
            showStatus("Reloading all sounds.");
            return;
        }
    }
    
    public void destroy() {
        //Execute a job on the event-dispatching thread:
        //destroying this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    destroyGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
    }

    private void destroyGUI() {
        looping = false;
        loopClip = null;
        onceClip = null;
        getContentPane().removeAll();
    }
    
}
