public class SchoolClass
{
    private int period;
    private String blockPeriod;
    public String teacher;
    private String[] blockPeriods = {"1AC", "2AC", "3/4/5AC", "6AC", "1BD", "2BD", "3/4/5BD", "6BD"};
    public String name;
    
    public SchoolClass(String nm, int p, String t)
    {
        name = nm;
        period = p;
        blockPeriod = blockPeriods[p - 1];
        teacher = t;
    }
    
    public String getTeacher() {
        return teacher;
    }
    
    public String getBlockPeriod() {
        return blockPeriod;
    }
    
    public int getPeriod() {
        return period;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean equals(Object other) {
        SchoolClass oth = (SchoolClass) other;
        return this.name.equals(oth.name) && this.teacher.equals(oth.teacher) && this.period == oth.period;
    }
}
