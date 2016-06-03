import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class NewBubble extends JPanel{
  
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
    repaint();
  }
  
  public void paint(Graphics g) 
  {
    System.out.println("Over here");
    super.paint(g);
    g.setColor(Color.BLUE);
    g.drawOval(40, 40, 100, 100);
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
    NewBubble b = new NewBubble("A", 100, 100, false);
    //b.moveBubble(100,100);
    JPanel j = new JPanel();
    
    //b.repaint();
    JFrame f = new JFrame("Load Image Sample");
    
    
    //System.out.println(Bubble.currentX + ", " + Bubble.currentY);
    
    f.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    f.add(b);
    f.pack();
    f.setVisible(true);
  }
  
  /* ADD YOUR CODE HERE */
  
}
