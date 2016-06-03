import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayList;


/**
 * Auto Generated Java Class.
 */
public abstract class Levels extends JPanel {
  
  protected Ball[] ball = new Ball[26];
  private static final int UPDATE_RATE = 30;  // Frames per second (fps)
  private static final int NUM_BUBBLES = 26;
  String word;
  protected ArrayList<String>words;

  private ContainerBox box;  // The container rectangular box
  private ContainerBox box2;
  
  private DrawCanvas canvas; // Custom canvas for drawing the box/ball
  private DrawLetters canvas2;
  protected int canvasWidth;
  protected int canvasHeight;
  int xCoord;
  int yCoord;
  
  int radius = 50;
  int x;
  int y;
  int speed;
  int angleInDegree;
  
  int background;
  
  char [] letters;
  int currentLetter;
  Clip clip;
  Clip music;
  
  Clip[] audio = new Clip[8];
  Clip[] alphabet = new Clip[26];
  Clip[] click = new Clip[3];
  
  BufferedImage [] pics = new BufferedImage [8];
  
  protected GameTimer t;
  
  Thread gameThread;
  
  int round1Time, round2Time, round3Time;
  
  public void readWords(String file)
  {
    BufferedReader input;
    int randNum;
    String tempString;
    words=new ArrayList<String>();      
    
    try
    {

      String fileName = file;
      input = new BufferedReader (new FileReader (fileName));
      System.out.println("OK");
      if (!input.readLine().equals("This is a Green Eggs & Sam file."))
      {
        JOptionPane.showMessageDialog (this, "This is not a .GSE file!", "Incompatible File Type", JOptionPane.ERROR_MESSAGE);
      }
      while (true)
      {
        tempString=input.readLine();
        System.out.println(tempString);
        if (tempString!=null)
        {
          System.out.println("W");
        words.add(tempString);
        System.out.println("YES");
        }
        else
        {
          break;
        }
      }
    }
    catch (FileNotFoundException l)
    {
      System.out.println("BAD");
    }
    catch (IOException q)
    {
      System.out.println("Open File IO Error");
    }
    catch (Exception e)
    {
      System.out.println("Open Error");
    }
    
    for (int x=words.size()-1; x>0;x--)
    {
      randNum=(int)(Math.random()*x);
      if (randNum!=x)
      {
        tempString=words.get(x);
        words.set(x,words.get(randNum));
        words.set(randNum, tempString);
      }
    }
  }
  
  public void loadAudio()
  {
    try
    {
      for (int x = 0; x < 6; x++)
      {
        audio[x] = AudioSystem.getClip();
        File audioClip = new File("Music_" + (x+1) + ".wav");
        AudioInputStream audioClipStream = AudioSystem.getAudioInputStream(audioClip);
        audio[x].open(audioClipStream);
      }
      for (int x = 0; x < 26; x++)
      {
        alphabet[x] = AudioSystem.getClip();
        File alphabetClip = new File(("" + (char)(65+x)) + ".wav");
        AudioInputStream alphabetClipStream = AudioSystem.getAudioInputStream(alphabetClip);
        alphabet[x].open(alphabetClipStream);
      }
    }
    catch (UnsupportedAudioFileException q) {
      q.printStackTrace();
    } catch (IOException q) {
      q.printStackTrace();
    } catch (LineUnavailableException q) {
      q.printStackTrace();
    }
  }
  
  public void volume(float volAdjust, int clipNum)
  {
    FloatControl gainControl = (FloatControl) audio[clipNum].getControl(FloatControl.Type.MASTER_GAIN);
    gainControl.setValue(volAdjust); // Reduce volume by 10 decibels.
  }
  
