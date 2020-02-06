import java.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
public class User
{
    //INSTANCE FIELDS
    private String name;
    private int age;
    private String hometown;
    private String[] schools;
    private ArrayList<User> friendsList;
    private String username;
    private String password;
    private ArrayList<Message> inbox;
    private String UserStatus;
    private ArrayList<Post> posts;
    //private ArrayList<String> groups;//same as clubs
    private Schedule schedule;
    private ArrayList<SchoolClub> clubList;
    Scanner scn = new Scanner(System.in);
    //DATE AND TIME
    static SimpleDateFormat etDf = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mma 'EST'");
    static TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
    static {etDf.setTimeZone( etTimeZone );}
    
    //CONSTRUCTOR - DONE FOR YOU
    //NOTE - it leaves the friendsList empty
    public User(String n, int a, String h, String[] s, String u, String pw, Schedule sch)
    {
        name = n;
        age = a;
        hometown = h;
        schools = s;
        friendsList = new ArrayList<User>(); 
        username = u;
        password = pw;
        schedule = sch;
        posts = new ArrayList<Post>();
    }//END Constructor
    
    public User(String n, int a, String h, String[] s)
    {
        name = n;
        age = a;
        hometown = h;
        schools = s;
        friendsList = new ArrayList<User>(); 
        posts = new ArrayList<Post>();
    }//END Constructor
    
    // DONE FOR YOU
    // Accepts a List of Users that will replace the current friendsList
    public void bulkAddFriends(ArrayList<User> u)
    {
        friendsList = u;
    }//END bulkAddFriends
    

    
    // STARTED FOR YOU
    // Should print out all information for the user, nicely formatted
    public String toString()
    {
        String retStr = "";
        retStr += "Name: \t\t" + name + "\n";
        retStr += "Age: \t\t" + age + "\n";
        retStr += "Hometown: \t" + hometown + "\n";
        retStr += "Schools:\t|";
        
        //Need to include schools and friendslist
        for (int i = 0 ; i < schools.length ; i++) {
            if (schools[i] != null) {
                retStr += schools[i];
                retStr += "|";
            }
        }
        
        if (friendsList.size() > 0) {
            retStr += "\nFriends:\t|";
            
            for (int i = 0 ; i < friendsList.size() ; i++) {
                retStr += friendsList.get(i).getName();
                retStr += "|";
            }
            
            retStr += "\n";
        }
        else {
            retStr += "\nFriends:\tNo friends yet";
        }
        
        return retStr;
    }//END toString
    
    
    // DONE FOR YOU
    // Returns the User's name
    public String getName()
    {
        return name;
    }//END getName
    
    public boolean equals(Object other) {
        User oth = (User) other;
        return this.name.equals(oth.name) && this.hometown.equals(oth.hometown) && this.age == oth.age;
    }
    
    public void addFriend(User newFriend) {
        friendsList.add(newFriend);
    }
    
    public void unfriend(String nm) {
        for (int i = 0 ; i < friendsList.size() ; i++) {
            if (friendsList.get(i).name.equals(nm)) {
                friendsList.remove(i);
                break;
            }
        }
    }
    
    public int countFriends() {
        return friendsList.size();
    }
    
    public ArrayList<User> getMutualFriends(User other) {
        ArrayList<User> mut = new ArrayList<User>();
        for (int i = 0 ; i < other.friendsList.size() ; i++) {
            for (int j = 0 ; j < this.friendsList.size() ; j++) {
                if (other.friendsList.get(i).equals(this.friendsList.get(j))) {
                    mut.add(this.friendsList.get(j));
                }
            }
        }
        return mut;
    }
    
    public ArrayList<User> getHometownFriends() {
        ArrayList<User> hom = new ArrayList<User>();
        for (int i = 0 ; i < friendsList.size() ; i++) {
            if (friendsList.get(i).hometown.equals(this.hometown)) {
                hom.add(friendsList.get(i));
            }
        }
        return hom;
    }
    
    public ArrayList<User> getSchoolmates() {
        ArrayList<User> sch = new ArrayList<User>();
        for (int i = 0 ; i < friendsList.size() ; i++) {
            for (int j = 0 ; j < 3 ; j ++) {
                if (friendsList.get(i).schools[j].equals(this.schools[j])) {
                    sch.add(friendsList.get(i));
                    break;
                }
            }
        }
        return sch;
    }
    
    public User suggestAFriend() {
        ArrayList<User> good = new ArrayList<User>();
        ArrayList<User> maybe = new ArrayList<User>();
        for (User i : friendsList) {
            for (User j : i.friendsList) {
                if (friendsList.indexOf(j) == -1 && !j.equals(this) && j.hometown.equals(this.hometown)) {
                    good.add(j);
                }
                else if (friendsList.indexOf(j) == -1 && !j.equals(this)) {
                    maybe.add(j);
                }
            }
        }
        if (good.size() > 0) {
            return good.get((int) (Math.random() * good.size()));
        }
        else if (maybe.size() > 0) {
            return maybe.get((int) (Math.random() * maybe.size()));
        }
        return null;
        
    }
    
    public ArrayList<Message> getInbox() {
        return inbox;
    }
    
    public void setStatus(User p){
        System.out.print("Enter status: ");
        p.UserStatus = scn.nextLine();
    }
    
    public void newPost(User u){
        System.out.print("Enter the text for your post: ");
        String posttext = scn.nextLine();
        System.out.print("Public or private (please enter one of the options): ");
        String pvstatus = scn.nextLine();
        String dato = this.getDate();
        Post pt = new Post(u, posttext, pvstatus, dato);
        this.posts.add(pt);
        
    }
    
    public ArrayList<Post> getPosts(){
        return this.posts;
    }
    public void sendMessage(User other) {
        System.out.print("Enter your message: ");
        String message = scn.nextLine();
        System.out.println();
        System.out.print("Enter the name of the user you would like to send it to: ");
        String u = scn.nextLine();
        System.out.println();
        User recipient = this;
        boolean found = false;
        for (int i = 0 ; i < friendsList.size() ; i++) {
            if (friendsList.get(i).name.equals(u)) {
                recipient = friendsList.get(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Either that user is not in your friends list, or they do not exist.");
            return;
        }
        
        
        
        Message ms = new Message(this, recipient, message);
        ms.sendMessage();
    }
    
    public String getDate(){
        Date currentDate = new Date();
        Calendar currentTime = Calendar.getInstance();
         
        //In ET Time
        return etDf.format(currentDate.getTime());
    }
    
    public void addClub(SchoolClub sc){
        this.clubList.add(sc);
    }
    
    public ArrayList<SchoolClub> getClubs(){
        return this.clubList;
    }
    
    public int getCommonClasses(Object other) {
        User oth = (User) other;
        return this.schedule.classesInCommon(oth.schedule);
    }
}//END CLASS