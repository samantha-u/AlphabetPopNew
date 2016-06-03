import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* The FrameAlphabetPop is the class that creates the JFrame for the program and controls program flow.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.13.16
 */

public class FrameAlphabetPop extends JFrame
{
  
      /**
 * This method constructs an object of the superclass and adds the SplashScreen and MainMenu to the frame.
 * It proceeds to set the frame size, make it visible, make it unsizable and set the default close operation.
 */ 
  public FrameAlphabetPop ()
  {
    super ("Alphabet Pop by Green Eggs & Sam");
//    PanelAlphabetPop panel = new PanelAlphabetPop ();
//    add (panel);
    
    //add(new Splashscreen()); 
    add(new LevelOne());
    //add(new MainMenu()); //this displays the main menu.  I commented it out to see the splashscreen.
    setSize (1200, 700);
    setVisible (true);
    setResizable(true);
    setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE); 
  }
}