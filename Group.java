import java.util.*;
public class Group{
    private ArrayList<User> members;
    private String title;
    
    public Group(String t){
        title = t;
        members = null;
    }
    
    public void addMember(Group g, User u){
        g.members.add(u);
    }
    
    public void removeMember(Group g, User u){
        for (User r : g.members){
            if (r.equals(u)){
                g.members.remove(r);
            }
        }
    }
}