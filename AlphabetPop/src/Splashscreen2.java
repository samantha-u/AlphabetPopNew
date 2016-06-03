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
  private GameTimer t; //= new GameTimer();
  int currentLetter;
  
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
    t = new GameTimer();
    
    t.setTimeElapsed(1);
    t.start();
    
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
    if (t.getTimeElapsed()%5 == 0)
    {
      System.out.println(t.getTimeElapsed());
      if (currentLetter == 8)
        currentLetter++;
      if (currentLetter < title.length())
      {
        introBubble[currentLetter].setSpeed(0);
        introBubble[currentLetter].setRadius(-100);
        introBubble[currentLetter].setLocation(-100,-100);
        
        t.setTimeElapsed(t.getTimeElapsed() + 1);
        currentLetter++;
      }
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
    g.setFont(new Font("Courier New", Font.PLAIN, 40));
      g.setColor(Colors.letters);
      for (int x = 0; x < currentLetter; x++)
      {
        //if (x != -1)
        if (currentLetter != 0)
        {
          g.drawString("" + title.charAt(x), (x*100) + 10, 50);
        }
      }
  }
  
//  for (int z = 0; z < title.length(); z++)
//    {
//      try
//      {
//        Thread.sleep(1000);
//      }
//      catch (InterruptedException e)
//      {
//      }
//    introBubble[z].setSpeed(0);
//    introBubble[z].setRadius(-100);
//    introBubble[z].setLocation(-100,-100);
//    }

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
