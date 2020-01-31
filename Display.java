import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;

public class Display extends JComponent{
    Game game;
    public Display(Game g) {
        game = g;
    }
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Avenir", Font.PLAIN, 65));
        g.drawString("Rambook Project", 200, 200);
        
        
    }
}