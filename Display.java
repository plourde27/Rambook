import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;

public class Display extends JComponent{
    Game game;
    Mouse mouse;
    Keyboard kb;
    String accountString;
    String[] enterFields = new String[8];
    String[] fieldNames = {"Name:", "Username:", "Password:", "Age:", "Hometown:", "High School (optional):", "College (optional):", "Graduate School (optional):"};

    int selInd = -1;
    
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
            //System.out.println(kb.pressed[65]);
            if (selInd != -1) {
                for (int i = 48 ; i <= 122 ; i++) {
                    if (kb.pressed[i]) {
                        if (i >= 65 && i <= 90) {
                            if (kb.keys[16]) {
                                enterFields[selInd] += (char) (i);
                            }
                            else {
                                enterFields[selInd] += (char) (i + 32);
                            }
                        }
                        else if (i >= 48 && i <= 57) {
                            enterFields[selInd] += (char) (i);
                        }
                    }
                }
                if (kb.pressed[32]) {
                    enterFields[selInd] += " ";
                }
                if (kb.pressed[8] && enterFields[selInd].length() > 0) {
                    enterFields[selInd] = enterFields[selInd].substring(0, enterFields[selInd].length() - 1);
                }
            }
            
            g.setColor(new Color(240, 240, 240));
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            for (int i = 0 ; i < enterFields.length ; i++) {
                g.setColor(new Color(240, 240, 240));
                g.fillRect(410, 290 + i * 65, 450, 50);
                g.setColor(new Color(0, 0, 0));
                g.drawString(fieldNames[i], 160, 330 + i * 65);
                if (enterFields[i] != null) {
                    g.drawString(enterFields[i], 420, 330 + i * 65);
                }
                else {
                    enterFields[i] = "";
                }
                if (selInd == i) {
                    g.drawRect(410, 290 + i * 65, 450, 50);
                }
                if (mouse.clicked && mouse.x >= 260 && mouse.x <= 710 && mouse.y >= 320 + i * 65 && mouse.y <= 370 + i * 65) {
                    selInd = i;
                }
            }
            
            g.setColor(new Color(180, 180, 180));
            g.fillRect(400, 850, 200, 90);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            g.drawString("Next", 470, 920);
            
            if (mouse.clicked && mouse.x >= 400 && mouse.x <= 600 && mouse.y >= 850 && mouse.y <= 940) {
                game.scene = "CreateClasses";
                accountString = "";
            }
            
            
        }
        else if (game.scene.equals("CreateClasses")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Create your Account:", 200, 200);
            //System.out.println(kb.pressed[65]);
            if (selInd != -1) {
                for (int i = 48 ; i <= 122 ; i++) {
                    if (kb.pressed[i]) {
                        if (i >= 65 && i <= 90) {
                            if (kb.keys[16]) {
                                enterFields[selInd] += (char) (i);
                            }
                            else {
                                enterFields[selInd] += (char) (i + 32);
                            }
                        }
                        else if (i >= 48 && i <= 57) {
                            enterFields[selInd] += (char) (i);
                        }
                    }
                }
                if (kb.pressed[32]) {
                    enterFields[selInd] += " ";
                }
                if (kb.pressed[8] && enterFields[selInd].length() > 0) {
                    enterFields[selInd] = enterFields[selInd].substring(0, enterFields[selInd].length() - 1);
                }
            }
            
            g.setColor(new Color(240, 240, 240));
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            for (int i = 0 ; i < enterFields.length ; i++) {
                g.setColor(new Color(240, 240, 240));
                g.fillRect(410, 290 + i * 65, 450, 50);
                g.setColor(new Color(0, 0, 0));
                g.drawString(fieldNames[i], 160, 330 + i * 65);
                if (enterFields[i] != null) {
                    g.drawString(enterFields[i], 420, 330 + i * 65);
                }
                else {
                    enterFields[i] = "";
                }
                if (selInd == i) {
                    g.drawRect(410, 290 + i * 65, 450, 50);
                }
                if (mouse.clicked && mouse.x >= 260 && mouse.x <= 710 && mouse.y >= 320 + i * 65 && mouse.y <= 370 + i * 65) {
                    selInd = i;
                }
            }
            
            g.setColor(new Color(180, 180, 180));
            g.fillRect(400, 850, 200, 90);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            g.drawString("Next", 470, 920);
            
            if (mouse.clicked && mouse.x >= 400 && mouse.x <= 600 && mouse.y >= 850 && mouse.y <= 940) {
                game.scene = "CreateClasses";
                accountString = "";
            }
            
            
        }
        
        for (int i = 0 ; i < 200 ; i++) {
            kb.pressed[i] = false;
        }
    }
}