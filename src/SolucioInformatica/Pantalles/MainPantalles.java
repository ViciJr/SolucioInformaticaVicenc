package SolucioInformatica.Pantalles;

import processing.core.PApplet;

public class MainPantalles extends PApplet {
    GUI gui;

    public static void main(String[] args) {
        PApplet.main("SolucioInformatica.Pantalles.MainPantalles", args);
    }

    public void settings(){
        //fullScreen();                       // Pantalla completa
        size(1336, 768);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        noStroke();                         // Sense bordes
        textAlign(CENTER); textSize(18);   // Alineació i mida del text
        gui = new GUI(this);           // Constructor de la GUI
    }

    public void draw(){

        // Dibuixa la pantalla corresponent
        switch(gui.pantallaActual){
            case INICIO:         gui.dibuixaPantallaInicio(this);
                break;

            case PLANO:          gui.dibuixaPantallaPlano(this);
                break;

            case SENSORX:        gui.dibuixaPantallaSensorX(this);
                break;

            case ACTUADORX:         gui.dibuixaPantallaActuadorX(this);
                break;

            case ESTADISTICASENSORX:       gui.dibuixaPantallaEstadisticaSensorX(this);
                break;

            case ESTADÍSTICAACTUADORX:    gui.dibuixaPantallaEstadisticaActuadorX(this);
                break;

        }

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='0'){
            gui.pantallaActual = GUI.PANTALLA.INICIO;
        }
        else if(key=='1'){
            gui.pantallaActual = GUI.PANTALLA.PLANO;
        }
        else if(key=='2'){
            gui.pantallaActual = GUI.PANTALLA.SENSORX;
        }
        else if(key=='3'){
            gui.pantallaActual = GUI.PANTALLA.ACTUADORX;
        }
        else if(key=='4'){
            gui.pantallaActual = GUI.PANTALLA.ESTADISTICASENSORX;
        }
        else if(key=='5'){
            gui.pantallaActual = GUI.PANTALLA.ESTADÍSTICAACTUADORX;
        }

        gui.TUsuario.keyPressed(key, keyCode);
        gui.TContraseña.keyPressed(key, keyCode);
        }



    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        println("X: "+mouseX+", Y:"+mouseY);
        gui.TUsuario.isPressed(this);
        gui.TContraseña.isPressed(this);
    }


    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

