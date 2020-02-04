import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;

public class Display extends JComponent{
    Game game;
    Mouse mouse;
    public Display(Game g, Mouse m) {
        game = g;
        mouse = m;
    }
    
    public void draw(){
        super.repaint();
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        if (game.scene.equals("Login")) {
        
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Welcome to Rambook!", 200, 200);
            g.setColor(new Color(180, 180, 180));
            g.fillRect(100, 600, 200, 90);
            g.fillRect(700, 600, 200, 90);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            g.drawString("Log In", 140, 650);
            g.drawString("Create an Account", 715, 650);
            
            if (mouse.clicked && mouse.x >= 100 && mouse.x <= 300 && mouse.y >= 630 && mouse.y <= 720) {
                game.scene = "CreateAccount";
            }
            System.out.println(mouse.x + " " + mouse.y);
        }
        else if (game.scene.equals("CreateAccount")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Create your Account:", 200, 200);
        }
        
    }
}