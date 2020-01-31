import java.util.*;

public class Game implements Runnable{
    
    public Game(){
        
    }
    public void run(){
        while(true) {
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}