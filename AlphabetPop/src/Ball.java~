import java.awt.*;
import java.util.Formatter;
/**
 * The bouncing ball.
 */
public class Ball {
   float x, y;           // Ball's center x and y (package access)
   float speedX, speedY; // Ball's speed per step in x and y (package access)
   float radius;         // Ball's radius (package access)
   char letter;
   boolean wasClicked;
   float angleInDegree;
   private Color color;  // Ball's color
   private Color outline;  // Ball's color
   private Color letterCol;  // Ball's color
  
   /**
    * Constructor: For user friendliness, user specifies velocity in speed and
    * moveAngle in usual Cartesian coordinates. Need to convert to speedX and
    * speedY in Java graphics coordinates for ease of operation.
    */
   public Ball(float x, float y, float radius, float speed, float angleInDegree,
         Color color, char letter, boolean wasClicked) {
      this.x = x;
      this.y = y;
      this.angleInDegree = angleInDegree;
      // Convert (speed, angle) to (x, y), with y-axis inverted
      this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
      this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
      this.radius = radius;
      this.color = color;
      outline = Color.white;
      letterCol = Colors.letters;
      this.letter = letter;
      this.wasClicked = wasClicked;
   }
   /** Constructor with the default color */
   public Ball(float x, float y, float radius, float speed, float angleInDegree) {
      this(x, y, radius, speed, angleInDegree, Colors.bubbles, 'A', false);
   }
   
   public void setLocation (int x, int y)
   {
     this.x = x;
     this.y = y;
   }
   
   public boolean getWasClicked()
   {
     return wasClicked;
   }
   
   public void setRadius (float newRadius)
   {
     radius = newRadius;
   }
   
   public void setWasClicked(boolean newWasClicked)
   {
     wasClicked = newWasClicked;
   }
   
   /** Draw itself using the given graphics context. */
   public void draw(Graphics g) {
      g.setColor(color);
      g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
      g.setColor(outline);
      g.drawOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
      g.setColor(letterCol);
      g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
      g.drawString("" + letter, (int)x-30, (int)y+25);
   }
   
//   public void remove (Graphics g)
//   {
//     g.clearOval(x, y, radius, radius);
//   }
   
   public float returnVerticalCenter()
  {
    return y;
  }
  public float returnHorizontalCenter()
  {
    return x;
  }
  
  public char getLetter()
  {
    return letter;
  }
  
  public void setColor (Color newColor)
  {
    color = newColor;
//    outline = newOutLine;
//    letterCol = newLetter;
  }
  
  public void setSpeed (float speed)
  {
    this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
    this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
  }
   
   /** 
    * Make one move, check for collision and react accordingly if collision occurs.
    * 
    * @param box: the container (obstacle) for this ball. 
    */
   public void moveOneStepWithCollisionDetection(ContainerBox box) {
      // Get the ball's bounds, offset by the radius of the ball
      float ballMinX = box.minX + radius;
      float ballMinY = box.minY + radius;
      float ballMaxX = box.maxX - radius;
      float ballMaxY = box.maxY - radius;
   
      // Calculate the ball's new position
      x += speedX;
      y += speedY;
      // Check if the ball moves over the bounds. If so, adjust the position and speed.
      if (x < ballMinX) {
         speedX = -speedX; // Reflect along normal
         x = ballMinX;     // Re-position the ball at the edge
      } else if (x > ballMaxX) {
         speedX = -speedX;
         x = ballMaxX;
      }
      // May cross both x and y bounds
      if (y < ballMinY) {
         speedY = -speedY;
         y = ballMinY;
      } else if (y > ballMaxY) {
         speedY = -speedY;
         y = ballMaxY;
      }
   }
   
   /** Return the magnitude of speed. */
   public float getSpeed() {
      return (float)Math.sqrt(speedX * speedX + speedY * speedY);
   }
   
   /** Return the direction of movement in degrees (counter-clockwise). */
   public float getMoveAngle() {
      return (float)Math.toDegrees(Math.atan2(-speedY, speedX));
   }
   
   /** Return mass */
   public float getMass() {
      return radius * radius * radius / 1000f;  // Normalize by a factor
   }
   
   /** Return the kinetic energy (0.5mv^2) */
   public float getKineticEnergy() {
      return 0.5f * getMass() * (speedX * speedX + speedY * speedY);
   }
  
   /** Describe itself. */
   public String toString() {
      sb.delete(0, sb.length());
      formatter.format("@(%3.0f,%3.0f) r=%3.0f V=(%2.0f,%2.0f) " +
            "S=%4.1f \u0398=%4.0f KE=%3.0f", 
            x, y, radius, speedX, speedY, getSpeed(), getMoveAngle(),
            getKineticEnergy());  // \u0398 is theta
      return sb.toString();
   }
   // Re-use to build the formatted string for toString()
   private StringBuilder sb = new StringBuilder();
   private Formatter formatter = new Formatter(sb);
}