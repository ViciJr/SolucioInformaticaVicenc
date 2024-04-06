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

       /// connectBBDD();
        noStroke();                         // Sense bordes
        textAlign(CENTER); textSize(18);   // Alineació i mida del text


        db = new DataBase("admin", "12345", "domotico");
        // Connecta amb la BBDD
        db.connect();

        // Número de files d'una taula
       // n = db.getNumRowsTaula("usuario");
        //println("\nFiles Usuario:"+n);

        // Dades d'una taula (unitat)
      //  String[][] dades1 = db.getInfoTaulaUnitat();
      //  println("\nDades Taula Usuario:");
       // printArray2D(dades1);

        gui = new GUI(this, db);           // Constructor de la GUI
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

            case SENSOR2:        gui.dibuixaPantallaSensor2(this);
                break;

            case SENSOR3:        gui.dibuixaPantallaSensor3(this);
                break;

            case SENSOR4:        gui.dibuixaPantallaSensor4(this);
                break;

            case SENSOR5:        gui.dibuixaPantallaSensor5(this);
                break;

            case SENSOR6:        gui.dibuixaPantallaSensor6(this);
                break;

            case SENSOR7:        gui.dibuixaPantallaSensor7(this);
                break;

            case ACTUADOR1:         gui.dibuixaPantallaActuador1(this);
                break;

            case ACTUADOR2:         gui.dibuixaPantallaActuador2(this);
                break;

            case ACTUADOR3:         gui.dibuixaPantallaActuador3(this);
                break;

            case ACTUADOR4:         gui.dibuixaPantallaActuador4(this);
                break;

            case ACTUADOR5:         gui.dibuixaPantallaActuador5(this);
                break;

            case ACTUADOR6:         gui.dibuixaPantallaActuador6(this);
                break;

            case ACTUADOR7:         gui.dibuixaPantallaActuador7(this);
                break;

            case GRÁFICA_SENSOR1:       gui.dibuixaPantallaEstadisticaSensor1(this);
                break;

            case GRÁFICA_SENSOR2:       gui.dibuixaPantallaEstadisticaSensor2(this);
                break;

            case GRÁFICA_SENSOR3:       gui.dibuixaPantallaEstadisticaSensor3(this);
                break;

            case GRÁFICA_SENSOR4:       gui.dibuixaPantallaEstadisticaSensor4(this);
                break;

            case GRÁFICA_SENSOR5:       gui.dibuixaPantallaEstadisticaSensor5(this);
                break;

            case GRÁFICA_SENSOR6:       gui.dibuixaPantallaEstadisticaSensor6(this);
                break;

            case GRÁFICA_SENSOR7:       gui.dibuixaPantallaEstadisticaSensor7(this);
                break;


            case GRÁFICA_ACTUADOR1:    gui.dibuixaPantallaEstadisticaActuador1(this);
                break;

            case GRÁFICA_ACTUADOR2:    gui.dibuixaPantallaEstadisticaActuador2(this);
                break;

            case GRÁFICA_ACTUADOR3:    gui.dibuixaPantallaEstadisticaActuador3(this);
                break;

            case GRÁFICA_ACTUADOR4:    gui.dibuixaPantallaEstadisticaActuador4(this);
                break;

            case GRÁFICA_ACTUADOR5:    gui.dibuixaPantallaEstadisticaActuador5(this);
                break;

            case GRÁFICA_ACTUADOR6:    gui.dibuixaPantallaEstadisticaActuador6(this);
                break;

            case GRÁFICA_ACTUADOR7:    gui.dibuixaPantallaEstadisticaActuador7(this);
                break;

            case INSTRUCCIONES:    gui.dibuixaPantallaInstrucciones(this);
                break;

        }
      /*  String info = connectat ? "OK" : "ERROR";
        fill(0); textSize(48);
        text("Connexió a la BBDD : "+ info, 100, 100); */

        println(gui.pantallaActual);

    }

   /* public void connectBBDD(){
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, pass);
            System.out.println("Connectat a la BBDD! :) ");
            connectat = true;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }*/

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
        gui.ValMin1.keyPressed(key, keyCode);
        gui.ValMax1.keyPressed(key, keyCode);
        gui.ValMin2.keyPressed(key, keyCode);
        gui.ValMax2.keyPressed(key, keyCode);
        gui.ValMin3.keyPressed(key, keyCode);
        gui.ValMax3.keyPressed(key, keyCode);
        gui.ValMin4.keyPressed(key, keyCode);
        gui.ValMax4.keyPressed(key, keyCode);
        gui.ValMin5.keyPressed(key, keyCode);
        gui.ValMax5.keyPressed(key, keyCode);
        gui.ValMin6.keyPressed(key, keyCode);
        gui.ValMax6.keyPressed(key, keyCode);
        gui.ValMin7.keyPressed(key, keyCode);
        gui.ValMax7.keyPressed(key, keyCode);



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
                if (gui.Actuador2.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR2;
                }
                if (gui.Actuador3.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR3;
                }
                if (gui.Actuador4.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR4;
                }
                if (gui.Actuador5.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR5;
                }
                if (gui.Actuador6.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR6;
                }
                if (gui.Actuador7.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.ACTUADOR7;
                }

                if (gui.Sensor1.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR1;
                }
                if (gui.Sensor2.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR2;
                }
                if (gui.Sensor3.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR3;
                }
                if (gui.Sensor4.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR4;
                }
                if (gui.Sensor5.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR5;
                }
                if (gui.Sensor6.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR6;
                }
                if (gui.Sensor7.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.SENSOR7;
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
                gui.Tipoa1.setEnabled(true);
                gui.Ubicaciona1.setEnabled(true);
                gui.Arduinoa1.setEnabled(true);
                gui.Sensora1.setEnabled(true);

                gui.ValMin1.isPressed(this);
                gui.ValMax1.isPressed(this);

                if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR1) {
                    gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR1;
                }
                if (gui.EncesA1.isEnabled()) {
                    gui.ActuadorMapa1.setEnces(true);
                } else{
                    gui.ActuadorMapa1.setEnces(false);
                }
                if (gui.MenuS.mouseOverButton(this)) {
                    gui.pantallaActual = GUI.PANTALLA.MENÚ;
                }
            }
            else{
                gui.MenuS.setEnabled(false);
                gui.GraficaActuador.setEnabled(false);
              //  gui.EncesA1.setEnabled(false);
              //  gui.BloquejatA.setEnabled(false);
                gui.MenuS.setEnabled(false);
                gui.Tipoa1.setEnabled(false);
                gui.Ubicaciona1.setEnabled(false);
                gui.Arduinoa1.setEnabled(false);
                gui.Sensora1.setEnabled(false);
            }

        if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR2 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            gui.MenuS.setEnabled(true);

            gui.GraficaActuador.setEnabled(true);
            //  gui.BloquejatA.setEnabled(true);
            // gui.MenuS.setEnabled(true);
            gui.Tipoa2.setEnabled(true);
            gui.Ubicaciona2.setEnabled(true);
            gui.Arduinoa2.setEnabled(true);
            gui.Sensora2.setEnabled(true);

            gui.ValMin2.isPressed(this);
            gui.ValMax2.isPressed(this);

            if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR2) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR2;
            }
            if (gui.EncesA2.isEnabled()) {
                gui.ActuadorMapa2.setEnces(true);
            } else{
                gui.ActuadorMapa2.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.GraficaActuador.setEnabled(false);
            //  gui.EncesA1.setEnabled(false);
            //  gui.BloquejatA.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.Tipoa2.setEnabled(false);
            gui.Ubicaciona2.setEnabled(false);
            gui.Arduinoa2.setEnabled(false);
            gui.Sensora2.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR3 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            gui.MenuS.setEnabled(true);

            gui.GraficaActuador.setEnabled(true);
            //  gui.BloquejatA.setEnabled(true);
            // gui.MenuS.setEnabled(true);
            gui.Tipoa3.setEnabled(true);
            gui.Ubicaciona3.setEnabled(true);
            gui.Arduinoa3.setEnabled(true);
            gui.Sensora3.setEnabled(true);

            gui.ValMin3.isPressed(this);
            gui.ValMax3.isPressed(this);

            if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR3) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR3;
            }
            if (gui.EncesA3.isEnabled()) {
                gui.ActuadorMapa3.setEnces(true);
            } else{
                gui.ActuadorMapa3.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.GraficaActuador.setEnabled(false);
            //  gui.EncesA1.setEnabled(false);
            //  gui.BloquejatA.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.Tipoa3.setEnabled(false);
            gui.Ubicaciona3.setEnabled(false);
            gui.Arduinoa3.setEnabled(false);
            gui.Sensora3.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR4 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            gui.MenuS.setEnabled(true);

            gui.GraficaActuador.setEnabled(true);
            //  gui.BloquejatA.setEnabled(true);
            // gui.MenuS.setEnabled(true);
            gui.Tipoa4.setEnabled(true);
            gui.Ubicaciona4.setEnabled(true);
            gui.Arduinoa4.setEnabled(true);
            gui.Sensora4.setEnabled(true);

            gui.ValMin4.isPressed(this);
            gui.ValMax4.isPressed(this);

            if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR4) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR4;
            }
            if (gui.EncesA4.isEnabled()) {
                gui.ActuadorMapa4.setEnces(true);
            } else {
                gui.ActuadorMapa4.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.GraficaActuador.setEnabled(false);
            //  gui.EncesA1.setEnabled(false);
            //  gui.BloquejatA.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.Tipoa4.setEnabled(false);
            gui.Ubicaciona4.setEnabled(false);
            gui.Arduinoa4.setEnabled(false);
            gui.Sensora4.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR5 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            gui.MenuS.setEnabled(true);

            gui.GraficaActuador.setEnabled(true);
            //  gui.BloquejatA.setEnabled(true);
            // gui.MenuS.setEnabled(true);
            gui.Tipoa5.setEnabled(true);
            gui.Ubicaciona5.setEnabled(true);
            gui.Arduinoa5.setEnabled(true);
            gui.Sensora5.setEnabled(true);

            gui.ValMin5.isPressed(this);
            gui.ValMax5.isPressed(this);

            if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR5) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR5;
            }
            if (gui.EncesA5.isEnabled()) {
                gui.ActuadorMapa5.setEnces(true);
            } else {
                gui.ActuadorMapa5.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.GraficaActuador.setEnabled(false);
            //  gui.EncesA1.setEnabled(false);
            //  gui.BloquejatA.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.Tipoa5.setEnabled(false);
            gui.Ubicaciona5.setEnabled(false);
            gui.Arduinoa5.setEnabled(false);
            gui.Sensora5.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR6 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            gui.MenuS.setEnabled(true);

            gui.GraficaActuador.setEnabled(true);
            //  gui.BloquejatA.setEnabled(true);
            // gui.MenuS.setEnabled(true);
            gui.Tipoa6.setEnabled(true);
            gui.Ubicaciona6.setEnabled(true);
            gui.Arduinoa6.setEnabled(true);
            gui.Sensora6.setEnabled(true);

            gui.ValMin6.isPressed(this);
            gui.ValMax6.isPressed(this);

            if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR6) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR6;
            }
            if (gui.EncesA6.isEnabled()) {
                gui.ActuadorMapa6.setEnces(true);
            } else {
                gui.ActuadorMapa6.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.GraficaActuador.setEnabled(false);
            //  gui.EncesA1.setEnabled(false);
            //  gui.BloquejatA.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.Tipoa6.setEnabled(false);
            gui.Ubicaciona6.setEnabled(false);
            gui.Arduinoa6.setEnabled(false);
            gui.Sensora6.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.ACTUADOR7 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {

            gui.MenuS.setEnabled(true);

            gui.GraficaActuador.setEnabled(true);
            //  gui.BloquejatA.setEnabled(true);
            // gui.MenuS.setEnabled(true);
            gui.Tipoa7.setEnabled(true);
            gui.Ubicaciona7.setEnabled(true);
            gui.Arduinoa7.setEnabled(true);
            gui.Sensora7.setEnabled(true);

            gui.ValMin7.isPressed(this);
            gui.ValMax7.isPressed(this);

            if (gui.GraficaActuador.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.ACTUADOR7) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_ACTUADOR7;
            }
            if (gui.EncesA7.isEnabled()) {
                gui.ActuadorMapa7.setEnces(true);
            } else{
                gui.ActuadorMapa7.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.GraficaActuador.setEnabled(false);
            //  gui.EncesA1.setEnabled(false);
            //  gui.BloquejatA.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.Tipoa7.setEnabled(false);
            gui.Ubicaciona7.setEnabled(false);
            gui.Arduinoa7.setEnabled(false);
            gui.Sensora7.setEnabled(false);
        }



        if (gui.pantallaActual == GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos1.setEnabled(true);
            gui.Ubicacions1.setEnabled(true);
            gui.Arduino1.setEnabled(true);
            gui.ActuadorS1.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR1) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR1;
            }
            if (gui.EncesS1.isEnabled()) {
                gui.SensorMapa1.setEnces(true);
            } else{
                gui.SensorMapa1.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos1.setEnabled(false);
            gui.Ubicacions1.setEnabled(false);
            gui.Arduino1.setEnabled(false);
            gui.ActuadorS1.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.SENSOR2 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos2.setEnabled(true);
            gui.Ubicacions2.setEnabled(true);
            gui.Arduino2.setEnabled(true);
            gui.ActuadorS2.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR2) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR2;
            }
            if (gui.EncesS2.isEnabled()) {
                gui.SensorMapa2.setEnces(true);
            } else{
                gui.SensorMapa2.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR2) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos2.setEnabled(false);
            gui.Ubicacions2.setEnabled(false);
            gui.Arduino2.setEnabled(false);
            gui.ActuadorS2.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.SENSOR3 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos3.setEnabled(true);
            gui.Ubicacions3.setEnabled(true);
            gui.Arduino3.setEnabled(true);
            gui.ActuadorS3.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR3) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR3;
            }
            if (gui.EncesS3.isEnabled()) {
                gui.SensorMapa3.setEnces(true);
            } else{
                gui.SensorMapa3.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos3.setEnabled(false);
            gui.Ubicacions3.setEnabled(false);
            gui.Arduino3.setEnabled(false);
            gui.ActuadorS3.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.SENSOR4 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos4.setEnabled(true);
            gui.Ubicacions4.setEnabled(true);
            gui.Arduino4.setEnabled(true);
            gui.ActuadorS4.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR4) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR4;
            }
            if (gui.EncesS4.isEnabled()) {
                gui.SensorMapa4.setEnces(true);
            } else{
                gui.SensorMapa4.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR4) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos4.setEnabled(false);
            gui.Ubicacions4.setEnabled(false);
            gui.Arduino4.setEnabled(false);
            gui.ActuadorS4.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.SENSOR5 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos5.setEnabled(true);
            gui.Ubicacions5.setEnabled(true);
            gui.Arduino5.setEnabled(true);
            gui.ActuadorS5.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR5) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR5;
            }
            if (gui.EncesS5.isEnabled()) {
                gui.SensorMapa5.setEnces(true);
            } else{
                gui.SensorMapa5.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos5.setEnabled(false);
            gui.Ubicacions5.setEnabled(false);
            gui.Arduino5.setEnabled(false);
            gui.ActuadorS5.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.SENSOR6 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos6.setEnabled(true);
            gui.Ubicacions6.setEnabled(true);
            gui.Arduino6.setEnabled(true);
            gui.ActuadorS6.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR6) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR6;
            }
            if (gui.EncesS6.isEnabled()) {
                gui.SensorMapa6.setEnces(true);
            } else {
                gui.SensorMapa6.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos6.setEnabled(false);
            gui.Ubicacions6.setEnabled(false);
            gui.Arduino6.setEnabled(false);
            gui.ActuadorS6.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.SENSOR7 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuS.setEnabled(true);
            gui.GraficaSensor.setEnabled(true);
            // gui.EncesS1.setEnabled(true);
            gui.Tipos7.setEnabled(true);
            gui.Ubicacions7.setEnabled(true);
            gui.Arduino7.setEnabled(true);
            gui.ActuadorS7.setEnabled(true);

            if (gui.GraficaSensor.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.SENSOR7) {
                gui.pantallaActual = GUI.PANTALLA.GRÁFICA_SENSOR7;
            }
            if (gui.EncesS7.isEnabled()) {
                gui.SensorMapa7.setEnces(true);
            } else {
                gui.SensorMapa7.setEnces(false);
            }
            if (gui.MenuS.mouseOverButton(this)) {
                gui.pantallaActual = GUI.PANTALLA.MENÚ;
            }
        }
        else{
            gui.MenuS.setEnabled(false);
            gui.MenuS.setEnabled(false);
            gui.GraficaSensor.setEnabled(false);
            //  gui.EncesS1.setEnabled(false);
            gui.Tipos7.setEnabled(false);
            gui.Ubicacions7.setEnabled(false);
            gui.Arduino7.setEnabled(false);
            gui.ActuadorS7.setEnabled(false);
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

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR2 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuSns.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR2) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR2;
            }

        }
        else{
            gui.MenuSns.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR3 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuSns.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR3) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR3;
            }

        }
        else{
            gui.MenuSns.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR4 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuSns.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR4) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR4;
            }

        }
        else{
            gui.MenuSns.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR5 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuSns.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR5) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR5;
            }

        }
        else{
            gui.MenuSns.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR6 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuSns.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR6) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR6;
            }

        }
        else{
            gui.MenuSns.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR7 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_ACTUADOR1) {
            gui.MenuSns.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_SENSOR7) {
                gui.pantallaActual = GUI.PANTALLA.SENSOR7;
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

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR2 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
            gui.MenuAct.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR2) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR2;
            }
        }
        else{
            gui.MenuAct.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR3 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
            gui.MenuAct.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR3) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR3;
            }
        }
        else{
            gui.MenuAct.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR4 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
            gui.MenuAct.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR4) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR4;
            }
        }
        else{
            gui.MenuAct.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR5 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
            gui.MenuAct.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR5) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR5;
            }
        }
        else{
            gui.MenuAct.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR6 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
            gui.MenuAct.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR6) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR6;
            }
        }
        else{
            gui.MenuAct.setEnabled(false);
        }

        if (gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR7 && gui.pantallaActual != GUI.PANTALLA.MENÚ && gui.pantallaActual != GUI.PANTALLA.INICIO && gui.pantallaActual != GUI.PANTALLA.ACTUADOR1 && gui.pantallaActual != GUI.PANTALLA.SENSOR1 && gui.pantallaActual != GUI.PANTALLA.GRÁFICA_SENSOR1) {
            gui.MenuAct.setEnabled(true);
            if (gui.MenuSns.mouseOverButton(this) && gui.pantallaActual == GUI.PANTALLA.GRÁFICA_ACTUADOR7) {
                gui.pantallaActual = GUI.PANTALLA.ACTUADOR7;
            }
        }
        else{
            gui.MenuAct.setEnabled(false);
        }

            if (gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR1 || gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR2 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR3 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR4 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR5 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR6 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_SENSOR7 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR1 ||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR2||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR3||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR4||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR5||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR6||gui.pantallaActual== GUI.PANTALLA.GRÁFICA_ACTUADOR7){
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

        if(gui.SensorMapa1.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR1;
        }
        if(gui.SensorMapa2.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR2;
        }
        if(gui.SensorMapa3.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR3;
        }
        if(gui.SensorMapa4.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR4;
        }
        if(gui.SensorMapa5.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR5;
        }
        if(gui.SensorMapa6.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR6;
        }
        if(gui.SensorMapa7.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.SENSOR7;
        }

        if(gui.ActuadorMapa1.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR1;
        }

        if(gui.ActuadorMapa2.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR2;
        }
        if(gui.ActuadorMapa3.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR3;
        }
        if(gui.ActuadorMapa4.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR4;
        }
        if(gui.ActuadorMapa5.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR5;
        }
        if(gui.ActuadorMapa6.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR6;
        }
        if(gui.ActuadorMapa7.mouseOnSensor(this)==true){
            gui.pantallaActual= GUI.PANTALLA.ACTUADOR7;
        }

        if(gui.Tipos1.mouseOverSelect(this) && gui.Tipos1.isEnabled()){
            if(!gui.Tipos1.isCollapsed()){
                gui.Tipos1.update(this);      // Actualitzar valor
             //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos1.toggle();        // Plegar o desplegar
        }

        if(gui.Tipos2.mouseOverSelect(this) && gui.Tipos2.isEnabled()){
            if(!gui.Tipos2.isCollapsed()){
                gui.Tipos2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos2.toggle();        // Plegar o desplegar
        }

        if(gui.Tipos3.mouseOverSelect(this) && gui.Tipos3.isEnabled()){
            if(!gui.Tipos3.isCollapsed()){
                gui.Tipos3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos3.toggle();        // Plegar o desplegar
        }

        if(gui.Tipos4.mouseOverSelect(this) && gui.Tipos4.isEnabled()){
            if(!gui.Tipos4.isCollapsed()){
                gui.Tipos4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos4.toggle();        // Plegar o desplegar
        }

        if(gui.Tipos5.mouseOverSelect(this) && gui.Tipos5.isEnabled()){
            if(!gui.Tipos5.isCollapsed()){
                gui.Tipos5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos5.toggle();        // Plegar o desplegar
        }

        if(gui.Tipos6.mouseOverSelect(this) && gui.Tipos6.isEnabled()){
            if(!gui.Tipos6.isCollapsed()){
                gui.Tipos6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos6.toggle();        // Plegar o desplegar
        }

        if(gui.Tipos7.mouseOverSelect(this) && gui.Tipos7.isEnabled()){
            if(!gui.Tipos7.isCollapsed()){
                gui.Tipos7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipos7.toggle();        // Plegar o desplegar
        }


        if(gui.Ubicacions1.mouseOverSelect(this) && gui.Ubicacions1.isEnabled()){
            if(!gui.Ubicacions1.isCollapsed()){
                gui.Ubicacions1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions1.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicacions2.mouseOverSelect(this) && gui.Ubicacions2.isEnabled()){
            if(!gui.Ubicacions2.isCollapsed()){
                gui.Ubicacions2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions2.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicacions3.mouseOverSelect(this) && gui.Ubicacions3.isEnabled()){
            if(!gui.Ubicacions3.isCollapsed()){
                gui.Ubicacions3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions3.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicacions4.mouseOverSelect(this) && gui.Ubicacions4.isEnabled()){
            if(!gui.Ubicacions4.isCollapsed()){
                gui.Ubicacions4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions4.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicacions5.mouseOverSelect(this) && gui.Ubicacions5.isEnabled()){
            if(!gui.Ubicacions5.isCollapsed()){
                gui.Ubicacions5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions5.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicacions6.mouseOverSelect(this) && gui.Ubicacions6.isEnabled()){
            if(!gui.Ubicacions6.isCollapsed()){
                gui.Ubicacions6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions6.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicacions7.mouseOverSelect(this) && gui.Ubicacions7.isEnabled()){
            if(!gui.Ubicacions7.isCollapsed()){
                gui.Ubicacions7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicacions7.toggle();        // Plegar o desplegar
        }

        if(gui.Arduino1.mouseOverSelect(this) && gui.Arduino1.isEnabled()){
            if(!gui.Arduino1.isCollapsed()){
                gui.Arduino1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino1.toggle();        // Plegar o desplegar
        }
        if(gui.Arduino2.mouseOverSelect(this) && gui.Arduino2.isEnabled()){
            if(!gui.Arduino2.isCollapsed()){
                gui.Arduino2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino2.toggle();        // Plegar o desplegar
        }
        if(gui.Arduino3.mouseOverSelect(this) && gui.Arduino3.isEnabled()){
            if(!gui.Arduino3.isCollapsed()){
                gui.Arduino3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino3.toggle();        // Plegar o desplegar
        }
        if(gui.Arduino4.mouseOverSelect(this) && gui.Arduino4.isEnabled()){
            if(!gui.Arduino4.isCollapsed()){
                gui.Arduino4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino4.toggle();        // Plegar o desplegar
        }
        if(gui.Arduino5.mouseOverSelect(this) && gui.Arduino5.isEnabled()){
            if(!gui.Arduino5.isCollapsed()){
                gui.Arduino5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino5.toggle();        // Plegar o desplegar
        }
        if(gui.Arduino6.mouseOverSelect(this) && gui.Arduino6.isEnabled()){
            if(!gui.Arduino6.isCollapsed()){
                gui.Arduino6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino6.toggle();        // Plegar o desplegar
        }
        if(gui.Arduino7.mouseOverSelect(this) && gui.Arduino7.isEnabled()){
            if(!gui.Arduino7.isCollapsed()){
                gui.Arduino7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduino7.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS1.mouseOverSelect(this) && gui.ActuadorS1.isEnabled()){
            if(!gui.ActuadorS1.isCollapsed()){
                gui.ActuadorS1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS1.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS2.mouseOverSelect(this) && gui.ActuadorS2.isEnabled()){
            if(!gui.ActuadorS2.isCollapsed()){
                gui.ActuadorS2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS2.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS3.mouseOverSelect(this) && gui.ActuadorS3.isEnabled()){
            if(!gui.ActuadorS3.isCollapsed()){
                gui.ActuadorS3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS3.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS4.mouseOverSelect(this) && gui.ActuadorS4.isEnabled()){
            if(!gui.ActuadorS4.isCollapsed()){
                gui.ActuadorS4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS4.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS5.mouseOverSelect(this) && gui.ActuadorS5.isEnabled()){
            if(!gui.ActuadorS5.isCollapsed()){
                gui.ActuadorS5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS5.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS6.mouseOverSelect(this) && gui.ActuadorS6.isEnabled()){
            if(!gui.ActuadorS6.isCollapsed()){
                gui.ActuadorS6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS6.toggle();        // Plegar o desplegar
        }
        if(gui.ActuadorS7.mouseOverSelect(this) && gui.ActuadorS7.isEnabled()){
            if(!gui.ActuadorS7.isCollapsed()){
                gui.ActuadorS7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.ActuadorS7.toggle();        // Plegar o desplegar
        }

        if(gui.Tipoa1.mouseOverSelect(this) && gui.Tipoa1.isEnabled()){
            if(!gui.Tipoa1.isCollapsed()){
                gui.Tipoa1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa1.toggle();        // Plegar o desplegar
        }
        if(gui.Tipoa2.mouseOverSelect(this) && gui.Tipoa2.isEnabled()){
            if(!gui.Tipoa2.isCollapsed()){
                gui.Tipoa2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa2.toggle();        // Plegar o desplegar
        }
        if(gui.Tipoa3.mouseOverSelect(this) && gui.Tipoa3.isEnabled()){
            if(!gui.Tipoa3.isCollapsed()){
                gui.Tipoa3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa3.toggle();        // Plegar o desplegar
        }
        if(gui.Tipoa4.mouseOverSelect(this) && gui.Tipoa4.isEnabled()){
            if(!gui.Tipoa4.isCollapsed()){
                gui.Tipoa4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa4.toggle();        // Plegar o desplegar
        }
        if(gui.Tipoa5.mouseOverSelect(this) && gui.Tipoa5.isEnabled()){
            if(!gui.Tipoa5.isCollapsed()){
                gui.Tipoa5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa5.toggle();        // Plegar o desplegar
        }
        if(gui.Tipoa6.mouseOverSelect(this) && gui.Tipoa6.isEnabled()){
            if(!gui.Tipoa6.isCollapsed()){
                gui.Tipoa6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa6.toggle();        // Plegar o desplegar
        }
        if(gui.Tipoa7.mouseOverSelect(this) && gui.Tipoa7.isEnabled()){
            if(!gui.Tipoa7.isCollapsed()){
                gui.Tipoa7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Tipoa7.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona1.mouseOverSelect(this) && gui.Ubicaciona1.isEnabled()){
            if(!gui.Ubicaciona1.isCollapsed()){
                gui.Ubicaciona1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona1.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona2.mouseOverSelect(this) && gui.Ubicaciona2.isEnabled()){
            if(!gui.Ubicaciona2.isCollapsed()){
                gui.Ubicaciona2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona2.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona3.mouseOverSelect(this) && gui.Ubicaciona3.isEnabled()){
            if(!gui.Ubicaciona3.isCollapsed()){
                gui.Ubicaciona3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona3.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona4.mouseOverSelect(this) && gui.Ubicaciona4.isEnabled()){
            if(!gui.Ubicaciona4.isCollapsed()){
                gui.Ubicaciona4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona4.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona5.mouseOverSelect(this) && gui.Ubicaciona5.isEnabled()){
            if(!gui.Ubicaciona5.isCollapsed()){
                gui.Ubicaciona5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona5.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona6.mouseOverSelect(this) && gui.Ubicaciona6.isEnabled()){
            if(!gui.Ubicaciona6.isCollapsed()){
                gui.Ubicaciona6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona6.toggle();        // Plegar o desplegar
        }
        if(gui.Ubicaciona7.mouseOverSelect(this) && gui.Ubicaciona7.isEnabled()){
            if(!gui.Ubicaciona7.isCollapsed()){
                gui.Ubicaciona7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Ubicaciona7.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa1.mouseOverSelect(this) && gui.Arduinoa1.isEnabled()){
            if(!gui.Arduinoa1.isCollapsed()){
                gui.Arduinoa1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa1.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa2.mouseOverSelect(this) && gui.Arduinoa2.isEnabled()){
            if(!gui.Arduinoa2.isCollapsed()){
                gui.Arduinoa2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa2.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa3.mouseOverSelect(this) && gui.Arduinoa3.isEnabled()){
            if(!gui.Arduinoa3.isCollapsed()){
                gui.Arduinoa3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa3.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa4.mouseOverSelect(this) && gui.Arduinoa4.isEnabled()){
            if(!gui.Arduinoa4.isCollapsed()){
                gui.Arduinoa4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa4.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa5.mouseOverSelect(this) && gui.Arduinoa5.isEnabled()){
            if(!gui.Arduinoa5.isCollapsed()){
                gui.Arduinoa5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa5.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa6.mouseOverSelect(this) && gui.Arduinoa6.isEnabled()){
            if(!gui.Arduinoa6.isCollapsed()){
                gui.Arduinoa6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa6.toggle();        // Plegar o desplegar
        }
        if(gui.Arduinoa7.mouseOverSelect(this) && gui.Arduinoa7.isEnabled()){
            if(!gui.Arduinoa7.isCollapsed()){
                gui.Arduinoa7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Arduinoa7.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora1.mouseOverSelect(this) && gui.Sensora1.isEnabled()){
            if(!gui.Sensora1.isCollapsed()){
                gui.Sensora1.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora1.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora2.mouseOverSelect(this) && gui.Sensora2.isEnabled()){
            if(!gui.Sensora2.isCollapsed()){
                gui.Sensora2.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora2.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora3.mouseOverSelect(this) && gui.Sensora3.isEnabled()){
            if(!gui.Sensora3.isCollapsed()){
                gui.Sensora3.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora3.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora4.mouseOverSelect(this) && gui.Sensora4.isEnabled()){
            if(!gui.Sensora4.isCollapsed()){
                gui.Sensora4.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora4.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora5.mouseOverSelect(this) && gui.Sensora5.isEnabled()){
            if(!gui.Sensora5.isCollapsed()){
                gui.Sensora5.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora5.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora6.mouseOverSelect(this) && gui.Sensora6.isEnabled()){
            if(!gui.Sensora6.isCollapsed()){
                gui.Sensora6.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora6.toggle();        // Plegar o desplegar
        }
        if(gui.Sensora7.mouseOverSelect(this) && gui.Sensora7.isEnabled()){
            if(!gui.Sensora7.isCollapsed()){
                gui.Sensora7.update(this);      // Actualitzar valor
                //   updateColor();    // Fer acció amb valor
            }
            gui.Sensora7.toggle();        // Plegar o desplegar
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

        if(gui.EncesS1.mouseOverButton(this)){
            gui.EncesS1.toggle();
            if(gui.EncesS1.isEnabled()){
                //bgColor = color(255);
            }
            else {
              //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesS2.mouseOverButton(this)){
            gui.EncesS2.toggle();
            if(gui.EncesS2.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesS3.mouseOverButton(this)){
            gui.EncesS3.toggle();
            if(gui.EncesS3.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesS4.mouseOverButton(this)){
            gui.EncesS4.toggle();
            if(gui.EncesS4.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesS5.mouseOverButton(this)){
            gui.EncesS5.toggle();
            if(gui.EncesS5.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesS6.mouseOverButton(this)){
            gui.EncesS6.toggle();
            if(gui.EncesS6.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesS7.mouseOverButton(this)){
            gui.EncesS7.toggle();
            if(gui.EncesS7.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }

        if(gui.EncesA1.mouseOverButton(this)){
            gui.EncesA1.toggle();
            if(gui.EncesA1.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesA2.mouseOverButton(this)){
            gui.EncesA2.toggle();
            if(gui.EncesA2.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesA3.mouseOverButton(this)){
            gui.EncesA3.toggle();
            if(gui.EncesA3.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesA4.mouseOverButton(this)){
            gui.EncesA4.toggle();
            if(gui.EncesA4.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesA5.mouseOverButton(this)){
            gui.EncesA5.toggle();
            if(gui.EncesA5.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesA6.mouseOverButton(this)){
            gui.EncesA6.toggle();
            if(gui.EncesA6.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
            }
        }
        if(gui.EncesA7.mouseOverButton(this)){
            gui.EncesA7.toggle();
            if(gui.EncesA7.isEnabled()){
                //bgColor = color(255);
            }
            else {
                //  gui.EncesS1.Color = color(0);
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

