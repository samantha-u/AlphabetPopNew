import javax.swing.JFrame;
import java.awt.event.*;


/**
 * Main Program for running the bouncing ball as a standalone application.
 */
public class Main {
<<<<<<< HEAD
  // Entry main program
  
  static JFrame frame;
  
 public static void switchMenu(int choice)
 {
   frame.getContentPane().removeAll();
   if (choice==0)
   {
   frame.add (new MainMenu());
   }
   else if (choice==1)
   {
     frame.add (new LevelOne(1200,550));
   }
   else if (choice==2)
   {
     frame.add (new LevelTwo(1200,550));
   }
   else if (choice==3)
   {
     frame.add (new LevelThree(1200,550));
   }
   else if (choice==4)
   {
     frame.add (new LevelMenu());
   }
   else if (choice==5)
   {
     frame.add(new ExitConfirm());
   }
   else if (choice==6)
   {
     frame.add(new Instructions());
   }
   frame.revalidate();
 }
  
  public static void main(String[] args) {
    // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
          frame = new JFrame("A World of Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu m = new MainMenu();
        frame.add(m);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1200,650);
        
        //while (true)
        //{
//        m.addMouseListener(new MouseAdapter() {
//          @Override
//          public void mouseClicked(MouseEvent e) {
//            if (m.getChoice()==2)
//            {
//              frame.remove(m);
//              LevelMenu l = new LevelMenu();
//              frame.add(l);
//              l.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                  if (l.getChoice()==1)
//                  { 
//                    frame.remove(l);
//                    //AlphabetPopGame a = new AlphabetPopGame(1200, 550);
//                    
//                    Levels a = new LevelOne(1200, 550);
//                    
//                    frame.add(a); 
//                    //a.levelOne();
//                    //a.startup();
//                    frame.revalidate();
////                    a.addMouseListener(new MouseAdapter() {
////                      @Override
////                      public void mouseClicked(MouseEvent e) {
////                        if (a.complete)
////                        {
////                          frame.remove(a);
////                          frame.add(m);
////                          frame.repaint();
////                          frame.revalidate();
////                        }
////                      }});
//                  }
//                  else if (l.getChoice()==2)
//                  {
//                    frame.remove(l);
//                    Levels a = new LevelTwo(1200, 550);
//                    frame.add(a); 
//                    //a.levelTwo();
//                    //a.startup();
//                    //System.out.println(a.word);
//                    frame.revalidate();
////                    a.addMouseListener(new MouseAdapter() {
////                      @Override
////                      public void mouseClicked(MouseEvent e) {
////                        if (a.complete)
////                        {
////                          frame.remove(a);
////                          frame.add(m);
////                          frame.repaint();
////                          frame.revalidate();
////                        }
////                      }});
//                  }
//                  else if (l.getChoice()==3)
//                  {
//                    frame.remove(l);
//                    Levels a = new LevelThree(1200, 550);
//                    frame.add(a); 
//                    //a.levelThree();
//                    //a.startup();
//                    frame.revalidate();
////                    a.addMouseListener(new MouseAdapter() {
////                      @Override
////                      public void mouseClicked(MouseEvent e) {
////                        if (a.complete)
////                        {
////                          frame.remove(a);
////                          frame.add(m);
////                          frame.repaint();
////                          frame.revalidate();
////                        }
////                      }});
//                  }
//                    else if (l.getChoice()==4)
//                    {
//                      frame.remove(l);
//                      frame.add(m);
//                      frame.repaint();
//                      frame.revalidate();
//                    }
//                  }});

//              frame.revalidate();
//              //break;
//            }
//      }
//            
//});
=======
   // Entry main program
   public static void main(String[] args) {
      // Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame frame = new JFrame("Alphabet Pop");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainMenu m = new MainMenu();
            frame.add(m);
            frame.pack();
            frame.setVisible(true);
            frame.setSize(1200,650);
            
            //while (true)
            //{
            m.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
      if (m.getChoice()==2)
            {
        frame.remove(m);
              frame.add(new AlphabetPopGame(1200, 550)); 
              frame.revalidate();
              //break;
            }
      }
            
});
>>>>>>> origin/master
            

            //}// BallWorld is a JPanel
                        // Preferred size of BallWorld
            
            
            
              // Show it
         }
      });
      //new AudioRecordings();
      
   }
}