import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/* The MainMenu class loads the MainMenu image and displays it on the screen.   It allows the user to select
 * which page in the game they would like to go to and takes them there.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.19.16
 */

public class MainMenu extends JPanel
{
  private BufferedImage menu;
  private int choice;
  
          /**
 * This is the constructor that constructs the MainMenu and checks where the user clicks so they can be directed 
 * to the corresponding page.
 */
  public MainMenu ()
  {
    choice=0;
    System.out.println("YAS");
    try 
    {
      menu = ImageIO.read(new File("MainMenu.jpg"));
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
          Main.switchMenu(6);
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
    }
});
  }
  
  public int getChoice()
  {
    
    System.out.println("HERE");
    return choice;
  }
  
  public void resetChoice()
  {
    choice = 0;
  }
  
  
        /**
* This is the method that paints components on the frame.
* 
* @param g Graphics passed in to allow painting on the frame.
*/ 
   public void paintComponent (Graphics g)
  {
    super.paintComponent(g);
    g.drawImage(menu, 0, 0, null);
    System.out.println("YAY");
  }
  
//  public void mouseClicked (MouseEvent e)
//  {
//    System.out.println("1");
//    int xCoord = e.getX();
//    int yCoord = e.getY();
//    System.out.println(xCoord+ "      "+yCoord);
//  }
//  
//  public void mouseExited (MouseEvent e)
//  {
//    System.out.println("2");
//  }
//  
//  public void mouseEntered (MouseEvent e)
//  {
//    System.out.println("3");
//  }
//  
//  public void mouseReleased (MouseEvent e)
//  {
//    System.out.println("4");
//  }
//  
//  public void mousePressed (MouseEvent e)
//  {
//    System.out.println("5");
//  }
}