import java.util.*;
import javax.swing.*;

public class Main 
{
  public static void main(String[] args) 
    {
        RamBook rb = new RamBook();

        //rb.printAllUsers();

        JFrame frame = new JFrame("DISPLAY");
        Game game = new Game();
        
        
        Mouse mouse = new Mouse();
        frame.addMouseListener(mouse);
        Keyboard keyboard = new Keyboard();
        frame.addKeyListener(keyboard);
        Display screen = new Display(game, mouse, keyboard);
        frame.add(screen);
        ;
        frame.setBounds(0,0,1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Thread(game).start();
        new Thread(new frameRateUpdater(30,screen)).start();
        
        
  }
}