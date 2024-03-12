package SolucioInformatica.Pantalles;

import java.sql.Connection;
import java.sql.DriverManager;

import SolucioInformatica.DataBase.DataBase;
import processing.core.PApplet;

public class MainPantalles extends PApplet {
    GUI gui;
    Connection con;

    // Dades de connexió (user, password, nom de la base de dades)
    String user     = "admin";
    String pass     = "12345";
    String database = "domotica";
    boolean connectat = false;
    DataBase db;
    int n;
    public static void main(String[] args) {
        PApplet.main("SolucioInformatica.Pantalles.MainPantalles", args);
    }

    public void settings(){
        //fullScreen();                       // Pantalla completa
        size(1336, 768);        // Pantalla HD
        smooth(10);
    }

    public void setup(){
        connectBBDD();
        noStroke();                         // Sense bordes
        textAlign(CENTER); textSize(18);   // Alineació i mida del text
        gui = new GUI(this);           // Constructor de la GUI

        db = new DataBase("admin", "12345", "domotico");
        // Connecta amb la BBDD
        db.connect();

        // Número de files d'una taula
        n = db.getNumRowsTaula("usuario");
        println("\nFiles Usuario:"+n);

        // Dades d'una taula (unitat)
        String[][] dades1 = db.getInfoTaulaUnitat();
        println("\nDades Taula Usuario:");
       // printArray2D(dades1);
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
      /*  String info = connectat ? "OK" : "ERROR";
        fill(0); textSize(48);
        text("Connexió a la BBDD : "+ info, 100, 100); */

    }

    public void connectBBDD(){
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, pass);
            System.out.println("Connectat a la BBDD! :) ");
            connectat = true;
        }
        catch(Exception e) {
            System.out.println(e);
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
        gui.ValMin.keyPressed(key, keyCode);
        gui.ValMax.keyPressed(key, keyCode);


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
        gui.ValMin.isPressed(this);
        gui.ValMax.isPressed(this);

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

        if(gui.Tipos.mouseOverSelect(this) && gui.Tipos.isEnabled()){
            if(!gui.Tipos.isCollapsed()){
                gui.Tipos.update(this);      // Actualitzar valor
             //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos.toggle();        // Plegar o desplegar
        }

        if(gui.Ubicacions.mouseOverSelect(this) && gui.Ubicacions.isEnabled()){
            if(!gui.Ubicacions.isCollapsed()){
                gui.Ubicacions.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions.toggle();        // Plegar o desplegar
        }

        if(gui.Arduino.mouseOverSelect(this) && gui.Arduino.isEnabled()){
            if(!gui.Arduino.isCollapsed()){
                gui.Arduino.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino.toggle();        // Plegar o desplegar
        }
        if(gui.Actuador.mouseOverSelect(this) && gui.Actuador.isEnabled()){
            if(!gui.Actuador.isCollapsed()){
                gui.Actuador.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Actuador.toggle();        // Plegar o desplegar
        }

        if(gui.Tipoa.mouseOverSelect(this) && gui.Tipoa.isEnabled()){
            if(!gui.Tipoa.isCollapsed()){
                gui.Tipoa.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona.mouseOverSelect(this) && gui.Ubicaciona.isEnabled()){
            if(!gui.Ubicaciona.isCollapsed()){
                gui.Ubicaciona.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa.mouseOverSelect(this) && gui.Arduinoa.isEnabled()){
            if(!gui.Arduinoa.isCollapsed()){
                gui.Arduinoa.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora.mouseOverSelect(this) && gui.Sensora.isEnabled()){
            if(!gui.Sensora.isCollapsed()){
                gui.Sensora.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora.toggle();        // Plegar o desplegar
        }
        if(gui.Rangot.mouseOverSelect(this) && gui.Rangot.isEnabled()){
            if(!gui.Rangot.isCollapsed()){
                gui.Rangot.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Rangot.toggle();        // Plegar o desplegar
        }
        if(gui.Unidadest.mouseOverSelect(this) && gui.Unidadest.isEnabled()){
            if(!gui.Unidadest.isCollapsed()){
                gui.Unidadest.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Unidadest.toggle();        // Plegar o desplegar
        }

       /* // Si pitjam sobre el select 2
        if(s2.mouseOverSelect(this) && s2.isEnabled()){
            if(!s2.isCollapsed()){
                s2.update(this);      // Actualitzar valor
                updateNumber();   // Fer acció amb valor
            }
            s2.toggle();        // Plegar o desplegar
        }
    }*/

    }




    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