  public void loadAudio(String fileName, int loop, float volAdjust)
  {
      try
      {
        Clip clip = AudioSystem.getClip();
        File effect = new File(fileName + ".wav");
        AudioInputStream effectAudio = AudioSystem.getAudioInputStream(effect);
        clip.open(effectAudio);
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volAdjust); // Reduce volume by 10 decibels.
        if (loop == 0)
          clip.start();
        else
          clip.loop(Clip.LOOP_CONTINUOUSLY);
      }
      catch (UnsupportedAudioFileException q) {
        q.printStackTrace();
      } catch (IOException q) {
        q.printStackTrace();
      } catch (LineUnavailableException q) {
        q.printStackTrace();
      }
  }
  
  /**
   * Constructor to create the UI components and init the game objects.
   * Set the drawing canvas to fill the screen (given its width and height).
   * 
   * @param width : screen width
   * @param height : screen height
   */
  public Levels(int width, int height) {

    canvasWidth = width;
    canvasHeight = height;
    loadAudio();

  }
  
  public void startup()
  {
    box = new ContainerBox(0, 0, canvasWidth, canvasHeight, "underwater.jpg", Color.BLACK);
    
    canvas = new DrawCanvas();
    canvas2 = new DrawLetters();
    this.setLayout(new BorderLayout());
    this.add(canvas, BorderLayout.CENTER);
    this.add(canvas2, BorderLayout.SOUTH);

    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        

        xCoord = e.getX();
        yCoord = e.getY();

        
        System.out.println("XCoord: " + xCoord+ "      " + "YCoord" +yCoord);
        
        for (int z = NUM_BUBBLES-1;z>=0;z--)
        {
          if (Math.sqrt(Math.pow(xCoord-ball[z].returnHorizontalCenter(),2)+Math.pow(yCoord-ball[z].returnVerticalCenter(),2))<=50 && !ball[z].getWasClicked())
          {
            if (ball[z].getLetter() == letters[currentLetter])
            {
              audio[4].setMicrosecondPosition(0);
              
              ball[z].setColor(Color.green);
              ball[z].setWasClicked(true);
              ball[z].setSpeed(0);
              ball[z].setRadius(-100);
              ball[z].setLocation(-100,-100);
              currentLetter++;
              if (currentLetter <= letters.length-1)
              {
                alphabet[letters[currentLetter]-65].setMicrosecondPosition(0);
                alphabet[letters[currentLetter]-65].start();
              }
            }
            else
            {
              loadAudio("Music_7",0,+5.0f);
            }
            if (currentLetter > letters.length-1)
            {
              currentLetter = 0;
              audio[2].stop();
              Main.switchMenu(0);
            }
            System.out.println("This is bubble number: " + currentLetter);
            System.out.println("Time elapsed is "+ t.getTimeElapsed());

            break;
          }
        }
      }
    });
    
    
    
    // Handling window resize.
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        Component c = (Component)e.getSource();
        Dimension dim = c.getSize();
        canvasWidth = dim.width;
        canvasHeight = dim.height;
        // Adjust the bounds of the container to fill the window
        box.set(0, 0, canvasWidth, canvasHeight);
        //box2.set(0, 0, 100, 100);
      }
    });
    
    // Start the ball bouncing
    gameStart();
  }
  
  /** Start the ball bouncing. */
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
            Thread.sleep(1000 / UPDATE_RATE);
          } catch (InterruptedException ex) {}
        }
      }
    };
    gameThread.start();  // Invoke GameThread.run()
  }
  
  /** 
   * One game time-step. 
   * Update the game objects, with proper collision detection and response.
   */
  public void gameUpdate() {
    for (int z = 0; z < 26; z++)
    {
      ball[z].moveOneStepWithCollisionDetection(box);
    }
    //ball[0].moveOneStepWithCollisionDetection(box);
  }
  
  /** The custom drawing panel for the bouncing ball (inner class). */
  class DrawCanvas extends JPanel {
    /** Custom drawing codes */
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
      // Draw the box and the ball
      //draw(g);
      box.draw(g);
      for (int z = 0; z < NUM_BUBBLES; z++)
      {
        ball[z].draw(g);
      }
      // Display ball's information
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      g.drawString("Ball " + ball.toString(), 20, 30);
      
    }
    
    /** Called back to get the preferred size of the component. */
    @Override
    public Dimension getPreferredSize() {
      return (new Dimension(canvasWidth, canvasHeight));
    }
  }
  
  class DrawLetters extends JPanel {
    /** Custom drawing codes */
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);    // Paint background
      // Draw the box and the ball
      g.setColor(Color.red);
      g.fillRect(0, 0, 100,100);
      g.fillRect(450, 0, 100,100);
      g.setColor(Color.black);
      g.setFont(new Font("Courier New", Font.PLAIN, 12));
      g.drawString("Time: " + t.getTimeElapsed(), 0, 50);
//      for (int z = 0; z < NUM_BUBBLES; z++)
//      {
//        ball[z].draw(g);
//      }
//      // Display ball's information
//      g.setColor(Color.WHITE);
//      g.setFont(new Font("Courier New", Font.PLAIN, 12));
//      g.drawString("Ball " + ball.toString(), 20, 30);
    }
    
    /** Called back to get the preferred size of the component. */
    @Override
    public Dimension getPreferredSize() {
      return (new Dimension(100, 100));
    }
  }
  

  
  

  
//  
////  public void draw (Graphics g)
////  {
////      g.drawImage(pics[background], 0, 0, null);
////      System.out.println(background);
////  }
  
  public void highScores()
  {
  }
  
  public void mainMenu()
  {
  }
  
  public void levelSelectMenu()
  {
  }
  
  public void splashScreen()
  {
  }
  
  public void exitConfirm()
  {
  }
  
  public void quitGameConfirm()
  {
  }
  
  public void printScores()
  {
  }
  
  public void instructions()
  {
  }
  
  public void resultScreen()
  {
  }
}

  

