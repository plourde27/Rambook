import java.util.*;

public class RamBook
{
    //INSTANCE FIELD
    public ArrayList<User> allUsers;
    public ArrayList<SchoolClub> allClubs;

    //CONSTRUCTOR
    public RamBook()
    {
        allUsers = new ArrayList<User>();
        
         //Add Users (Info only, no friends in friendsList yet)
        /*allUsers.add(new User("Grace", 20, "Syracuse", new String[]{"JDHS", "SU", null}));
        allUsers.add(new User("Bohdin", 21, "Los Angeles", new String[]{"Beverly Hills High", "UCLA", "USC"}));
        allUsers.add(new User("Shamus", 30, "DeWitt", new String[]{"JDHS", "Rutgers", null}));
        allUsers.add(new User("Jessica", 43, "Cleveland", new String[]{null, null, null}));
        allUsers.add(new User("Brooke", 68, "NYC", new String[]{"PS999", "NYU", null}));
        allUsers.add(new User("Claire", 16, "Syracuse", new String[]{"FM", "LeMoyne", "University of Phoenix"}));
        allUsers.add(new User("Samuel", 50, "NYC", new String[]{"PS101", "NYU", null}));
        allUsers.add(new User("Aimar", 66, "Los Angeles", new String[]{"MBHS", null, null}));
        allUsers.add(new User("Collin", 22, "Cincinnati", new String[]{"Bengal HS", "Ohio St.", null}));
        allUsers.add(new User("Minn", 28, "Los Angeles", new String[]{"LA HS", "UCSB", "Stanford"}));
        allUsers.add(new User("Xavier", 39, "Syracuse", new String[]{"Corcoran", "Oneonta", "Stanford"}));
        allUsers.add(new User("Kyra", 19, "Syracuse", new String[]{"Corcoran", null, null}));
        allUsers.add(new User("Linda", 20, "Syracuse", new String[]{"Corcoran", "SU", null}));
        allUsers.add(new User("Stefan", 21, "Los Angeles", new String[]{"Beverly Hills High", "UCLA", "USC"}));
        allUsers.add(new User("Sarah", 30, "DeWitt", new String[]{"F-P", null, null}));
        allUsers.add(new User("LangBot", 44, "Syracuse", new String[]{"Marcellus HS", "Bucknell U", "Binghamton U"}));
        */
        
        //Randomly Generate Friends
        for (int x=0; x < allUsers.size(); x++)
        {
            int friends = (int)(Math.random()*allUsers.size());
            ArrayList<User> addList = new ArrayList<User>();
            
            
            for (int i = 0; i < friends; i++)
            {
                User u = allUsers.get((int)(Math.random()*allUsers.size()));
                if (!addList.contains(u) && !u.equals(allUsers.get(x)))
                {    
                    addList.add(u);
                }
            }
            
            allUsers.get(x).bulkAddFriends(addList);
            
        }
        
        
    }//END CONSTRUCTOR
    
    
    // Prints out all the users
    public void printAllUsers()
    {
        for (User u : allUsers)
        {   
            System.out.println(u);
           
        }
    }//END printUsers
    
    //add club to list of all clubs????
    public void createClub(SchoolClub sc){
        allClubs.add(sc);
    }
    
    public ArrayList<User> getClubMembers(SchoolClub sc){
        ArrayList<User> total = new ArrayList<User>();
        for (User u : allUsers) {
            for (SchoolClub s : u.getClubs()){
                if (s.equals(sc)){
                    total.add(u);
                }
            }
        }
        return total;
    }
    
    public void addUser(User u){
        allUsers.add(u);
    }
    
}//END CLASS