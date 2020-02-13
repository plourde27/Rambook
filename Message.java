public class Message {
    public User from;
    public User to;
    public String message;
    public Message(User f, User t, String m) {
        from = f;
        to = t;
        message = m;
    }
    
    public void sendMessage() {
        to.inbox.add(0, this);
    }
    
    public String toString() {
        return message;
    }
}