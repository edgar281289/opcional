package simulador;

import java.awt.AWTEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import javax.media.j3d.*;

public class ControlRaton extends javax.media.j3d.Behavior {
    WakeupOnAWTEvent    clic = new WakeupOnAWTEvent(MouseEvent.MOUSE_CLICKED);
    WakeupOnAWTEvent    move = new WakeupOnAWTEvent(MouseEvent.MOUSE_MOVED);
    WakeupCondition     keepUpCondition = null;
    WakeupCriterion[]   continueArray = new WakeupCriterion[2];
    Juego juego;

 public ControlRaton(Juego j) {
        this.juego = j;
        continueArray[0]=clic;
        continueArray[1]=move;
        keepUpCondition = new WakeupOr(continueArray);
    }

 public void initialize()    {
            wakeupOn(keepUpCondition);
    }

 public void processStimulus(Enumeration criteria) {
      while (criteria.hasMoreElements()){
      WakeupCriterion ster=(WakeupCriterion) criteria.nextElement();
       if (ster instanceof WakeupOnAWTEvent)   {
           AWTEvent[] events = ( (WakeupOnAWTEvent) ster).getAWTEvent();
           for (int n=0;n<events.length;n++){
              if (events[n]  instanceof MouseEvent){
                MouseEvent em = (MouseEvent) events[n] ;
                if (em.getID() == MouseEvent.MOUSE_CLICKED) {
                    float x = em.getX();
                    float y = em.getY();
                   
                    /*
                    if (ek.getKeyChar() == 'w') personaje.adelante= true;
                    else if (ek.getKeyChar() == 'a') personaje.izquierda=true;
                    else if (ek.getKeyChar() == 'd') personaje.derecha=true;
                    else if (ek.getKeyChar() == 's') personaje.atras=true;
                    */
                    juego.posY = y;
                    juego.crearBola = true;
                    
                }
                else if (em.getID() == MouseEvent.MOUSE_MOVED)   {
                    /*
                    if (ek.getKeyChar()== 'w') personaje.adelante=false;
                    else if (ek.getKeyChar() == 'a') personaje.izquierda=false;
                    else if (ek.getKeyChar() == 'd') personaje.derecha=false;
                    else if (ek.getKeyChar() == 's')personaje.atras=false;
                    */
                    //System.out.println("Move!");
                }
          }
        }
}}
 wakeupOn(keepUpCondition);
  }
}
