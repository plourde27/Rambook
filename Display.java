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
    String[] classPeriods = {"1AC", "2AC", "3/4/5AC", "6AC", "1BD", "2BD", "3/4/5BD", "6BD", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher"};
    String[] names =  new String[16];
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    Cursor arrowCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    int selInd = -1;
    
    User you;
    
    RamBook rb;

    
    public Display(Game g, Mouse m, Keyboard k) {
        game = g;
        mouse = m;
        kb = k;
        rb = new RamBook();
    }
    
    public void draw(){
        super.repaint();
    }
    
    public boolean button(Graphics g, int x, int y, int w, int h, Color c, String txt) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
        g.setColor(new Color(0, 0, 0));
        g.drawString(txt, x + 20, (int) (y + (3 * h / 4.0)));
        if (mouse.x >= x && mouse.x <= x + w && mouse.y >= y && mouse.y <= y + h) {
            return true;
        }
        return false;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if (game.scene.equals("Login")) {
        
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Welcome to Rambook!", 200, 200);
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            if (button(g, 100, 600, 200, 90, new Color(180, 180, 180), "Create Account")) {
                game.scene = "CreateAccount";
                accountString = "";
            }
            if (button(g, 700, 600, 200, 90, new Color(180, 180, 180), "Log In")) {
                game.scene = "CreateAccount";
                accountString = "";
            }
            //System.out.println(mouse.x + " " + mouse.y);
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
                g.setColor(new Color(0, 0, 0));
                g.drawString(fieldNames[i], 160, 325 + i * 65);
                if (enterFields[i] != null) {
                    g.drawString(enterFields[i], 420, 325 + i * 65);
                }
                else {
                    enterFields[i] = "";
                }
                if (selInd == i) {
                    g.drawRect(410, 290 + i * 65, 450, 50);
                }
                if (button(g, 410, 290 + i * 65, 450, 50, new Color(240, 240, 240), enterFields[i])) {
                    selInd = i;
                }
            }
            
            g.setColor(new Color(180, 180, 180));
            g.fillRect(400, 880, 200, 60);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            g.drawString("Next", 470, 920);
            
            if (mouse.clicked && mouse.x >= 400 && mouse.x <= 600 && mouse.y >= 880 && mouse.y <= 940) {
                game.scene = "CreateClasses";
                
            }
            
        }
        else if (game.scene.equals("CreateClasses")) {
            
            //String[] teachers = {"","","","","","","",""};
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Enter your Schedule:", 200, 200);
            //System.out.println(kb.pressed[65]);
            if (selInd != -1) {
                for (int i = 48 ; i <= 122 ; i++) {
                    if (kb.pressed[i]) {
                        if (i >= 65 && i <= 90) {
                            if (kb.keys[16]) {
                                System.out.println(names[selInd]);
                                names[selInd] += (char) (i);
                            }
                            else {
                                names[selInd] += (char) (i + 32);
                            }
                        }
                        else if (i >= 48 && i <= 57) {
                            names[selInd] += (char) (i);
                        }
                    }
                }
                if (kb.pressed[32]) {
                    names[selInd] += " ";
                }
                if (kb.pressed[8] && names[selInd].length() > 0) {
                    names[selInd] = names[selInd].substring(0, names[selInd].length() - 1);
                }
            }
            
            g.setColor(new Color(240, 240, 240));
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            g.setColor(new Color(0, 0, 0));
            g.drawString("Class Name", 280, 270);
            g.drawString("Teacher", 750, 270);
            for (int i = 0 ; i < enterFields.length ; i++) {
                g.setColor(new Color(240, 240, 240));
                g.fillRect(160, 290 + i * 65, 300, 50);
                g.setColor(new Color(0, 0, 0));
                g.drawString(classPeriods[i], 90, 330 + i * 65);
                if (names[i] != null) {
                    g.drawString(names[i], 180, 330 + i * 65);
                }
                else {
                    names[i] = "";
                }
                if (selInd == i) {
                    g.drawRect(160, 290 + i * 65, 300, 50);
                }
                if (mouse.clicked && mouse.x >= 160 && mouse.x <= 460 && mouse.y >= 320 + i * 65 && mouse.y <= 370 + i * 65) {
                    selInd = i;
                }
                g.setColor(new Color(240, 240, 240));
                g.fillRect(630, 290 + i * 65, 300, 50);
                g.setColor(new Color(0, 0, 0));
                if (names[i + 8] != null) {
                    g.drawString(names[i + 8], 650, 330 + i * 65);
                }
                else {
                    names[i + 8] = "";
                }
                if (selInd == i + 8) {
                    g.drawRect(630, 290 + i * 65, 300, 50);
                }
                if (mouse.clicked && mouse.x >= 630 && mouse.x <= 930 && mouse.y >= 320 + i * 65 && mouse.y <= 370 + i * 65) {
                    selInd = i + 8;
                }
            }
            
            g.setColor(new Color(180, 180, 180));
            g.fillRect(400, 850, 200, 90);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            g.drawString("Next", 470, 920);
            
            if (mouse.clicked && mouse.x >= 400 && mouse.x <= 600 && mouse.y >= 850 && mouse.y <= 940) {
                SchoolClass[] classes = new SchoolClass[8];
                for (int i = 0 ; i < 8 ; i++) {
                    classes[i] = new SchoolClass(names[i], i + 1, names[i + 8]);
                }
                Schedule sd = new Schedule(classes, enterFields[0]);
                String[] scho = new String[3];
                for (int i = 5 ; i <= 7 ; i++) {
                    if (enterFields[i].length() > 0) {
                        scho[i - 5] = enterFields[i];
                    }
                }
                you = new User(enterFields[0], Integer.parseInt(enterFields[3]), enterFields[4], scho, enterFields[1], enterFields[2], sd); 
                rb.addUser(you);
                rb.printAllUsers();
                game.scene = "Home";
            }
        }
        else if (game.scene.equals("Home")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, 1000, 1000);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Welcome, " + you.getName(), 200, 200);
        }
        else if (game.scene.equals("ViewOtherUser")) {
            Color[] classColors = {new Color(0, 0, 0), new Color(255, 0, 0), new Color(200, 50, 0), new Color(180, 180, 0), new Color(100, 200, 0), new Color(0, 255, 0), new Color(0, 125, 255), new Color(0, 55, 255), new Color(0, 200, 200)};
        }
        
        
        setCursor(arrowCursor);
        
        for (int i = 0 ; i < 200 ; i++) {
            kb.pressed[i] = false;
        }
        mouse.clicked = false;
        
    }
}