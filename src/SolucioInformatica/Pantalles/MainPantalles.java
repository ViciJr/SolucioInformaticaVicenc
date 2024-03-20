package SolucioInformatica.Pantalles;

import java.sql.Connection;
import java.sql.DriverManager;

import SolucioInformatica.DataBase.DataBase;
import processing.core.PApplet;

import static SolucioInformatica.Pantalles.LayoutNMides.*;

public class MainPantalles extends PApplet {
    GUI gui;
    Connection con;

    // Dades de connexió (user, password, nom de la base de dades)
    String user     = "admin";
    String pass     = "12345";
    String database = "domotico";
    String usuario = "Lolito FDZ";
    String password = "12345";
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

            case SENSOR1:        gui.dibuixaPantallaSensor1(this);
                break;

            case ACTUADOR1:         gui.dibuixaPantallaActuador1(this);
                break;

            case GRÁFICA_SENSOR1:       gui.dibuixaPantallaEstadisticaSensor1(this);
                break;

            case GRÁFICA_ACTUADOR1:    gui.dibuixaPantallaEstadisticaActuador1(this);
                break;

            case INSTRUCCIONES:    gui.dibuixaPantallaInstrucciones(this);
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
        /*
        if(key=='0'){
            gui.pantallaActual = GUI.PANTALLA.INICIO;
        }
        else if(key=='1'){
            gui.pantallaActual = GUI.PANTALLA.MENÚ;
        }
        else if(key=='2'){
            gui.pantallaActual = GUI.PANTALLA.SENSOR1;
        }
        else if(key=='3'){
            gui.pantallaActual = GUI.PANTALLA.ACTUADOR1;
        }
        else if(key=='4'){
            gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR1;
        }
        else if(key=='5'){
            gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR1;
        }
        else if(key=='6'){
            gui.pantallaActual = GUI.PANTALLA.INSTRUCCIONES;
        }
*/
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
        if(gui.pantallaActual == GUI.PANTALLA.INICIO || gui.pantallaActual == GUI.PANTALLA.MENÚ || gui.pantallaActual == GUI.PANTALLA.SENSOR1 || gui.pantallaActual == GUI.PANTALLA.ACTUADOR1 || gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR1 || gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            if (gui.Logo.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
/*
            if (gui.BlogIn.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
            if (gui.Sensor1.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR1;
            }
            if (gui.Actuador1.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR1;
            }

*/
            }

            if (gui.pantallaActual == GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
                gui.Logo.setEnabled(false);
                gui.TUsuario.isPressed(this);
                gui.TContraseña.isPressed(this);

                String userName = gui.TUsuario.getText();
                String password = gui.TContraseña.getText();

                if (gui.pantallaActual == GUI.PANTALLA.INICIO && gui.BlogIn.mouseOverButton(this) &&  db.isValidUser(usuario, password)) {
                    gui.pantallaActual = GUI.PANTALLA.MENÚ;
                }

                else if(gui.BlogIn.mouseOverButton(this)&& !db.isValidUser(userName, password) ){
                    gui.BlogIn.setEnabled(false);
                    gui.Inicio.setVisible(true);
                }

              else  if(gui.Inicio.bAceptar.mouseOverButton(this)){
                    gui.Inicio.setVisible(false);
                    gui.BlogIn.setEnabled(true);
                }
            }
            else{
                gui.Logo.setEnabled(true);
            }

            if (gui.pantallaActual == GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
                gui.Sensor1.setEnabled(true);
                gui.Sensor2.setEnabled(true);
                gui.Sensor3.setEnabled(true);
                gui.Sensor4.setEnabled(true);
                gui.Sensor5.setEnabled(true);
                gui.Sensor6.setEnabled(true);
                gui.Sensor7.setEnabled(true);

                gui.Actuador1.setEnabled(true);
                gui.Actuador2.setEnabled(true);
                gui.Actuador3.setEnabled(true);
                gui.Actuador4.setEnabled(true);
                gui.Actuador5.setEnabled(true);
                gui.Actuador6.setEnabled(true);
                gui.Actuador7.setEnabled(true);


                if (gui.Actuador1.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR1;
                }
                if (gui.Sensor1.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR1;
                }
            }
            else{
                gui.Sensor1.setEnabled(false);
                gui.Sensor2.setEnabled(false);
                gui.Sensor3.setEnabled(false);
                gui.Sensor4.setEnabled(false);
                gui.Sensor5.setEnabled(false);
                gui.Sensor6.setEnabled(false);
                gui.Sensor7.setEnabled(false);

                gui.Actuador1.setEnabled(false);
                gui.Actuador2.setEnabled(false);
                gui.Actuador3.setEnabled(false);
                gui.Actuador4.setEnabled(false);
                gui.Actuador5.setEnabled(false);
                gui.Actuador6.setEnabled(false);
                gui.Actuador7.setEnabled(false);
            }

            if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

                gui.MenuS.setEnabled(true);

                gui.GraficaActuador.setEnabled(true);
                //  gui.BloquejatA.setEnabled(true);
               // gui.MenuS.setEnabled(true);
                gui.Tipoa.setEnabled(true);
                gui.Ubicaciona.setEnabled(true);
                gui.Arduinoa.setEnabled(true);
                gui.Sensora.setEnabled(true);

                gui.ValMin.isPressed(this);
                gui.ValMax.isPressed(this);

                if (gui.GraficaActuador.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR1;
                }
                if (gui.EncesA.isEnabled()) {
                    gui.ActuadorMapa1.setEnces(true);
                } else {
                    gui.ActuadorMapa1.setEnces(false);
                }
                if (gui.MenuS.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR1) {
                    gui.pantallaActual = GUI.PANTALLA.MENÚ;
                }
            }
            else{
                gui.MenuS.setEnabled(false);

                gui.GraficaActuador.setEnabled(false);
              //  gui.EncesA.setEnabled(false);
              //  gui.BloquejatA.setEnabled(false);
                gui.MenuS.setEnabled(false);
                gui.Tipoa.setEnabled(false);
                gui.Ubicaciona.setEnabled(false);
                gui.Arduinoa.setEnabled(false);
                gui.Sensora.setEnabled(false);
            }

