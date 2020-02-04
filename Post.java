public class Post{
    private User poster;
    private String text;
    private String date;
    private boolean privacy;
    
    public Post(User p, String t, String pv){
        poster = p;
        text = t;
        if (pv.toLowerCase() == "public")
            privacy = false;
        else
            privacy = true;
    }
    }
        
