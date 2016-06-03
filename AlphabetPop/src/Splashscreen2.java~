import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class Splashscreen2 extends JPanel
{
  private BufferedImage splash;
  private String title = "Alphabet Pop".toUpperCase();
  private Ball[] introBubble = new Ball [title.length()];
  Thread gameThread;
  private ContainerBox box;
  
  public Splashscreen2() 
  { 
    System.out.println(title);
    box = new ContainerBox(0, 0, 1200,650, "SplashscreenBack.jpg", Color.BLACK);
    for (int x = 0; x < title.length(); x++)
    {
      if (title.charAt(x) != ' ')
      introBubble[x] = new Ball (90+x*90, 300,50, 2, (float)(Math.random()*360), Colors.bubbles, (char)((title.charAt(x))), false);
    }
    repaint();
    gameStart();
  }
  
  public void gameStart() {
    // Run the game logic in its own thread.
    gameThread = new Thread() {
      public void run() {
        while (true) {
          // Execute one time-step for the game 
          gameUpdate();
          // Refresh the display
          repaint();
          // Delay and give other thread a chance
          try {
            Thread.sleep(1000 / 30);
          } catch (InterruptedException ex) {}
        }
      }
    };
    gameThread.start();  // Invoke GameThread.run()
  }
  
  public void gameUpdate() {
    for (int z = 0; z < title.length(); z++)
    {
      if (title.charAt(z) != ' ')
      introBubble[z].moveOneStepWithCollisionDetection(box);
    }
    //ball[0].moveOneStepWithCollisionDetection(box);
  }
  
  public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    box.draw(g);
    g.drawImage(splash, 0, 0, null);
    System.out.println("YAY");
    for (int z = 0; z < title.length(); z++)
    {
      if (title.charAt(z) != ' ')
      introBubble[z].draw(g);
    }
  }

public static void main (String [] args)
{
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("Alphabet Pop");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Splashscreen2 m = new Splashscreen2();
            frame.add(m);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(1200,650);
};
  });
}
}
