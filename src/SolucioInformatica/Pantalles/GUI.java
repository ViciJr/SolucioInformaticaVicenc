package SolucioInformatica.Pantalles;

import processing.core.PApplet;

import static SolucioInformatica.Pantalles.LayoutNMides.*;


public class GUI {

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {INICIO, PLANO, ABOUT, SENSOR, ACTUADOR, NUEVOSENSOR, NUEVOACTUADOR};

    // Pantalla Actual
    public PANTALLA pantallaActual;

    // Constructor de la GUI
    public GUI(){
        pantallaActual = PANTALLA.INICIO;
    }


    // PANTALLES DE LA GUI

    public void dibuixaPantallaInicio(PApplet p5){

        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaAbout(PApplet p5){
        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumna1(p5);
    }

    public void dibuixaPantallaPlano(PApplet p5){
        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes12(p5);
    }

    public void dibuixaPantallaSensor(PApplet p5){

        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaActuador(PApplet p5){

        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaNuevoSensor(PApplet p5){

        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaNuevoActuador(PApplet p5){

        p5.background(55);
        dibuixaLogo(p5);
        dibuixaSideBar(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }
    // ZONES DE LA GUI

    public void dibuixaLogo(PApplet p5){
        p5.fill(200,50,100);
        p5.rect(marginH, marginV, logoWidth, logoHeight);
        p5.fill(0);
        p5.text("LOGO", marginH + logoWidth/2, marginV + logoHeight/2);
    }

    public void dibuixaSideBar(PApplet p5){
        // Zona Sidebar ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(50,200,100);
        p5.rect(marginH, 2*marginV + logoHeight, sidebarWidth, sidebarHeight);
        p5.fill(0);
        p5.text("SIDEBAR", marginH + sidebarWidth/2, marginV + logoHeight + sidebarHeight/2);
    }

    public void dibuixaBanner(PApplet p5){
        p5.fill(240, 100, 50);
        p5.rect(2*marginH + logoWidth, marginV, bannerWidth, bannerHeight);
        p5.fill(0);
        p5.text("PANTALLA " +  pantallaActual + "("+pantallaActual.ordinal() +")", marginH + logoWidth + bannerWidth/2, marginV + bannerHeight/2);
    }

    public void dibuixaColumna1(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(200, 200, 50);
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, 3*columnWidth + 2*marginH, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth + 3*columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes12(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(200, 200, 50);
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(200, 200, 50);
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, 2*columnWidth + marginH, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes123(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(200, 200, 50);
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(200, 200, 50);
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(200, 200, 50);
        p5.rect(4*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 3", 4*marginH + sidebarWidth + 2*columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }
}