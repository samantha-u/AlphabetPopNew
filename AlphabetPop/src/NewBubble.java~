import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class NewBubble {
  
  private String letter;
  static int currentX;
  static int currentY;
  private boolean moves;
  
  public NewBubble(String newLetter, int startX, int startY, boolean newMoves) 
  { 
    letter=newLetter;
    currentX=startX;
    currentY=startY;
    moves=newMoves;
    //repaint();
  }
  
  public void paint(Graphics g) 
  {
    System.out.println("Got here");
    //super.paint(g);
    g.setColor(Color.BLUE);
    g.drawOval(40, 40, 60, 60);
    g.setColor(Colors.letters);
    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
    g.drawString(letter, currentX+18, currentY+70);
  }
  
  public int returnVerticalCenter()
  {
    return currentY+50;
  }
  public int returnHorizontalCenter()
  {
    return currentX+50;
  }
  
  public static void main(String[] args) { 
    
  }
  
  /* ADD YOUR CODE HERE */
  
}