            if (gui.pantallaActual == GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
                gui.MenuS.setEnabled(true);
                gui.GraficaSensor.setEnabled(true);
               // gui.EncesS.setEnabled(true);
                gui.Tipos.setEnabled(true);
                gui.Ubicacions.setEnabled(true);
                gui.Arduino.setEnabled(true);
                gui.Actuador.setEnabled(true);

                if (gui.GraficaSensor.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR1;
                }
                if (gui.EncesS.isEnabled()) {
                    gui.SensorMapa4.setEnces(true);
                } else {
                    gui.SensorMapa4.setEnces(false);
                }
                if (gui.MenuS.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR1) {
                    gui.pantallaActual = GUI.PANTALLA.MENÚ;
                }
            }
            else{
                gui.MenuS.setEnabled(false);
                gui.MenuS.setEnabled(false);
                gui.GraficaSensor.setEnabled(false);
              //  gui.EncesS.setEnabled(false);
                gui.Tipos.setEnabled(false);
                gui.Ubicacions.setEnabled(false);
                gui.Arduino.setEnabled(false);
                gui.Actuador.setEnabled(false);
            }

            if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
                gui.MenuSns.setEnabled(true);
                if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR1) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR1;
                }

            }
            else{
                gui.MenuSns.setEnabled(false);
            }

            if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
                gui.MenuAct.setEnabled(true);
                if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR1;
                }
            }
            else{
                gui.MenuAct.setEnabled(false);
            }

            if (gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR1 || gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR1){
                gui.Rangot.setEnabled(true);
                gui.Unidadest.setEnabled(true);
            }
            else{
                gui.Rangot.setEnabled(false);
                gui.Unidadest.setEnabled(false);
            }


        println("X: "+mouseX+", Y:"+mouseY);




        for(int i=0; i<gui.habitacions.length; i++) {
            gui.habitacions[i].updateSensors(this);
        }

        // Comprova si clicam sobre una habitació.
       /*for(int i=0; i<gui.habitacions.length; i++) {
            if(gui.habitacions[i].mouseOnHabitacio(this)){
                gui.hSelected = gui.habitacions[i];
                gui.habitacions[i].setSelected(true);
            }
            else {
                gui.habitacions[i].setSelected(false);
            }
        }*/

        if(gui.SensorMapa4.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR1;
        }

        if(gui.ActuadorMapa1.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR1;
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
        if(gui.EncesS.mouseOverButton(this)){
            gui.EncesS.toggle();
            if(gui.EncesS.isEnabled()){
                //bgColor = color(255);
            }
            else {
              //  gui.EncesS.Color = color(0);
            }
        }

        if(gui.EncesA.mouseOverButton(this)){
            gui.EncesA.toggle();
            if(gui.EncesA.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS.Color = color(0);
            }
        }

        if(gui.BloquejatA.mouseOverButton(this)){
            gui.BloquejatA.toggle();
            if(gui.BloquejatA.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS.Color = color(0);
            }
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

