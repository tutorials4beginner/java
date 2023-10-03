import java.applet.Applet;
import java.awt.*;
import java.net.*;

/** An applet that loads an image from an absolute
 *  URL on the same machine that the applet came from.
 */

public class JavaMan extends Applet {
  private Image javaMan;

  public void init() {
    try {
      URL imageFile = new URL("http://www.corewebprogramming.com" +
                              "/images/Java-Man.gif");
      javaMan = getImage(imageFile);
    } catch(MalformedURLException mue) {
      showStatus("Bogus image URL.");
      System.out.println("Bogus URL");
    }
  }

  public void paint(Graphics g) {
    g.drawImage(javaMan, 0, 0, this);
  }
}

