package SolucioInformatica.Pantalles;


import processing.core.PApplet;

public class MainPantalles extends PApplet {
    GUI gui;

    public static void main(String[] args) {
        PApplet.main("SolucioInformatica.Pantalles.MainPantalles", args);
    }

    public void settings(){
        fullScreen();                       // Pantalla completa
        //size(1336, 768);        // Pantalla HD
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

            case MENÚ:          gui.dibuixaPantallaPlano(this);
                break;

            case SENSORX:        gui.dibuixaPantallaSensorX(this);
                break;

            case ACTUADORX:         gui.dibuixaPantallaActuadorX(this);
                break;

            case ESTADÍSTICA_SENSORX:       gui.dibuixaPantallaEstadisticaSensorX(this);
                break;

            case ESTADÍSTICA_ACTUADORX:    gui.dibuixaPantallaEstadisticaActuadorX(this);
                break;

            case MAPA:    gui.dibuixaPantallaMapa(this);
                break;

        }

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='0'){
            gui.pantallaActual = GUI.PANTALLA.INICIO;
        }
        else if(key=='1'){
            gui.pantallaActual = GUI.PANTALLA.MENÚ;
        }
        else if(key=='2'){
            gui.pantallaActual = GUI.PANTALLA.SENSORX;
        }
        else if(key=='3'){
            gui.pantallaActual = GUI.PANTALLA.ACTUADORX;
        }
        else if(key=='4'){
            gui.pantallaActual = GUI.PANTALLA.ESTADÍSTICA_SENSORX;
        }
        else if(key=='5'){
            gui.pantallaActual = GUI.PANTALLA.ESTADÍSTICA_ACTUADORX;
        }
        else if(key=='6'){
            gui.pantallaActual = GUI.PANTALLA.MAPA;
        }

        gui.TUsuario.keyPressed(key, keyCode);
        gui.TContraseña.keyPressed(key, keyCode);
        gui.TNameSensor.keyPressed(key, keyCode);
        gui.TNameActuador.keyPressed(key, keyCode);

        if(key=='n' || key=='N'){
            if(gui.hSelected != null) {
                gui.hSelected.encenLlums();
            }
        }
        // Apaga tots els llums
        else if(key=='f' || key=='F'){
            if(gui.hSelected != null) {
                gui.hSelected.apagaLlums();
            }
        }


        }



    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        println("X: "+mouseX+", Y:"+mouseY);
        gui.TUsuario.isPressed(this);
        gui.TContraseña.isPressed(this);
        gui.TNameSensor.isPressed(this);
        gui.TNameActuador.isPressed(this);

        for(int i=0; i<gui.habitacions.length; i++) {
            gui.habitacions[i].updateSensors(this);
        }

        // Comprova si clicam sobre una habitació.
        for(int i=0; i<gui.habitacions.length; i++) {
            if(gui.habitacions[i].mouseOnHabitacio(this)){
                gui.hSelected = gui.habitacions[i];
                gui.habitacions[i].setSelected(true);
            }
            else {
                gui.habitacions[i].setSelected(false);
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

