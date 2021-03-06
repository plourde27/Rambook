import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Display extends JComponent{
    Game game;
    Mouse mouse;
    Keyboard kb;
    String accountString;
    String[] enterFields = new String[8];
    String[] fieldNames = {"Name:", "Username:", "Password:", "Age:", "Hometown:", "High School (optional):", "College (optional):", "Graduate School (optional):"};
    String[] classPeriods = {"1AC", "2AC", "3/4/5AC", "6AC", "1BD", "2BD", "3/4/5BD", "6BD", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher", "Teacher"};
    String[] names =  new String[16];
    String[] pf = new String[2];
    String newPostText = "";
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    Cursor arrowCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    int usersel = 0;
    int selInd = -1;
    int loginsel = -1;
    User ttu;
    String pmess = "";
    
    BufferedImage image;
    
    User you;
    
    RamBook rb;
    
    Frame frm;
    
    

    
    public Display(Game g, Mouse m, Keyboard k, Frame f) {
        game = g;
        mouse = m;
        kb = k;
        rb = new RamBook();
        frm = f;
        try {
            image = ImageIO.read(new File("graphic.png"));
        }
        catch (Exception e) {
        }
    }
    
    public void draw(){
        super.repaint();
    }
    
    public String editBox(Graphics g, int x, int y, int w, int h, Color c, String txt, boolean selected) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
        g.setColor(new Color(0, 0, 0));
        if (selected) {
            g.drawRect(x, y, w, h);
        }
        g.drawString(txt, x + 20, (int) (y + (3 * h / 4.0)));
        
        if (selected) {
            for (int i = 33 ; i <= 150 ; i++) {
                if (kb.pressed[i]) {
                    if (i >= 65 && i <= 90) {
                        if (kb.keys[16]) {
                            txt += (char) (i);
                        }
                        else {
                            txt += (char) (i + 32);
                        }
                    }
                    else {
                        txt += (char) (i);
                    }
                }
            }
            if (kb.pressed[32]) {
                txt += " ";
            }
            if (kb.pressed[8] && txt.length() > 0) {
                txt = txt.substring(0, txt.length() - 1);
            }
        }
        return txt;
    }
    
    public boolean button(Graphics g, int x, int y, int w, int h, Color c, String txt) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
        g.setColor(new Color(0, 0, 0));
        g.drawString(txt, x + 20, (int) (y + (3 * h / 4.0)));
        if (mouse.x >= x && mouse.x <= x + w && mouse.y >= y + 25 && mouse.y <= y + h + 25) {
            frm.setCursor(handCursor);
            if (mouse.clicked) {
                mouse.clicked = false;
                return true;
            }
        }
        return false;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0, 1000, 1000, null, null);
        g.setColor(new Color(255, 255, 255, 200));
        g.fillRect(0, 0, 1000, 1000);
        
        if (game.scene.equals("Login")) {
        
            g.setColor(new Color(255, 255, 255));
            
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Welcome to Rambook!", 200, 200);
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            if (button(g, 100, 600, 200, 90, new Color(180, 180, 180), "Create Account")) {
                game.scene = "CreateAccount";
                accountString = "";
            }
            if (button(g, 700, 600, 200, 90, new Color(180, 180, 180), "Log In")) {
                game.scene = "Log In";
                accountString = "";
            }
            //System.out.println(mouse.x + " " + mouse.y);
        }
        
        //***below are three guidelines for the graphics
        //obviously they have errors because this is the Display class
        //please delete/replace them when finished
        
        /*else if(game.scene.equals("Post")) {
            System.out.print("Make a post: ");
            String TextOfPost = scn.nextLine();
            //need to read for input, the user posting is the one logged in
        }
        else if(game.scene.equals("Message")) {
            System.out.print("Message Recipient: ");
            User RecipientOfMessage = scn.nextLine();
            
            this.sendMessage(RecipientOfMessage); //sendMessage() function has an intrinsic check to verify whether the potential recipient is a friend
                
        }
        else if(game.scene.equals("CreateClub")) {
            System.out.print("Club Name: ");
            String ClubName = scn.nextLine();
            System.out.print("President: ");
            String ClubPres = scn.nextLine();
            System.out.print("Advisor: ");
            String ClubAdvisor = scn.nextLine();
            
            SchoolClub NameOfClub = new SchoolClub(ClubName, ClubAdvisor, ClubPres);
        }*/

        
        
        
        else if (game.scene.equals("Log In")) {
            g.setColor(new Color(255, 255, 255));
            
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 95));
            g.drawString("Log In:", 200, 200);
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            g.drawString("Username: ", 240, 455);
            g.drawString("Password: ", 240, 605);
            if (pf[0] == null) {
                pf[0] = "";
            }
            if (pf[1] == null) {
                pf[1] = "";
            }
            if (button(g, 400, 400, 200, 100, new Color(220, 220, 220), pf[0])) {
                loginsel = 0;
            }
            if (button(g, 400, 550, 200, 100, new Color(220, 220, 220), pf[1])) {
                loginsel = 1;
            }
            pf[0] = editBox(g, 400, 400, 200, 100, new Color(220, 220, 220), pf[0], loginsel == 0);
            pf[1] = editBox(g, 400, 550, 200, 100, new Color(220, 220, 220), pf[1], loginsel == 1);
            if (button(g, 400, 850, 200, 100, new Color(220, 220, 220), "Log In")) {
                you = null;
                for (int i = 0 ; i < rb.allUsers.size() ; i++) {
                    if (rb.allUsers.get(i).getUsername().equals(pf[0]) && rb.allUsers.get(i).getPassword().equals(pf[1])) {
                        you = rb.allUsers.get(i);
                    }
                }
                if (you != null) {
                    game.scene = "Home";
                }
            }
        }
        else if (game.scene.equals("CreateAccount")) {
            
            g.setColor(new Color(255, 255, 255));
            
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Create your Account:", 200, 200);
            //System.out.println(kb.pressed[65]);
            if (selInd != -1) {
                
            }
            
            g.setColor(new Color(240, 240, 240));
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            for (int i = 0 ; i < enterFields.length ; i++) {
                if (enterFields[i] == null) {
                    enterFields[i] = "";
                }
                enterFields[i] = editBox(g, 410, 290 + i * 65, 450, 50, new Color(240, 240, 240), enterFields[i], selInd == i);
                
                g.setColor(new Color(0, 0, 0));
                g.drawString(fieldNames[i], 120, 325 + i * 65);
                
                
                if (button(g, 410, 290 + i * 65, 450, 50, new Color(240, 240, 240), enterFields[i])) {
                    
                    selInd = i;
                }
                if (selInd == i) {
                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(410, 290 + i * 65, 450, 50);
                }
            }
            
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            
            if (button(g, 400, 880, 200, 60, new Color(180, 180, 180), "Next")) {
                game.scene = "CreateClasses";
            }
            
        }
        else if (game.scene.equals("CreateClasses")) {
            
            //String[] teachers = {"","","","","","","",""};
            g.setColor(new Color(255, 255, 255));
            
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Enter your Schedule:", 200, 200);
            //System.out.println(kb.pressed[65]);
            if (selInd != -1) {
                
            }
            
            g.setColor(new Color(240, 240, 240));
            g.setFont(new Font("Helveticaneue", Font.PLAIN, 22));
            g.setColor(new Color(0, 0, 0));
            g.drawString("Class Name", 280, 270);
            g.drawString("Teacher", 750, 270);
            for (int i = 0 ; i < enterFields.length ; i++) {
                if (names[i] == null) {
                    names[i] = "";
                }
                if (names[i + 8] == null) {
                    names[i + 8] = "";
                }
                names[i] = editBox(g, 160, 290 + i * 65, 300, 50, new Color(240, 240, 240), names[i], selInd == i);
                names[i + 8] = editBox(g, 630, 290 + i * 65, 300, 50, new Color(240, 240, 240), names[i + 8], selInd == i + 8);
                g.setColor(new Color(240, 240, 240));
                g.fillRect(160, 290 + i * 65, 300, 50);
                g.setColor(new Color(0, 0, 0));
                g.drawString(classPeriods[i], 90, 330 + i * 65);
                
                
                g.setColor(new Color(0, 0, 0));
                if (button(g, 160, 290 + i * 65, 300, 50, new Color(240, 240, 240), names[i])) {
                    selInd = i;
                }
                g.setColor(new Color(240, 240, 240));
                g.fillRect(630, 290 + i * 65, 300, 50);
                g.setColor(new Color(0, 0, 0));
                
                if (button(g, 630, 290 + i * 65, 300, 50, new Color(240, 240, 240), names[i + 8])) {
                    selInd = i + 8;
                }
                if (selInd == i) {
                    g.drawRect(160, 290 + i * 65, 300, 50);
                }
                if (selInd == i + 8) {
                    g.drawRect(630, 290 + i * 65, 300, 50);
                }
            }
            g.setFont(new Font("Avenir", Font.PLAIN, 20));
            
            if (button(g, 400, 850, 200, 70, new Color(180, 180, 180), "Next")) {
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
        else if (game.scene.equals("Home") || game.scene.equals("Friends") || game.scene.equals("All Users") || game.scene.equals("Inbox") || game.scene.equals("Log Out")) {
            g.setColor(new Color(255, 255, 255));
            
            
            String[] buttonops = {"Home", "Friends", "All Users", "Inbox", "Log Out"};
            g.setFont(new Font("Avenir", Font.PLAIN, 22));
            for (int i = 0 ; i < buttonops.length ; i++) {
                if (game.scene.equals(buttonops[i])) {
                    if (button(g, 50 + i * 180, 300, 170, 80, new Color(180, 180, 180), buttonops[i])) {
                        game.scene = buttonops[i];
                    }
                }
                else {
                    if (button(g, 50 + i * 180, 300, 170, 80, new Color(210, 210, 210), buttonops[i])) {
                        game.scene = buttonops[i];
                    }
                }
            }
        }
        if (game.scene.equals("Home")) {
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            g.drawString("Welcome, " + you.getName(), 200, 200);
            g.setFont(new Font("Avenir", Font.PLAIN, 26));
            newPostText = editBox(g, 200, 400, 600, 100, new Color(220, 220, 220), newPostText, true);
            g.setFont(new Font("Avenir", Font.PLAIN, 22));
            if (button(g, 400, 530, 200, 80, new Color(220, 220, 220), "Make Post")) {
                you.newPost(you, newPostText);
                newPostText = "";
            }
            g.setFont(new Font("Avenir", Font.PLAIN, 22));
            g.setColor(new Color(0, 0, 0));
            g.drawString("Recent Posts:", 400, 660);
            for (int i = 0 ; i < Math.min(3, you.posts.size()) ; i++) {
                g.setColor(new Color(210, 210, 210));
                g.fillRect(200, 680 + i * 80, 600, 70);
                g.setColor(new Color(0, 0, 0));
                g.setFont(new Font("Avenir", Font.PLAIN, 22));
                Post ps = you.posts.get(i);
                g.setFont(new Font("Avenir", Font.PLAIN, 26));
                g.drawString(ps.text, 250, 710 + i * 80);
            }
        }
        else if (game.scene.equals("All Users") || game.scene.equals("Friends")) {
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 65));
            if (game.scene.equals("All Users") ) {
                g.drawString("View Other Users", 200, 200);
            }
            else {
                g.drawString("View Friends", 200, 200);
            }
            
            int i = usersel;
            int t = 0;
            ArrayList<User> tuu = new ArrayList<User>();
            for (int j = 0 ; j < rb.allUsers.size() ; j++) {
                if (rb.allUsers.get(j).equals(you)) {
                    continue;
                }
                if (game.scene.equals("Friends") && !you.isFriend(rb.allUsers.get(j))) {
                    continue;
                }
                tuu.add(rb.allUsers.get(j));
            }
            while (i < tuu.size() && t < 6) {
                g.setColor(new Color(230, 230, 230));
                User tu = tuu.get(i);
                
                if (button(g, 50, 400 + t * 90, 900, 80, new Color(230, 230, 230), "")) {
                    game.scene = "ViewOtherUser";
                    ttu = tu;
                }
                g.setColor(new Color(0, 0, 0));
                g.setFont(new Font("Avenir", Font.PLAIN, 30));
                g.drawString(tu.getName(), 200, 435 + t * 90);
                g.setFont(new Font("Avenir", Font.PLAIN, 21));
                g.drawString("Hometown: " + tu.getHometown(), 200, 470 + t * 90);
                g.drawString("Schools: " + tu.getSchools(), 460, 435 + t * 90);
                //g.drawString(", 460, 470 + (i - usersel) * 90);
                i++;
                t++;
                

            }
        }
        else if (game.scene.equals("ViewOtherUser")) {
            Color[] classColors = {new Color(0, 0, 0), new Color(255, 0, 0), new Color(200, 50, 0), new Color(180, 180, 0), new Color(100, 200, 0), new Color(0, 255, 0), new Color(0, 125, 255), new Color(0, 55, 255), new Color(0, 200, 200)};
            int cc = you.classesInCommon(ttu);
            g.setColor(classColors[cc]);
            g.fillOval(50, 120, 120, 120);
            g.fillRect(100, 230, 20, 1000);
            g.fillRect(160, 170, 1000, 20);
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 85));
            g.drawString(ttu.getName(), 250, 80);
            g.setFont(new Font("Avenir", Font.PLAIN, 28));
            g.drawString("Hometown: " + ttu.getHometown(), 250, 120);
            g.drawString("Schools: " + ttu.getSchools(), 250, 150);
            g.drawString("Age: " + Integer.toString(ttu.age), 650, 120);
            g.drawString(Integer.toString(cc) + " classes in common", 270, 240);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Avenir",Font.PLAIN, 120));
            g.drawString(Integer.toString(cc), 74, 219);
            g.setFont(new Font("Avenir", Font.PLAIN, 26));
            if (!you.isFriend(ttu)) {
                if (button(g, 250, 320, 200, 80, new Color(210, 210, 210), "Add as Friend")) {
                    you.addFriend(ttu);
                }
            }
            else {
                if (button(g, 250, 320, 200, 80, new Color(210, 210, 210), "Unfriend")) {
                    you.unfriend(ttu.getName());
                }
            }
            if (you.isFriend(ttu)) {
                pmess = editBox(g, 600, 320, 300, 80, new Color(210, 210, 210), pmess, true);
                if (button(g, 650, 440, 200, 80, new Color(210, 210, 210), "Send Message")) {
                    you.sendMessage(ttu.getName(), pmess);
                    pmess = "";
                    System.out.println(ttu.inbox);
                }
            }
            if (button(g, 400, 800, 200, 80, new Color(230, 230, 230), "Back")) {
                game.scene = "All Users";
            }
            g.setFont(new Font("Avenir", Font.PLAIN, 22));
            g.setColor(new Color(0, 0, 0));
            g.drawString("Recent Posts:", 200, 500);
            for (int i = 0 ; i < Math.min(3, ttu.posts.size()) ; i++) {
                g.setColor(new Color(210, 210, 210));
                g.fillRect(170, 530 + i * 80, 500, 70);
                g.setColor(new Color(0, 0, 0));
                g.setFont(new Font("Avenir", Font.PLAIN, 22));
                Post ps = ttu.posts.get(i);
                g.setFont(new Font("Avenir", Font.PLAIN, 26));
                g.drawString(ps.text, 200, 560 + i * 80);
            }
        }
        else if (game.scene.equals("Inbox")) {
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("Avenir", Font.PLAIN, 50));
            g.drawString("Inbox", 200, 200);
            for (int i = 0 ; i < Math.min(4, you.inbox.size()) ; i++) {
                g.setColor(new Color(210, 210, 210));
                g.fillRect(200, 400 + i * 100, 600, 80);
                g.setColor(new Color(0, 0, 0));
                g.setFont(new Font("Avenir", Font.PLAIN, 22));
                Message ms = you.inbox.get(i);
                g.drawString("From: " + ms.from.getName(), 250, 420 + i * 100);
                g.drawString("To: " + ms.to.getName(), 250, 470 + i * 100);
                g.setFont(new Font("Avenir", Font.PLAIN, 26));
                g.drawString(ms.message, 480, 430 + i * 100);
            }
        }
        else if (game.scene.equals("Log Out")) {
            you = null;
            rb.printAllUsers();
            game.scene = "Login";
            for (int i = 0 ; i < enterFields.length ; i++) {
                enterFields[i] = null;
            }
            for (int i = 0 ; i < pf.length ; i++) {
                pf[i] = null;
            }
        }
        else if (game.scene.equals("All Users")) {
            rb.printAllUsers();
        }
        
        
        setCursor(arrowCursor);
        
        for (int i = 0 ; i < 200 ; i++) {
            kb.pressed[i] = false;
        }
        mouse.clicked = false;
        if (you != null) {
            //System.out.println(you.getInbox());
        }
    }
}