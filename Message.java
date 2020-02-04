public class Message {
    private User from;
    private User to;
    private String message;
    public Message(User f, User t, String m) {
        from = f;
        to = t;
        message = m;
    }
    
    public void sendMessage() {
        //to.getInbox().add(this);
    }
}