import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class ApptoAppl extends Applet
		 implements ActionListener {

   JLabel text;
   JButton button;
   JPanel panel;
   private boolean _clickMeMode = true;

   public void init(){
     setLayout(new BorderLayout(1, 2));
     setBackground(Color.white);

     text = new JLabel("I'm a Simple Program");
     button = new JButton("Click Me");
     button.addActionListener(this);
     add("Center", text);
     add("South", button);
   }

  public void start(){
     System.out.println("Applet starting.");
  }

  public void stop(){
     System.out.println("Applet stopping.");
  }

  public void destroy(){
     System.out.println("Destroy method called.");
  }

   public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        if (_clickMeMode) {
          text.setText("Button Clicked");
          button.setText("Click Again");
          _clickMeMode = false;
        } else {
          text.setText("I'm a Simple Program");
          button.setText("Click Me");
          _clickMeMode = true;
        }
   }
}
