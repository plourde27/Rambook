import java.awt.event.*;
public class Mouse implements MouseListener{
    boolean clicked;
    boolean pressed;
    int x, y;
    public Mouse(){
        clicked = false;
        pressed = false;
    }
    
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        /*if (!pressed) {
            clicked = true;
            pressed = true;
        }
        else {
            clicked = false;
            pressed = true;
        }*/
    }
    public void mouseReleased(MouseEvent e){
        //clicked = false;
        //pressed = false;
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }
}