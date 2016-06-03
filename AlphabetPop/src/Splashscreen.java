import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/* The Splashscreen class displays the splashscreen to the user.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.16.16
 */
public class Splashscreen 
{
  Bubble b = new Bubble ("A",0,0, false);
  int x = 0;
  double y = 0;
  Timer myTimer;
  final int TRAVEL_DISTANCE = 500;
  private BufferedImage underwater;
  
          /**
* This is the constructor that displays the Splashscreen.
*/ 
  public Splashscreen ()
  {
    
    try 
    {
      underwater = ImageIO.read(new File("underwater.jpg"));
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    }
    Bubble.loadImage();
    //add(b);
    //b.setBounds(0,0, 10,10);
//    add(b);
//    repaint();
    new Timer(100, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent actEvt) {
            if (x <= TRAVEL_DISTANCE) {
               x = x + 5;
               y = 25 * Math.sin(Math.toDegrees(x/5));
               
               //repaint();
            } else {
               ((Timer)actEvt.getSource()).stop();
            }
         }
      }).start();
  }
  
//  public void run ()
//  {
//    try
//    {
//      Thread.sleep(10);
//    }
//    catch (InterruptedException e)
//    {
//    }
//  }
  
  
  
//  public void paint (Graphics g)
//  {
//    //g.drawImage(Bubble.bubblePic, 0, 0, null);
//    for (int delay = 0; delay <= 800; delay++)
//    {
//    ActionListener taskPerformer = new ActionListener() {
//      public void actionPerformed(ActionEvent ae) {
//        x++;
//        g.drawImage(Bubble.bubblePic, 0 + x, 0, null);
//        revalidate();
//        if (x == 800)
//          myTimer.stop();
//      }
//    };
//    myTimer = new Timer(delay, taskPerformer);
//    myTimer.start();
//    }
//  }
  
          /**
* This is the method that paints components on the frame.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
  public void paintComponent (Graphics g)
  {
    System.out.println("Hi");
//    for (int y = 0; y <= 80; y++)
//    {
//      x++;
//    ActionListener taskPerformer = new ActionListener ()
//    {
//      g.setColor(Color.WHITE);
//      g.fillOval(-3+x,-1,100,100);
//      g.drawImage(Bubble.bubblePic, 0+x, 0, null);
//    }
//    myTimer = new Timer(1, taskPerformer);
//    myTimer.start();
//    }
    //super.paintComponent(g);
    //load underwater image
    
    g.drawImage(underwater, 0, 0, null);
    
    b.moveBubble(x, (int)y);
    
//    for (int y = 0; y <= 40; y++)
//    {
//      x++;
//  ActionListener taskPerformer = new ActionListener() {
//      public void actionPerformed(ActionEvent evt) {
          //g.setColor(Color.WHITE);
      //g.fillOval(-2+x,(int)(39+y),100,100);
          
    //  g.drawImage(Bubble.bubblePic, 0+x, (int)(40+y), null);
      //repaint();
//      repaint();
//      if (x == 40)
//        myTimer.stop();
//      }
//  };
//  myTimer = new Timer(1000, taskPerformer);
//    myTimer.start();
//    }
  }
  
          /**
* This is the method that sees when an action is performed.
* 
* @param ae ActionEvent passed in to indicate an action that has been performed.
*/ 
  public void ActionPerformed (ActionEvent ae)
  {
    
  }
  
//  public void paint(Graphics g){
//  //  paint occurs when the method repaint() is called (see actionPerformed method )
//  Graphics2D g2d = (Graphics2D) g;
//  g2d.drawRoundRect(rectX, rectY, rectWidth, rectHeight, 10, 10);
//  g2d.setColor(Color.blue);
//  g2d.drawOval(ovalX, ovalY, ovalWidth, ovalHeight);
// }
  
}