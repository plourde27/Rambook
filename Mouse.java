import java.awt.event.*;
public class Mouse implements MouseListener{
    boolean clicked;
    int x, y;
    public Mouse(){
        clicked = false;
    }
    
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        clicked = true;
    }
    public void mouseReleased(MouseEvent e){
        clicked = false;
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {

    }
}