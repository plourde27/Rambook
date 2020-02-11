import java.util.*;
import javax.swing.*;

public class Main 
{
  public static void main(String[] args) 
    {

        //rb.printAllUsers();

        JFrame frame = new JFrame("DISPLAY");
        Game game = new Game();
        
        
        Mouse mouse = new Mouse();
        frame.addMouseListener(mouse);
        Keyboard keyboard = new Keyboard();
        frame.addKeyListener(keyboard);
        Display screen = new Display(game, mouse, keyboard, frame);
        frame.add(screen);
        
        frame.setBounds(0,0,1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Thread(game).start();
        new Thread(new frameRateUpdater(30,screen)).start();
        
        User x = new User("Joe", 18, "South Bend", new String[] {"SBHS", "Harvard"});
        //x.newPost(x);
        //System.out.println(x.getPosts().get(0));
        SchoolClub jousting = new SchoolClub("Jousting Club", "Jake", "James");
        x.addClub(jousting);
        System.out.println(x.getClubs());
  }
}