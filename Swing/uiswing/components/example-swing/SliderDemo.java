import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderDemo extends JFrame 
                        implements ActionListener {
    //Set up animation parameters.
    static final int FPS_INIT = 15;    //initial frames per second
    int frameNumber = 0;
    int delay;
    Timer timer;
    boolean frozen = false;

    //This label uses ImageIcon to show the doggy pictures.
    JLabel picture;

    public SliderDemo(String windowTitle) {
        super(windowTitle);
        delay = 1000 / FPS_INIT;

        //Create the slider and its label
        JLabel sliderLabel = new JLabel("Frames Per Second", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                                              0, 30, FPS_INIT);
        framesPerSecond.addChangeListener(new SliderListener());

        //Turn on labels at major tick marks.
        framesPerSecond.setMajorTickSpacing(10);
        framesPerSecond.setMinorTickSpacing(1);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        framesPerSecond.setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));

        //Create the label for the animation.
        picture = new JLabel(new ImageIcon("images/doggy/T"
                                         + frameNumber
                                         + ".gif"),
                             JLabel.CENTER);
        picture.setAlignmentX(Component.CENTER_ALIGNMENT);
        picture.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLoweredBevelBorder(),
                BorderFactory.createEmptyBorder(10,10,10,10)));

        //Put everything in the content pane.
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(sliderLabel);
        contentPane.add(framesPerSecond);
        contentPane.add(picture);
        contentPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setContentPane(contentPane);

        //Set up a timer that calls this object's action handler.
        timer = new Timer(delay, this);
        timer.setInitialDelay(delay * 10); //pauses animation after frames
                                          //0 and 6 by restarting the timer
        timer.setCoalesce(true);

        //Add a listener for window events
        addWindowListener(new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                stopAnimation();
            }
            public void windowDeiconified(WindowEvent e) {
                startAnimation();
            }
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }  
        });

    }

    /** Listens to the slider. */
    class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int fps = (int)source.getValue();
                if (fps == 0) {
                    if (!frozen) stopAnimation();
                } else {
                    delay = 1000 / fps;
                    timer.setDelay(delay);
                    timer.setInitialDelay(delay * 10);
                    if (frozen) startAnimation();
                }
            }
        }
    }    

    public void startAnimation() {
        //Start (or restart) animating!
        timer.start();
        frozen = false;
    }

    public void stopAnimation() {
        //Stop the animating thread.
        timer.stop();
        frozen = true;
    }

    //Called when the Timer fires
    public void actionPerformed(ActionEvent e) {
        //Advance the animation frame.
        if (frameNumber==13) {
            frameNumber = 0;
        } else {
            frameNumber++;
        }
        //XXX no caching?
        picture.setIcon(new ImageIcon("images/doggy/T"
                                      + frameNumber
                                      + ".gif"));
        if (frameNumber==0 || frameNumber==6) {
            timer.restart();
        }
    }

    public static void main(String[] args) {
        SliderDemo animator = new SliderDemo("SliderDemo");
        animator.pack();
        animator.setVisible(true);
        animator.startAnimation();
    }
}
