import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

/* The LevelOne class allows the user to play level one of the game.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.19.16
 */

public class LevelOne extends JPanel {

  private BufferedImage background;
  private NewBubble[] bubbles;
  
  
        /**
 * This is the constructor that constructs the Bubble objects that are required for the level.
 */ 
  public LevelOne()
  {
    //Bubble.loadImage();
    bubbles = new NewBubble[26];
    for (int x = 0 ; x < 26 ; x ++)
    {
      bubbles[x] = new NewBubble (""+ (char)(65+x), 0, 0, false);
      //add(bubbles[x]);
    }
    add(bubbles[0]);
    //add(bubbles[1]);
    //add(bubbles[2]);
    
//    try 
//    {
//      background = ImageIO.read(new File("LevelOneBackground.jpg"));
//    } 
//    catch (IOException e) 
//    {
//      System.out.println("NOOOOO");
//    } 
    //repaint();
    
    addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      int xCoord = e.getX();
      int yCoord = e.getY();
      System.out.println(xCoord+ "      "+yCoord);
      for (int x = 0;x<26;x++)
      {
        System.out.println(Math.sqrt(Math.pow(xCoord-bubbles[x].returnHorizontalCenter(),2)+Math.pow(yCoord-bubbles[x].returnVerticalCenter(),2)));
        System.out.println(bubbles[x].returnHorizontalCenter());
        if (Math.sqrt(Math.pow(xCoord-bubbles[x].returnHorizontalCenter(),2)+Math.pow(yCoord-bubbles[x].returnVerticalCenter(),2))<=50)
        {
          System.out.println(x);
        }
      }
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
    //super.paintComponent(g);
    //g.setColor(Color.WHITE);
//    for (int x = 0 ; x < 26 ; x ++)
//    {
      //repaint();
    //}
    //g.drawImage(background, 0, 0, null);
  }  
  
  
}
