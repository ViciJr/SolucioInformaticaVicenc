package SolucioInformatica.gui;

import processing.core.PApplet;
/**Pruebas de los SwitchButtons*/
public class SwitchButtonTest extends PApplet {

    // Elements de la Interfície Gràfica (TextFields)
    SwitchButton sbt;
    int bgColor;

    public static void main(String[] args) {
        PApplet.main("SolucioInformatica.gui.SwitchButtonTest", args);
    }

    public void settings(){
        size(800, 800);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        // Crea els TextFields
        sbt = new SwitchButton(this, "On","Off",width/2 - 150, height/2 - 100, 300, 100);

        bgColor = color(255);
    }

    public void draw(){
        background(bgColor);
        fill(0); textSize(28);

        // Dibuixa el SwitchButton
        sbt.display(this);

        updateCursor();
    }

    // Estableix quin cursor emprar (HAND, ARROW)
    public void updateCursor(){
        if(sbt.mouseOverButton(this)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){  }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        // Comprova si pitjam amb el mouse sobre el SwitchButton
        if(sbt.mouseOverButton(this)){
            sbt.toggle();
            if(sbt.isEnabled()){
                bgColor = color(255);
            }
            else {
                bgColor = color(0);
            }
        }
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}