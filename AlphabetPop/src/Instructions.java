import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/**
 * Auto Generated Java Class.
 */
public class Instructions extends JPanel {
  
    private BufferedImage menu;
  private int choice;
  
  public Instructions ()
  {
    choice=0;
    System.out.println("YAS");
    try 
    {
      menu = ImageIO.read(new File("placeholder.jpg"));
      System.out.println("GOOD");
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    } 
    repaint();
    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      if (xCoord>=217&&xCoord<=1016)
      {
        if (yCoord>=162&&yCoord<=211)
        {
          System.out.println("Instructions");
          choice = 1;
        }
        else if (yCoord>=260&&yCoord<=309)
        {
          System.out.println("Play");
          choice = 2;
          Main.switchMenu(4);
        } 
        else if (yCoord>=363&&yCoord<=412)
        {
          System.out.println("High Scores");
          choice = 3;
        }
        else 
        {
          if (yCoord>=462&&yCoord<=511)
          {
            System.out.println("Exit");
            choice = 4;
            Main.switchMenu(5);
          }
        }
      }
      Main.switchMenu(0);
    }
});
  }
  
  
          /**
* This is the method that paints components on the frame.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.drawImage(menu, 0, 0, null);
    System.out.println("YAY");
  }
  
}
