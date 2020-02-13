public class Post{
    private User poster;
    public String text;
    public Post(User p, String t){
        poster = p;
        text = t;
    }
    
    public String toString() {
        return text;
    }
    /*public String toString(){
        return  pstring + " post: \"" + text + "\"\n\n\t" + date;
    }*/
    }
        
