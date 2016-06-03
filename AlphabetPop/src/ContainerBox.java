import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A rectangular container box, containing the bouncing ball.  
 */
public class ContainerBox {
   int minX, maxX, minY, maxY;  // Box's bounds (package access)
   private String imageName;   // Box's filled color (background)
   private Color colorBorder;   // Box's border color
   private BufferedImage pic;
   private static final Color DEFAULT_COLOR_FILLED = Color.BLACK;
   private static final Color DEFAULT_COLOR_BORDER = Color.YELLOW;
   
   /** Constructors */
   public ContainerBox(int x, int y, int width, int height, String name, Color colorBorder) {
      minX = x;
      minY = y;
      maxX = x + width - 1;
      maxY = y + height - 1;
      imageName = name;
      this.colorBorder = colorBorder;
      pic = loadImage();
   }
   
//   /** Constructor with the default color */
//   public ContainerBox(int x, int y, int width, int height) {
//      this(x, y, width, height, image, DEFAULT_COLOR_BORDER);
//   }
   
   /** Set or reset the boundaries of the box. */
   public void set(int x, int y, int width, int height) {
      minX = x;
      minY = y;
      maxX = x + width - 1;
      maxY = y + height - 1;
   }
   
   public BufferedImage loadImage()
  {
    try 
    {
      return ImageIO.read(new File(imageName));
    } 
    catch (IOException e) 
    {
      System.out.println("NOOOOO");
    }
    return null;
    //repaint();
  }

   /** Draw itself using the given graphic context. */
   public void draw(Graphics g) {
      //g.setColor(image);
      g.drawImage(pic, minX, minY, null);
      g.setColor(colorBorder);
      g.drawRect(minX, minY, maxX - minX - 1, maxY - minY - 1);
   }
}