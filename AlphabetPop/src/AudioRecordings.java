import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/** The AudioRecordings class contains all the recordings we will use for our game.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.27.16
 */

public class AudioRecordings
{
  public AudioRecordings()
  {
    try
    {
      Clip clip = AudioSystem.getClip();
      File music1 = new File("Music_1.wav");
      AudioInputStream music1Audio = AudioSystem.getAudioInputStream(music1);
      File music2 = new File("Music_2.wav");
      AudioInputStream music2Audio = AudioSystem.getAudioInputStream(music2);
      File music3 = new File("Music_3.wav");
      AudioInputStream music3Audio = AudioSystem.getAudioInputStream(music3);
      File music4 = new File("Music_4.wav");
      AudioInputStream music4Audio = AudioSystem.getAudioInputStream(music4);
      
      clip.open(music1Audio);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
         e.printStackTrace();
    }
  }
}