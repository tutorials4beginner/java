/* 
 * Java(TM) SE 6 version.
 * Code is the same as 1.0.
 * Exercise for the reader:  Convert this applet to use SwingWorker
 * and getResource.  SwingWorker can be downloaded at:
 * https://swingworker.dev.java.net/
 * SwingWorker must be downloaded for Java SE 5, but will be included
 * in Java SE 6.
 */

import java.applet.*;
import java.net.URL;

class SoundLoader extends Thread {
    Applet applet;
    SoundList soundList;
    URL baseURL;
    String relativeURL;

    public SoundLoader(Applet applet, SoundList soundList,
                       URL baseURL, String relativeURL) {
        this.applet = applet;
        this.soundList = soundList;
        this.baseURL = baseURL;
        this.relativeURL = relativeURL;
        setPriority(MIN_PRIORITY);
        start();
    }

    public void run() {
        AudioClip audioClip = applet.getAudioClip(baseURL, relativeURL);

        //AudioClips load too fast for me!
        //Simulate slow loading by adding a delay of up to 10 seconds.
        try {
            sleep((int)(Math.random()*10000));
        } catch (InterruptedException e) {}

        soundList.putClip(audioClip, relativeURL);
    }
}
