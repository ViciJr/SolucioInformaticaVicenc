package SolucioInformatica.Pantalles;

;
import SolucioInformatica.gui.Button;
import SolucioInformatica.gui.TextField;
import processing.core.PApplet;




import static SolucioInformatica.Pantalles.LayoutNMides.*;


public class GUI {

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {INICIO, PLANO, ABOUT, SENSOR, ACTUADOR, NUEVOSENSOR, NUEVOACTUADOR};

    // Pantalla Actual
    public PANTALLA pantallaActual;

    //Colors i tipografia
    Fonts Fonts;
    Colors Colors;

    // PANTALLA INICIAL Y LOGIN
    Button BlogIn;
    TextField TUsuario;
    TextField TContraseña;



    // Constructor de la GUI
    public GUI(PApplet p5){

        pantallaActual = PANTALLA.INICIO;

        Colors = new Colors(p5);   // Constructor dels colors de l'App
        Fonts = new Fonts(p5);     // Constructor de les fonts de l'App

        TUsuario = new TextField (p5, XUsuari+marginH, heightPrimeraPantalla+YUsuari, widthPrimeraPantalla, heightPrimeraPantalla /*, "Usuario"*/);
        TContraseña = new TextField (p5, XContra+marginH, YContra, widthPrimeraPantalla, heightPrimeraPantalla/*, "Contraseña"*/);
        p5.textFont(Fonts.getFontAt(2));
        BlogIn = new Button (p5, "HECHO", XHecho+marginH, YHecho, widthPrimeraPantalla, heightPrimeraPantalla);
        BlogIn.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));





    }


    // PANTALLES DE LA GUI

    public void dibuixaPantallaInicio(PApplet p5){

        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);
       // dibuixaColumnes123(p5);

        BlogIn.display(p5);
        TUsuario.display(p5);
        TContraseña.display(p5);

        p5.textFont(Fonts.getFontAt(2));
        p5.text("   Usuario:", XUsuari+2*marginH, YUsuari*9/7-5);
        p5.textFont(Fonts.getFontAt(2));
        p5.text("           Contraseña:", XContra+2*marginH, YContra*8/7-heightPrimeraPantalla-2);
    }

    public void dibuixaPantallaAbout(PApplet p5){
        p5.background(255);
        dibuixaLogo(p5);
        dibuixaImatgeMapa(p5);
        dibuixaBanner(p5);
        dibuixaColumna1(p5);
    }

    public void dibuixaPantallaPlano(PApplet p5){
        p5.background(255);
        dibuixaLogo(p5);
        dibuixaImatgeMapa(p5);
        dibuixaBanner(p5);
        dibuixaColumnes12(p5);
    }

    public void dibuixaPantallaSensor(PApplet p5){

        p5.background(255);
        dibuixaLogo(p5);
        dibuixaImatgeMapa(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaActuador(PApplet p5){

        p5.background(255);
        dibuixaLogo(p5);
        dibuixaImatgeMapa(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaNuevoSensor(PApplet p5){

        p5.background(255);
        dibuixaLogo(p5);
        dibuixaImatgeMapa(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaNuevoActuador(PApplet p5){

        p5.background(255);
        dibuixaLogo(p5);
        dibuixaImatgeMapa(p5);
        dibuixaBanner(p5);
        dibuixaColumnes123(p5);
    }
    // ZONES DE LA GUI

    public void dibuixaLogo(PApplet p5){
        p5.fill(Colors.getColorAt(0));
        p5.rect(marginH, marginV, midaLogo, midaLogo);
        p5.fill(0);
        p5.text("LOGO", marginH + midaLogo/2, marginV + midaLogo/2);
    }

    public void dibuixaImatgeMapa(PApplet p5){
        // Zona Sidebar ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(Colors.getColorAt(2));
        p5.rect(marginH, 6*marginV + logoHeight, widthImatge, heightImatge);
        p5.fill(0);
        p5.text("IMATGE/MAPA", marginH + widthImatge/2, 3*marginV + logoHeight + heightImatge/2);
    }

    public void dibuixaBanner(PApplet p5){
        p5.fill(Colors.getColorAt(1));
        p5.rect(2*marginH + midaLogo, marginV, bannerWidth, bannerHeight);
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