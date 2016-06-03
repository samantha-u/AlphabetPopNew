/** The GameTimer class is a thread that is used to time the user's game.
 * 
 * @author Samantha Unger, Esther Yoo
 * @version 1 05.29.16
 */
import java.awt.*;
import java.lang.*;

public class GameTimer extends Thread
{
    private int timeElapsed;

    public void timer ()
    {
        timeElapsed = 0;
        do
        {
            try
            {
                Thread.sleep (1000);
            }
            catch (Exception e)
            {
            }
            timeElapsed++;
        }
        while (true);
    }


    public int getTimeElapsed ()
    {
        return timeElapsed;
    }

    public GameTimer ()
    {
    }


    public void run ()
    {
        timer ();
    }
}