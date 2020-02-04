import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;

public class Display extends JComponent{
    Game game;
    Mouse mouse;
    Keyboard kb;
    String accountString;
    public Display(Game g, Mouse m, Keyboard k) {
        game = g;
        mouse = m;
        kb = k;
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
                accountString = "";
            }
            System.out.println(mouse.x + " " + mouse.y);
        }
        else if (game.scene.equals("CreateAccount")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Create your Account:", 200, 200);
            g.drawString(accountString, 300, 300);
            //System.out.println(kb.pressed[65]);
            for (int i = 48 ; i <= 122 ; i++) {
                if (kb.pressed[i]) {
                    if (i >= 65 && i <= 90) {
                        accountString += (char) (i + 32);
                    }
                    else if (i >= 48 && i <= 57) {
                        accountString += (char) (i);
                    }
                }
            }
            if (kb.pressed[32]) {
                accountString += " ";
            }
            if (kb.pressed[8] && accountString.length() > 0) {
                accountString = accountString.substring(0, accountString.length() - 1);
            }
        }
        
        for (int i = 0 ; i < 200 ; i++) {
            kb.pressed[i] = false;
        }
    }
}