import java.util.*;

public class Schedule
{
    private SchoolClass[] classes;
    private ArrayList<SchoolClub> clubs;
    private String name;
    
    public Schedule(SchoolClass[] cs, String nm)
    {
        classes = cs;
        clubs = new ArrayList<SchoolClub>();
        name = nm;
    }
    
    public void addClub(SchoolClub cb) {
        clubs.add(cb);
    }

    public SchoolClass[] getClasses() {
        return classes;
    }
    
    public ArrayList<SchoolClub> getClubs() {
        return clubs;
    }
    
    public String getName() {
        return name;
    }
    
    public int classesInCommon(Object other) {
        Schedule oth = (Schedule) other;
        int common = 0;
        for (int i = 0 ; i < classes.length ; i++) {
            //System.out.println(this.classes[i].equals(oth.classes[i]) + " " + this.classes[i].name + " " + this.classes[i].teacher + " " + oth.classes[i].name + " " + oth.classes[i].teacher);
            if (this.classes[i].equals(oth.classes[i])) {
                common += 1;
            }
        }
        return common;
    }
    
    public int clubsInCommon(Object other) {
        Schedule oth = (Schedule) other;
        int common = 0;
        for (int i = 0 ; i < clubs.size() ; i++) {
            for (int j = 0 ; j < oth.clubs.size() ; j++) {
                if (this.clubs.get(i).equals(oth.clubs.get(j))) {
                    common += 1;
                }
            }
        }
        return common;
    }
}
