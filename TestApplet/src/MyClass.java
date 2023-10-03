import java.awt.*;
import java.applet.*;

class MyClass extends Applet {
public void init() {
/* All the variables, methods and images initialize here 
will be called only once because this method is called only 
  once when the applet is first initializes */
}
public void start() {
/* The components needed to be initialize more than once 
in your applet are written here or if the reader 
  switches back and forth in the applets. This method
 can be called more than once.*/
}

public void stop() {
/* This method is the counterpart to start(). The code, 
used to stop the execution is written here*/
}

public void destroy() {
/* This method contains the code that result in to release 
the resources to the applet before it is
finished. This method is called only once. */
}
public void paint(Graphics g) {
/* Write the code in this method to draw, write, or color 
things on the applet pane are */
}
}