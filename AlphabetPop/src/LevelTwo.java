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

/**
 * Auto Generated Java Class.
 */
public class LevelTwo extends Levels {
  
  public LevelTwo(int x, int y)
  {
    super(x, y);
    background = 2;
    letters = new char [4];
    readWords("Level2.txt");
    word = words.get(0).toUpperCase();
    
    volume(-15.0f, 2);
    audio[2].loop(Clip.LOOP_CONTINUOUSLY);
    t = new GameTimer();
    t.start();
    
    for (int q = 0; q < word.length(); q++)
    {
      letters[q] = word.charAt(q);
    }
    Random rand = new Random();
    //ball[0] = new Ball(x, y, radius, speed, 227, Color.RED, "A", false);
    for (int z = 0 ; z < 26 ; z ++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (3 - 1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, (char)(65+z), false);
    }
    alphabet[letters[currentLetter]-65].start();
    
    startup();
  }
  
}