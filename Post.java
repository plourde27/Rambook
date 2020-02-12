public class Post{
    private User poster;
    private String text;
    private String date;
    private String pstring;
    public Post(User p, String t, String pv, String d){
        poster = p;
        text = t;
        date = d;    
        pstring = pv;
    }
    
    public String toString(){
        return  pstring + " post: \"" + text + "\"\n\n\t" + date;
    }
    }
        
