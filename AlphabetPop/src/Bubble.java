import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/** The Bubble class creates a Bubble object.
 * Each Bubble object has the following characteristics:
 * - The letter it contains (ex. A, B, C)
 * - Its starting X-coordinate
 * - Its starting Y-coordinate
 * - Whether or not the Bubble will move (Bubble does not move in Level 1)
 * 
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * <b>letter</b> Contains the letter of the Bubble.
 * <p>
 * <b>currentX</b> Contains the current X-coordinate of the Bubble.
 * <p>
 * <b>currentY</b> Contains the current Y-coordinate of the Bubble.
 * <p>
 * <b>newMoves</b> Contains whether the Bubble moves or not.
 * <p>
 * <b>bubblePic</b> A static BufferedImage variable that refers to the picture of the Bubble.
 * 
 * @author Samantha Unger, Esther Yoo, and graphics code by Oracle and/or its affiliates.
 * @version 1 05.13.16
 */
public class Bubble
{
  private String letter;
  static int currentX;
  static int currentY;
  private boolean moves;
  static BufferedImage bubblePic;
  
  /** This method loads the Bubble image. It reads in the file "Bubble2.png" and assigns it to the static instance
   * variable, bubblePic.
   * 
   * First, the method enters a try-catch statement. It tries to assign the picture to the static instance variable,
   * bubblepic. If this fails, it catches the IOException and prints "NOOOOO" on the console.
   */
  public static void loadImage()
  {
    try 
    {
      bubblePic = ImageIO.read(new File("Bubble2.png"));
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    }
    //repaint();
  }
  
  /** This is the Bubble class constructor. It assigns new values to all of the object's attributes (instance variables)
   * each time it is called. It also loads the image (this is a temporary arrangement).
   * @param newLetter This parameter pass is used to assign a new value to instance variable, letter.
   * @param startX This parameter pass is used to assign a new value to instance variable, currentX.
   * @param startY This parameter pass is used to assign a new value to instance variable, currentY.
   * @param newMoves This parameter pass is used to assign a new value to instance variable, newMoves.
   */
  public Bubble(String newLetter, int startX, int startY, boolean newMoves)
  {
    loadImage(); //this does not belong here in the constructor. it belongs with the class that constructs bubbles
    letter=newLetter;
    currentX=startX;
    currentY=startY;
    moves=newMoves;
  }
  
  //comment these two methods :)
  public int returnVerticalCenter()
  {
    return currentY+50;
  }
  public int returnHorizontalCenter()
  {
    return currentX+50;
  }
  
  /** This method is used to move Bubbles.
    * 
    * @param x specifies how much the Bubble should move horizontally.
    * @param y specifies how much the Bubble should move vertically.
   */
  public void moveBubble(int x, int y)
  {
    System.out.println("At moveBubble");
    currentX = currentX + x;
    currentY = currentY + y;
    //repaint();
  }
  
  /** This method draws the Bubble image.
   * <p>
   * @param g This parameter pass is used to access the Graphics class.
   * <p>
   * <b>Local variables: </b>
   * <p>
   * <b>g </b> This local variable is used to access the Graphics class.
   */
  //@Override
  public void paint(Graphics g) 
  {
    System.out.println("Got here");
    g.drawImage(bubblePic, currentX, currentY, null);
    g.setColor(Colors.letters);
    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
    g.drawString(letter, currentX+18, currentY+70);
    //repaint();
  }
  
  /** This method sets the preferred Dimensions of the window.
   * @return new Dimension it returns the preferred Dimensions of the window.
   * The if structure checks if bubblepic has been assigned yet. If it has not (null), the method returns an automatic
   * Dimension of 100 by 100. Else, the method returns Dimensions that match the width and height of the Bubble.
   */
  public Dimension getPreferredSize() {
    if (bubblePic == null) {
      return new Dimension(100,100);
    } else {
      //return new Dimension(bubblePic.getWidth(null), bubblePic.getHeight(null));
      return new Dimension(1200, 600);
    }
  }
  
  public String getLetter()
  {
    return letter;
  }
  
  /* Description of main(String [] args)
   * This method creates a new Bubble, creates a new JPanel, creates a new JFrame, and is used to test the Bubble class.
   * 
   * @param args []  String array that allows command line parameters to be used when executing the program.
   */ 
//  public static void main (String[]args)
//  {
//    Bubble b = new Bubble ("A",100,100, true);
//    b.moveBubble(100,100);
//    JPanel j = new JPanel();
//    
//    //b.repaint();
//    JFrame f = new JFrame("Load Image Sample");
//    
//    
//    //System.out.println(Bubble.currentX + ", " + Bubble.currentY);
//    
//    f.addWindowListener(new WindowAdapter(){
//      public void windowClosing(WindowEvent e) {
//        System.exit(0);
//      }
//    });
//    
//    f.add(b);
//    f.pack();
//    f.setVisible(true);
//    
//  }
}