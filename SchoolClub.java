import java.util.*;

public class SchoolClub
{
    private String advisor;
    private String president;
    private String name;
    
    
    public SchoolClub(String nm, String ad, String pres)
    {
        advisor = ad;
        president = pres;
        name = nm;
        
        
    }
    
    public String getAdvisor() {
        return advisor;
    }
    
    public String getPresident() {
        return president;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean equals(Object other) {
        SchoolClub oth = (SchoolClub) other;
        return this.name.equals(oth.name);
    }
}
