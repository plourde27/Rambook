import java.util.*;

public class User
{
    //INSTANCE FIELDS
    private String name;
    private int age;
    private String hometown;
    private String[] schools;
    private ArrayList<User> friendsList;
    
    //CONSTRUCTOR - DONE FOR YOU
    //NOTE - it leaves the friendsList empty
    public User(String n, int a, String h, String[] s)
    {
        name = n;
        age = a;
        hometown = h;
        schools = s;
        friendsList = new ArrayList<User>(); 
        
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
        
        retStr += "\nFriends:\t|";
        
        for (int i = 0 ; i < friendsList.size() ; i++) {
            retStr += friendsList.get(i).getName();
            retStr += "|";
        }
        
        retStr += "\n";
        
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
                if (friendsList.indexOf(j) == -1 && j.hometown.equals(this.hometown)) {
                    good.add(j);
                }
                else if (friendsList.indexOf(j) == -1) {
                    maybe.add(j);
                }
            }
        }
        if (good.size() > 0) {
            
        
    }
    
}//END CLASS