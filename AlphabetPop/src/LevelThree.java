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
public class LevelThree extends Levels {
  
  public LevelThree(int x, int y)
  {
    super(x, y);
    background = 3;
    letters = new char [5];
    readWords("Level3.txt");
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
    for (int z = 0 ; z < word.length(); z ++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (7 - 4) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, letters[z], false);
    }
    
    for (int z = word.length(); z < 26; z++)
    {
      x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      speed = (int)(Math.random() * (8 - 1) + 1) + 1;
      angleInDegree = rand.nextInt(360);
      ball[z] = new Ball(x, y, radius, speed, angleInDegree, Colors.bubbles, (char)(65+(int)(Math.random() * (25)) + 1), false);
    }
    alphabet[letters[currentLetter]-65].start();
    
    startup();
  }
  
}
